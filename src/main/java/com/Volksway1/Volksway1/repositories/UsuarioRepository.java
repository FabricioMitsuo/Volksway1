package com.Volksway1.Volksway1.repositories;

import com.Volksway1.Volksway1.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, UUID> {


    UsuarioModel findByEmail(String email);
}
