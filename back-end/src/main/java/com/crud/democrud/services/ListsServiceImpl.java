package com.crud.democrud.services;

import com.crud.democrud.models.ListsModel;
import com.crud.democrud.repositories.ListsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/**
 * [Clase de implementación del servicio de la entidad Lists.]
 *
 * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
 * @version 1.0.0
 * @since Esta presente desde la version 1.0.0
 */
@Service
public class ListsServiceImpl {
    /**
     * crea una instancia o implementación de la interfaz de ListsRepository.
     */
    @Autowired
    ListsRepository listsRepository;

    /**
     * [Método para consultar todos los elemento de la tabla Lists.]
     *
     * @return List<ListsModel></>
     * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
     * @since Esta presente desde la version 1.0.0
     */
    public List<ListsModel> getListsAll(){
        return (List<ListsModel>) listsRepository.findAll();
    }


    /**
     * [Método para crear nuevas filas en la tabla Lists.]
     *
     * @return ListsModel
     * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
     * @since Esta presente desde la version 1.0.0
     */
    public ListsModel addLists(ListsModel list){
        return listsRepository.save(list);
    }

    /**
     * [Método para actualizar una fila por el id del elemento.]
     * @param id int
     * @param list ListsModel
     * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
     * @since Esta presente desde la version 1.0.0
     */
    public void update(Integer id, ListsModel list) {
        Optional<ListsModel> existslist = listsRepository.findById(id);
        if (existslist.isPresent()) {
            existslist.get().setId(list.getId());
            existslist.get().setName(list.getName());
            existslist.get().setTasks(list.getTasks());
            listsRepository.save(existslist.get());
        }
    }

    /**
     * [Método para eliminar una fila por el id del elemento.]
     *
     * @param id int
     * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
     * @since Esta presente desde la version 1.0.0
     */
    public boolean deleteById(Integer id) {
        try{
            listsRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }


    
}