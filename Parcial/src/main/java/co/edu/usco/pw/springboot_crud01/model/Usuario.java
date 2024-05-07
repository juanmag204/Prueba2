package co.edu.usco.pw.springboot_crud01.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name = "usuario")

public class Usuario implements Serializable{

        /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idUsuario;

        @NotEmpty
        private String username;
        @NotEmpty
        private String password;

        @OneToMany
        @JoinColumn(name="id_usuario")
        private List<Rol> roles;


        public List<Rol> getRoles() {
            return roles;
        }


        public void setRoles(List<Rol> roles) {
            this.roles = roles;
        }


        public Usuario() {
            super();
        }



        public Usuario(Long idUsuario, @NotEmpty String username, @NotEmpty String password, List<Rol> roles) {
            super();
            this.idUsuario = idUsuario;
            this.username = username;
            this.password = password;
            this.roles = roles;
        }


        public Long getIdUsuario() {
            return idUsuario;
        }
        public void setIdUsuario(Long id) {
            this.idUsuario = id;
        }
        public String getUsername() {
            return username;
        }
        public void setUsername(String username) {
            this.username = username;
        }
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
}