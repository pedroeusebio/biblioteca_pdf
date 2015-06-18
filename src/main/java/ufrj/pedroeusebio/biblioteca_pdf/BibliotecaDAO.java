package ufrj.pedroeusebio.biblioteca_pdf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class BibliotecaDAO {
// Implementing all getters ------------------------------------------------------------------------------------------------------------------------------------------------------

    private JSONArray jsonArray;
    private ArrayList<JSONArray> answer = new ArrayList<JSONArray>();
    private String strQuery;

    public String getStrQuery() {
        return strQuery;
    }

    public void setStrQuery(String strQuery) {
        this.strQuery = strQuery;
    }
    
    public String QueryGenatator(String tabela, String tributo, String mode, String base) {
        if (mode == null) {
            this.strQuery = "SELECT patrimonio FROM public." + base + " WHERE " + tabela + "='" + tributo + "' ";
        }
        if (mode.equalsIgnoreCase("OU")) {
            this.strQuery = "UNION SELECT patrimonio FROM public." + base + " WHERE " + tabela + "='" + tributo + "' ";
        }
        if (mode.equalsIgnoreCase("E")) {
            this.strQuery = "INTERSECT SELECT patrimonio FROM public." + base + " WHERE " + tabela + "='" + tributo + "' ";
        }
        return strQuery;
    }

    public ArrayList<JSONArray> ExecuteQuery(String query) {
        try {
            this.answer = new ArrayList<JSONArray>();
            DbInfo database = new DbInfo();
            database.DadoBanco();
            Class.forName("org.postgresql.Driver");

            Connection con;

            con = DriverManager.getConnection(database.getUrl(), database.getUsuario(), database.getSenha());
            PreparedStatement pstmt = con.prepareStatement(query + ";");
            ResultSet rst = pstmt.executeQuery();
            JSONArray JSONArray = new JSONArray();
            while (rst.next()) {
                JSONArray.put(new JSONObject().put("patrimonio", rst.getString("patrimonio")));

            }
            for (int i = 0; i < JSONArray.length(); i++) {
                String patrimonio = JSONArray.getJSONObject(i).getString("patrimonio");
                query = "SELECT * FROM public.dadoscatalogo WHERE patrimonio='" + patrimonio + "';";
                pstmt = con.prepareStatement(query);
                rst = pstmt.executeQuery();
                while (rst.next()) {
                    this.jsonArray = new JSONArray();
                    this.jsonArray.put(new JSONObject().put("patrimonio", rst.getString("patrimonio")));
                    this.jsonArray.put(new JSONObject().put("titulo", rst.getString("titulo")));
                    this.jsonArray.put(new JSONObject().put("autoria", rst.getString("autoria")));
                    this.jsonArray.put(new JSONObject().put("veiculo", rst.getString("veiculo")));
                    this.jsonArray.put(new JSONObject().put("date", rst.getString("data_publicacao")));
                    this.jsonArray.put(new JSONObject().put("arquivo", rst.getString("arquivo")));
                    pstmt = con.prepareStatement("SELECT * FROM public.palavras_chave WHERE patrimonio='" + rst.getString("patrimonio") + "';");
                    ResultSet auxrst = pstmt.executeQuery();
                    String aux = "";
                    while (auxrst.next()) {
                        aux += auxrst.getString("palchave") + "; ";
                    }
                    this.jsonArray.put(new JSONObject().put("palchave", aux));

                    pstmt = con.prepareStatement("SELECT * FROM public.comentarios WHERE patrimonio='" + rst.getString("patrimonio") + "';");
                    auxrst = pstmt.executeQuery();
                    aux = "";
                    while (auxrst.next()) {
                        aux += auxrst.getString("comentario");
                    }
                    this.jsonArray.put(new JSONObject().put("comentarios", aux));
                    this.answer.add(jsonArray);
                }
            }
            con.close();
        } catch (Exception e) {

        }
        return answer;
    }

    //Implementing all write at the database -------------------------------------------------------------------------------------------------------------------------------------
    public boolean updateDatebase(RespostaDTO dto) {
        try {
            DbInfo database = new DbInfo();
            database.DadoBanco();
            Class.forName("org.postgresql.Driver");

            Connection con;

            con = DriverManager.getConnection(database.getUrl(), database.getUsuario(), database.getSenha());
            String query = "update public.dadoscatalogo set titulo='" + dto.getTitulo()
                    + "',veiculo='" + dto.getVeiculo() + "',data_publicacao='" + dto.getData() + "' ,autoria='" + dto.getAutoria()
                    + "' where patrimonio='" + dto.getPatrimonio() + "';";
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet rst = pstmt.executeQuery();
            con.close();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public void updateDbPalchave(RespostaDTO dto) {
        ArrayList<String> parts = new ArrayList<String>();
        ArrayList<String> partssaved = new ArrayList<String>();
        String[] list = dto.getPalchave().replaceAll("\\s", "").split(";");
        List<String> newList = Arrays.asList(list);
        parts.addAll(newList);
        String palsaved = "";
        String query = "SELECT * FROM public.palavras_chave WHERE patrimonio='" + dto.getPatrimonio() + "' ;";
        try {
            DbInfo database = new DbInfo();
            database.DadoBanco();
            Class.forName("org.postgresql.Driver");
            Connection con;
            con = DriverManager.getConnection(database.getUrl(), database.getUsuario(), database.getSenha());
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet rst = pstmt.executeQuery();
            while (rst.next()) {
                palsaved += rst.getString("palchave") + ";";
            }
            String[] Arraypal = palsaved.replaceAll("\\s", "").split(";");
            newList = Arrays.asList(Arraypal);
            partssaved.addAll(newList);
            for (int i = 0; i < partssaved.size(); i++) {
                if (!parts.contains(partssaved.get(i))) {
                    query = "DELETE FROM public.palavras_chave WHERE patrimonio =" + dto.getPatrimonio() + "and palchave='" + partssaved.get(i) + "' ;";
                    pstmt = con.prepareStatement(query);
                    rst = pstmt.executeQuery();
                }
            }
            for (int i = 0; i < parts.size(); i++) {
                if (!partssaved.contains(parts.get(i))) {
                    query = "INSERT INTO palavras_chave (palchave, patrimonio) VALUES ('" + parts.get(i) + "'," + dto.getPatrimonio() + ");";
                    pstmt = con.prepareStatement(query);
                    rst = pstmt.executeQuery();
                }
            }
            con.close();
        } catch (Exception e) {
        }
    }

    public void updateDbComentario(RespostaDTO dto) {
        try {
            DbInfo database = new DbInfo();
            database.DadoBanco();
            Class.forName("org.postgresql.Driver");
            Connection con;
            con = DriverManager.getConnection(database.getUrl(), database.getUsuario(), database.getSenha());
            String query = "INSERT INTO public.comentarios(comentario,patrimonio) VALUES ('" + dto.getComentario() + "'," + dto.getPatrimonio() + ");";
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet rst = pstmt.executeQuery();
            con.close();
        } catch (Exception e) {

        }
    }

    public void addNewCatalogo(RespostaDTO dto) {
        int patrimonio = 0;
        String query = "INSERT INTO public.dadoscatalogo (titulo, autoria, veiculo, data_publicacao)"
                + " VALUES ('" + dto.getTitulo() + "','" + dto.getAutoria() + "','" + dto.getVeiculo() + "','" + dto.getData() + "');";
        try {
            DbInfo database = new DbInfo();
            database.DadoBanco();
            Class.forName("org.postgresql.Driver");
            Connection con;
            con = DriverManager.getConnection(database.getUrl(), database.getUsuario(), database.getSenha());
            PreparedStatement pstmt = con.prepareStatement(query, new String[]{"patrimonio"});
            pstmt.executeUpdate();
            ResultSet rst = pstmt.getGeneratedKeys();
            if (rst != null && rst.next()) {
                patrimonio = (int) rst.getLong(1);
            }
            if (dto.getPalchave() != null) {
                String[] parts = dto.getPalchave().replaceAll("\\s", "").split(";");
                for (int i = 0; i < parts.length; i++) {
                    query = "INSERT INTO public.palavras_chave (palchave,patrimonio) VALUES ('"
                            + parts[i] + "','" + patrimonio + "');";
                    PreparedStatement pstmtPalchave = con.prepareStatement(query);
                    pstmtPalchave.executeUpdate();
                }
            }
            if (dto.getComentario() != null) {
                query = "INSERT INTO public.comentarios (comentario,patrimonio) VALUES ('"
                        + dto.getComentario() + "','" + patrimonio + "');";
                PreparedStatement pstmtComentario = con.prepareStatement(query);
                pstmtComentario.executeUpdate();
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteData(RespostaDTO dto) {
        String patrimonio = dto.getPatrimonio();
        String[] ArrayQuery = new String[3];
        ArrayQuery[0] = "DELETE FROM public.dadoscatalogo WHERE patrimonio ='" + patrimonio + "' ;";
        ArrayQuery[1] = "DELETE FROM public.palavras_chave WHERE patrimonio ='" + patrimonio + "' ;";
        ArrayQuery[2] = "DELETE FROM public.comentarios WHERE patrimonio ='" + patrimonio + "' ;";
        for (int i = 0; i < ArrayQuery.length; i++) {
            try {
                DbInfo database = new DbInfo();
                database.DadoBanco();
                Class.forName("org.postgresql.Driver");
                Connection con;
                con = DriverManager.getConnection(database.getUrl(), database.getUsuario(), database.getSenha());
                PreparedStatement pstmt = con.prepareStatement(ArrayQuery[i]);
                ResultSet rst = pstmt.executeQuery();
            } catch (Exception e) {

            }
        }
    }

    public void saveFile(RespostaDTO dto) {
        String query = "UPDATE public.dadoscatalogo SET arquivo='" + dto.getPath() + "' WHERE patrimonio='" + dto.getPatrimonio() + "' ;";
        try {
            DbInfo database = new DbInfo();
            database.DadoBanco();
            Class.forName("org.postgresql.Driver");
            Connection con;
            con = DriverManager.getConnection(database.getUrl(), database.getUsuario(), database.getSenha());
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
