package microservicioMono.dto;

public class ReporteCantMonos {
	private int cantDisponibles;
	private int cantMantenimiento;

	public ReporteCantMonos() {
	}

	public ReporteCantMonos(int cantDisponibles, int cantMantenimiento) {
		this.cantDisponibles = cantDisponibles;
		this.cantMantenimiento = cantMantenimiento;
	}

	public int getCantDisponibles() {
		return cantDisponibles;
	}

	public void setCantDisponibles(int cantDisponibles) {
		this.cantDisponibles = cantDisponibles;
	}

	public int getCantMantenimiento() {
		return cantMantenimiento;
	}

	public void setCantMantenimiento(int cantMantenimiento) {
		this.cantMantenimiento = cantMantenimiento;
	}

}
