package modele;

public class Vehicule {
	private int idV;
	private String marque;
	private String modele;
	private double prixJ;
	private String description;
	private String image;
	private Agence agence;
	
	public Vehicule(int idV, String marque, String modele, double prixJ, String description, String image,
			Agence agence) {
		
		this.idV = idV;
		this.marque = marque;
		this.modele = modele;
		this.prixJ = prixJ;
		this.description = description;
		this.image = image;
		this.agence = agence;
	}
	
	
	public int getIdV() {
		return idV;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public double getPrixJ() {
		return prixJ;
	}

	public void setPrixJ(double prixJ) {
		this.prixJ = prixJ;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}
	
	@Override
	public String toString() {
		return "Vehicule [idV=" + idV + ", marque=" + marque + ", modele=" + modele + ", prixJ=" + prixJ
				+ ", description=" + description + ", image=" + image + ", agence=" + agence + "]";
	}


	
	
}
