package modelo.entidades;

import java.lang.reflect.Field;
import java.util.Map;

public class Curso {
    private String X_OFERTAMATRIG;
    private String D_OFERTAMATRIG;

    public Curso(String X_OFERTAMATRIG, String D_OFERTAMATRIG) {
        this.X_OFERTAMATRIG = X_OFERTAMATRIG;
        this.D_OFERTAMATRIG = D_OFERTAMATRIG;
    }

    public Curso(Map<String, String> mapa) {
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

    public String getIdCurso() {
        return X_OFERTAMATRIG;
    }

    public String getNombreCurso() {
        return D_OFERTAMATRIG;
    }
}
