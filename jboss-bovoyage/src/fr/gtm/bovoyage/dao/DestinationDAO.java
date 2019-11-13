package fr.gtm.bovoyage.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import fr.gtm.bovoyage.entities.DatesVoyage;
import fr.gtm.bovoyage.entities.Destination;

@Singleton
public class DestinationDAO {
	@PersistenceContext(name="destination") private EntityManager em;
	
	public DestinationDAO() {
		
	}
	
	public List<Destination> getAllDestinations() {	
		List<Destination> destinations = em.createNamedQuery("Destination.getAllDestinations", Destination.class).getResultList();		
		return destinations;
	}
	
	public Set<DatesVoyage> getDatesVoyageByDestinationId(long id){
		Destination destination = em.find(Destination.class, id);
		Set<DatesVoyage> datesVoyage = new HashSet<DatesVoyage>();
		for (DatesVoyage d : destination.getDatesVoyage()){
			datesVoyage.add(d);
			}
		return datesVoyage;
	}
	
	public void deleteDatesVoyage(long id) {
		DatesVoyage datesVoyage = em.find(DatesVoyage.class, id);
		em.remove(datesVoyage);
	
	}

	public void deleteDestination(long id) {
		Destination destination = em.find(Destination.class, id);
		em.remove(destination);
	}
	
	public List<Destination> addDestination(long id) {
		List<Destination> destinations = new ArrayList<Destination>();
		em.persist(destinations);
		for(Destination destination : addDestination(id)) {
			destinations.add(destination);
		}
		return destinations;
	}	
	
	public void update(Destination destination) {
		em.merge(destination);
	}

	
}
