package com.crud.democrud.services;

import com.crud.democrud.models.TasksModel;
import com.crud.democrud.repositories.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * [Clase de los servicios de la entidad tasks.]
 *
 * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
 * @version 1.0.0
 * @since Esta presente desde la version 1.0.0
 */
@Service
public class TasksServiceImpl {
    /**
     * crea una instancia o implementa de la Interfaz TasksRepasitory
     */
    @Autowired
    private TasksRepository taskRepositori;

    /**
     * [Método para consultar todos los elemento de la tabla task.]
     *
     * @return List<TasksModel>
     * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
     * @since Esta presente desde la version 1.0.0
     */
    public List<TasksModel> getAll() {
        List<TasksModel> task = new ArrayList<>();
        taskRepositori.findAll().forEach(task::add);
        return task;
    }

    /**
     * [Método para crear nuevas filas en la tabla task.]
     *
     * @param task TasksModel
     * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
     * @since Esta presente desde la version 1.0.0
     */
    public void create(TasksModel task)
    {
        taskRepositori.save(task);
    }

    /**
     * [Método para actualizar una fila por el id del elemento.]
     * @param id int
     * @param task TasksModel
     * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
     * @since Esta presente desde la version 1.0.0
     */
    public void update(Integer id, TasksModel task) {
        Optional<TasksModel> existsTask = taskRepositori.findById(id);
        if (existsTask.isPresent()) {
            existsTask.get().setIdTask(task.getIdTask());
            existsTask.get().setDescription(task.getDescription());
            existsTask.get().setRealized(task.isRealized());
           // existsTask.get().setIdlist(task.getIdlist());
            taskRepositori.save(existsTask.get());
        }
    }

    /**
     * [Método para eliminar una fila por el id del elemento.]
     *
     * @param id int
     * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
     * @since Esta presente desde la version 1.0.0
     */
    public boolean delete(Integer id) {
        Optional<TasksModel> existsTask = taskRepositori.findById(id);
        if (existsTask.isPresent()) {
            try {
                taskRepositori.delete(existsTask.get());
                return true;
            }catch(Exception err){
                try {
                    taskRepositori.deleteById(id);
                    return true;
                }catch(Exception e){
                    e.printStackTrace();
                    return false;
                }
            }
        }
        return false;
    }

}
