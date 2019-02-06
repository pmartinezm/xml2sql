package modelo.entidades;

import java.lang.reflect.Field;
import java.util.Map;

public class Profesor {
    private String X_EMPLEADO;
    private String F_TOMAPOS;
    private String D_PUESTO;
    private String APELLIDO1;
    private String APELLIDO2;
    private String NOMBRE;

    public Profesor(String idEmpleado, String tomaPos, String nombrePuesto, String apellido1, String apellido2, String nombre) {
        this.X_EMPLEADO = idEmpleado;
        this.F_TOMAPOS = tomaPos;
        this.D_PUESTO = nombrePuesto;
        this.APELLIDO1 = apellido1;
        this.APELLIDO2 = apellido2;
        this.NOMBRE = nombre;
    }

    public Profesor(Map<String, String> mapa) {
        try {
            Field[] propiedades = this.getClass().getDeclaredFields();

            for (Field propiedad : propiedades) {
                this.getClass().getDeclaredField(propiedad.getName()).set(this, mapa.get(propiedad.getName()));
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        String ts = "";
        try {
            Field[] propiedades = this.getClass().getDeclaredFields();
            for (Field propiedad : propiedades) {
                ts += propiedad.get(this) + " ";
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return ts;
    }

    public String getIdEmpleado() {
        return X_EMPLEADO;
    }

    public String getTomaPos() {
        return F_TOMAPOS;
    }

    public String getNombrePuesto() {
        return D_PUESTO;
    }

    public String getApellido1() {
        return APELLIDO1;
    }

    public String getApellido2() {
        return APELLIDO2;
    }

    public String getNombre() {
        return NOMBRE;
    }
}
