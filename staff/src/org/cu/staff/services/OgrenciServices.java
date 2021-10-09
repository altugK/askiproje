package org.cu.staff.services;

import java.util.List;
import org.cu.staff.dao.OgrenciDao;
import org.cu.staff.model.Ogrenci;

public class OgrenciServices {

	private OgrenciDao ogrenciDao = new OgrenciDao();

	public Ogrenci insert(Ogrenci entity) {
		ogrenciDao.insert(entity);
		return entity;
	}

	public Ogrenci update(Ogrenci entity) {
		ogrenciDao.update(entity);
		return entity;
	}

	public List<Ogrenci> selectAll() {
		List<Ogrenci> ogrenciList = ogrenciDao.select();
		return ogrenciList;
	}

	public void delete(Ogrenci entity) {

		ogrenciDao.delete(entity);

	}

}
