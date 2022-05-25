package com.idat.C.WorkspaceIDAT.service;

import java.util.List;

import com.idat.C.WorkspaceIDAT.model.Tareas;

public interface TareaService {
	
	void guadarTareas(Tareas tarea);
	void actualizarTareas(Tareas tareas);
	void eliminarTareas(Integer id);
	List<Tareas> listarTareas();
	Tareas obtenerTareasID(Integer id);
	

}
