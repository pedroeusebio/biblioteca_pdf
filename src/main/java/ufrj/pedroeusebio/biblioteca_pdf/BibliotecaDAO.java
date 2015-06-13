package ufrj.pedroeusebio.biblioteca_pdf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BibliotecaDAO extends base2 {
// Implementing all getters ------------------------------------------------------------------------------------------------------------------------------------------------------

    public boolean getBypatrimonio(String patrimonio) {
        try {
            DbInfo database = new DbInfo();
            database.DadoBanco();

            Class.forName("org.postgresql.Driver");

            Connection con;

            con = DriverManager.getConnection(database.getUrl(), database.getUsuario(), database.getSenha());
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM dadoscatalogo WHERE patrimonio=" + patrimonio + ";");
            ResultSet rst = pstmt.executeQuery();
            while (rst.next()) {

            }
            con.close();
            //System.out.println(rst.getString("titulo"));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean getBytitulo(String titulo) {
        try {
            DbInfo database = new DbInfo();
            database.DadoBanco();
            Class.forName("org.postgresql.Driver");

            Connection con;

            con = DriverManager.getConnection(database.getUrl(), database.getUsuario(), database.getSenha());
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM dadoscatalogo WHERE titulo=" + titulo + ";");
            ResultSet rst = pstmt.executeQuery();
            rst.next();
            System.out.println(rst.getString("patrimonio"));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean getByautoria(String autoria) {
        try {
            DbInfo database = new DbInfo();
            database.DadoBanco();
            Class.forName("org.postgresql.Driver");

            Connection con;

            con = DriverManager.getConnection(database.getUrl(), database.getUsuario(), database.getSenha());
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM dadoscatalogo WHERE autoria=" + autoria + ";");
            //pstmt.setString(1, dto.getAutoria());
            ResultSet rst = pstmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean getByveiculo(String veiculo) {
        try {
            DbInfo database = new DbInfo();
            database.DadoBanco();
            Class.forName("org.postgresql.Driver");

            Connection con;

            con = DriverManager.getConnection(database.getUrl(), database.getUsuario(), database.getSenha());
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM dadoscatalogos WHERE veiculo=" + veiculo + ";");
            ResultSet rst = pstmt.executeQuery();
            rst.next();
            System.out.println(rst.getString("veiculo"));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean getBydata(String data) {
        try {
            DbInfo database = new DbInfo();
            database.DadoBanco();
            Class.forName("org.postgresql.Driver");

            Connection con;

            con = DriverManager.getConnection(database.getUrl(), database.getUsuario(), database.getSenha());
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM dadoscatalogo WHERE data=" + data + ";");
            ResultSet rst = pstmt.executeQuery();
            rst.next();
            System.out.println(rst.getString("titulo"));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean getBypalchave(String palchave) {
        try {
            DbInfo database = new DbInfo();
            database.DadoBanco();
            Class.forName("org.postgresql.Driver");

            Connection con;

            con = DriverManager.getConnection(database.getUrl(), database.getUsuario(), database.getSenha());
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM dadoscatalogo WHERE palchave=" + palchave + ";");
            ResultSet rst = pstmt.executeQuery();
            rst.next();
            System.out.println(rst.getString("palchave"));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
     //Implementing all write at the database -------------------------------------------------------------------------------------------------------------------------------------
}
