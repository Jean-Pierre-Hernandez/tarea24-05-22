package com.idat.C.WorkspaceIDAT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idat.C.WorkspaceIDAT.model.Tareas;
import com.idat.C.WorkspaceIDAT.service.TareaService;

@Controller
@RequestMapping("/tarea/v1")
public class TareaController {
	
	@Autowired
	private TareaService service;
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<Tareas>> listar(){
		return new ResponseEntity<List<Tareas>>(service.listarTareas(),HttpStatus.OK);
	}
	
	@RequestMapping( path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Tareas tareas){
		service.guadarTareas(tareas);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping( path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		Tareas t =service.obtenerTareasID(id);
		if(t != null) {
			service.eliminarTareas(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping( path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody Tareas tareas){
		Tareas t = service.obtenerTareasID(tareas.getIdItem());
		if(t !=null) {
			service.actualizarTareas(tareas);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping( path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Tareas> obtenerId(@PathVariable Integer id){
		Tareas t = service.obtenerTareasID(id);
		if(t !=null) {
			return new ResponseEntity<Tareas>(service.obtenerTareasID(id),HttpStatus.OK);
		}
		return new ResponseEntity<Tareas>(HttpStatus.NOT_FOUND);
	}
}
