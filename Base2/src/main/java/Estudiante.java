public class Estudiante {
    String nombre;
    String apellidoMat;
    String apellidoPat;
    int registro;
    String carrera;
    String fechaNac;
    int ci;
    Materias []materias= new Materias[7];
    public Estudiante(String nombre,String apellidoMat,String apellidoPat,int registro,String carrera,
                      String fechaNac,int ci,Materias []materias){
        this.nombre = nombre;
        this.apellidoMat = apellidoMat;
        this.apellidoPat = apellidoPat;
        this.ci = ci;
        this.registro = registro;
        this.fechaNac = fechaNac;
        this.carrera = carrera;
        this.materias = materias;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoMat() {
        return apellidoMat;
    }

    public String getApellidoPat() {
        return apellidoPat;
    }
    public String getApellidos() {
        return apellidoPat+" "+apellidoMat;
    }

    public int getCi() {
        return ci;
    }

    public int getRegistro() {
        return registro;
    }

    public Materias[] getMaterias() {
        return materias;
    }

    public String getCarrera() {
        return carrera;
    }

    public String getFechaNac() {
        return fechaNac;
    }
}
