package modele;

public class Agence {
	
	
	private int idA;
	private String nom;
	private int tel;
	private String email;
	private String adresse;
	private int cp;
	private String ville;
	private String image;
	
	public Agence(int idA, String nom, int tel, String email, String adresse, int cp, String ville, String image) {
		
		this.idA = idA;
		this.nom = nom;
		this.tel = tel;
		this.email = email;
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
		this.image = image;
	}

	public int getIdA() {
		return idA;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	
	@Override
	public String toString() {
		return "Agence [idA=" + idA + ", nom=" + nom + ", tel=" + tel + ", email=" + email + ", adresse=" + adresse
				+ ", cp=" + cp + ", ville=" + ville + ", image=" + image + "]";
	}
	
	

}
