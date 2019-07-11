package com.diaco.apidiaco;

import com.diaco.modelo.Departamento;
import com.diaco.modelo.Municipio;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@ApplicationScoped
public class DiacoDao {
 
    @PersistenceContext
    private EntityManager em;
    
    
    public List<Departamento> findAllDepartamentos() {
	return em.createNamedQuery("Departamento.findAll").getResultList();
    }
    
    public List<Municipio> findAllMunicipios() {
	return em.createNamedQuery("Municipio.findAll").getResultList();
    }
    
    public List<Municipio> getMunicipioID(String id) {
	return em.createNamedQuery("Municipio.findByIdDepartamento").setParameter("idDepartamento", id).getResultList();
    }
    
    public EntityManager getEm() {
            return em;
        }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
