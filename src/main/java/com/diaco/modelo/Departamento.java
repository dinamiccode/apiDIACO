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
        private Integer codigo_departamento;
        @Column(name="nombre_departamento")
        private String nombre_departamento;
	
	public Departamento() {
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


        
   

        
}
