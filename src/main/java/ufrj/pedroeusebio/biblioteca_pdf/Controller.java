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
import java.util.ArrayList;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;

public class Controller extends HttpServlet {

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
        BibliotecaDAO Biblioteca = new BibliotecaDAO();
        ArrayList<JSONArray> answer = new ArrayList<>();
        Biblioteca.setStrQuery("");
        String Query = "";
        try {
            if (!JSONObject.getString("patrimonio").isEmpty()) {
                System.out.println("entrei !!");
                dto.setPatrimonio(JSONObject.getString("patrimonio"));
                if (Biblioteca.getStrQuery().isEmpty()) {
                    Query += "SELECT patrimonio FROM public.dadoscatalogo WHERE patrimonio='" + dto.getPatrimonio() + "' ";
                    Biblioteca.setStrQuery(Query);
                } else {
                    Query += Biblioteca.QueryGenatator("patrimonio", dto.getPatrimonio(), null,"dadoscatalogo");
                }
            }
        } catch (Exception e) {
        }
        try {
            if (!JSONObject.getJsonObject("titulo").isEmpty()) {
                innerObj = JSONObject.getJsonObject("titulo");
                dto.setTitulo(innerObj.getString("texto"));
                if (Biblioteca.getStrQuery().isEmpty()) {
                    Query += "SELECT patrimonio FROM public.dadoscatalogo WHERE titulo='" + dto.getTitulo() + "' ";
                    Biblioteca.setStrQuery(Query);
                } else {
                    Query += Biblioteca.QueryGenatator("titulo", dto.getTitulo(), innerObj.getString("mode"),"dadoscatalogo");
                };
            }
        } catch (Exception e) {
        }
        try {
            if (!JSONObject.getJsonObject("autoria").isEmpty()) {
                innerObj = JSONObject.getJsonObject("autoria");
                dto.setAutoria(innerObj.getString("texto"));
                if (Biblioteca.getStrQuery().isEmpty()) {
                    Query += "SELECT patrimonio FROM public.dadoscatalogo WHERE autoria='" + dto.getAutoria() + "' ";
                    Biblioteca.setStrQuery(Query);
                } else {
                    Query += Biblioteca.QueryGenatator("autoria", dto.getAutoria(), innerObj.getString("mode"),"dadoscatalogo");
                }
            }
        } catch (Exception e) {
        }
        try {
            if (!JSONObject.getJsonObject("veiculo").isEmpty()) {
                innerObj = JSONObject.getJsonObject("veiculo");
                dto.setVeiculo(innerObj.getString("texto"));
                if (Biblioteca.getStrQuery().isEmpty()) {
                    Query += "SELECT patrimonio FROM public.dadoscatalogo WHERE veiculo='" + dto.getVeiculo() + "' ";
                    Biblioteca.setStrQuery(Query);
                } else {
                    Query += Biblioteca.QueryGenatator("veiculo", dto.getAutoria(), innerObj.getString("mode"),"dadoscatalogo");
                }
            }
        } catch (Exception e) {
        }
        try {
            if (!JSONObject.getJsonObject("datapublicacao").isEmpty()) {
                innerObj = JSONObject.getJsonObject("datapublicacao");
                dto.setData(innerObj.getString("texto"));
                if (Biblioteca.getStrQuery().isEmpty()) {
                    Query += "SELECT patrimonio FROM public.dadoscatalogo WHERE data_publicacao='" + dto.getData() + "' ";
                    Biblioteca.setStrQuery(Query);
                } else {
                    Query += Biblioteca.QueryGenatator("datapublicacao", dto.getData(), innerObj.getString("mode"),"dadoscatalogo");
                }
            }
        } catch (Exception e) {
        }
        try {
            if (!JSONObject.getJsonObject("palchave").isEmpty()) {
                innerObj = JSONObject.getJsonObject("palchave");
                String[] parts = innerObj.getString("texto").replaceAll("\\s", "").split(";");
                for (int i = 0; i < parts.length; i++) {
                    if (Biblioteca.getStrQuery().isEmpty()) {
                        Query += "SELECT patrimonio FROM public.palavras_chave WHERE palchave='" + parts[i] + "' ";
                        Biblioteca.setStrQuery(Query);
                    } else if(!Biblioteca.getStrQuery().isEmpty()) {
                        Query += Biblioteca.QueryGenatator("palchave", parts[i] , innerObj.getString("mode"),"palavras_chave");
                    }
                }   
            }
        } catch (Exception e) {
        }
        try{
            if(JSONObject.getJsonObject("palchave").isEmpty() && JSONObject.getJsonObject("datapublicacao").isEmpty()
                    && JSONObject.getJsonObject("veiculo").isEmpty() && JSONObject.getJsonObject("autoria").isEmpty()
                            && JSONObject.getJsonObject("titulo").isEmpty() && JSONObject.getJsonObject("patrimonio").isEmpty()){
                Query = "SELECT patrimonio FROM public.dadoscatalogo;";
                
            }
        }catch(Exception e){
            
        }
        
        answer.addAll(Biblioteca.ExecuteQuery(Query));

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
