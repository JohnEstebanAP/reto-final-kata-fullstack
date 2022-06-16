package com.crud.democrud.ControllerServiceTest;

import com.crud.democrud.repositories.ListsRepository;
import com.crud.democrud.services.ListsServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
 class UsuarioServiceMockTest {

  @MockBean
  ListsRepository usuarioRepository;

  @Autowired
  ListsServiceImpl usuarioService;

  @Test
  void testUsuarioMock(){
    when(usuarioRepository.findAll()).thenReturn(new ArrayList<>());
    assertThat(usuarioService.getListsAll()).isEmpty();
    verify(usuarioRepository).findAll();
  }

}
