package com.diaco.servicios;

import com.diaco.modelo.Departamento;
import com.diaco.modelo.Municipio;
import com.diaco.modelo.category;
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
}
