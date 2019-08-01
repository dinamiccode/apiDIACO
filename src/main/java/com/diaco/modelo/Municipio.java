package com.diaco.modelo;


import com.google.gson.JsonObject;
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
import com.diaco.modelo.category;
import com.google.gson.JsonArray;
import com.diaco.model.diaco_categorias;

@Entity
@Table(name="municipio")
@NamedQueries({
    @NamedQuery(name = "Municipio.findAll", query = "SELECT m FROM Municipio m"),
    @NamedQuery(name = "Municipio.findByIdDepartamento", query = "SELECT m FROM Municipio m where m.codigo_departamento = :id_departamento")  
})
//, @NamedQuery(name = "Municipio.findByNombreMunicipio", query = "SELECT m FROM Municipio m WHERE m.nombreMunicipio = :nombreMunicipio")
public class Municipio implements Serializable{

    
    private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codigo_municipio", precision=0)
        private Integer codigo;
        @Column(name="codigo_departamento", precision=0)
        private Integer codigo_departamento;
        @Column(name="nombre_municipio")
        private String nombre;
        
        
//        @JoinColumn(name = "codigo_departamento", referencedColumnName = "codigo",updatable=false, insertable=false)
//        @OneToOne
//        private Departamento tipoDepartamento; 
//        @JoinColumn(name = "codigo_municipio", referencedColumnName = "codigo_municipio",updatable=false, insertable=false)
//        @OneToOne
//        private diaco_categorias categoriaId;
        
	public Municipio() {
	}


    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        JsonObject temp = new JsonObject();
        temp.addProperty("codigo_municipio",this.codigo);
        temp.addProperty("codigo_departamento",this.codigo_departamento);
        temp.addProperty("nombre_municipio",this.nombre);
//        temp.addProperty("code",this.categoriaId.getId_Categoria());
//        temp.addProperty("name",this.categoriaId.getNombre());
        return temp.toString()+",";
    }

     public JsonObject toJsonelement() {
            JsonObject temp = new JsonObject();
            temp.addProperty("codigo_municipio",this.codigo);
            temp.addProperty("codigo_departamento",this.codigo_departamento);
            temp.addProperty("nombre_municipio",this.nombre);
//            temp.addProperty("code",this.categoriaId.getId_Categoria());
//            temp.addProperty("name",this.categoriaId.getNombre());
            return temp;
        }

        

        

}
