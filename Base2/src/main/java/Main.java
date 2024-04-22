
public class Main {
    public static void main(String[] args) {
        // Crear una instancia de la conexión
        Conexion conexion = Conexion.getInstance();
/*
        // Crear algunas notas
        Notas[] notasFisica = {
                new Notas(1, "Examen 1", 85),
                new Notas(2, "Examen 2", 90),
                new Notas(3, "Final", 95)
        };

        Notas[] notasAlgebra = {
                new Notas(1, "Examen 1", 78),
                new Notas(2, "Examen 2", 82),
                new Notas(3, "Final", 90)
        };

        // Crear algunas materias
        Materias fisica = new Materias(6, "Matemáticas", 4, notasFisica);
        Materias algebra = new Materias(7, "Física", 3, notasAlgebra);

        // Crear un estudiante
        Estudiante estudiante1 = new Estudiante(
                "Juan", "González", "Pérez", 662720, "Ingeniería Informática",
                "1998-05-10", 9658388, new Materias[]{fisica, algebra}
        );

        // Insertar el estudiante en la base de datos
        insertarEstudiante(estudiante1, conexion);
*/
        // Cerrar la conexión
        conexion.desconectar();
    }

    // Método para insertar un estudiante en la base de datos
    public static void insertarEstudiante(Estudiante estudiante, Conexion conexion) {
        // Consulta SQL para insertar el estudiante
        String sqlEstudiante = String.format("INSERT INTO Estudiante (nombre, apellidoMat, apellidoPat, registro, carrera, fechaNac, ci) " +
                        "VALUES ('%s', '%s', '%s', %d, '%s', '%s', %d)",
                estudiante.getNombre(), estudiante.getApellidoMat(), estudiante.getApellidoPat(),
                estudiante.getRegistro(), estudiante.getCarrera(), estudiante.getFechaNac(), estudiante.getCi());

        // Ejecutar la consulta SQL para insertar el estudiante
        conexion.ejecutarSQL(sqlEstudiante);

        // Insertar las materias del estudiante
        for (Materias materia : estudiante.getMaterias()) {
            insertarMateria(materia, conexion);
        }
    }

    // Método para insertar una materia en la base de datos
    public static void insertarMateria(Materias materia, Conexion conexion) {
        // Consulta SQL para insertar la materia
        String sqlMateria = String.format("INSERT INTO Materias (codigo, nombre, creditos) " +
                        "VALUES (%d, '%s', %d)",
                materia.getCodigo(), materia.getNombre(), materia.getCreditos());

        // Ejecutar la consulta SQL para insertar la materia
        conexion.ejecutarSQL(sqlMateria);

        // Insertar las notas de la materia
        for (Notas nota : materia.getNotas()) {
            insertarNota(nota, materia.getCodigo(), conexion);
        }
    }

    // Método para insertar una nota en la base de datos
    public static void insertarNota(Notas nota, int codigoMateria, Conexion conexion) {
        // Consulta SQL para insertar la nota
        String sqlNota = String.format("INSERT INTO Notas (id, nombre, puntaje, materia_codigo) " +
                        "VALUES (%d, '%s', %d, %d)",
                nota.getId(), nota.getNombre(), nota.getPuntaje(), codigoMateria);

        // Ejecutar la consulta SQL para insertar la nota
        conexion.ejecutarSQL(sqlNota);
    }

}
