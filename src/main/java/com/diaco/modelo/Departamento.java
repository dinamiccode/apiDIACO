package com.diaco.modelo;


import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="departamento")
@NamedQuery(name = "Departamento.findAll", query = "SELECT t FROM Departamento t")
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codigo_departamento", precision=0)
        private Integer codigo;
        @Column(name="nombre_departamento")
        private String nombre;
	
	public Departamento() {
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

        


        
   

        
}
