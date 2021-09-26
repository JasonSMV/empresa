package universidadean.empresa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import universidadean.empresa.modelo.empresa;
import universidadean.empresa.repositorio.empresaRepositorio;

import java.util.Optional;

@Service
public class EmpresaServiceImpl implements EmpresaService{

    @Autowired
    private empresaRepositorio empresaRepositorio;
    @Override
    @Transactional(readOnly = true)
    public Iterable<empresa> findAll() {

        return empresaRepositorio.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<empresa> findAll(Pageable pageable) {
        return empresaRepositorio.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<empresa> findById(Long cedula) {
        return empresaRepositorio.findById(cedula);
    }

    @Override
    @Transactional
    public empresa save(empresa e) {
        return empresaRepositorio.save(e);
    }

    @Override
    @Transactional
    public void deleteById(Long cedula) {
        empresaRepositorio.deleteById(cedula);
    }
}
