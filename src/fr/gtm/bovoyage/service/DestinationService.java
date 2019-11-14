package fr.gtm.bovoyage.service;

import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Path;

import fr.gtm.bovoyage.dao.DestinationDAO;
import fr.gtm.bovoyage.entities.DatesVoyage;
import fr.gtm.bovoyage.entities.Destination;


public class DestinationService {
	
	@EJB private DestinationDAO destinationdao;
	
	public DestinationService() {}
	
	public void create(Destination destination) {
		destinationdao.create(destination);
	}
	
	public void update(Destination destination) {
		destinationdao.update(destination);
	}
	
	public void delete(String id) {
		long identifiant = Long.parseLong(id);
		destinationdao.delete(identifiant);
	}
	
	public List<Destination> getAllDestinations() {
		return destinationdao.getAllDestinations();
	}
	
	public Destination findById(long id) {
		return destinationdao.findById(id);
	}
	
	public Set<DatesVoyage> getDatesVoyageByDestinationId(long id) {
		return destinationdao.getDatesVoyageByDestinationId(id);
	}
	
	public void deleteDatesVoyage(long id) {
		destinationdao.deleteDatesVoyage(id);
	}
}
