package com.crud.democrud.controllers;

import com.crud.democrud.models.ListsModel;
import com.crud.democrud.services.ListsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * [Clase controladora de tabla Lists.]
 *
 * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
 * @version 1.0.0
 * @since Esta presente desde la version 1.0.0
 */
@CrossOrigin
@RestController
@RequestMapping("/list")
public class ListsController {

    /**
     * crea una instancia de la clase ListsService
     */
    @Autowired
    ListsServiceImpl listsService;

    /**
     * [Método para consultar todos los elemento de la tabla Lists.]
     *
     * @return List<ListsModel></>
     * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
     * @since Esta presente desde la version 1.0.0
     */
    @GetMapping()
    public List<ListsModel> getListsAll() {
        return listsService.getListsAll();
    }

    /**
     * [Método para consultar por él id.]
     *
     * @return Optional<ListsModel></>
     * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
     * @since Esta presente desde la version 1.0.0
     */
    @GetMapping(path = "/{id}")
    public Optional<ListsModel> gotListsById(@PathVariable("id") Integer id) {
        return this.listsService.getListById(id);
    }

    /**
     * [Método para crear nuevas filas en la tabla Lists.]
     *
     * @return ListsModel
     * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
     * @since Esta presente desde la version 1.0.0
     */
    @PostMapping()
    public ListsModel addLists(@RequestBody ListsModel lists) {
        return this.listsService.addLists(lists);
    }

    /**
     * [Método para actualizar una fila por el id del elemento.]
     * @param id int
     * @param list ListsModel
     * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
     * @since Esta presente desde la version 1.0.0
     */
    @PutMapping(path= "/{id}")
    public void update(@PathVariable Integer id, @RequestBody ListsModel list){
        listsService.update(id, list);
    }

    /**
     * [Método para eliminar una fila por el id del elemento.]
     *
     * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
     * @since Esta presente desde la version 1.0.0
     */
    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Integer id) {
        boolean ok = this.listsService.deleteById(id);
        if (ok) {
            return "Se eliminó el la lista con el id ".concat(String.valueOf(id));
        } else {
            return "No pudo eliminar el la lista con el id ".concat(String.valueOf(id));
        }
    }


}