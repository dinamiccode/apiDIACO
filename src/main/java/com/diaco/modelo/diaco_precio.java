
package com.diaco.modelo;

import java.io.Serializable;
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
import com.diaco.modelo.diaco_diaco_name_template;
import com.diaco.modelo.diaco_plantilla;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Entity
@Table(name="diaco_vaciadocba")
@NamedQueries({
    @NamedQuery(name = "VaciadoPrecios.findAll", query = "SELECT DISTINCT d FROM diaco_precio d")  
})
public class diaco_precio implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="correlativo", precision=0)
        private Integer code;
    @Column(name="idPlantilla")
    private Integer idPlantilla;
    @JoinColumn(name = "idPlantilla", referencedColumnName = "id",updatable=false, insertable=false)
        @OneToOne
   
    private diaco_diaco_name_template tipoTemplate;
    
    @Column(name="NombreTemplate")
    private String NombreTemplate;
//    @JoinColumn(name = "NombreTemplate", referencedColumnName = "NombrePlantilla",updatable=false, insertable=false)
//    @OneToOne
//     private diaco_plantilla tipoPlantilla; 
    //@Column(name="NombrePlantilla")
    //private String Plantilla;
//    @JoinColumn(name = "Plantilla", referencedColumnName = "NombrePlantilla",updatable=false, insertable=false)
//        @OneToOne
        //private diaco_plantilla tipoPlantilla;

    
    
    
    public diaco_precio(){
        
    }

    /**
     * @return the code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(Integer code) {
        this.code = code;
    }
    
    

   
    
    @Override
    public String toString() {
        JsonObject precio = new JsonObject();
        JsonArray template = new JsonArray();
//        JsonArray cate = new JsonArray();
        precio.addProperty("Plantilla",this.tipoTemplate.getId());
        precio.addProperty("template", this.tipoTemplate.getNombreTemplate());
        
        //dep.addProperty("name",this.nombre);
//        for(diaco_diaco_name_template loc : this.tipoTemplate){
//            template.add(loc.toJsonelement());
//        }
//        precio.add("template",template);
        
//        for(category cat : this.typeCategory){
//            cate.add(cat.toString());  
//        }
//        dep.add("category",cate);
        
        return precio.toString();
    }
    public JsonObject toJsonelement() {
            JsonObject precio = new JsonObject();
            
                precio.addProperty("Plantilla",this.tipoTemplate.getId());
                //precio.addProperty("template", this.tipoPlantilla.getIdCategoria());
                //precio.addProperty("nombre",this.tipoPlantilla.getNombrePlantilla());
                //precio.addProperty("Nombre",this.tipoTemplate.getNombreTemplate());
//            temp.addProperty("name",this.nombre);
            return precio;
        }

    /**
     * @return the idPlantilla
     */
    public Integer getIdPlantilla() {
        return idPlantilla;
    }

    /**
     * @param idPlantilla the idPlantilla to set
     */
    public void setIdPlantilla(Integer idPlantilla) {
        this.idPlantilla = idPlantilla;
    }
}
