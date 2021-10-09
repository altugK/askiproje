package org.cu.staff.bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.cu.staff.model.Ogrenci;
import org.cu.staff.services.SinifServices;
import org.cu.staff.services.OgrenciServices;
import org.cu.staff.systemp.Util;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@ManagedBean(name = "ogrenciBean")
@SessionScoped
public class OgrenciBean {
	private List<Ogrenci> ogrenciList = new ArrayList<Ogrenci>();
	private Ogrenci ogrenci = new Ogrenci();
	private Ogrenci deleteOgrenci = new Ogrenci();
	private Ogrenci updateOgrenci = new Ogrenci();
	private OgrenciServices ogrenciServices = new OgrenciServices();
	private SinifServices sinifServices = new SinifServices();
	private Boolean kaydetGuncelleRendered;
	private Util util = new Util();
	private Boolean basariliBasarisiz;
	private DataModel<Ogrenci> ogrenciDataModelList;
	private List<Ogrenci> filteredOgrenci;

	public void select() {

		ogrenciDataModelList = new ListDataModel<Ogrenci>();
		try {
			ogrenciList = ogrenciServices.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		ogrenciDataModelList.setWrappedData(ogrenciList);
	}

	public void sayfaYenile() {
		ogrenciDataModelList = null;
		filteredOgrenci = null;
		ogrenciList = null;
		ogrenci = new Ogrenci();
		deleteOgrenci = new Ogrenci();
		updateOgrenci = new Ogrenci();
		kaydetGuncelleRendered = true;
		select();
	}

	public void insert() {
		try {
			ogrenciServices.insert(ogrenci);
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
			ogrenciServices.update(updateOgrenci);
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
			ogrenciServices.delete(deleteOgrenci);
			basariliBasarisiz = true;
		} catch (Exception e) {
			e.printStackTrace();
			basariliBasarisiz = false;
		}
		util.silmeMesaji(basariliBasarisiz);
		sayfaYenile();
	}

	public List<Ogrenci> getOgrenciList() {
		return ogrenciList;
	}

	public void setOgrenciList(List<Ogrenci> ogrenciList) {
		this.ogrenciList = ogrenciList;
	}

	public Ogrenci getOgrenci() {
		return ogrenci;
	}

	public void setOgrenci(Ogrenci ogrenci) {
		this.ogrenci = ogrenci;
	}

	public Ogrenci getDeleteOgrenci() {
		return deleteOgrenci;
	}

	public void setDeleteOgrenci(Ogrenci deleteOgrenci) {
		this.deleteOgrenci = deleteOgrenci;
		delete();
	}

	public Ogrenci getUpdateOgrenci() {
		return updateOgrenci;
	}

	public void setUpdateOgrenci(Ogrenci updateOgrenci) {
		this.updateOgrenci = updateOgrenci;
		ogrenci = updateOgrenci;
		kaydetGuncelleRendered = false;
	}

	public DataModel<Ogrenci> getOgrenciDataModelList() {
		return ogrenciDataModelList;
	}

	public void setOgrenciDataModelList(DataModel<Ogrenci> ogrenciDataModelList) {
		this.ogrenciDataModelList = ogrenciDataModelList;
	}

	public Boolean getKaydetGuncelleRendered() {
		return kaydetGuncelleRendered;
	}

	public void setKaydetGuncelleRendered(Boolean kaydetGuncelleRendered) {
		this.kaydetGuncelleRendered = kaydetGuncelleRendered;
	}

	public SinifServices getSinifServices() {
		return sinifServices;
	}

	public void setSinifServices(SinifServices sinifServices) {
		this.sinifServices = sinifServices;
	}

	private StreamedContent file;
	String jasperprint;

	public void init() throws JRException {
		select();
		String filePath = "C:\\Users\\altug\\Desktop\\javaegitim\\askiproje\\staff\\WebContent\\resources\\ogrenci.jasper";
		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(ogrenciList);
		jasperprint = JasperFillManager.fillReportToFile(filePath, new HashMap<String, Object>(),
				beanCollectionDataSource);
	}

	public void ogrenciReport() throws JRException {
		init();
		file = null;
		try {
			JasperExportManager.exportReportToPdfFile(jasperprint,
					"C://Users//Altug//AppData//Local//Temp//ogrenci.pdf");

			File filee = new File("C:\\Users\\altug\\Desktop\\ogrenciRaporu.pdf");
			InputStream stream;
			try {
				stream = new FileInputStream(filee);
				file = new DefaultStreamedContent(stream, "application/pdf", "ogrenciRaporu.pdf");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} catch (JRException e) {
			e.printStackTrace();
		}

	}

	public StreamedContent getFile() {
		return file;
	}

	public List<Ogrenci> getFilteredOgrenci() {
		return filteredOgrenci;
	}

	public void setFilteredOgrenci(List<Ogrenci> filteredOgrenci) {
		this.filteredOgrenci = filteredOgrenci;
	}

}
