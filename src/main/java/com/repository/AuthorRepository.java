package com.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.model.Author;

public class AuthorRepository {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("BookStorePU");
	EntityManager em = emf.createEntityManager();
	public List<Author> findAll() {
		TypedQuery<Author> query = em.createNamedQuery("findBookByTitle", Author.class);
		return query.getResultList();
	}
		
}
