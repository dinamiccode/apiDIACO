package com.diaco.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
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
import javax.validation.constraints.NotNull;

@Entity
@Table(name="diaco_vaciadocba")
@NamedQuery(name = "precios.findAll", query = "SELECT t FROM diaco_vaciadocba t")
public class diaco_vaciadocba implements Serializable {
    private static long serialVersionUID = 1L;
    @Id
    
    @Column(name="correlativo", precision=0)
    private Integer correlativo;
    @Column(name = "idProducto")
    private String idProducto;
    
//    @Column(name="idCategoria")
//    private String idCategoria;
    
    @Column(name="precioProducto")
    private BigDecimal precioProducto;
//    @Column(name = "idPlantilla")
//    private Integer template;
    //@JoinColumn(name = "idPlantilla", referencedColumnName = "idPlantilla",updatable=false, insertable=false)
    //@OneToOne
    //private DiacoAsignarsedecba asignacion;
    
            
    
    
    public diaco_vaciadocba(){
        
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

    /**
     * @return the idProducto
     */
    public String getIdProducto() {
        return idProducto;
    }

    /**
     * @param idProducto the idProducto to set
     */
    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

   
    /**
     * @return the precioProducto
     */
    public BigDecimal getPrecioProducto() {
        return precioProducto;
    }

    /**
     * @param precioProducto the precioProducto to set
     */
    public void setPrecioProducto(BigDecimal precioProducto) {
        this.precioProducto = precioProducto;
    }
   

}
