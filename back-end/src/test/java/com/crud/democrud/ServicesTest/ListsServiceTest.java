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

    @Autowired
    TasksRepository tasksRepository;

    @Test
    void testGuardarLists() {
        List<TasksModel> tasks = new ArrayList<>();

        TasksModel taskModel=new TasksModel("Luisa te amo", true);
        TasksModel taskModelRegistrado1 = tasksRepository.save(taskModel);
        TasksModel taskModel2=new TasksModel("Luisa te amo", true);
        TasksModel taskModelRegistrado2 = tasksRepository.save(taskModel);

        tasks.add(taskModelRegistrado1);
        tasks.add(taskModelRegistrado2);

        ListsModel listsModel = new ListsModel( "to do-list", tasks);
        ListsModel listsModelRegistrado = usuarioRepository.save(listsModel);
        assertNotNull(listsModelRegistrado);
    }

    @Test
    void testListarLists() {

        List<TasksModel> tasks = null;
        ListsModel listsModel = new ListsModel( "to do-list", tasks);
        ListsModel listsModelRegistrado = usuarioRepository.save(listsModel);

        List<TasksModel> tasks2 = null;
        ListsModel listsModel2 = new ListsModel( "to do-list", tasks2);
        ListsModel listsModelRegistrado2 = usuarioRepository.save(listsModel2);

        List<ListsModel> listsModelList = (List<ListsModel>) usuarioRepository.findAll();
        assertThat(listsModelList).size().isGreaterThan(1);
    }



}
