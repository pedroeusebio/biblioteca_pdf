/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufrj.pedroeusebio.biblioteca_pdf;

/**
 *
 * @author pedroeusebio
 */
public class DbInfo {
    private String url;
    private String usuario;
    private String senha;

    public String getUrl() {
        return url;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }
    
    public void DadoBanco(){
        url = "jdbc:postgresql://localhost:5432/biblio_db";
        usuario = "postgres";
        senha = "pedror@fa95pr";
    }
    
}
