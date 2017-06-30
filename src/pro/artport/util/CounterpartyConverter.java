package pro.artport.util;

import pro.artport.dao.CounterpartyDAO;
import pro.artport.tables.Counterparty;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

@FacesConverter("counterpartyConverter")
@Named
@RequestScoped
public class CounterpartyConverter implements Converter {
    @Inject
    private CounterpartyDAO counterpartyDAO;

    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                int n = Integer.parseInt(value);
                return counterpartyDAO.find(n);
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
            return String.valueOf(((Counterparty) object).getId());
        }
        else {
            return null;
        }
    }
}