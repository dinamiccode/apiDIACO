
package com.diaco.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class diaco_jpql implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="correlativo", precision=0)
    private Integer correlativo;
//    @Column(name="estado")
//    private String estado;
//    @Column(name="idPlantilla")
//    private Integer idPlantilla;
//    @Column(name="idVerificador")
//    private String idVerificador;
    
    public diaco_jpql(){
        
    }

    /**
     * @return the correlativo
     */
    public Integer getCorrelativo() {
        return correlativo;
    }

    /**
     * @param correlativo the correlativo to set
     */
    public void setCorrelativo(Integer correlativo) {
        this.correlativo = correlativo;
    }

   
   
    
}
