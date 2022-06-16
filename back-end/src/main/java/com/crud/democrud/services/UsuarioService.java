package com.crud.democrud.services;

import com.crud.democrud.models.ListsModel;
import com.crud.democrud.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;
    
    public ArrayList<ListsModel> obtenerUsuarios(){
        return (ArrayList<ListsModel>) usuarioRepository.findAll();
    }

    public ListsModel guardarUsuario(ListsModel usuario){
        return usuarioRepository.save(usuario);
    }

    public Optional<ListsModel> obtenerPorId(Long id){
        return usuarioRepository.findById(id);
    }

    public Optional<ListsModel> obtenerPorEmail(String email){
        return usuarioRepository.findByEmail(email);
    }

    public ArrayList<ListsModel>  obtenerPorPrioridad(Integer prioridad) {
        return usuarioRepository.findByPrioridad(prioridad);
    }

    public boolean eliminarUsuario(Long id) {
        try{
            usuarioRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

    public boolean eliminarPorEmail(String email) {
        try{
            Optional<ListsModel> usuario = usuarioRepository.findByEmail(email);
            Long id = usuario.get().getId();
            eliminarUsuario(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }


    public void update(Long id, ListsModel usuario) {
        Optional<ListsModel> existsUsuario = usuarioRepository.findById(id);
        if (existsUsuario.isPresent()) {
            existsUsuario.get().setId(usuario.getId());
            existsUsuario.get().setNombre(usuario.getNombre());
            existsUsuario.get().setEmail(usuario.getEmail());
            existsUsuario.get().setPrioridad(usuario.getPrioridad());
            usuarioRepository.save(existsUsuario.get());
        }
    }
    
}