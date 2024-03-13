package com.rawen.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.rawen.entities.Plat;
import com.rawen.util.JPAutil;

//classe contenant les méthodes génériques ajouter, supprimer,
//consulter par clé primaire (Id)
public class ClientDao {
	private EntityManager entityManager = JPAutil.getEntityManager("MonProjetJPA");

	//méthode ajouter d'une entité à la bd
	public void ajouter(Plat c)
	{
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(c);


		tx.commit();
	}

	//méthode modifier d'une entité à partir de la bd
	public void modifier(Plat c) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(c);
		tx.commit();
	}

	//méthode Supprimer d'une entité à partir de la bd
	public void supprimer(Plat c) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		c = entityManager.merge(c); // important
		entityManager.remove(c);
		tx.commit();
	}

	//méthode Consulter d'une entité à partir de la bd
	public Plat consulter(Plat c, Object id) {
		return entityManager.find(c.getClass(), id);
	}

	//méthode pour lister tous les objets à partir de la bd
	//méthode pour lister tous les objets à partir de la bd
	public List<Plat> listerTous() {
	    List<Plat> plats = entityManager.createQuery("SELECT p FROM Plat p").getResultList();
	    return plats;
	}

	//méthode pour lister tous les client dont le nom contient un
	//texte donné en paramètre (pnom)
	public List<Plat> listerParNom(String nom) {
	    List<Plat> plats = entityManager.createQuery("SELECT p FROM Plat p WHERE p.NOM_PLAT LIKE :pnom").setParameter("pnom", "%" + nom + "%").getResultList();
	    return plats;
	}


}