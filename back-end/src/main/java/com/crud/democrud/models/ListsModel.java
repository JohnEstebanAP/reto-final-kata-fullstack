package com.crud.democrud.models;

import javax.persistence.*;


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
    private int id;
    private String name;


    /**
     * [Método constructor con todos los parámetros.]
     *
     * @param name String
     * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.coW
     * @since Esta presente desde la version 1.0.0
     */
    public ListsModel(String name) {
        this.name = name;
    }

    /**
     * [Método constructor por defecto.]
     *
     * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.coW
     * @since Esta presente desde la version 1.0.0
     */
    public ListsModel() {

    }

    //Setters and getters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}