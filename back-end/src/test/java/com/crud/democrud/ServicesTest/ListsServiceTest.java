package com.crud.democrud.ServicesTest;

import com.crud.democrud.models.ListsModel;
import com.crud.democrud.models.TasksModel;
import com.crud.democrud.repositories.ListsRepository;
import com.crud.democrud.repositories.TasksRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ListsServiceTest {
    @Autowired
    ListsRepository usuarioRepository;

    @Test
    void testGuardarLists() {
        ListsModel listsModel = new ListsModel("to do-list");
        ListsModel listsModelRegistrado = usuarioRepository.save(listsModel);
        assertNotNull(listsModelRegistrado);
    }

    @Test
    void testListarLists() {
        List<ListsModel> listsModelList = (List<ListsModel>) usuarioRepository.findAll();
        assertThat(listsModelList).size().isGreaterThan(1);
    }


}
