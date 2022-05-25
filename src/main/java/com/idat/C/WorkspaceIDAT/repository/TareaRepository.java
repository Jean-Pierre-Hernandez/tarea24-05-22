package com.idat.C.WorkspaceIDAT.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.C.WorkspaceIDAT.model.Tareas;

@Repository
public interface TareaRepository extends JpaRepository<Tareas, Integer>{

}
