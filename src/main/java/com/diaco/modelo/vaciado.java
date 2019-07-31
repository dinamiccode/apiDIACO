
package com.diaco.modelo;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(
            name="findAllEmployees",
            procedureName = "getPrecios",
            resultClasses = { vaciado.class },
            parameters={
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "cat"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "muni")
            }
    )
})
@Entity
public class vaciado implements Serializable{

    private static long serialVersionUID = 1L;
    @Id
    //@GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id",precision=0)
    private String id;
    @Column(name="producto")
    private String producto;
    @Column(name="categoria")
    private String categoria;
    @Column(name="Precio")
    private BigDecimal Precio;
    @Column(name="created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;
    @Column(name="medida")
    private String medida;

    
     public vaciado(){
     }
    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the producto
     */
    public String getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(String producto) {
        this.producto = producto;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the Precio
     */
    public BigDecimal getPrecio() {
        return Precio;
    }

    /**
     * @param Precio the Precio to set
     */
    public void setPrecio(BigDecimal Precio) {
        this.Precio = Precio;
    }

    /**
     * @return the created_at
     */
    public Date getCreated_at() {
        return created_at;
    }

    /**
     * @param created_at the created_at to set
     */
    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    /**
     * @return the medida
     */
    public String getMedida() {
        return medida;
    }

    /**
     * @param medida the medida to set
     */
    public void setMedida(String medida) {
        this.medida = medida;
    }

    @Override
    public String toString() {
        JsonObject precio = new JsonObject();
        //JsonArray muni = new JsonArray();
        precio.addProperty("producto",this.producto);
        precio.addProperty("categoria",this.categoria);
        precio.addProperty("Precio", this.Precio);
        precio.addProperty("fecha", this.created_at.toString());
        precio.addProperty("medida", this.medida);
        
        return precio.toString();
    }
}
