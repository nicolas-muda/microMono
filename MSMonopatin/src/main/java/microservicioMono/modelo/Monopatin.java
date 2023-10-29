package microservicioMono.modelo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Value;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Monopatin {

	// id monopatin
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// id parada
	@Column
	private int idParada;

	// mantenimiento,ocupado,disponible,prendido,apagado
	@Column
	private String estado;

	// posicion para el GPS
	@Column
	private float latitud;
	@Column
	private float longitud;

	@Column
	private LocalDate ultimoMantenimiento;

	// Constructor vacío
	public Monopatin() {
	}

	// Constructor con todos los campos
	public Monopatin(String estadoInicial, float y, float x) {
		this.estado = estadoInicial;
		this.latitud = y;
		this.longitud = x;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public float getLatitud() {
		return latitud;
	}

	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}

	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

	public int getIdParada() {
		return idParada;
	}

	public void setIdParada(int idParada) {
		this.idParada = idParada;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Monopatin [id=" + id + ", idParada=" + idParada + ", estado=" + estado + ", latitud=" + latitud
				+ ", longitud=" + longitud + ", ultimoMantenimiento=" + ultimoMantenimiento + "]";
	}

}