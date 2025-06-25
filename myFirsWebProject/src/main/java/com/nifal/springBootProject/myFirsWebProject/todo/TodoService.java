package com.nifal.springBootProject.myFirsWebProject.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	
	public static List<Todo> todos = new ArrayList<Todo>();
	public static int countTodo=0;
	static {
		todos.add(new Todo(++countTodo,"Nifal", "learn Java",
				LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++countTodo,"Nifal", "learn Java1",
				LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++countTodo,"Nifal", "learn Java2",
				LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++countTodo,"Nifal", "learn Java3",
				LocalDate.now().plusYears(1), false));
	}
	
	public List<Todo> findByUsername(String userName) {
		Predicate<? super Todo> predicate = 
				todo -> todo.getUsername().equalsIgnoreCase(userName);
		return todos.stream().filter(predicate).toList();
	}
	
	public void addTodo(String username,String discription,LocalDate localDate,boolean done) {
		Todo todo = new Todo(++countTodo,username ,discription,localDate, done);
		todos.add(todo);
		
	}
	
	public void deleteTodo(int id) {
		
		Predicate<? super Todo> predicate = todo -> todo.getId()==id;
		todos.removeIf(predicate);
		
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId()==id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		deleteTodo(todo.getId());
		todos.add(todo);
		
	}

}
