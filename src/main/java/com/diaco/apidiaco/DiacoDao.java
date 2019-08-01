package com.diaco.apidiaco;

import com.diaco.model.diaco_categorias;
import com.diaco.model.diaco_departamentos;
import com.diaco.model.diaco_jpql;
import com.diaco.modelo.Departamento;
import com.diaco.modelo.Municipio;
import com.diaco.modelo.category;
import com.diaco.modelo.diaco_diaco_name_template;
import com.diaco.modelo.diaco_plantilla;
import com.diaco.modelo.diaco_precio;
import com.diaco.modelo.diaco_vaciadocba;
import com.diaco.modelo.vaciado;
import com.diaco.model.diaco_departamentos;
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
    
    
    //-----------------------------------------JOINS NUEVOS
    
    
    public List<diaco_diaco_name_template> getDataPrecio2(){
        return em.createNamedQuery("vaciadotemplate.findAll").getResultList();
    }
    
    public List<diaco_plantilla> getPlantilla(){
        return em.createNamedQuery("vaciadoPlantilla.findAll").getResultList();
    }
    
    public List<diaco_precio> getDataPrecio(){
        return em.createNamedQuery("VaciadoPrecios.findAll").getResultList();
    }
    
    public List<diaco_jpql> getListData(){
        Query query = em.createNativeQuery("select distinct\n" +
"		plantilla.idCategoria, \n" +
"		categoria.nombre,asignacion.idSede, muni.nombre_municipio ,\n" +
"		depa.nombre_departamento\n" +
"		from diaco_vaciadocba vacio\n" +
"	INNER JOIN diaco_name_template_cba template\n" +
"		ON template.id = vacio.idPlantilla\n" +
"	INNER JOIN diaco_plantillascba plantilla\n" +
"		ON plantilla.NombrePlantilla = template.NombreTemplate\n" +
"	INNER JOIN diaco_categoriacba categoria\n" +
"		ON categoria.id_Categoria = plantilla.idCategoria\n" +
"	INNER JOIN diaco_asignarsedecba asignacion\n" +
"		ON asignacion.idPlantilla = vacio.idPlantilla\n" +
"	INNER JOIN diaco_sede sede\n" +
"		ON sede.id_diaco_sede = asignacion.idSede\n" +
"	INNER JOIN municipio muni\n" +
"		ON muni.codigo_municipio = sede.id_diaco_sede \n" +
"	INNER JOIN departamento depa\n" +
"		ON depa.codigo_departamento = muni.codigo_departamento");
//        query.setParameter("first", "Bob");
//        query.setParameter("last", "Smith");
        List<diaco_jpql> lista = query.getResultList();
        return lista;
        
    }
    
    public List<diaco_departamentos> getDepartamentosAll(){
            em.getEntityManagerFactory().getCache().evict(diaco_departamentos.class);
        return  em.createNamedStoredProcedureQuery("getDepartamentAll").getResultList(); 
    }
    
    public List<diaco_categorias> getCategoriasAll(){
            em.getEntityManagerFactory().getCache().evict(diaco_categorias.class);
        return  em.createNamedStoredProcedureQuery("getCategoriasAll").getResultList(); 
    }
    
    
    public EntityManager getEm() {
            return em;
        }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    
}
