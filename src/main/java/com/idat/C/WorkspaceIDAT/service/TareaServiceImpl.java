package com.idat.C.WorkspaceIDAT.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.C.WorkspaceIDAT.model.Tareas;
import com.idat.C.WorkspaceIDAT.repository.TareaRepository;


@Service
public class TareaServiceImpl implements TareaService{
	
	@Autowired
	private TareaRepository repository;

	@Override
	public void guadarTareas(Tareas tarea) {
		// TODO Auto-generated method stub
		repository.save(tarea);
		
	}

	@Override
	public void actualizarTareas(Tareas tareas) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(tareas);
	}

	@Override
	public void eliminarTareas(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<Tareas> listarTareas() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Tareas obtenerTareasID(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

}
