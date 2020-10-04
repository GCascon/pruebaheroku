package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.models.dao.IFavoritoDao;
import com.bolsadeideas.springboot.app.models.entity.Favorito;

@Service
public class FavoritoServiceImpl implements IFavoritoService {

	@Autowired
	private IFavoritoDao favoritoDao;

	@Transactional(readOnly = true)
	public List<Favorito> findAll() {
		return (List<Favorito>) favoritoDao.findAll();
	}

	@Transactional(readOnly = true)
	public Page<Favorito> findAll(Pageable pageable) {
		return favoritoDao.findAll(pageable);
	}
	
	@Transactional(readOnly = true)
	public Page<Favorito> findByTipoAndLugarId(Pageable pageable, String tipo, Long idLugar){
		return favoritoDao.findByTipoAndLugarId(pageable, tipo, idLugar);
	}

	@Transactional
	public void save(Favorito cliente) {
		favoritoDao.save(cliente);
		
	}

	@Transactional(readOnly = true)
	public Favorito findOne(Long id) {
		return favoritoDao.findById(id).orElse(null);
	}

	@Transactional
	public void delete(Long id) {
		favoritoDao.deleteById(id);
		
	}
	
}
