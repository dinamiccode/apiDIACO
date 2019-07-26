package com.diaco.modelo;

import com.google.gson.JsonObject;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="municipio")
@NamedQueries({
    @NamedQuery(name = "Municipio.findAll", query = "SELECT m FROM Municipio m"),
    @NamedQuery(name = "Municipio.findByIdDepartamento", query = "SELECT m FROM Municipio m  WHERE m.codigo_departamento = :idDepartamento")  
})
//, @NamedQuery(name = "Municipio.findByNombreMunicipio", query = "SELECT m FROM Municipio m WHERE m.nombreMunicipio = :nombreMunicipio")
public class Municipio implements Serializable{

    
    private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codigo_municipio", precision=0)
        private Integer codigo;
        @Column(name="nombre_municipio")
        private String nombre;
        @Column(name="codigo_departamento", precision=0)
        private String codigo_departamento;
        
//        @JoinColumn(name = "codigo_departamento", referencedColumnName = "codigo",updatable=false, insertable=false)
//        @OneToOne
//        private Departamento tipoDepartamento; 
        
	public Municipio() {
	}

        
//        /**
//     * @return the tipotipoDpto
//     */
//    public Departamento getTipotipoDpto() {
//        return tipotipoDpto;
//    }
//
//    /**
//     * @param tipotipoDpto the tipotipoDpto to set
//     */
//    public void setTipotipoDpto(Departamento tipotipoDpto) {
//        this.tipotipoDpto = tipotipoDpto;
//    }
//    
    /**
     * @return the codigo
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
        JsonObject temp = new JsonObject();
        temp.addProperty("codigo_municipio",this.codigo);
        temp.addProperty("codigo_departamento",this.codigo_departamento);
        temp.addProperty("nombre_municipio",this.nombre);

        return temp.toString()+",";
    }

     public JsonObject toJsonelement() {
            JsonObject temp = new JsonObject();
            temp.addProperty("code",this.codigo);
            temp.addProperty("name",this.nombre);
            return temp;
        }

        

        

}
