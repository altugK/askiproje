package org.cu.staff.services;

import java.util.List;

import org.cu.staff.dao.SinifDao;
import org.cu.staff.model.Sinif;

public class SinifServices {

	private SinifDao sinifDao = new SinifDao();

	public Sinif insert(Sinif entity) {
		sinifDao.insert(entity);
		return entity;
	}

	public Sinif update(Sinif entity) {
		sinifDao.update(entity);
		return entity;
	}

	public List<Sinif> selectAll() {
		List<Sinif> sinifList = sinifDao.select();
		return sinifList;
	}

	public void delete(Sinif entity) {

		sinifDao.delete(entity);

	}

}
