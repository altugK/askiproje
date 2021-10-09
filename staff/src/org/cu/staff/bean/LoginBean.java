package org.cu.staff.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean(name = "loginBean")
public class LoginBean {
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String login() {
		try {
			if (username == null) {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
						"Kullanýcý adý veya þifre geçerli deðil", "");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				return "";
			} else {
				if (username.equals("admin") && password.equals("1234")) {
					return "/pages/index.xhtml?faces-redirect=true";
				} else {
					FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Kullanýcý adý veya þifre geçerli deðil", "");
					FacesContext.getCurrentInstance().addMessage(null, msg);
					return "";
				}
			}

		} catch (

		Exception e) {
			e.printStackTrace();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Hata alýnmýþtýr", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return "";
		}

	}
}