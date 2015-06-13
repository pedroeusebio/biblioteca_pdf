/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufrj.pedroeusebio.biblioteca_pdf;

import java.io.BufferedReader;
import static java.io.FileDescriptor.out;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import javax.json.*;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;

public class Controller extends HttpServlet {

    //private BibliotecaDAO database;
    //private base2 database2;
    private ArrayList<JSONArray> answer;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String json = "";
        if (br != null) {
            json = br.readLine();
        }
        JsonReader reader = Json.createReader(new StringReader(json));
        JsonObject JSONObject = reader.readObject();
        reader.close();

        JsonObject innerObj;
        RespostaDTO dto = new RespostaDTO();
        BibliotecaDAO Biblioteca = null;
        try {
            System.out.println(JSONObject.getJsonObject("autoria").getString("texto").isEmpty());
            if (JSONObject.getString("patrimonio") != null && !JSONObject.getString("patrimonio").isEmpty()) {
                System.out.println("entrei");
                Biblioteca.getBypatrimonio(JSONObject.getString("patrimonio"));
            } else {
                if (JSONObject.getJsonObject("autoria").getString("texto") != null && !JSONObject.getJsonObject("autoria").getString("texto").isEmpty()) {
                    System.out.println("entrei");
                    innerObj = JSONObject.getJsonObject("autoria");
                    Biblioteca.getByautoria(innerObj.getString("texto"));
                }
                if (JSONObject.getJsonObject("titulo") != null) {
                    System.out.println("entrei");
                    innerObj = JSONObject.getJsonObject("titulo");
                    Biblioteca.getBytitulo(innerObj.getString("texto"));
                }
                if (JSONObject.getJsonObject("data") != null) {
                    System.out.println("entrei");
                    innerObj = JSONObject.getJsonObject("data");
                    Biblioteca.getBydata(innerObj.getString("texto"));
                }
                if (JSONObject.getJsonObject("palchave") != null) {
                    System.out.println("entrei");
                    innerObj = JSONObject.getJsonObject("palchave");
                    Biblioteca.getBydata(innerObj.getString("texto"));
                }
            }
            innerObj = JSONObject.getJsonObject("autoria");
            dto.setAutoria(innerObj.getString("texto"));

        } catch (Exception e) {

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
