package com.rawen.test;

import com.rawen.dao.ClientDao;
import com.rawen.entities.Plat;

public class ClientTest {
	public static void main(String[] args) {
//créer un objet client
		Plat c = new Plat();
		c.setPrix(57000.0);
		c.setNOM_PLAT("couscous");
		Plat p2 = new Plat();
		p2.setPrix(95000.0);
		p2.setNOM_PLAT("PLAT TUNISIEN");
//ajouter l'objet client à la BD
		ClientDao cltDao = new ClientDao();
		cltDao.ajouter(c);
		//cltDao.ajouter(p2);

		System.out.println("Appel de la méthode listerTous");
		for (Plat pl : cltDao.listerTous())
			System.out.println(pl.getID_PLAT() + " " + pl.getNOM_PLAT());
		System.out.println("Appel de la méthode listerParNom");
		for (Plat pl : cltDao.listerParNom("cous"))

			System.out.println(pl);

//tester les autres méthodes de la classe ClientDao
	}
}