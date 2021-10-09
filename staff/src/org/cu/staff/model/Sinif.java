package org.cu.staff.model;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Sinif", schema = "dbo")
public class Sinif implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SinifId", unique = true, nullable = false)
	private Integer sinifId;

	@Column(name = "SinifAdi", nullable = false)
	private String sinifAdi;

	@Column(name = "KatNo", nullable = false)
	private String katNo;

	@OneToMany
	private List<Ogrenci> ogrenci;

	public Integer getSinifId() {
		return sinifId;
	}

	public void setSinifId(Integer sinifId) {
		this.sinifId = sinifId;
	}

	public String getSinifAdi() {
		return sinifAdi;
	}

	public void setSinifAdi(String sinifAdi) {
		if (sinifAdi == "") {
			this.sinifAdi = null;
		} else {
			this.sinifAdi = sinifAdi;
		}
		this.sinifAdi = sinifAdi;
	}

	public List<Ogrenci> getOgrenci() {
		return ogrenci;
	}

	public void setOgrenci(List<Ogrenci> ogrenci) {
		this.ogrenci = ogrenci;
	}

	public String getKatNo() {
		return katNo;
	}

	public void setKatNo(String katNo) {
		if (katNo == "") {
			this.katNo = null;
		} else {
			this.katNo = katNo;
		}
	}

}
