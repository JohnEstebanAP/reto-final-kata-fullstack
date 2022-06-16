package com.crud.democrud.repositories;

import com.crud.democrud.models.ListsModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends CrudRepository<ListsModel, Long> {
    public abstract ArrayList<ListsModel> findByPrioridad(Integer prioridad);

    public abstract Optional<ListsModel> findByEmail(String email);

}