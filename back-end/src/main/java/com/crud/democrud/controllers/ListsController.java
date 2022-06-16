package com.crud.democrud.controllers;

import com.crud.democrud.models.ListsModel;
import com.crud.democrud.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    UsuarioService listsService;

    /**
     * [Método para consultar todos los elemento de la tabla Lists.]
     *
     * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
     * @since Esta presente desde la version 1.0.0
     */
    @GetMapping()
    public ArrayList<ListsModel> getListsAll() {
        return listsService.getListAll();
    }

    /**
     * [Método para crear nuevas filas en la tabla Lists.]
     *
     * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
     * @since Esta presente desde la version 1.0.0
     */
    @PostMapping()
    public ListsModel addLists(@RequestBody ListsModel lists) {
        return this.listsService.addLists(lists);
    }

    /**
     * [Método para actualizar una fila por el id del elemento.]
     *
     * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
     * @since Esta presente desde la version 1.0.0
     */
    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody ListsModel lists){
        listsService.update(id, lists);
    }

    /**
     * [Método para eliminar una fila por el id del elemento.]
     *
     * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
     * @since Esta presente desde la version 1.0.0
     */
    @DeleteMapping(path = "/{id}")
    public String DeleteById(@PathVariable("id") Long id) {
        boolean ok = this.listsService.DeleteById(id);
        if (ok) {
            return "Se eliminó el la lista con el id ".concat(String.valueOf(id));
        } else {
            return "No pudo eliminar el la lista con el id ".concat(String.valueOf(id));
        }
    }


}