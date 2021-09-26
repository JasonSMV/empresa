package universidadean.empresa.modelo;


import javax.persistence.*;

@Entity
@Table(name="empresa")
public class empresa{


    @Id
    private long cedula;

    @Column(length = 50)
    private String nombres;

    private String apellidos;

    private String cargo;

    @Column(unique = true)
    private String email;

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
