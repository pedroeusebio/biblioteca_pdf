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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import org.json.JSONObject;

public class Controller extends HttpServlet {

    //private ArrayList<JSONArray> answer;
    //private BibliotecaDAO Biblioteca;
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
        System.out.println(JSONObject);
        JsonObject innerObj;
        RespostaDTO dto = new RespostaDTO();
        BibliotecaDAO Biblioteca = new BibliotecaDAO();
        ArrayList<JSONArray> answer = new ArrayList<JSONArray>();
        ArrayList<JSONArray> answeraux = new ArrayList<JSONArray>();
        String[] ModeArray = new String[4];

        try {
            if (!JSONObject.getString("patrimonio").isEmpty()) {
                System.out.println("entrei1");
                dto.setPatrimonio(JSONObject.getString("patrimonio"));
                answer.addAll(Biblioteca.getBypatrimonio(dto.getPatrimonio()));
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        try {
            if (!JSONObject.getJsonObject("titulo").isEmpty()) {
                System.out.println("entrei 2");
                innerObj = JSONObject.getJsonObject("titulo");
                dto.setTitulo(innerObj.getString("texto"));
                ModeArray[0] = innerObj.getString("mode");
                System.out.println(ModeArray[0]);
                if (ModeArray[0].equalsIgnoreCase("OU")) {
                    System.out.println("entrei3");
                    System.out.println(dto.getTitulo());
                    answer.addAll(Biblioteca.getBytitulo(dto.getTitulo()));
                } else {
                    answeraux = Biblioteca.getBytitulo(dto.getTitulo());
                    if(answer.size()!= 0){
                    for (int i = 0; i < answeraux.size(); i++) {
                        if (!answer.contains(answeraux.get(i))) {
                            answer.remove(answeraux.get(i));
                        }
                    }
                    }else {answer.addAll(Biblioteca.getBytitulo(dto.getTitulo()));}
                }
            }
            //if(!JSONObject.getJsonObject("").isEmpty())
        } catch (Exception e) {
            //e.printStackTrace();
        }
        try {
            if (!JSONObject.getJsonObject("autoria").isEmpty()) {
                System.out.println("entrei autoria");
                innerObj = JSONObject.getJsonObject("autoria");
                dto.setAutoria(innerObj.getString("texto"));
                ModeArray[0] = innerObj.getString("mode");
                if (ModeArray[0].equalsIgnoreCase("OU")) {;
                    System.out.println(dto.getAutoria());
                    answer.addAll(Biblioteca.getByautoria(dto.getAutoria()));
                } else {
                    answeraux = Biblioteca.getByautoria(dto.getAutoria());
                    if(answer.size()!= 0){
                        System.out.println("nao ta vazia !");
                    for (int i = 0; i < answeraux.size(); i++) {
                        if (!answer.contains(answeraux.get(i))) {
                            System.out.println("removerei!");
                            answer.remove(answeraux.get(i));
                            System.out.println("removi!");
                        }
                    }
                    }else {answer.addAll(Biblioteca.getByautoria(dto.getAutoria()));}
                }
            }
            //if(!JSONObject.getJsonObject("").isEmpty())
        } catch (Exception e) {
            //e.printStackTrace();
        }
        System.out.println(answer);
            //dto.setTitulo(JSONObject.getJsonObject("titulo").getString("texto"));
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(answer);
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
