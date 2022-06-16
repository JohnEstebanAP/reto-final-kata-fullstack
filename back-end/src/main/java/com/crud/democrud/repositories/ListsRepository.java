package com.crud.democrud.repositories;

import com.crud.democrud.models.ListsModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListsRepository extends CrudRepository<ListsModel, Integer> {

}