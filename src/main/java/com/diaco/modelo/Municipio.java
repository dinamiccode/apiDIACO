package com.diaco.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="municipio")
@NamedQueries({
    @NamedQuery(name = "Municipio.findAll", query = "SELECT m FROM Municipio m"),
    @NamedQuery(name = "Municipio.findByIdDepartamento", query = "SELECT m FROM Municipio m " + " WHERE m.id_departamento = :idDepartamento")  
})
//, @NamedQuery(name = "Municipio.findByNombreMunicipio", query = "SELECT m FROM Municipio m WHERE m.nombreMunicipio = :nombreMunicipio")
public class Municipio implements Serializable{
    
    private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codigo_municipio", precision=0)
        private Integer codigo;
        @Column(name="nombre_municipio")
        private String nombre;
        @Column(name="codigo_departamento")
        private String id_departamento;
	
	public Municipio() {
	}

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

    /**
     * @return the id_departamento
     */
    public String getId_departamento() {
        return id_departamento;
    }

    /**
     * @param id_departamento the id_departamento to set
     */
    public void setId_departamento(String id_departamento) {
        this.id_departamento = id_departamento;
    }

        

        

}
