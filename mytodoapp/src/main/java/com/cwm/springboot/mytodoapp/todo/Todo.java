package com.cwm.springboot.mytodoapp.todo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Todo {
	public Todo(String username2, String description2, LocalDate targetDate2, boolean done2) {
		this.username = username2;
		this.description = description2;
		this.targetDate = targetDate2;
		this.done = done2;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	@Size(min = 10, message = "min 10 character require")
	private String description;
	private LocalDate targetDate;
	private boolean done;

}
