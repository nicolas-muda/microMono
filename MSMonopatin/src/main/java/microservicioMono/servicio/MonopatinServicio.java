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

	public List<MonopatinDto> traerMonopatinCercanos(float latitud, float longitud, float margen) {
		List<Monopatin> monopatinesCercanos = monopatinRepositorio.reporteMonopatinCercano(latitud, longitud, margen);
		List<MonopatinDto> resultado = new ArrayList<MonopatinDto>();
		for (int i = 0; i < monopatinesCercanos.size(); i++) {
			String estado = monopatinesCercanos.get(i).getEstado();
			float mLatitud = monopatinesCercanos.get(i).getLatitud();
			float mLongitud = monopatinesCercanos.get(i).getLongitud();
			MonopatinDto nuevoDto = new MonopatinDto(estado, mLatitud, mLongitud);
			resultado.add(nuevoDto);
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
