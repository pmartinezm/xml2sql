package modelo.entidades;

import java.lang.reflect.Field;
import java.util.Map;

public class Dependencia {
    private String X_DEPENDENCIA;
    private String D_DEPENDENCIA;

    public Dependencia(String x_DEPENDENCIA, String d_DEPENDENCIA) {
        X_DEPENDENCIA = x_DEPENDENCIA;
        D_DEPENDENCIA = d_DEPENDENCIA;
    }

    public Dependencia(Map<String, String> mapa) {
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

    public String getX_DEPENDENCIA() {
        return X_DEPENDENCIA;
    }

    public String getD_DEPENDENCIA() {
        return D_DEPENDENCIA;
    }
}
