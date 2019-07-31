
package com.diaco.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "diaco_asignarsedecba")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiacoAsignarsedecba.findAll", query = "SELECT d FROM DiacoAsignarsedecba d")
})
public class DiacoAsignarsedecba implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idPlantilla")
    private Integer idPlantilla;
    
    
    
    public DiacoAsignarsedecba(){
        
    }

}
