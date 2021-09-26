package universidadean.empresa.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import universidadean.empresa.modelo.empresa;
import universidadean.empresa.services.EmpresaService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/empleados")
public class empresaControlador {

    @Autowired
    private EmpresaService empresaService;

    // Crear un nuevo empleado
    @PostMapping
    public ResponseEntity<?> nuevoEmpleado (@RequestBody empresa e){
        return ResponseEntity.status(HttpStatus.CREATED).body(empresaService.save(e));

    }
    // Buscar un empleado
    @GetMapping("/{cedula}")
    public ResponseEntity<?> read(@PathVariable Long cedula){
        Optional<empresa> oEmpleado = empresaService.findById(cedula);

        if(!oEmpleado.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oEmpleado);
    }

    // Actualizar un empleado
    @PutMapping("/{cedula}")
    public ResponseEntity<?> actualizar(@RequestBody empresa eDetalles, @PathVariable Long cedula){
        Optional<empresa> empleado = empresaService.findById(cedula);

        if(!empleado.isPresent()){
            return ResponseEntity.notFound().build();
        }
        empleado.get().setNombres(eDetalles.getNombres());
        empleado.get().setApellidos(eDetalles.getApellidos());
        empleado.get().setCargo(eDetalles.getCargo());
        empleado.get().setEmail(eDetalles.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).body(empresaService.save(empleado.get()));
    }

    @DeleteMapping("/{cedula}")
    public ResponseEntity<?> borrar(@PathVariable Long cedula){

        if(!empresaService.findById(cedula).isPresent()){
            return ResponseEntity.notFound().build();
        }
        empresaService.deleteById(cedula);
        return ResponseEntity.ok().build();
    }
    //Ver todos los empleados
    public List<empresa> leerEmpleados(){
        List<empresa> empleados = StreamSupport.stream(empresaService.findAll().spliterator(),false).collect(Collectors.toList());
        return empleados;
    }




}


