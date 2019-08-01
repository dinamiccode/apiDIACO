
package com.diaco.model;

import com.diaco.modelo.Municipio;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(
            name="getCategoriasAll",
            procedureName = "GetMunicipiosCategoria",
            resultClasses = { diaco_categorias.class }
//            parameters={
//                @StoredProcedureParameter(mode = ParameterMode.IN, type = int.class, name = "codigo_municipio")  
//            }
    )
})
@Entity
public class diaco_categorias implements Serializable{


    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="id_Categoria",precision=0)
    private Integer id_Categoria;
    @Column(name="codigo_municipio")
    private Integer codigo_municipio;
    @Column(name="nombre")
    private String nombre;
    
    
    
    
    
    public diaco_categorias(){
        
    }
    
   
    

    /**
     * @return the id_Categoria
     */
    public Integer getId_Categoria() {
        return id_Categoria;
    }

    /**
     * @param id_Categoria the id_Categoria to set
     */
    public void setId_Categoria(Integer id_Categoria) {
        this.id_Categoria = id_Categoria;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the codigo_municipio
     */
    public Integer getCodigo_municipio() {
        return codigo_municipio;
    }

    /**
     * @param codigo_municipio the codigo_municipio to set
     */
    public void setCodigo_municipio(Integer codigo_municipio) {
        this.codigo_municipio = codigo_municipio;
    }

     @Override
    public String toString() {
        JsonObject temp = new JsonObject();
        temp.addProperty("code", this.id_Categoria);
        temp.addProperty("name", this.nombre);
        temp.addProperty("municipio", this.codigo_municipio);
        return temp.toString();
    }
    
     public JsonObject toJsonelement() {
        JsonObject temp = new JsonObject();
        temp.addProperty("code", this.id_Categoria);
        temp.addProperty("name", this.nombre);
        temp.addProperty("municipio", this.codigo_municipio);
        return temp;
    }
}
