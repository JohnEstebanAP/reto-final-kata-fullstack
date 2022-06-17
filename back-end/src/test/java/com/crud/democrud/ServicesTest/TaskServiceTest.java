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

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
class TaskServiceTest {
    @Autowired
    TasksRepository tasksRepository;

    @Autowired
    ListsRepository usuarioRepository;

    @Test
    void testGuardarTasks(){
        ListsModel listsModel = new ListsModel("to do-list");
        ListsModel listsModelRegistrado = usuarioRepository.save(listsModel);

        TasksModel taskModel=new TasksModel("Luisa te amo", true, listsModelRegistrado);
        TasksModel taskModelRegistrado = tasksRepository.save(taskModel);
        assertNotNull(taskModelRegistrado);
    }

    @Test
    void testListarTasks(){
        ListsModel listsModel = new ListsModel("to do-list");
        ListsModel listsModelRegistrado = usuarioRepository.save(listsModel);

        TasksModel taskModel=new TasksModel("Luisa te amo", true, listsModelRegistrado);
        TasksModel taskModelRegistrado = tasksRepository.save(taskModel);

        List<TasksModel> tasksModelList= (List<TasksModel>) tasksRepository.findAll();
        assertThat(tasksModelList).size().isGreaterThan(1);
    }

}
