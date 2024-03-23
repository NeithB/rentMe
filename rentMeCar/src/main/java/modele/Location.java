package modele;

import java.time.LocalDate;
import java.util.Date;

public class Location {
	private int idL;
	private Membre membre;
	private Vehicule vehicule;
	private Date dateDebut;
	private Date dateFin;
	private Float total;
	private LocalDate dateReservation;
	
	public Location(int idL, Membre membre, Vehicule vehicule, Date dateDebut, Date dateFin, Float total,
			LocalDate dateReservation) {
		
		this.idL = idL;
		this.membre = membre;
		this.vehicule = vehicule;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.total = total;
		this.dateReservation = dateReservation;
	}

	public Membre getMembre() {
		return membre;
	}

	public void setMembre(Membre membre) {
		this.membre = membre;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public LocalDate getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(LocalDate dateReservation) {
		this.dateReservation = dateReservation;
	}

	public int getIdL() {
		return idL;
	}

	@Override
	public String toString() {
		return "Location [idL=" + idL + ", membre=" + membre + ", vehicule=" + vehicule + ", dateDebut=" + dateDebut
				+ ", dateFin=" + dateFin + ", total=" + total + ", dateReservation=" + dateReservation + "]";
	}
	
	
	
	
}
