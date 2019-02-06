package modelo;

public enum ExpresionesRegulares {
    Curso("^CURSO_\\d+$"), Materia("^MATERIA_\\d+$"), Profesor("^PROFESOR_\\d+$");

    private String expresion;

    ExpresionesRegulares(String expresion) {
        this.expresion = expresion;
    }

    public String getExpresion() {
        return this.expresion;
    }
}
