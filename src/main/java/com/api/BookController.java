package com.api;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;

import com.model.BookModel;
import com.repository.BookRepository;

@Path("/books")

public class BookController {

	@Inject
	private BookRepository bookRepository;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response getBook(@PathParam("id") Long id) {
		BookModel book = bookRepository.find(id);
		return Response.ok(book).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response createBook(BookModel bookModel) {
		bookModel = bookRepository.create(bookModel);
		/*
		 * URI createdURI =
		 * uriInfo.getBaseUriBuilder().path(bookModel.getId().toString()).build();
		 */ return Response.ok(bookModel).build();
	}

	@DELETE
	@Path("{id}")
	public Response deleteBook(@PathParam("id") Long id) {
		bookRepository.delete(id);
		return Response.noContent().build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBooks() {
	
		List <String> book = new ArrayList<String>();
		//List<BookModel> books = new ArrayList<BookModel>(bookRepository.findAll());
		book.add("Hi");
		book.add("RKG");
		/*GenericEntity<List<BookModel>> list = new GenericEntity<List<BookModel>>(books) {};*/
		return Response.ok(book).build();
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateBook(BookModel bookModel) {
		bookModel = bookRepository.update(bookModel);
		return Response.ok(bookModel).build();
	}

	@GET
	@Path("/counts")
	public Response countBook() {
		Long count = bookRepository.countAll();
		return Response.ok(count).build();
	}

}