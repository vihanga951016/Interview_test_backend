package com.demo.vihanga.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.demo.vihanga.backend.model.Note;
import com.demo.vihanga.backend.service.NoteService;

@RestControllerAdvice
//@CrossOrigin
@RequestMapping("/note")
public class NoteController {

	private final NoteService noteService;

	@Autowired
	public NoteController(NoteService noteService) {
		this.noteService = noteService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Note>> getAllNotes(){
		return new ResponseEntity<>(noteService.getAllNotes(), HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Note> getNote(@PathVariable("id") Integer id){
		return new ResponseEntity<>(noteService.findNote(id), HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Note> addNote(@RequestBody Note note){
		return new ResponseEntity<>(noteService.addNote(note), HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Note> updateNotes(@PathVariable("id") Integer id,@RequestBody Note note){
		return new ResponseEntity<>(noteService.updateNote(note), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable("id") Integer id){
		noteService.deleteNote(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
