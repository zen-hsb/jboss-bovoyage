package fr.gtm.bovoyage.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import fr.gtm.bovoyage.entities.DatesVoyage;
import fr.gtm.bovoyage.entities.Destination;

public class DestinationDAO extends AbstractDAO<Destination, Long> {
	
	public DestinationDAO(EntityManagerFactory emf) {
		super(emf, Destination.class);
	}
	//coucou
	//2eme essai
	public List<Destination> getAllDestinations() {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		List<Destination> destinations = em.createNamedQuery("Destination.getAllDestinations", Destination.class).getResultList();
		em.close();
		return destinations;
	}
	
	public Set<DatesVoyage> getDatesVoyageByDestinationId(long id){
		EntityManager em = getEntityManagerFactory().createEntityManager();
		Destination destination = em.find(Destination.class, id);
		Set<DatesVoyage> datesVoyage = new HashSet<DatesVoyage>();
		for (DatesVoyage d : destination.getDates()){
			datesVoyage.add(d);
			}
		return datesVoyage;
	}
	
	public void deleteDatesVoyage(long id) {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		DatesVoyage datesVoyage = em.find(DatesVoyage.class, id);
		em.remove(datesVoyage);
		em.getTransaction().commit();
		em.close();
	}
}
