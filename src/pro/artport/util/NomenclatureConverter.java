package pro.artport.util;

import pro.artport.dao.CounterpartyDAO;
import pro.artport.dao.NomenclatureDAO;
import pro.artport.tables.Counterparty;
import pro.artport.tables.Nomenclature;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

@FacesConverter("nomeclatureConverter")
@Named
@RequestScoped
public class NomenclatureConverter implements Converter {
    @Inject
    private NomenclatureDAO dao;

    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                int n = Integer.parseInt(value);
                return dao.find(n);
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid"));
            }
        }
        else {
            return null;
        }
    }

    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((Nomenclature) object).getId());
        }
        else {
            return null;
        }
    }
}