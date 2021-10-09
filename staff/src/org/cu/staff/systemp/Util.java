package org.cu.staff.systemp;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class Util {

	public void hosgeldinMesaji() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Hoþgeldin admin", ""));
	}

	public void kayitMesaji(Boolean deger) {
		if (deger == true) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Kayýt Baþarýlý", ""));
		} else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Kayýt Baþarýsýz", ""));
		}

	}

	public void silmeMesaji(Boolean deger) {
		if (deger == true) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Silme Baþarýlý", ""));
		} else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Silme Baþarýsýz", "Veri Kullanýlýyor"));
		}

	}

	public void guncellemeMesaji(Boolean deger) {
		if (deger == true) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Güncelleme Baþarýlý", ""));
		} else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Güncelleme Baþarýsýz", ""));
		}

	}

}
