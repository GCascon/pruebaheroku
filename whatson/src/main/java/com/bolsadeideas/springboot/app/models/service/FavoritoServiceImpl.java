package com.bolsadeideas.springboot.app.models.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.models.dao.IFavoritoDao;
import com.bolsadeideas.springboot.app.models.entity.Favorito;
import com.bolsadeideas.springboot.app.models.entity.Imagen;
import com.bolsadeideas.springboot.app.util.DistanceCalculator;

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
	
	@Transactional(readOnly = true)
	public Page<Favorito> findCercaDeMi(String tipo, String posicion){
		TreeMap<Double,Favorito> map=new TreeMap();
		List<Favorito> favoritosByTipo=favoritoDao.findByTipo(tipo);
		
		for(Favorito f:favoritosByTipo) {
			if(f.getLatitud()!=null && f.getLongitud()!=null) {
				StringTokenizer sb=new StringTokenizer(posicion,", ");
				Double latitud=Double.parseDouble(sb.nextToken());
				Double longitud=Double.parseDouble(sb.nextToken());
				double distancia=DistanceCalculator.distance(latitud,longitud,f.getLatitud(),f.getLongitud(),'K');
				f.setDistancia(String.format("%.3f", distancia)+" Km");
				
				if(distancia < 10.0D) {
					map.put(distancia, f);
				}								
			}
		}
		Page<Favorito> page=new PageImpl<Favorito>(new ArrayList<Favorito>(map.values()));
		
		return page;
	}

	@Transactional
	public void save(Favorito favorito, List<Imagen> imagenes) {
		Favorito f=favoritoDao.save(favorito);
		if(imagenes!=null && imagenes.size()>0) {			
			if(f.getImagenes()==null) {
				f.setImagenes(imagenes);
			}else {
				f.getImagenes().addAll(imagenes);
			}			
			favoritoDao.save(f);
		}				
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
