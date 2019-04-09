package com.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Book")
@NamedQuery(name = "findBookByTitle", query = "SELECT b from BookModel b order by b.title")
public class BookModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long id;

	private String description;

	private String imageUrl;

	private String isbn;

	private String languageEnum;

	private int nbOfPages;

	@Column(name = "pubalication_date")
	@Temporal(TemporalType.DATE)
	private Date pubalicationDate;

	private String title;

	@Column(name = "unit_cost")
	private int unitCost;

	@OneToOne(mappedBy = "bookModel")
	private Author author;

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getLanguageEnum() {
		return this.languageEnum;
	}

	public void setLanguageEnum(String languageEnum) {
		this.languageEnum = languageEnum;
	}

	public int getNbOfPages() {
		return this.nbOfPages;
	}

	public void setNbOfPages(int nbOfPages) {
		this.nbOfPages = nbOfPages;
	}

	public Date getPubalicationDate() {
		return this.pubalicationDate;
	}

	public void setPubalicationDate(Date pubalicationDate) {
		this.pubalicationDate = pubalicationDate;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getUnitCost() {
		return this.unitCost;
	}

	public void setUnitCost(int unitCost) {
		this.unitCost = unitCost;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	
	public BookModel() {
		
	}

	@Override
	public String toString() {
		return "BookModel [id=" + id + ", description=" + description + ", imageUrl=" + imageUrl + ", isbn=" + isbn
				+ ", languageEnum=" + languageEnum + ", nbOfPages=" + nbOfPages + ", pubalicationDate="
				+ pubalicationDate + ", title=" + title + ", unitCost=" + unitCost + "]";
	}

}