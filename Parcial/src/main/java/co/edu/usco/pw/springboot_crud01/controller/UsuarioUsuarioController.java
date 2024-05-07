package co.edu.usco.pw.springboot_crud01.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import co.edu.usco.pw.springboot_crud01.model.Todo;
import co.edu.usco.pw.springboot_crud01.service.ITodoService;

@Controller
public class UsuarioUsuarioController {
	
	@Autowired
	private ITodoService todoService;
	
	 private String getLoggedInUserName() {
	        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        if (principal instanceof UserDetails) {
	            return ((UserDetails) principal).getUsername();
	        }
	        return principal.toString();
	    }

	@GetMapping("/user/todos")
	public String listUserTodos(Model model) {
	    String username = getLoggedInUserName();
	    List<Todo> todos = todoService.getTodosByUser(username);
	    model.addAttribute("todos", todos);
	    return "user-todos"; // Nombre de la vista para los todos del usuario
	}

	@GetMapping("/user/todo/{id}")
	public String viewUserTodo(@PathVariable Long id, Model model) {
	    Optional<Todo> todo = todoService.getTodoById(id);
	    model.addAttribute("todo", todo.orElse(new Todo()));
	    return "user-todo-view"; // Nombre de la vista para ver un todo específico del usuario
	}

}
