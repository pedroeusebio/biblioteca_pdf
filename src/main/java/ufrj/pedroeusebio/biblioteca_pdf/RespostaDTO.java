
package ufrj.pedroeusebio.biblioteca_pdf;

import java.io.Serializable;
import javax.json.Json;
import javax.json.JsonObject;

public class RespostaDTO implements Serializable{
    private String patrimonio;
    private String titulo;
    private String autoria;
    private String veiculo;
    private String data;
    private String palchave;
    private String comentario;
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPalchave() {
        return palchave;
    }

    public void setPalchave(String palchave) {
        this.palchave = palchave;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public JsonObject getObjetoJSON() {
        return objetoJSON;
    }

    public void setObjetoJSON(JsonObject objetoJSON) {
        this.objetoJSON = objetoJSON;
    }

    public String getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(String patrimonio) {
        this.patrimonio = patrimonio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutoria() {
        return autoria;
    }

    public void setAutoria(String autoria) {
        this.autoria = autoria;
    }
    
    JsonObject objetoJSON;
    
    public JsonObject toJSON(){

        objetoJSON = Json.createObjectBuilder()
                .add("campo1", patrimonio)
                .add("campo2", titulo)
                .add("campo3", autoria)
                .add("campo4", veiculo)
                .add("campo5", data)
                .add("campo6", palchave)
                .add("campo7", comentario)
                .add("campo8", path)
                .build();
        
        return objetoJSON;
    }
    
    @Override
    public String toString(){
        return toJSON().toString();
    }
}
