package microservicioMono.controlador;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import microservicioMono.dto.ReporteCantMonos;
import microservicioMono.modelo.Monopatin;
import microservicioMono.repositorio.MonopatinRepositorio;
import microservicioMono.servicio.MonopatinServicio;

@RestController
@RequestMapping("/MSMonopatin")
public class MonopatinControlador {

	@Autowired
	private MonopatinRepositorio MonopatinRepositorio;
	@Autowired
	private MonopatinServicio monopatinServicio;

	// crear monopatin
	@PostMapping
	public void crearMonopatin(@RequestBody Monopatin e) {
		MonopatinRepositorio.save(e);
	}

	// eliminar monopatin
	@DeleteMapping("/borrar/{idMono}")
	public void eliminarMonopatin(@PathVariable int idMono) {
		MonopatinRepositorio.deleteById(idMono);
	}

	// cambia la parada del monopatin
	@PutMapping("/parada/{idMono}/{idParada}")
	public void cambiarParada(@PathVariable int idMono, @PathVariable int idParada) {
		MonopatinRepositorio.cambiarParada(idMono, idParada);
	}

	// cambia el estado del monopatin
	@PutMapping("/estado/{idMono}/{estado}")
	public void cambiarEstado(@PathVariable int idMono, @PathVariable String estado) {
		MonopatinRepositorio.cambiarEstado(idMono, estado);
	}

	// cambia la posicion del monopatin
	@PutMapping("/gps/{idMono}/{latitud}/{longitud}")
	public void cambiarPosicion(@PathVariable int idMono, @PathVariable int latitud, @PathVariable int longitud) {
		MonopatinRepositorio.cambiarPosicion(idMono, latitud, longitud);
	}

	// punto e1 consultar los monopatines que se encuentran disponibles
	@GetMapping("/cantDisponibles")
	public ReporteCantMonos cantMonoDisponibles() {
		ReporteCantMonos reporte=monopatinServicio.reporteMonopatinesDisponibles();
		return reporte;
	}

	// indica cual fue el ultimo mantenimiento del monopatin
	@PutMapping("/mantenimiento/{idMono}")
	public void registrarMantenimiento(@PathVariable int idMono) {
		LocalDate fechaActual = LocalDate.now();
		MonopatinRepositorio.registrarMantenimiento(idMono, fechaActual);
	}

	// buscar monopatines cercanos
	@GetMapping("/buscarMonopatines/{latitud}/{longitud}/{margen}")
	public List<Monopatin> buscarMonopatines(@PathVariable float latitud, @PathVariable float longitud,
			@PathVariable float margen) {
		return monopatinServicio.traerMonopatinCercanos(latitud, longitud, margen);
	}
}