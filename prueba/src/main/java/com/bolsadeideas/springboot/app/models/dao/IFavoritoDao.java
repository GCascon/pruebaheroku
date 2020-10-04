package com.bolsadeideas.springboot.app.models.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.bolsadeideas.springboot.app.models.entity.Favorito;

public interface IFavoritoDao extends PagingAndSortingRepository<Favorito, Long>{

	@Query(value="Select f from Favorito f where f.tipo=?1 and f.lugar.id=?2")
	public Page<Favorito> findByTipoAndLugarId(Pageable page, String tipo, Long idLugar);
}
