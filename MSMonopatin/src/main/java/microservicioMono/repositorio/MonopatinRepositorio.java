package microservicioMono.repositorio;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import microservicioMono.modelo.Monopatin;

public interface MonopatinRepositorio extends JpaRepository<Monopatin, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE Monopatin m SET m.idParada = :idParada WHERE m.id = :idMono")
	void cambiarParada(int idMono, int idParada);

	@Transactional
	@Modifying
	@Query("UPDATE Monopatin m SET m.estado = :estado WHERE m.id = :idMono")
	void cambiarEstado(int idMono, String estado);

	@Transactional
	@Modifying
	@Query("UPDATE Monopatin m SET m.latitud = :latitud, m.longitud = :longitud WHERE m.id = :idMono")
	void cambiarPosicion(int idMono, int latitud, int longitud);

	@Transactional
	@Modifying
	@Query("UPDATE Monopatin m SET m.usoKm = m.usoKm + :km WHERE m.id = :idMono")
	void aumentarKm(int idMono, int km);

	@Transactional
	@Modifying
	@Query("UPDATE Monopatin m SET m.ultimoMantenimiento = :fechaActual WHERE m.id = :idMono")
	void registrarMantenimiento(int idMono, LocalDate fechaActual);

}
