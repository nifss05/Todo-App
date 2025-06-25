package com.nifal.springBootProject.myFirsWebProject.todo;

import java.time.LocalDate;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

//@Controller
@SessionAttributes("name")
public class TodoController {
	
	TodoService todoService;
	
	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	@RequestMapping("todo-list")
	public String listAllTodos(ModelMap model) {
		String username = getLoggedinUsername(model);
		model.put("todos", todoService.findByUsername(username));
		return"listTodo";
	}
	
	@RequestMapping(value = "add-todo",method = RequestMethod.GET)
	public String showTodoPage(ModelMap model) {
		String username = getLoggedinUsername(model);
		Todo todo = new Todo(0, username,"", LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		return"todo";
	}
	
	@RequestMapping(value = "add-todo",method = RequestMethod.POST)
	public String addTodo(ModelMap model, @Valid Todo todo,BindingResult result) {
		
		if (result.hasErrors()) {
			return"todo";
		}
		
		String username = getLoggedinUsername(model);
		todoService.addTodo(username, todo.getDiscription(),todo.getTargetDate(), false);
		return"redirect:todo-list";
	}
	
	@RequestMapping("delete-todo")
	public String listAllTodos(@RequestParam int id) {
		todoService.deleteTodo(id);
		return"redirect:todo-list";
	}
	
	@RequestMapping(value = "update-todo",method = RequestMethod.GET)
	public String showUpadteTodo(@RequestParam int id,ModelMap model) {
		Todo todo = todoService.findById(id);
		model.addAttribute("todo",todo);
		return"todo";
	}
	
	@RequestMapping(value = "update-todo",method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo,BindingResult result) {
		
		if (result.hasErrors()) {
			return"todo";
		}
		
		String username = getLoggedinUsername(model);
		todo.setUsername(username);
		todoService.updateTodo(todo);
		return"redirect:todo-list";
	}
	
	private String getLoggedinUsername(ModelMap model) {
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	

}
