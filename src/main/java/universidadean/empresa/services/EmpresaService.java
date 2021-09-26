package universidadean.empresa.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import universidadean.empresa.modelo.empresa;

import java.util.Optional;

public interface EmpresaService {

    public Iterable<empresa> findAll();

    public Page<empresa> findAll(Pageable pageable);

    public Optional<empresa> findById(Long cedula);

    public empresa save(empresa e);

    public void deleteById(Long cedula);
}
