package com.diaco.modelo;


import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import com.diaco.modelo.Municipio;
import com.diaco.modelo.category;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;






@Entity
@Table(name="departamento")
@NamedQuery(name = "Departamento.findAll", query = "SELECT t FROM Departamento t WHERE t.habilitado = 1")
public class Departamento implements Serializable {

   
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codigo_departamento", precision=0)
        private Integer codigo;
        @Column(name="nombre_departamento")
        private String nombre;
        @Column(name="habilitado")
        private String habilitado;
        @JoinColumn(name = "codigo_departamento", referencedColumnName = "codigo_departamento",updatable=false, insertable=false)
        @OneToOne
        private List<Municipio> tipoMunicipio = new ArrayList<>(); 
//        private List<Municipio> municipio = new ArrayList<>();
	//@Column(name="id_Categoria")
//        private Integer id_Categoria;
//        @JoinColumn(name = "id_Categoria", referencedColumnName = "id_Categoria", updatable=false, insertable = false)
//        @OneToOne
        //private List<category> typeCategory = new ArrayList<>();
        
	public Departamento() {
	}

        
        
        
        
//    /**
//     * @return the municipio
//     */
//    public List<Municipio> getMunicipio() {
//        return municipio;
//    }
//
//    /**
//     * @param municipio the municipio to set
//     */
//    public void setMunicipio(List<Municipio> municipio) {
//        this.municipio = municipio;
//    }

   
    /**
     * @return the codigo
     * 
     */
    public Integer getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
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

    @Override
    public String toString() {
        JsonObject dep = new JsonObject();
        JsonArray muni = new JsonArray();
        JsonArray cate = new JsonArray();
        dep.addProperty("code",this.codigo);
        dep.addProperty("name",this.nombre);
        for(Municipio loc : this.tipoMunicipio){
            muni.add(loc.toJsonelement());
        }
        dep.add("locations",muni);
        
//        for(category cat : this.typeCategory){
//            cate.add(cat.toString());  
//        }
//        dep.add("category",cate);
        
        return dep.toString();
    }
      
}
