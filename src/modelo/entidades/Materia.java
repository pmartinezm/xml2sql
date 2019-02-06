package modelo.entidades;

import java.lang.reflect.Field;
import java.util.Map;

public class Materia {
    private String X_OFERTAMATRIG;
    private String X_MATERIAOMG;
    private String D_MATERIAC;

    public Materia(String X_OFERTAMATRIG, String X_MATERIAOMG, String D_MATERIAC) {
        this.X_OFERTAMATRIG = X_OFERTAMATRIG;
        this.X_MATERIAOMG = X_MATERIAOMG;
        this.D_MATERIAC = D_MATERIAC;
    }

    public Materia(Map<String, String> mapa) {
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

    public String getCodigoCurso() {
        return X_OFERTAMATRIG;
    }

    public String getCodigoMateria() {
        return X_MATERIAOMG;
    }

    public String getNombreMateria() {
        return D_MATERIAC;
    }
}
