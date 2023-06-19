package com.springBootPrac.MyFirstWebServer.todo;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
@SessionAttributes("name")
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();
    private static int todoCount = 0;

    static {
        todos.add(new Todo(++todoCount,"sathish","Jogging",
                LocalDate.now().plusMonths(4),false));
        todos.add(new Todo(++todoCount,"Ram","Meditation",
                LocalDate.now().plusMonths(5),false));
        todos.add(new Todo(++todoCount,"shanmathi","Sleeping",
                LocalDate.now().plusMonths(6),false));
    }
    public List<Todo> findByUsername(String username){
        Predicate<? super Todo> Predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
        return todos.stream().filter(Predicate).toList();
    }

    public void addTodo(@RequestParam String name, String description, LocalDate targetDate, Boolean done){
        Todo todo = new Todo(++todoCount, name,description,targetDate,done);
        todos.add(todo);
    }
    public static void deleteById(int id){
        Predicate<? super Todo> Predicate = todo -> todo.getId() == id ;
        todos.removeIf(Predicate);

    }
    public Todo findById(int id) {
        Predicate<? super Todo> Predicate = todo -> todo.getId() == id ;
        return todos.stream().filter(Predicate).findFirst().get();
    }
    public void updateTodo( Todo todo) {
        deleteById(todo.getId());
        todos.add(todo);
    }
}

