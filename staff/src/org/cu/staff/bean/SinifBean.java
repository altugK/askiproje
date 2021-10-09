package org.cu.staff.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import org.cu.staff.model.Sinif;
import org.cu.staff.services.SinifServices;
import org.cu.staff.systemp.Util;

@ManagedBean(name = "sinifBean")
@SessionScoped
public class SinifBean {
	private List<Sinif> sinifList = new ArrayList<Sinif>();
	private Sinif sinif = new Sinif();
	private Sinif deleteSinif = new Sinif();
	private Sinif updateSinif = new Sinif();
	private SinifServices sinifServices = new SinifServices();
	private Boolean kaydetGuncelleRendered;
	private Util util = new Util();
	private Boolean basariliBasarisiz;
	private DataModel<Sinif> sinifDataModelList;
	private List<Sinif> filteredSinif;

	public void select() {

		setSinifDataModelList(new ListDataModel<Sinif>());
		try {
			sinifList = sinifServices.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		getSinifDataModelList().setWrappedData(sinifList);
	}

	public void sayfaYenile() {
		sinifList = null;
		sinif = new Sinif();
		kaydetGuncelleRendered = true;
		updateSinif = new Sinif();
		deleteSinif = new Sinif();
		select();
	}

	public void insert() {
		try {
			sinifServices.insert(sinif);
			basariliBasarisiz = true;
		} catch (Exception e) {
			e.printStackTrace();
			basariliBasarisiz = false;
		}
		util.kayitMesaji(basariliBasarisiz);
		sayfaYenile();

	}

	public void update() {
		try {
			sinifServices.update(updateSinif);
			basariliBasarisiz = true;
		} catch (Exception e) {
			e.printStackTrace();
			basariliBasarisiz = false;
		}
		util.guncellemeMesaji(basariliBasarisiz);
		sayfaYenile();
	}

	public void delete() {
		try {
			sinifServices.delete(deleteSinif);
			basariliBasarisiz = true;
		} catch (Exception e) {
			e.printStackTrace();
			basariliBasarisiz = false;
		}
		util.silmeMesaji(basariliBasarisiz);
		sayfaYenile();
	}

	public List<Sinif> getSinifList() {
		return sinifList;
	}

	public void setSinifList(List<Sinif> sinifList) {
		this.sinifList = sinifList;
	}

	public Sinif getSinif() {
		return sinif;
	}

	public void setSinif(Sinif sinif) {
		this.sinif = sinif;
	}

	public Sinif getDeleteSinif() {
		return deleteSinif;
	}

	public void setDeleteSinif(Sinif deleteSinif) {
		this.deleteSinif = deleteSinif;
		delete();
	}

	public Sinif getUpdateSinif() {
		return updateSinif;
	}

	public void setUpdateSinif(Sinif updateSinif) {
		this.updateSinif = updateSinif;
		sinif = updateSinif;
		kaydetGuncelleRendered = false;
	}

	public DataModel<Sinif> getSearchDatamodelList() {
		return getSinifDataModelList();
	}

	public void setSearchDatamodelList(DataModel<Sinif> sinifDataModelList) {
		this.setSinifDataModelList(sinifDataModelList);
	}

	public Boolean getKaydetGuncelleRendered() {
		return kaydetGuncelleRendered;
	}

	public void setKaydetGuncelleRendered(Boolean kaydetGuncelleRendered) {
		this.kaydetGuncelleRendered = kaydetGuncelleRendered;
	}

	public List<Sinif> getFilteredSinif() {
		return filteredSinif;
	}

	public void setFilteredSinif(List<Sinif> filteredSinif) {
		this.filteredSinif = filteredSinif;
	}

	public DataModel<Sinif> getSinifDataModelList() {
		return sinifDataModelList;
	}

	public void setSinifDataModelList(DataModel<Sinif> sinifDataModelList) {
		this.sinifDataModelList = sinifDataModelList;
	}

}
