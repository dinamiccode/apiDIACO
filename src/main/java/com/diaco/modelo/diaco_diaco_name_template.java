
package com.diaco.modelo;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.diaco.modelo.diaco_precio;
import java.io.Serializable;

@Entity
@Table(name="diaco_name_template_cba")
@NamedQueries({
    @NamedQuery(name = "vaciadotemplate.findAll", query = "SELECT d FROM diaco_diaco_name_template d")  
})
public class diaco_diaco_name_template implements Serializable{
     private static final long serialVersionUID = 1L;
    @Id
    @Column(name="id", precision=0)
    private Integer id;
    @Column(name="NombreTemplate")
    private String NombreTemplate;
   
    @JoinColumn(name = "NombreTemplate", referencedColumnName = "NombrePlantilla",updatable=false, insertable=false)
    @OneToOne
     private diaco_plantilla tipoPlantilla; 
    
    
    public diaco_diaco_name_template(){
        
    }

  
    
    
    
    @Override
    public String toString() {
        JsonObject temp = new JsonObject();
        JsonArray precio = new JsonArray();
        temp.addProperty("codigo", this.getId());
        temp.addProperty("nombre", this.tipoPlantilla.getNombrePlantilla());
        //temp.addProperty("Plantilla",this.tipoPrecio.getIdPlantilla());
//        for(diaco_precio loc : this.tipoTemplate){
//            precio.add(loc.toJsonelement());
//        }
//        temp.add("precio",precio);
        
//        temp.addProperty("codigo_departamento",this.codigo_departamento);
//        temp.addProperty("nombre_municipio",this.nombre);

        return temp.toString()+",";
    }

     public JsonObject toJsonelement() {
            JsonObject temp = new JsonObject();
            JsonArray precio = new JsonArray();
                temp.addProperty("codigo", this.getId());
                temp.addProperty("nombre", this.tipoPlantilla.getNombrePlantilla());
//            temp.addProperty("name",this.nombre);
            return temp;
        }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the NombreTemplate
     */
    public String getNombreTemplate() {
        return NombreTemplate;
    }

    /**
     * @param NombreTemplate the NombreTemplate to set
     */
    public void setNombreTemplate(String NombreTemplate) {
        this.NombreTemplate = NombreTemplate;
    }

    
}
