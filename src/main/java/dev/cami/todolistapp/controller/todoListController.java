package dev.cami.todolistapp.controller;

import dev.cami.todolistapp.model.TodoList;
import dev.cami.todolistapp.service.TodoListService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/todo-lists")
public record todoListController(
        TodoListService todoListService
) {

    @GetMapping
    public List<TodoList> getAllTodoLists() {
        return todoListService.getAllTodoLists();
    }

    @GetMapping("/{id}")
    public TodoList getTodoList(@PathVariable UUID id) {
        return todoListService.getTodoList(id);
    }

    @PostMapping
    public TodoList createTodoList(@RequestBody TodoList todoList) {
        return todoListService.createTodoList(todoList);
    }

    @PutMapping("/update/{id}")
    public TodoList updateTodoList(@PathVariable("id") UUID uuid, @RequestBody TodoList todoList) {
        return todoListService.updateTodoList(uuid, todoList);
    }

    @DeleteMapping("delete/{id}")
    public void deleteTodoList(@PathVariable UUID id) {
        todoListService.deleteTodoList(id);
    }
}


