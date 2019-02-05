package modelo.entidades;

public class Curso {
    private String idCurso;
    private String nombreCurso;

    public Curso(String idCurso, String nombreCurso) {
        this.idCurso = idCurso;
        this.nombreCurso = nombreCurso;
    }

    public String getIdCurso() {
        return idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }
}
