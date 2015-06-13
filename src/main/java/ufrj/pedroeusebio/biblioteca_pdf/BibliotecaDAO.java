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
    private ArrayList<JSONArray> answer;
    
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

            con =  (Connection) DriverManager.getConnection(database.getUrl(), database.getUsuario(), database.getSenha());
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
     //Implementing all write at the database -------------------------------------------------------------------------------------------------------------------------------------
}
