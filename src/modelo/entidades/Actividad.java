package modelo.entidades;

import java.lang.reflect.Field;
import java.util.Map;

public class Actividad {
    private String L_REGULAR;
    private String X_ACTIVIDAD;
    private String D_ACTIVIDAD;
    private String L_REQUNIDAD;
    private String L_REQMATERIA;

    public Actividad(String l_REGULAR, String x_ACTIVIDAD, String d_ACTIVIDAD, String l_REQUNIDAD, String l_REQMATERIA) {
        L_REGULAR = l_REGULAR;
        X_ACTIVIDAD = x_ACTIVIDAD;
        D_ACTIVIDAD = d_ACTIVIDAD;
        L_REQUNIDAD = l_REQUNIDAD;
        L_REQMATERIA = l_REQMATERIA;
    }

    public Actividad(Map<String, String> mapa) {
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

    public String getL_REGULAR() {
        return L_REGULAR;
    }

    public String getX_ACTIVIDAD() {
        return X_ACTIVIDAD;
    }

    public String getD_ACTIVIDAD() {
        return D_ACTIVIDAD;
    }

    public String getL_REQUNIDAD() {
        return L_REQUNIDAD;
    }

    public String getL_REQMATERIA() {
        return L_REQMATERIA;
    }
}
