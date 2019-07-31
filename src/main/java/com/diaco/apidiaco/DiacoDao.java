package com.diaco.apidiaco;

import com.diaco.modelo.Departamento;
import com.diaco.modelo.Municipio;
import com.diaco.modelo.category;
import com.diaco.modelo.diaco_vaciadocba;
import com.diaco.modelo.vaciado;
import java.util.Iterator;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import org.eclipse.persistence.queries.StoredProcedureCall;
import org.eclipse.persistence.queries.ReadAllQuery;
import org.eclipse.persistence.queries.DataReadQuery;


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
    
    public List<category> getCategory(){
        return em.createNamedQuery("category.findAll").getResultList();
    }
    
    public List<diaco_vaciadocba> getPrecio(){
        return em.createNamedQuery("precios.findAll").getResultList();
    }
    
    public List<vaciado> FindAll(Integer categoria, Integer municipio){ 
                em.getEntityManagerFactory().getCache().evict(vaciado.class);
        return  em.createNamedStoredProcedureQuery("findAllEmployees").setParameter("cat", categoria).setParameter("muni", municipio).getResultList();        
    }

   
    public List<vaciado> getDatosPrecios(Integer categoria, Integer municipio){
        StoredProcedureQuery query = em.createStoredProcedureQuery("getPrecios");
        query.registerStoredProcedureParameter("cat", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("muni", Integer.class, ParameterMode.IN);
        query.setParameter("cat", categoria);
        query.setParameter("muni", municipio);
        boolean queryResult = query.execute();
        //String result = String.valueOf(query.getOutputParameterValue("o_output_1"));
        List<vaciado> institutionResults = query.getResultList();

        return institutionResults;

    }
    
    public EntityManager getEm() {
            return em;
        }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    
}
