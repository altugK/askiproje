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
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ho�geldin admin", ""));
	}

	public void kayitMesaji(Boolean deger) {
		if (deger == true) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Kay�t Ba�ar�l�", ""));
		} else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Kay�t Ba�ar�s�z", ""));
		}

	}

	public void silmeMesaji(Boolean deger) {
		if (deger == true) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Silme Ba�ar�l�", ""));
		} else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Silme Ba�ar�s�z", "Veri Kullan�l�yor"));
		}

	}

	public void guncellemeMesaji(Boolean deger) {
		if (deger == true) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "G�ncelleme Ba�ar�l�", ""));
		} else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "G�ncelleme Ba�ar�s�z", ""));
		}

	}

}
