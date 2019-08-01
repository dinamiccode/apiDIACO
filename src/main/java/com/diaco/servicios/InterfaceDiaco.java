package com.diaco.servicios;

import com.diaco.model.diaco_jpql;
import com.diaco.modelo.Departamento;
import com.diaco.modelo.Municipio;
import com.diaco.modelo.category;
import com.diaco.modelo.diaco_diaco_name_template;
import com.diaco.modelo.diaco_plantilla;
import com.diaco.modelo.diaco_precio;
import com.diaco.modelo.diaco_vaciadocba;
import com.diaco.modelo.vaciado;
import java.util.List;

public interface InterfaceDiaco {
    public List<Departamento> getDepartamentos();
    
    public List<Municipio> getMunicipios();
    
    public List<Municipio> getMunicipioId(String id);
    
    public List<category> getCategory();
    
    public List<vaciado> getvaciaso(Integer categoria, Integer municipio);
    
    //public List<vaciado> getDatosPrecios(Integer categoria, Integer municipio);
    
    public List<diaco_vaciadocba> getPrecio();
    
    //*************************JOIN NUEVOS
    public List<diaco_diaco_name_template> getDataPrecio2();
    
    public List<diaco_plantilla> getPlantilla();
    
    public List<diaco_precio> getDataPrecio();
    
    public List<diaco_jpql> getListData();
//    public List<diaco_precio> getDataPrecio();
    
}
