package com.cwm.springboot.mytodoapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

	@Autowired
	private TodoRepository todoRepository;

//	public static int todoId = 0;
//	private static List<Todo> todoList = new ArrayList<>();
//
//	static {
//		todoList.add(new Todo(++todoId, "manish", "to learn spring", LocalDate.now().plusYears(1), false));
//		todoList.add(new Todo(++todoId, "sunny", "to learn springboot", LocalDate.now().plusYears(2), false));
//		todoList.add(new Todo(++todoId, "raj", "to learn nextJs", LocalDate.now().plusYears(1), false));
//		todoList.add(new Todo(++todoId, "kushank", "to learn reactJs", LocalDate.now().plusYears(5), false));
//		todoList.add(new Todo(++todoId, "ayansh", "to learn Java", LocalDate.now().plusYears(10), false));
//	}

	public List<Todo> findAllTodos() {
		return todoRepository.findAll();
	}

	public List<Todo> findAllByUsername(String username) {

		List<Todo> todos = todoRepository.findByUsername(username);
		return todos;
//		return todoList.stream().filter(todo -> todo.getUsername().equalsIgnoreCase(username))
//				.collect(Collectors.toList());

	}

	public void addNewTodo(String username, String description, LocalDate targetDate, boolean done) {
		Todo todo = new Todo(username, description, targetDate, done);
		todo.setUsername(username);
		todoRepository.save(todo);
	}

	public void deleteTodo(int id) {
//		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
//		todoList.removeIf(predicate);
		todoRepository.deleteById(id);
	}

	public Todo findById(int id) {
//		Todo todo = todoList.stream().filter(t -> t.getId() == id).findFirst().get();
		Todo todo = todoRepository.findById(id).get();
		return todo;
	}

	public void updateTodo(Todo todo) {
		deleteTodo(todo.getId());
		todoRepository.save(todo);
	}
}
