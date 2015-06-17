/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufrj.pedroeusebio.biblioteca_pdf;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author pedroeusebio
 */
public class ServletFile extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/javascript;charset=UTF-8");
        boolean UploadedFile = false;
        String fileName = null;
        String patrimonio = null;
        Part part = null;
        PrintWriter out = response.getWriter();
        try {
            ArrayList parts = (ArrayList) request.getParts();
            patrimonio = request.getParameter("patrimonio");
            Iterator itr = parts.iterator();
            while (itr.hasNext()) {
                part = (Part) itr.next();
                if (part.getName().compareTo("arquivo") == 0) {
                    fileName = extractFileName(part, patrimonio);
                    String path = this.getServletContext().getRealPath("");
                    String pathAux[] = path.split("/biblioteca_pdf/");
                    String filePath = pathAux[0] + "/biblioteca_pdf/src/main/webapp/files/" + fileName;
                    System.out.println(filePath);
                    System.out.println(fileName);
                    BibliotecaDAO biblioteca = new BibliotecaDAO();
                    RespostaDTO dto = new RespostaDTO();
                    dto.setPatrimonio(patrimonio);
                    dto.setPath(fileName);
                    biblioteca.saveFile(dto);
                    part.write(filePath);
                    UploadedFile = true;
                }
                out.print(UploadedFile);
                out.flush();
            }
        } catch (Exception e) {
            out.print(false);
            out.flush();
            e.printStackTrace();
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String extractFileName(Part part, String patrimonio) {
        String numberAux = patrimonio;
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {

            if (s.trim().startsWith("filename")) {
                System.out.println(s);
                for (int i = patrimonio.length(); i < 6; i++) {
                    numberAux = '0' + numberAux;
                }
                String aux = s.substring(11, s.length() - 1);
                System.out.println(aux);
                String ext = "";
                for (int j = aux.length() - 1; j >= 0; j--) {
                    if (aux.charAt(j) != '.') {
                        String aux2 = ext;
                        ext = aux.charAt(j) + aux2;
                    } else {
                        break;
                    }
                }
                numberAux += "." + ext;
            }
        }
        System.out.println(numberAux);
        return numberAux;
    }

}
