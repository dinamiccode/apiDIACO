
package com.diaco.modelo;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.diaco.modelo.diaco_diaco_name_template;
import java.io.Serializable;

@Entity
@Table(name="diaco_plantillascba")
@NamedQueries({
    @NamedQuery(name = "vaciadoPlantilla.findAll", query = "SELECT   d FROM diaco_plantilla d")  
})
public class diaco_plantilla  implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="idPlantilla", precision=0)
    private Integer idPlantilla;
    @Column(name="NombrePlantilla")
    private String NombrePlantilla;
    @Column(name="idCategoria")
    private Integer idCategoria;
//    @JoinColumn(name="NombrePlantilla", referencedColumnName = "NombreTemplate", updatable=false, insertable=false)
//    @OneToOne
//    private  diaco_diaco_name_template tipoNombre;
    
    public diaco_plantilla(){
        
    }


    public Integer getIdPlantilla() {
        return idPlantilla;
    }

 
    public void setIdPlantilla(Integer idPlantilla) {
        this.idPlantilla = idPlantilla;
    }


    public String getNombrePlantilla() {
        return NombrePlantilla;
    }


    public void setNombrePlantilla(String NombrePlantilla) {
        this.NombrePlantilla = NombrePlantilla;
    }
    
    
        @Override
    public String toString() {
        JsonObject temp = new JsonObject();
        temp.addProperty("Nombre", this.getNombrePlantilla());
        //temp.addProperty("nTemplate",this.tipoNombre.getNombreTemplate());

        return temp.toString()+",";
    }

     public JsonObject toJsonelement() {
            JsonObject temp = new JsonObject();
                temp.addProperty("Nombre", this.getNombrePlantilla());
                //temp.addProperty("nTemplate",this.tipoNombre.getNombreTemplate());
//            temp.addProperty("name",this.nombre);
            return temp;
        }

    /**
     * @return the idCategoria
     */
    public Integer getIdCategoria() {
        return idCategoria;
    }

    /**
     * @param idCategoria the idCategoria to set
     */
    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }
    
}
