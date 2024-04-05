package com.notetaker.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import jakarta.annotation.Generated;

@Entity
@Table(name="tbl_note")
public class Note {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int noteId;

	private String noteTitle;
	
	@Column(length=2000)
	private String noteContent;
	
	private Date noteAddedDate;

	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Note(int noteId, String noteTitle, String noteContent, Date noteAddedDate) {
		super();
		this.noteId = noteId;
		this.noteTitle = noteTitle;
		this.noteContent = noteContent;
		this.noteAddedDate = noteAddedDate;
	}

	public int getNoteId() {
		return noteId;
	}

	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}

	public String getNoteTitle() {
		return noteTitle;
	}

	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}

	public String getNoteContent() {
		return noteContent;
	}

	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}

	public Date getNoteAddedDate() {
		return noteAddedDate;
	}

	public void setNoteAddedDate(Date noteAddedDate) {
		this.noteAddedDate = noteAddedDate;
	}

	@Override
	public String toString() {
		return "Note [noteId=" + noteId + ", noteTitle=" + noteTitle + ", noteContent=" + noteContent
				+ ", noteAddedDate=" + noteAddedDate + "]";
	}

}
