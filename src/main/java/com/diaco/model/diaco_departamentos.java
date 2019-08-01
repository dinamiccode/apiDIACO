
package com.diaco.model;

import com.diaco.modelo.Municipio;
import com.diaco.modelo.category;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToOne;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(
            name="getDepartamentAll",
            procedureName = "GetDepartamentos",
            resultClasses = { diaco_departamentos.class }
    )
})
@Entity
public class diaco_departamentos implements Serializable{


    private static final long serialVersionUID = 1L;
    
    @Id
    
    @Column(name="codigo_departamento")
    private Integer codigo_departamento;
    @Column(name="nombre_departamento")
    private String nombre_departamento;
    
    @JoinColumn(name = "codigo_departamento", referencedColumnName = "codigo_departamento",updatable=false, insertable=false)
        @OneToOne
        private List<Municipio> tipoMunicipio = new ArrayList<>(); 
    
//    @JoinColumn(name = "id_Categoria", referencedColumnName = "id_Categoria",updatable=false, insertable=false)
//        @OneToOne
//        private List<category> tipoCategoria = new ArrayList<>(); 
    public diaco_departamentos(){
        
    }
    
  

    public Integer getCodigo_departamento() {
        return codigo_departamento;
    }

    public void setCodigo_departamento(Integer codigo_departamento) {
        this.codigo_departamento = codigo_departamento;
    }

    public String getNombre_departamento() {
        return nombre_departamento;
    }

    public void setNombre_departamento(String nombre_departamento) {
        this.nombre_departamento = nombre_departamento;
    }

 @Override
    public String toString() {
        JsonObject dep = new JsonObject();
        JsonArray muni = new JsonArray();
        JsonArray cate = new JsonArray();
        dep.addProperty("code",this.codigo_departamento);
        dep.addProperty("name",this.nombre_departamento);
        for(Municipio loc : this.tipoMunicipio){
            muni.add(loc.toJsonelement());
        }
        dep.add("locations",muni);
//        for(category loc : this.tipoCategoria){
//            cate.add(loc.toJsonelement());
//        }
//        dep.add("category",cate);
        
//        for(category cat : this.typeCategory){
//            cate.add(cat.toString());  
//        }
//        dep.add("category",cate);
        
        return dep.toString();
    }

    
}
