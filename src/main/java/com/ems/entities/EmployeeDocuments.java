package com.ems.entities;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class EmployeeDocuments {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer documentId;
	
	@ManyToOne@NotNull
	@JoinColumn(name = "employee_id")
	private Employee employee;
	
	private String documentDescription;
	
	private Blob doc;
	
	public Blob getDoc() {
		return doc;
	}

	public void setDoc(Blob doc) {
		this.doc = doc;
	}

	private byte[] documentFile;

	public Integer getDocumentId() {
		return documentId;
	}

	public void setDocumentId(Integer documentId) {
		this.documentId = documentId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getDocumentDescription() {
		return documentDescription;
	}

	public void setDocumentDescription(String documentDescription) {
		this.documentDescription = documentDescription;
	}

	public byte[] getDocumentFile() {
		return documentFile;
	}

	public void setDocumentFile(byte[] documentFile) {
		this.documentFile = documentFile;
	}
	
	
}
