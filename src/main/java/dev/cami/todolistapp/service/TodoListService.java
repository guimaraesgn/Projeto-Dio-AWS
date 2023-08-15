package dev.cami.todolistapp.service;

import dev.cami.todolistapp.model.TodoList;
import dev.cami.todolistapp.repository.TodoListRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public record TodoListService(TodoListRepository todoListRepository) {



    public TodoList createTodoList(TodoList todoList) {
        return todoListRepository.save(todoList);
    }

    public List<TodoList> getAllTodoLists() {
        return todoListRepository.findAll();
    }

    public TodoList getTodoList(UUID id) {
        return todoListRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Todo list not found"));
    }

    public TodoList updateTodoList(UUID id, TodoList todoList) {
        TodoList todoListToUpdate = todoListRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Todo list not found"));
        todoListToUpdate.setTitle(todoList.getTitle());
        return todoListRepository.save(todoListToUpdate);
    }

    public void deleteTodoList(UUID id) {
        todoListRepository.deleteById(id);
    }

}
