
package com.diaco.modelo;

import com.google.gson.JsonObject;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



@Entity
@Table(name="diaco_categoriacba")
@NamedQueries({
    @NamedQuery(name = "category.findAll", query = "SELECT d FROM category d")  
})
public class category implements Serializable{
 
    private static final long serialVersionUID = 1L;
    @Id
    
    @Column(name="id_Categoria", precision=0)
    private Integer code;
    @Column(name="nombre")
    private String name;
    
    public category() {
	}


    public Integer getCode() {
        return code;
    }


    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        JsonObject temp = new JsonObject();
        temp.addProperty("code",this.code);
        temp.addProperty("name",this.name);

        return temp.toString();
    }

     public JsonObject toJsonelement() {
            JsonObject temp = new JsonObject();
            temp.addProperty("codeCategory",this.code);
            temp.addProperty("nameCategory",this.name);
            return temp;
        }
    
}
