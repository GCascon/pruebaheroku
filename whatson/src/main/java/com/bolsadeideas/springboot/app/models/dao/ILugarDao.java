package com.bolsadeideas.springboot.app.models.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.bolsadeideas.springboot.app.models.entity.Favorito;
import com.bolsadeideas.springboot.app.models.entity.Lugar;

public interface ILugarDao extends PagingAndSortingRepository<Lugar, Long>{

	public List<Lugar> findAllByOrderByIdAsc();
}
