package com.crud.democrud.ServicesTest;

import com.crud.democrud.models.ListsModel;
import com.crud.democrud.repositories.UsuarioRepository;
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
public class UsuarioServiceTest {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Test
    public void testGuardarUsuario() {
        ListsModel usuarioModel = new ListsModel( "john", "esteban.ea145@gmail.com", 99);
        ListsModel usuarioModelRegistrado = usuarioRepository.save(usuarioModel);
        assertNotNull(usuarioModelRegistrado);
    }


    @Test
    public void testListarUsuarios() {
        List<ListsModel> usuarioModelList = (List<ListsModel>) usuarioRepository.findAll();
        assertThat(usuarioModelList).size().isGreaterThan(1);
    }

    @Test
    public void testBuscarUsuarioPorId() {
        Long idBuscado = 1l;
        Optional<ListsModel> usuarioModelBuscado = usuarioRepository.findById(idBuscado);
        assertThat(usuarioModelBuscado.get().getId()).isEqualTo(idBuscado);
    }

    @Test
    public void testBuscarUsuarioPorEmail() {
        String emailBuscado = "esteban.ea145@gmail.com";
        Optional<ListsModel> usuarioModelBuscado = usuarioRepository.findByEmail(emailBuscado);
        assertThat(usuarioModelBuscado.get().getEmail()).isEqualTo(emailBuscado);
    }


    @Test
    public void testEliminarUsuarioPorEmail() {
        String emailBuscado = "esteban.ea145@gmail.com";

        Optional<ListsModel> usuario = usuarioRepository.findByEmail(emailBuscado);
        Long id = usuario.get().getId();
        usuarioRepository.deleteById(id);
        
        List<ListsModel> usuarioModelList = (List<ListsModel>) usuarioRepository.findAll();
        assertThat(usuarioModelList).size().isGreaterThan(0);
    }


}
