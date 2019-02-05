package modelo.entidades;

public class Materia {
    private String codigoCurso;
    private String codigoMateria;
    private String nombreMateria;

    public Materia(String codigoCurso, String codigoMateria, String nombreMateria) {
        this.codigoCurso = codigoCurso;
        this.codigoMateria = codigoMateria;
        this.nombreMateria = nombreMateria;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public String getCodigoMateria() {
        return codigoMateria;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }
}
