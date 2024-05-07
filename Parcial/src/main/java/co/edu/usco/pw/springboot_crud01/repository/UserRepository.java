package co.edu.usco.pw.springboot_crud01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.usco.pw.springboot_crud01.model.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {

    Usuario findByUsername(String username);

}