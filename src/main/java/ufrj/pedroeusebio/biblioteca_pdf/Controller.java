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


public class Controller extends HttpServlet{
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Não é um par nome-valor, então tem que ler como se fosse um upload de arquivo...
        BufferedReader br = new BufferedReader(new  InputStreamReader(request.getInputStream()));
        String json = "";
        if(br != null){
            json = br.readLine();
        }
        
        //Converte o string em "objeto json" java
        // Create JsonReader from Json.
        JsonReader reader = Json.createReader(new StringReader(json));
        // Get the JsonObject structure from JsonReader.
        JsonObject jsonObject = reader.readObject();
        // We are done with the reader, let's close it.
        reader.close();
        
        // Agora é só responder...
        RespostaDTO dto = new RespostaDTO();
        dto.setPatrimonio("Servidor recebeu:" + jsonObject.getString("campo1"));
        dto.setTitulo("Servidor recebeu:" + jsonObject.getString("campo2"));
        //dto.setCampo3("Servidor recebeu:" + jsonObject.getString("campo3"));
        //dto.setCampo4("Servidor recebeu:" + jsonObject.getString("campo4"));
        //System.out.println(dto.campo3);
        //System.out.println(dto.campo4);
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
