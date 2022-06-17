package com.crud.democrud.ServicesTest;

import com.crud.democrud.models.ListsModel;
import com.crud.democrud.models.TasksModel;
import com.crud.democrud.repositories.TasksRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
class TaskServiceTest {
    @Autowired
    TasksRepository tasksRepository;

    @Test
    void testGuardarTasks(){
        TasksModel taskModel=new TasksModel("Luisa te amo", true);
        TasksModel taskModelRegistrado = tasksRepository.save(taskModel);
        assertNotNull(taskModelRegistrado);
    }

    @Test
    void testListarTasks(){
        TasksModel taskModel=new TasksModel("Luisa te amo", true);
        TasksModel taskModelRegistrado = tasksRepository.save(taskModel);

        List<TasksModel> tasksModelList= (List<TasksModel>) tasksRepository.findAll();
        assertThat(tasksModelList).size().isGreaterThan(0);
    }

}
