package com.crud.democrud.repositories;


import com.crud.democrud.models.TasksModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface TasksRepository extends CrudRepository<TasksModel, Integer> {
    public abstract ArrayList<TasksModel> findByRol(Integer idrol);
}
