package com.rawen.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "plats")  // Utilisez l'annotation Table pour spécifier le nom de la table

public class Plat implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//pour autoincrement
	private int ID_PLAT;
	
	private String NOM_PLAT;
	private Double prix;
	public int getID_PLAT() {
		return ID_PLAT;
	}
	public void setID_PLAT(int iD_PLAT) {
		ID_PLAT = iD_PLAT;
	}
	public String getNOM_PLAT() {
		return NOM_PLAT;
	}
	public void setNOM_PLAT(String nOM_PLAT) {
		NOM_PLAT = nOM_PLAT;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	@Override
	public String toString() {
		return "Plat [ID_PLAT=" + ID_PLAT + ", NOM_PLAT=" + NOM_PLAT + ", prix=" + prix + "]";
	}
	

}