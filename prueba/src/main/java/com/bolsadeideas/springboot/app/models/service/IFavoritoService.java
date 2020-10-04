package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.models.entity.Favorito;

public interface IFavoritoService {
	
	public List<Favorito> findAll();
	
	public Page<Favorito> findAll(Pageable pageable);
	
	public Page<Favorito> findByTipoAndLugarId(Pageable pageable, String tipo, Long idLugar);

	public void save(Favorito cliente);
	
	public Favorito findOne(Long id);
	
	public void delete(Long id);
	
}
