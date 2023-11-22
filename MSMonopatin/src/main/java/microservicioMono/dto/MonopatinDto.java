package microservicioMono.dto;

public class MonopatinDto {

	// mantenimiento,ocupado,disponible,prendido,apagado
	private String estado;

	// posicion para el GPS
	private float latitud;
	private float longitud;

	// Constructor con todos los campos
	public MonopatinDto(String estadoInicial, float y, float x) {
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
	
}
