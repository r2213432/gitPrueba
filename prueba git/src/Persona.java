

import java.time.LocalDate;

public class Persona {
	private String nombre;
    private String apellido;
    private LocalDate nacimiento;

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacimiento = null;
    }

    public Persona(String nombre, String apellido, LocalDate nacimiento) {
        this(nombre, apellido);
        this.nacimiento = nacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public LocalDate getNacimiento() {
        return nacimiento;
    }

    @Override
    public String toString() {
        return String.format("%s %s", nombre, apellido);
    }
}
