package com.crud.democrud.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

/**
 * [Clase para modelar la tabla de las Tareas que se relaciana col las listas de tareas.]
 *
 * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
 * @version 1.0.0
 * @since Esta presente desde la version 1.0.0
 */
@Entity
@Table(name = "Tasks")
public class TasksModel {

    /**
     * Representa la columna del id como llave primaria auto incrementable y no puede ser nula.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtask", unique = true, nullable = false)
    private Integer idTask;

    /**
     * Representa la columna de la descripción de la tarea.
     */
    @Column(name = "descripcion")
    private String description;

    /**
     * Representa la columna si la tarea esta realizada.
     */
    @Column(name = "realized")
    private boolean realized;
    /**
     * Llave foranea, representa la columna  que hace referencia a el id de la lista.
     */
    //@JoinColumn(name = "idlist", referencedColumnName = "id")
//    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idlist")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private ListsModel idlist;


    /**
     * [Método constructor por defecto.]
     *
     * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.coW
     * @since Esta presente desde la version 1.0.0
     */
    public TasksModel() {

    }

    /**
     * [Método constructor con todos los parámetros.]
     * @param description Strign
     * @param realized boolean
     * @param idlist ListsModel
     * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.coW
     * @since Esta presente desde la version 1.0.0
     */
    public TasksModel(String description, boolean realized, ListsModel idlist) {
        this.description = description;
        this.realized = realized;
        this.idlist = idlist;
    }


    //Getters and Setters

    public Integer getIdTask() {
        return idTask;
    }

    public void setIdTask(Integer idTask) {
        this.idTask = idTask;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isRealized() {
        return realized;
    }

    public void setRealized(boolean realized) {
        this.realized = realized;
    }

    public ListsModel getIdlist() {
        return idlist;
    }

    public void setIdlist(ListsModel idlist) {
        this.idlist = idlist;
    }


}
