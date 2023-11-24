package microservicioMono.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import microservicioMono.dto.MonopatinDto;
import microservicioMono.dto.ReporteCantMonos;
import microservicioMono.modelo.Monopatin;
import microservicioMono.repositorio.MonopatinRepositorio;

@Service
public class MonopatinServicio {
	@Autowired
	private MonopatinRepositorio monopatinRepositorio;

	public List<Monopatin> traerMonopatinCercanos(float latitud, float longitud, float margen) {
		List<Monopatin> monopatines = monopatinRepositorio.findAll();
		List<Monopatin> resultado = new ArrayList<Monopatin>();
		for (int i = 0; i < monopatines.size(); i++) {
			float diferenciaLat = monopatines.get(i).getLatitud() - latitud;
			float diferenciaLon = monopatines.get(i).getLongitud() - longitud;
			if (monopatines.get(i).getEstado() == "disponible"){
				if (diferenciaLat < 0) {
					diferenciaLat *= -1;
				}
				if (diferenciaLon < 0) {
					diferenciaLon *= -1;
				}
				if (diferenciaLat <= margen) && (diferenciaLon <= margen) {
					resultado.add(monopatines.get(i));
				}
			}
		}
		return resultado;
	}

	public ReporteCantMonos reporteMonopatinesDisponibles() {
		int disponibles = monopatinRepositorio.cantDisponibles();
		int mantenimiento = monopatinRepositorio.cantMantenimiento();
		ReporteCantMonos reporte = new ReporteCantMonos(disponibles, mantenimiento);
		return reporte;
	}

	public void crearMonopatin(MonopatinDto e) {
		String estado = e.getEstado();
		float latitud = e.getLatitud();
		float longitud = e.getLongitud();
		Monopatin m = new Monopatin(estado, latitud, longitud);
		monopatinRepositorio.save(m);

	}

}
