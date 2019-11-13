package fr.gtm.bovoyage.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.gtm.bovoyage.dao.DestinationDAO;
import fr.gtm.bovoyage.dto.DestinationDTO;
//import fr.gtm.bovoyage.entities.DatesVoyage;
//import fr.gtm.bovoyage.entities.Destination;
import fr.gtm.bovoyage.entities.Destination;

@Path("/destination")
public class DestinationService {
	@EJB
	private DestinationDAO destinationdao;
	
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<DestinationDTO> getAllDestination() {
		List<DestinationDTO> dtos = new ArrayList<DestinationDTO>();
		List<Destination> destinations = destinationdao.getAllDestinations();
		for(Destination d : destinations) {
			dtos.add(new DestinationDTO(d));
		}
		return dtos;
	}
	
	
	@DELETE
	@Path("/del/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String delete(@PathParam("id") long id) {
		destinationdao.deleteDestination(id);
		return "destination supprimée";
	}
	
	@POST
	@Path("/add")
	@Produces(MediaType.TEXT_PLAIN)
	public String add(long id) {
		destinationdao.addDestination(id);
		return "Destination ajoutée";
	}
	
	@POST
	@Path("/edit")
	@Produces(MediaType.TEXT_PLAIN)
	public String update(Destination destination) {
		destinationdao.update(destination);
		return "Destination modifiée";
	}
	
	
	
	
//	public DestinationService(EntityManagerFactory emf) {
//		destinationdao = new DestinationDAO(emf);
//	}
//	
//	public void create(Destination destination) {
//		destinationdao.create(destination);
//	}
//	
//	public void update(Destination destination) {
//		destinationdao.update(destination);
//	}
//	
//	public void delete(String id) {
//		long identifiant = Long.parseLong(id);
//		destinationdao.delete(identifiant);
//	}
//	
//	public List<Destination> getAllDestinations() {
//		return destinationdao.getAllDestinations();
//	}
//	
//	public Destination findById(long id) {
//		return destinationdao.findById(id);
//	}
//	
//	public Set<DatesVoyage> getDatesVoyageByDestinationId(long id) {
//		return destinationdao.getDatesVoyageByDestinationId(id);
//	}
//	
//	public void deleteDatesVoyage(long id) {
//		destinationdao.deleteDatesVoyage(id);
//	}
}
