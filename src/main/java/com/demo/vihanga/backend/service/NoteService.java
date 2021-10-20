package com.demo.vihanga.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.vihanga.backend.exception.NoteNotFoundException;
import com.demo.vihanga.backend.model.Note;
import com.demo.vihanga.backend.repository.NoteRepository;

@Service
public class NoteService {

	private final NoteRepository noteRepository;
	
	@Autowired
	public NoteService(NoteRepository noteRepository) {
		this.noteRepository = noteRepository;
	}
	
	public Note addNote(Note note) {
		return noteRepository.save(note);
	}
	
	public List<Note> getAllNotes(){
		return noteRepository.findAll();
	}
	
	public Note updateNote(Note note) {
		return noteRepository.save(note);
	}
	
	public Note findNote(Integer id) {
		return noteRepository.findById(id)
				.orElseThrow(() -> new NoteNotFoundException ("No Note like this by id: " +id));
	}
	
	public void deleteNote(Integer id) {
		noteRepository.deleteById(id);
	}
	
}
