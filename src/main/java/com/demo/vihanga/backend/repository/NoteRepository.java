package com.demo.vihanga.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.vihanga.backend.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer>{


}
