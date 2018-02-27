package com.ems.entities;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class EmployeeDocuments implements Serializable{

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer documentId;
	
	@JsonIgnore
	@ManyToOne@NotNull
	@JoinColumn(name = "user_id")
	@Basic(fetch = FetchType.LAZY)
	private User user;
	
	private String documentDescription;
	
	@JsonIgnore
	private Blob doc;
	
	public Blob getDoc() {
		return doc;
	}

	public void setDoc(Blob doc) {
		this.doc = doc;
	}

	public Integer getDocumentId() {
		return documentId;
	}

	public void setDocumentId(Integer documentId) {
		this.documentId = documentId;
	}


	public String getDocumentDescription() {
		return documentDescription;
	}

	public void setDocumentDescription(String documentDescription) {
		this.documentDescription = documentDescription;
	}


	
	
}
