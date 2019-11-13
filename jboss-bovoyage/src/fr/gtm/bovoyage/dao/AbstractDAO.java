package fr.gtm.bovoyage.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public abstract class AbstractDAO<E,ID> {

	private EntityManagerFactory emf;
	private Class<E> entityClass;
	
	public AbstractDAO(EntityManagerFactory emf, Class<E> entityClass) {
		this.entityClass = entityClass;
		this.emf = emf;
	}
	
	protected EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}
	
	public void create(E entity) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		em.close();
	}
	
	public void delete(ID id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		E entity = em.find(entityClass, id);
		em.remove(entity);
		em.getTransaction().commit();
		em.close();
	}
	
	public void update(E entity) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
		em.close();
	}
	
	public E findById(ID id) {
		EntityManager em =emf.createEntityManager();
		E entity = em.find(entityClass, id);
		em.close();
		return entity;
	}
}
