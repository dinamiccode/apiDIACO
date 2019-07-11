package com.diaco.servicios;

import com.diaco.apidiaco.DiacoDao;
import com.diaco.modelo.Departamento;
import com.diaco.modelo.Municipio;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;

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
    
    public DiacoDao getDao() {
        return dao;
    }

    public void setDao(DiacoDao dao) {
        this.dao = dao;
    }
}
