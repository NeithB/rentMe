package modele;

public class VehiculeDisponible {
	private Vehicule vehicule;

	public VehiculeDisponible(Vehicule vehicule) {
		super();
		this.vehicule = vehicule;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	@Override
	public String toString() {
		return "VehiculeDisponible [vehicule=" + vehicule + "]";
	}
	

}
