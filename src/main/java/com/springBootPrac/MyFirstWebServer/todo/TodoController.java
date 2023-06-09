package com.springBootPrac.MyFirstWebServer.todo;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

//@Controller
@SessionAttributes("name")
public class TodoController {
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        super();
        this.todoService = todoService;
    }

    @RequestMapping("list-todo")
    private String ListAllTodos(ModelMap map){
        String username = getLoggedInUsername(map);
        List<Todo> todos = todoService.findByUsername(username);
        map.addAttribute("todos",todos);
        return "listToDos";
    }

    private static String getLoggedInUsername(ModelMap map) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @RequestMapping(value="Add-Todo", method = RequestMethod.GET)
    private String showNewTodoPage(ModelMap map){
        String username = getLoggedInUsername(map);
        Todo todo = new Todo(0,username,"",LocalDate.now().plusYears(1),false);
        map.put("todo",todo);
        return "todo";
    }

    @RequestMapping(value="Add-Todo",method = RequestMethod.POST)
    private String addNewTodoPage(ModelMap map, @Valid Todo todo, BindingResult result) {
//        if (result.hasErrors()){
//            return "todo";
//        }
        String username = getLoggedInUsername(map);
        todoService.addTodo(username, todo.getDescription(), LocalDate.now().plusYears(1),false);
        return "redirect:list-todo";
    }
    @RequestMapping("deleteTodo")
    private String deleteTodo(@RequestParam int id){
        TodoService.deleteById(id);
        return "redirect:list-todo";
    }
    @RequestMapping(value="updateTodo",method = RequestMethod.GET)
    private String showUpdatePage(@RequestParam int id, ModelMap map){
        Todo todo = todoService.findById(id);
        map.addAttribute("todo",todo);
        return "todo";
    }
    @RequestMapping(value="updateTodo",method = RequestMethod.POST)
    private String updateTodo(ModelMap map, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()){
            return "todo";
        }
        String username = getLoggedInUsername(map);
        todo.setUsername(username);
        todoService.updateTodo(todo);
        return "redirect:list-todo";
    }
}