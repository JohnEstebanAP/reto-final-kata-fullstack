package com.crud.democrud.ServicesTest;

import com.crud.democrud.models.ListsModel;
import com.crud.democrud.models.TasksModel;
import com.crud.democrud.repositories.TasksRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioRolServiceTest {
    @Autowired
    TasksRepository usuarioRolRepository;

    @Test
    public void testGuardarUsuarioRol(){
        ListsModel usuarioModel=new ListsModel("Luisa","Luisa@gmail.com",100);
        TasksModel usuarioRolModel=new TasksModel(1,usuarioModel ,"Ingeniera");
        TasksModel usuarioRolModelRegistrado = usuarioRolRepository.save(usuarioRolModel);
        assertNotNull(usuarioRolModelRegistrado);
    }

    @Test
    public void testBuscarUsuarioRolPorId(){
        Integer idBuscado=1;
        Optional<TasksModel> usuarioRolModelBuscado=usuarioRolRepository.findById(idBuscado);
        assertThat(usuarioRolModelBuscado.get().getIdRol()).isEqualTo(idBuscado);
    }

    @Test
    public void testListarUsuariosRol(){
        List<TasksModel> usuarioRolModelList=(List<TasksModel>) usuarioRolRepository.findAll();
        assertThat(usuarioRolModelList).size().isGreaterThan(0);
    }

}
