package ufrj.pedroeusebio.biblioteca_pdf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BibliotecaDAO extends BaseDAO {
// Implementing all getters ------------------------------------------------------------------------------------------------------------------------------------------------------
    boolean getBypatrimonio(RespostaDTO dto) {
        try {
            Connection con = getConnection();
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM "+" WHERE patrimonio=?;");
            pstmt.setString(1, dto.getPatrimonio());
            ResultSet rst = pstmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    boolean getBytitulo(RespostaDTO dto) {
        try {
            Connection con = getConnection();
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM "+" WHERE titulo=?;");
            pstmt.setString(1, dto.getTitulo());
            ResultSet rst = pstmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    boolean getByautoria(RespostaDTO dto) {
        try {
            Connection con = getConnection();
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM "+" WHERE autoria=?;");
            pstmt.setString(1, dto.getAutoria());
            ResultSet rst = pstmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    boolean getByveiculo(RespostaDTO dto) {
        try {
            Connection con = getConnection();
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM "+" WHERE veiculo=?;");
            pstmt.setString(1, dto.getVeiculo());
            ResultSet rst = pstmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    boolean getBydata(RespostaDTO dto) {
        try {
            Connection con = getConnection();
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM "+" WHERE data=?;");
            pstmt.setString(1, dto.getData());
            ResultSet rst = pstmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    boolean getBypalchave(RespostaDTO dto) {
        try {
            Connection con = getConnection();
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM "+" WHERE palchave=?;");
            pstmt.setString(1, dto.getPalchave());
            ResultSet rst = pstmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
        
    //Implementing all write at the database -------------------------------------------------------------------------------------------------------------------------------------
    }
}
