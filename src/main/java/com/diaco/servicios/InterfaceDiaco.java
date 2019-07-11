package com.diaco.servicios;

import com.diaco.modelo.Departamento;
import com.diaco.modelo.Municipio;
import java.util.List;

public interface InterfaceDiaco {
    public List<Departamento> getDepartamentos();
    
    public List<Municipio> getMunicipios();
    
    public List<Municipio> getMunicipioId(String id);
}
