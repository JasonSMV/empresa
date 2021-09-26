package universidadean.empresa.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import universidadean.empresa.modelo.empresa;

//Repositorio para acceder a los datos de la entidad empleado desde la base de datos.

@Repository
public interface empresaRepositorio extends JpaRepository<empresa, Long> {

}
