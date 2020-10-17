package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bolsadeideas.springboot.app.models.entity.Favorito;
import com.bolsadeideas.springboot.app.models.entity.Lugar;

public interface ILugarService {
	
	public List<Lugar> findAll();
	
	public Page<Lugar> findAll(Pageable pageable);

	public void save(Lugar lugar);
	
	public Lugar findOne(Long id);
	
	public void delete(Long id);
	
}
