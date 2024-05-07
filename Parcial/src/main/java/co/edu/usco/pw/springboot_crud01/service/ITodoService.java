package co.edu.usco.pw.springboot_crud01.service;

import java.util.Date;

import java.util.List;
import java.util.Optional;

import co.edu.usco.pw.springboot_crud01.model.Todo;


public interface ITodoService {

    List<Todo> getTodosByUser(String user);

    Optional<Todo> getTodoById(long id);

    void updateTodo(Todo todo);

    void deleteTodo(long id);

    void saveTodo(Todo todo);

    List<Todo> getTodos();

    void addTodo(String userName, String name, String schedule, String teacher, String classroom, String status);
}