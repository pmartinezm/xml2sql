package modelo;

public enum Clases {
    Actividad("modelo.entidades.Actividad"), Curso("modelo.entidades.Curso"), Dependencia("modelo.entidades.Dependencia"), Materia("modelo.entidades.Materia"), Profesor("modelo.entidades.Profesor"), Tramo("modelo.entidades.Tramo");

    private String clase;

    Clases(String clase) {
        this.clase = clase;
    }

    public String getClase() {
        return this.clase;
    }
}
