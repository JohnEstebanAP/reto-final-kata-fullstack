package com.crud.democrud.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/**
 * [Clase para modelar la tabla de las listas.]
 *
 * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
 * @version 1.0.0
 * @since Esta presente desde la version 1.0.0
 */
@Entity
@Table(name = "Lists")
public class ListsModel {

    /**
     * Representa la columna del id como llave primaria auto incrementable y no puede ser nula.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;
    private String name;
    //@JsonManagedReference
    //@OneToMany( cascade = CascadeType.REMOVE, mappedBy = "idlist")
    //@OneToMany( fetch = FetchType.LAZY, targetEntity = TasksModel.class, cascade = CascadeType.REMOVE, mappedBy = "idlist")
    @OneToMany( mappedBy = "idlist", cascade = CascadeType.REMOVE )
    private List<TasksModel> tasks;

    /*
     * [Método constructor con todos los parámetros.]
     * @param tasks List<TaksModel>
     * @param name String
     * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.coW
     * @since Esta presente desde la version 1.0.0
     */
    /*
    public ListsModel(String name, List<TasksModel> tasks) {
        this.name = name;
        this.tasks = tasks;
    }
*/
    /*
     * [Método constructor con un solo parámetro.]
     * @param name String
     * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.coW
     * @since Esta presente desde la version 1.0.0
     */
    /*
    public ListsModel(String name) {
        this.name = name;
    }
*/
    /**
     * [Método constructor por defecto.]
     *
     * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.coW
     * @since Esta presente desde la version 1.0.0
     */
    public ListsModel() {

    }

    //Setters and getters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TasksModel> getTasks() {
        return tasks;
    }

    public void setTasks(List<TasksModel> tasks) {

        this.tasks = tasks;
        for(TasksModel task: tasks){
            task.setIdlist(this);
        }
    }
}