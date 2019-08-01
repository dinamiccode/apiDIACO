package com.diaco.servicios;

import com.diaco.apidiaco.DiacoDao;
import com.diaco.model.diaco_jpql;
import com.diaco.modelo.Departamento;
import com.diaco.modelo.Municipio;
import com.diaco.modelo.category;
import com.diaco.modelo.diaco_diaco_name_template;
import com.diaco.modelo.diaco_plantilla;
import com.diaco.modelo.diaco_precio;
import com.diaco.modelo.diaco_vaciadocba;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import com.diaco.modelo.vaciado;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class DiacoBeans implements InterfaceDiaco{
    
    @Inject
    private DiacoDao dao;
    
    @Override
    public List<Departamento> getDepartamentos()
    {
        return getDao().findAllDepartamentos();
    }
   
    
    public List<Municipio> getMunicipios()
    {
        return getDao().findAllMunicipios();
    }
    
    public List<Municipio> getMunicipioId(String idDepartamento)
    {
        return getDao().getMunicipioID(idDepartamento);
    }
    
    public List<category> getCategory(){
        return getDao().getCategory();
    }
    
    public List<vaciado> getvaciaso(Integer categoria, Integer municipio){
        return getDao().FindAll(categoria,municipio);
    }
    
    public List<diaco_vaciadocba> getPrecio(){
        return getDao().getPrecio();
    }
    
//    public List<vaciado> getDatosPrecios(Integer categoria, Integer municipio){
//        return getDao().getDatosPrecios(categoria, municipio);
//    }
    
    
    
    //------------------------------------------ joins adicionales
    
    
    public List<diaco_diaco_name_template> getDataPrecio2(){
        return getDao().getDataPrecio2();
    }
    
    public List<diaco_precio> getDataPrecio(){
        return getDao().getDataPrecio();
    }
    
    public List<diaco_plantilla> getPlantilla(){
        return getDao().getPlantilla();
    }
    
    public List<diaco_jpql> getListData(){
        return getDao().getListData();
    }
    
    public DiacoDao getDao() {
        return dao;
    }

    public void setDao(DiacoDao dao) {
        this.dao = dao;
    }
    
    
}
