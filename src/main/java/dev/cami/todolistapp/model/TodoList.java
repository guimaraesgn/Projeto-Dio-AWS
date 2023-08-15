package dev.cami.todolistapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Builder
@Entity
@Getter
@NoArgsConstructor
//@Setter
public class TodoList {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "list_id")
    private List<TodoItem> items = new ArrayList<>();


    /*public TodoList(UUID id, String title, List<TodoItem> items) {
        this.id = id;
        this.title = title;
        this.items = items;
    }

    public TodoList() {
    }*/

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<TodoItem> getItems() {
        return items;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setItems(List<TodoItem> items) {
        this.items = items;
    }
}
