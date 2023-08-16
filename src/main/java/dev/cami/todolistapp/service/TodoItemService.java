package dev.cami.todolistapp.service;

import dev.cami.todolistapp.model.TodoItem;
import dev.cami.todolistapp.repository.TodoItemRepository;
import dev.cami.todolistapp.model.TodoList;
import dev.cami.todolistapp.repository.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.UUID;
import java.util.List;
import java.util.Optional;

@Service
public record TodoItemService(
        TodoItemRepository todoItemRepository,
        TodoListService todoListService
) {

    public TodoItem createTodoItem(TodoItem todoItem) {
        return todoItemRepository.save(todoItem);
    }

    public TodoItem getTodoItem(UUID id) {
        return todoItemRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Todo item with id " + id + " does not exist.")
        );
    }

    public void deleteTodoItem(UUID id) {
        todoItemRepository.deleteById(id);
    }

    public TodoItem updateTodoItem(TodoItem todoItem) {
        TodoItem existingTodoItem = getTodoItem(todoItem.getId());
        existingTodoItem.setDescription(todoItem.getDescription());
        existingTodoItem.setCompleted(todoItem.isCompleted());
        return todoItemRepository.save(existingTodoItem);
    }

    public TodoItem markTodoItemCompleted(UUID id) {
        TodoItem existingTodoItem = getTodoItem(id);
        existingTodoItem.setCompleted(true);
        return todoItemRepository.save(existingTodoItem);
    }
}