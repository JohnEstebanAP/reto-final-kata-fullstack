package com.crud.democrud.ServicesTest;

import com.crud.democrud.models.ListsModel;
import com.crud.democrud.repositories.ListsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UsuarioServiceTest {
    @Autowired
    ListsRepository usuarioRepository;

    @Test
    void testGuardarUsuario() {
        ListsModel listsModel = new ListsModel( "to do-list");
        ListsModel usuarioModelRegistrado = usuarioRepository.save(listsModel);
        assertNotNull(usuarioModelRegistrado);
    }


    @Test
    void testListarUsuarios() {
        List<ListsModel> listsModelList = (List<ListsModel>) usuarioRepository.findAll();
        assertThat(listsModelList).size().isGreaterThan(1);
    }



}
