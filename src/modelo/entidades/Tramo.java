package modelo.entidades;

import java.lang.reflect.Field;
import java.util.Map;

public class Tramo {
    private String X_TRAMO;
    private String T_HORCEN;
    private String N_INICIO;
    private String N_FIN;
    private String X_PLAJORESCCEN;

    public Tramo(String x_TRAMO, String t_HORCEN, String n_INICIO, String n_FIN, String x_PLAJORESCCEN) {
        X_TRAMO = x_TRAMO;
        T_HORCEN = t_HORCEN;
        N_INICIO = n_INICIO;
        N_FIN = n_FIN;
        X_PLAJORESCCEN = x_PLAJORESCCEN;
    }

    public Tramo(Map<String, String> mapa) {
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

    public String getX_TRAMO() {
        return X_TRAMO;
    }

    public String getT_HORCEN() {
        return T_HORCEN;
    }

    public String getN_INICIO() {
        return N_INICIO;
    }

    public String getN_FIN() {
        return N_FIN;
    }

    public String getX_PLAJORESCCEN() {
        return X_PLAJORESCCEN;
    }
}
