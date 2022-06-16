package com.crud.democrud.controllers;

import com.crud.democrud.models.TasksModel;
import com.crud.democrud.services.TasksServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/**
 * [Clase controladora de la tabla tasks.]
 *
 * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
 * @version 1.0.0
 * @since Esta presente desde la version 1.0.0
 */
@CrossOrigin
@RestController
@RequestMapping("/tasks")
public class TasksController {

    /**
     * crea una instancia de la clase taskService
     */
    @Autowired
    TasksServiceImpl taskService;

    /**
     * [Método para consultar todos los elemento de la tabla task.]
     *
     * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
     * @since Esta presente desde la version 1.0.0
     */
    @GetMapping
    public List<TasksModel> getAll(){
        return taskService.getAll();
    }

    /**
     * [Método para crear nuevas filas en la tabla task.]
     *
     * @param task TasksModel
     * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
     * @since Esta presente desde la version 1.0.0
     */
    @PostMapping
    public void create(@RequestBody TasksModel task){
        taskService.create(task);
    }

    /**
     * [Método para actualizar una fila por el id del elemento.]
     * @param id int
     * @param task TasksModel
     * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
     * @since Esta presente desde la version 1.0.0
     */
    @PutMapping("/{idrol}")
    public void update(@PathVariable int id, @RequestBody TasksModel task){
        taskService.update(id, task);
    }

    /**
     * [Método para eliminar una fila por el id del elemento.]
     *
     * @param id int
     * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
     * @since Esta presente desde la version 1.0.0
     */
    @DeleteMapping("/{idrol}")
    public String delete(@PathVariable int id){

        boolean ok = this.taskService.delete(id);
        if (ok) {
            return "Se eliminó el la tarea con el id ".concat(String.valueOf(id));
        } else {
            return "No pudo eliminar el la tarea con el id ".concat(String.valueOf(id));
        }
    }
}