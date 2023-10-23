package microservicioMono.controlador;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import microservicioMono.modelo.Monopatin;
import microservicioMono.repositorio.MonopatinRepositorio;

@RestController
@RequestMapping("/MSMonopatin")
public class MonopatinControlador {

	@Autowired
	private MonopatinRepositorio MonopatinRepositorio;

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

	// aumenta los kilomentros del monopatin
	@PutMapping("/km/{idMono}/{km}")
	public void aumentarKm(@PathVariable int idMono, @PathVariable int km) {
		MonopatinRepositorio.aumentarKm(idMono, km);
	}

	// indica cual fue el ultimo mantenimiento del monopatin
	@PutMapping("/mantenimiento/{idMono}")
	public void registrarMantenimiento(@PathVariable int idMono) {
		LocalDate fechaActual = LocalDate.now();
		MonopatinRepositorio.registrarMantenimiento(idMono, fechaActual);
	}
}