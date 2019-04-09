package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the Author database table.
 * 
 */
@Entity
@Table(name = "Author")
@NamedQuery(name = "findAuthorByName", query = "SELECT a from Author a order by a.name")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long id;

	private String name;

	@OneToOne
	@JoinColumn(name = "id_fk")
	private BookModel bookModel;

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BookModel getBookModel() {
		return bookModel;
	}

	public void setBookModel(BookModel bookModel) {
		this.bookModel = bookModel;
		this.id = bookModel.getId();
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + "]";
	}

}