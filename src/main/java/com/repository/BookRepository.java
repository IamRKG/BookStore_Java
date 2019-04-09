package com.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.model.BookModel;

public class BookRepository {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("BookStorePU");
	EntityManager em = emf.createEntityManager();

	/* JTA Type */
	/*
	 * @PersistenceContext(unitName="BookStorePU",
	 * type=PersistenceContextType.TRANSACTION) EntityManager em;
	 */

	public BookModel find(Long id) {
		return em.find(BookModel.class, id);
	}

	public BookModel create(BookModel bookModel) {
		em.getTransaction().begin();
		em.persist(bookModel);
		em.getTransaction().commit();
		return bookModel;
	}

	public void delete(Long id) {
		em.getTransaction().begin();
		em.remove(em.getReference(BookModel.class, id));
		em.getTransaction().commit();

	}

	public List<BookModel> findAll() {
		TypedQuery<BookModel> query = em.createNamedQuery("findBookByTitle", BookModel.class);
		return query.getResultList();
	}

	public Long countAll() {
		TypedQuery<Long> query = em.createQuery("select count(b) from BookModel b", Long.class);
		return query.getSingleResult();
	}

	public BookModel update(BookModel bookModel) {
		em.getTransaction().begin();
		em.merge(bookModel);
		em.getTransaction().commit();
		return bookModel;

	}

}
