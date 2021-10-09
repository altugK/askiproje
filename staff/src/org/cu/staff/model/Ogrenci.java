package org.cu.staff.model;

import java.io.Serializable;
import java.lang.Integer;

import javax.persistence.*;

@Entity
@Table(name = "Ogrenci", schema = "dbo")
public class Ogrenci implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OgrenciId", unique = true, nullable = false)
	private Integer ogrenciid;

	@Column(name = "OgrenciNo", nullable = false)
	private Integer ogrenciNo;

	@Column(name = "Adi", nullable = false)
	private String ogrenciAdi;

	@Column(name = "Soyadi", nullable = false)
	private String soyAdi;

	@Column(name = "SinifId", nullable = false)
	private String sinifId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SinifId", insertable = false, updatable = false)
	private Sinif sinif;

	public Integer getOgrenciid() {
		return ogrenciid;
	}

	public void setOgrenciid(Integer ogrenciid) {
		this.ogrenciid = ogrenciid;
	}

	public Integer getOgrenciNo() {
		return ogrenciNo;
	}

	public void setOgrenciNo(Integer ogrenciNo) {
		this.ogrenciNo = ogrenciNo;
	}

	public String getOgrenciAdi() {
		return ogrenciAdi;
	}

	public void setOgrenciAdi(String ogrenciAdi) {
		if (ogrenciAdi == "") {
			this.ogrenciAdi = null;
		} else {
			this.ogrenciAdi = ogrenciAdi;
		}
	}

	public String getSoyAdi() {
		return soyAdi;
	}

	public void setSoyAdi(String soyAdi) {
		if (soyAdi == "") {
			this.soyAdi = null;
		} else {
			this.soyAdi = soyAdi;
		}
	}

	public String getSinifId() {
		return sinifId;
	}

	public void setSinifId(String sinifId) {
		if (sinifId == "") {
			this.sinifId = null;
		} else {
			this.sinifId = sinifId;
		}
	}

	public Sinif getSinif() {
		return sinif;
	}

	public void setSinif(Sinif sinif) {
		this.sinif = sinif;
	}

}
