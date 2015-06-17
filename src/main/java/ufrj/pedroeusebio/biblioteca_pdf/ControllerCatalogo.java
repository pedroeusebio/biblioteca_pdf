/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufrj.pedroeusebio.biblioteca_pdf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pedroeusebio
 */
public class ControllerCatalogo extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String json = "";
        if (br != null) {
            json = br.readLine();
        }
        JsonReader reader = Json.createReader(new StringReader(json));
        JsonObject JSONObject = reader.readObject();
        reader.close();
        RespostaDTO dto = new RespostaDTO();
        boolean send = false;
        BibliotecaDAO biblioteca = new BibliotecaDAO();
        System.out.println(JSONObject);
        try {
            if (!JSONObject.getString("patrimonio").isEmpty()) {
                dto.setPatrimonio(JSONObject.getString("patrimonio"));
            }
            if (!JSONObject.getString("autoria").isEmpty()) {
                dto.setAutoria(JSONObject.getString("autoria"));
            }
            if (!JSONObject.getString("titulo").isEmpty()) {
                dto.setTitulo(JSONObject.getString("titulo"));
            }
            if (!JSONObject.getString("veiculo").isEmpty()) {
                dto.setVeiculo(JSONObject.getString("veiculo"));
            }
            if (!JSONObject.getString("datapublicacao").isEmpty()) {
                dto.setData(JSONObject.getString("datapublicacao"));
            }
            if (!JSONObject.getString("palchave").isEmpty()) {
                dto.setPalchave(JSONObject.getString("palchave"));
            }
            if (!JSONObject.getString("novocomentario").isEmpty()) {
                String[] parts = JSONObject.getString("novocomentario").split("\n");
                String comentario = "<span style=\"color:blue;\">" + parts[0] + "</span><br>" + parts[1] + "<br><hr>";
                dto.setComentario(comentario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (JSONObject.getString("mode").equalsIgnoreCase("atualizar")) {
            try {
                biblioteca.updateDatebase(dto);
                if (!dto.getPalchave().isEmpty()) {
                    biblioteca.updateDbPalchave(dto);
                }
                if (!dto.getComentario().isEmpty()) {
                    biblioteca.updateDbComentario(dto);
                }
            } catch (Exception e) {

            }
        } else if (JSONObject.getString("mode").equalsIgnoreCase("excluir")) {
            biblioteca.deleteData(dto);
        } else if (JSONObject.getString("mode").equalsIgnoreCase("novo")) {
            biblioteca.addNewCatalogo(dto);
        }

        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(dto.toString());
        out.flush();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
