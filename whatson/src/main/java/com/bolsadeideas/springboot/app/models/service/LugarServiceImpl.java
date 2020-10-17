package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.models.dao.IFavoritoDao;
import com.bolsadeideas.springboot.app.models.dao.ILugarDao;
import com.bolsadeideas.springboot.app.models.entity.Favorito;
import com.bolsadeideas.springboot.app.models.entity.Lugar;

@Service
public class LugarServiceImpl implements ILugarService {

	@Autowired
	private ILugarDao lugarDao;

	@Transactional(readOnly = true)
	public List<Lugar> findAll() {
		return (List<Lugar>) lugarDao.findAll();
	}
	
	@Transactional(readOnly = true)
	public Page<Lugar> findAll(Pageable pageable) {
		return lugarDao.findAll(pageable);
	}

	@Transactional
	public void save(Lugar lugar) {
		lugarDao.save(lugar);
		
	}

	@Transactional(readOnly = true)
	public Lugar findOne(Long id) {
		return lugarDao.findById(id).orElse(null);
	}

	@Transactional
	public void delete(Long id) {
		lugarDao.deleteById(id);
		
	}
	
}
