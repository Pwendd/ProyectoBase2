public class Materias {
    int codigo;
    String nombre;
    int creditos;
    Notas[] notas = new Notas[3];

    public Materias(int codigo,String nombre,int creditos,
    Notas[] notas){
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.notas = notas;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getCreditos() {
        return creditos;
    }

    public Notas[] getNotas() {
        return notas;
    }

    public String getNombre() {
        return nombre;
    }
}

