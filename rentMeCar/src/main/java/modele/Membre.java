package modele;

import java.util.Date;

public class Membre {
	private int idM;
	private String prenom;
	private String nom;
	private String login;
	private String mdp;
	private int    tel;
	private String email;
	private String adresse;
	private int    cp;
	private String ville;
	private String statut;
	private Date   date_inscr;
	
	public Membre(int idM, String prenom, String nom, String login, String mdp, int tel, String email, String adresse,
			int cp, String ville, String statut, Date date_inscr) {
		
		this.idM = idM;
		this.prenom = prenom;
		this.nom = nom;
		this.login = login;
		this.mdp = mdp;
		this.tel = tel;
		this.email = email;
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
		this.statut = statut;
		this.date_inscr = date_inscr;
	}

	public int getIdM() {
		return idM;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public String getStatut() {
		return statut;
	}
	
	public void setStatut(String statut) {
		this.statut = statut;
	}
	
	public Date getDate_inscr() {
		return date_inscr;
	}
	
	public void setDate_inscr(Date date_inscr) {
		this.date_inscr = date_inscr;
	}
	
	@Override
	public String toString() {
		return "Membre [idM=" + idM + ", prenom=" + prenom + ", nom=" + nom + ", login=" + login + ", mdp=" + mdp
				+ ", tel=" + tel + ", email=" + email + ", adresse=" + adresse + ", cp=" + cp + ", ville=" + ville
				+ ", statut=" + statut + ", date_inscr=" + date_inscr + "]";
	}

	
}
