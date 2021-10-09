package org.cu.staff.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

@ManagedBean(name = "cvBean")
@SessionScoped
public class CvBean {

	private MapModel simpleModel;

	@PostConstruct
	public void init() {
		simpleModel = new DefaultMapModel();

		LatLng coord1 = new LatLng(37.055484, 35.281149);
		simpleModel.addOverlay(new Marker(coord1, "Altug Adres"));
	}

	public MapModel getSimpleModel() {
		return simpleModel;
	}
}
