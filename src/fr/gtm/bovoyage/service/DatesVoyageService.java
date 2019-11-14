package fr.gtm.bovoyage.service;

import javax.persistence.EntityManagerFactory;

import fr.gtm.bovoyage.dao.DatesVoyageDAO;

public class DatesVoyageService {
	
	private DatesVoyageDAO datesvoyagedao;
	
	public DatesVoyageService(EntityManagerFactory emf) {
		datesvoyagedao = new DatesVoyageDAO(emf);
	}
	
	public void delete(String id) {
		long identifiant = Long.parseLong(id);
		datesvoyagedao.delete(identifiant);
	}
}
