package ufrj.pedroeusebio.biblioteca_pdf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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

    public ArrayList<JSONArray> getBypatrimonio(String patrimonio) {
        try {
            this.answer = new ArrayList<JSONArray>();
            DbInfo database = new DbInfo();
            database.DadoBanco();

            Class.forName("org.postgresql.Driver");

            Connection con;

            con = DriverManager.getConnection(database.getUrl(), database.getUsuario(), database.getSenha());
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM public.dadoscatalogo WHERE patrimonio=" + patrimonio + ";");
            ResultSet rst = pstmt.executeQuery();
            while (rst.next()) {

                this.jsonArray = new JSONArray();
                this.jsonArray.put(new JSONObject().put("patrimonio", rst.getString("patrimonio")));
                this.jsonArray.put(new JSONObject().put("titulo", rst.getString("titulo")));
                this.jsonArray.put(new JSONObject().put("autoria", rst.getString("autoria")));
                this.jsonArray.put(new JSONObject().put("veiculo", rst.getString("veiculo")));
                this.jsonArray.put(new JSONObject().put("data", rst.getString("data_publicacao")));
                this.jsonArray.put(new JSONObject().put("arquivo", rst.getString("arquivo")));
                this.answer.add(jsonArray);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return answer;
    }

    public ArrayList<JSONArray> getBytitulo(String titulo) {
        try {
            this.answer = new ArrayList<JSONArray>();
            DbInfo database = new DbInfo();
            database.DadoBanco();
            Class.forName("org.postgresql.Driver");

            Connection con;

            con = (Connection) DriverManager.getConnection(database.getUrl(), database.getUsuario(), database.getSenha());
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM public.dadoscatalogo WHERE titulo='" + titulo + "';");
            ResultSet rst = pstmt.executeQuery();
            while (rst.next()) {
                this.jsonArray = new JSONArray();
                this.jsonArray.put(new JSONObject().put("patrimonio", rst.getString("patrimonio")));
                this.jsonArray.put(new JSONObject().put("titulo", rst.getString("titulo")));
                this.jsonArray.put(new JSONObject().put("autoria", rst.getString("autoria")));
                this.jsonArray.put(new JSONObject().put("veiculo", rst.getString("veiculo")));
                this.jsonArray.put(new JSONObject().put("data", rst.getString("data_publicacao")));
                this.jsonArray.put(new JSONObject().put("arquivo", rst.getString("arquivo")));
                this.answer.add(jsonArray);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return answer;
    }

    public ArrayList<JSONArray> getByautoria(String autoria) {
        try {
            this.answer = new ArrayList<JSONArray>();
            DbInfo database = new DbInfo();
            database.DadoBanco();
            Class.forName("org.postgresql.Driver");

            Connection con;

            con = DriverManager.getConnection(database.getUrl(), database.getUsuario(), database.getSenha());
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM dadoscatalogo WHERE autoria='" + autoria + "';");
            ResultSet rst = pstmt.executeQuery();
            while (rst.next()) {

                this.jsonArray = new JSONArray();
                this.jsonArray.put(new JSONObject().put("patrimonio", rst.getString("patrimonio")));
                this.jsonArray.put(new JSONObject().put("titulo", rst.getString("titulo")));
                this.jsonArray.put(new JSONObject().put("autoria", rst.getString("autoria")));
                this.jsonArray.put(new JSONObject().put("veiculo", rst.getString("veiculo")));
                this.jsonArray.put(new JSONObject().put("data", rst.getString("data_publicacao")));
                this.jsonArray.put(new JSONObject().put("arquivo", rst.getString("arquivo")));
                this.answer.add(jsonArray);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return answer;
    }

    public ArrayList<JSONArray> getByveiculo(String veiculo) {
        try {
            DbInfo database = new DbInfo();
            database.DadoBanco();
            Class.forName("org.postgresql.Driver");

            Connection con;

            con = DriverManager.getConnection(database.getUrl(), database.getUsuario(), database.getSenha());
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM dadoscatalogos WHERE veiculo=" + veiculo + ";");
            ResultSet rst = pstmt.executeQuery();
            while (rst.next()) {

                this.jsonArray = new JSONArray();
                this.jsonArray.put(new JSONObject().put("patrimonio", rst.getString("patrimonio")));
                this.jsonArray.put(new JSONObject().put("titulo", rst.getString("titulo")));
                this.jsonArray.put(new JSONObject().put("autoria", rst.getString("autoria")));
                this.jsonArray.put(new JSONObject().put("veiculo", rst.getString("veiculo")));
                this.jsonArray.put(new JSONObject().put("data", rst.getString("data_publicacao")));
                this.jsonArray.put(new JSONObject().put("arquivo", rst.getString("arquivo")));
                this.answer.add(jsonArray);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return answer;
    }

    public ArrayList<JSONArray> getBydata(String data) {
        try {
            DbInfo database = new DbInfo();
            database.DadoBanco();
            Class.forName("org.postgresql.Driver");

            Connection con;

            con = DriverManager.getConnection(database.getUrl(), database.getUsuario(), database.getSenha());
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM dadoscatalogo WHERE data=" + data + ";");
            ResultSet rst = pstmt.executeQuery();
            while (rst.next()) {

                this.jsonArray = new JSONArray();
                this.jsonArray.put(new JSONObject().put("patrimonio", rst.getString("patrimonio")));
                this.jsonArray.put(new JSONObject().put("titulo", rst.getString("titulo")));
                this.jsonArray.put(new JSONObject().put("autoria", rst.getString("autoria")));
                this.jsonArray.put(new JSONObject().put("veiculo", rst.getString("veiculo")));
                this.jsonArray.put(new JSONObject().put("data", rst.getString("data_publicacao")));
                this.jsonArray.put(new JSONObject().put("arquivo", rst.getString("arquivo")));
                this.answer.add(jsonArray);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return answer;
    }

    public ArrayList<JSONArray> getBypalchave(String palchave) {
        try {
            DbInfo database = new DbInfo();
            database.DadoBanco();
            Class.forName("org.postgresql.Driver");

            Connection con;

            con = DriverManager.getConnection(database.getUrl(), database.getUsuario(), database.getSenha());
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM public.palchave WHERE palchave=" + palchave + ";");
            ResultSet rst = pstmt.executeQuery();
            while (rst.next()) {

                this.jsonArray = new JSONArray();
                this.jsonArray.put(new JSONObject().put("patrimonio", rst.getString("patrimonio")));
                this.jsonArray.put(new JSONObject().put("palchave", rst.getString("palchave")));

                this.answer.add(jsonArray);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return answer;
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
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public void updateDbPalchave(RespostaDTO dto) {

        String[] parts = dto.getPalchave().replaceAll("\\s", "").split(";");
        for (int i = 0; i < parts.length; i++) {
            try {
                DbInfo database = new DbInfo();
                database.DadoBanco();
                Class.forName("org.postgresql.Driver");
                Connection con;
                con = DriverManager.getConnection(database.getUrl(), database.getUsuario(), database.getSenha());
                String query = "SELECT * FROM public.palavras_chave WHERE palchave='" + parts[i] + "' and patrimonio='"+dto.getPatrimonio()+"' ;";
                PreparedStatement pstmt = con.prepareStatement(query);
                ResultSet rst = pstmt.executeQuery();
                if (!rst.next()) {
                    query = "INSERT INTO palavras_chave (palchave, patrimonio) VALUES ('" + parts[i] + "'," + dto.getPatrimonio() + ");";
                    pstmt = con.prepareStatement(query);
                    ResultSet auxrst = pstmt.executeQuery();
                }
            } catch (Exception e) {

            }
        }
    }

    public void updateDbComentario(RespostaDTO dto) {
        //"<span style=""color:blue;"">Leao</span><br>Este é bom porque a teoria é prática.<br><hr>"
        String[] parts = dto.getComentario().split("\n");
        String comentario = "<span style=\"color:blue;\">" + parts[0] + "</span><br>" + parts[1] + "<br><hr>";
        try {
            DbInfo database = new DbInfo();
            database.DadoBanco();
            Class.forName("org.postgresql.Driver");
            Connection con;
            con = DriverManager.getConnection(database.getUrl(), database.getUsuario(), database.getSenha());
            String query = "INSERT INTO public.comentarios(comentario,patrimonio) VALUES ('" + comentario + "'," + dto.getPatrimonio() + ");";
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet rst = pstmt.executeQuery();
        } catch (Exception e) {

        }
    }
    public void insertNewCatalogo(RespostaDTO dto){
        
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
}
