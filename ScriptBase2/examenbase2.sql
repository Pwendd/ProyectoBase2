-- Crear tabla Estudiante
CREATE TABLE Estudiante (
    id_estudiante INT PRIMARY KEY,
    nombre VARCHAR(100),
    apellido VARCHAR(100),
    fecha_nac DATE,
    carrera VARCHAR(100)
);

-- Crear tabla Materia
CREATE TABLE Materia (
    cod_materia INT PRIMARY KEY,
    nombre_materia VARCHAR(100),
    creditos INT
);

-- Crear tabla Estudiante_Materia
CREATE TABLE Estudiante_Materia (
    id_me INT PRIMARY KEY,
    cod_materia INT,
    codigo_estudiante INT,
    FOREIGN KEY (codigo_estudiante) REFERENCES Estudiante(id_estudiante),
    FOREIGN KEY (cod_materia) REFERENCES Materia(cod_materia)
);

-- Crear tabla Notas
CREATE TABLE Notas (
    id_nota INT PRIMARY KEY,
    primer_parcial INT,
    segundo_parcial INT,
    evaluacion_final INT,
    cod_materia INT,
    cod_estudiante INT,
    FOREIGN KEY (cod_materia) REFERENCES Materia(cod_materia),
    FOREIGN KEY (cod_estudiante) REFERENCES Estudiante(id_estudiante)
);

drop table notas ;
-- Inserts para la tabla Estudiante
INSERT INTO Estudiante (id_estudiante, nombre, apellido, fecha_nac, carrera)
VALUES
    (1, 'Leo', 'Loayza', '2000-02-27', 'Sistemas'),
    (2, 'Richard', 'Parra', '2001-05-02', 'Sistemas'),
    (3, 'Angelo', 'Rodriguez', '2004-06-12', 'Sistemas'),
    (4, 'Laura', 'González', '2000-08-12', 'Biología'),
    (5, 'Pedro', 'Rodríguez', '1996-12-03', 'Arquitectura'),
    (6, 'Ana', 'Sánchez', '2001-06-28', 'Psicología');

   -- Inserts para la tabla Estudiante_Materia
INSERT INTO Estudiante_Materia (id_me, cod_materia, codigo_estudiante)
VALUES
    (1, 1,1), -- Leo - Base2
    (2, 1,2), -- Richard - Base2
    (3, 2,2), -- Richard - S.O
    (4, 3,3), -- Angelo - Pro4
    (5, 3,1); -- Leo - Pro4

-- Inserts para la tabla Materia
INSERT INTO Materia (cod_materia, nombre_materia, creditos)
VALUES
    (1,'Base2', 4),
    (2,'S.O', 5),
    (3,'Pro4', 4);

    
-- Inserts para la tabla Notas
INSERT INTO Notas (id_nota, primer_parcial, segundo_parcial, evaluacion_final, cod_materia, cod_estudiante)
VALUES
    (1,75, 45, 24, 1, 1), -- Leo - Base2
    (2,59, 37, 75, 1, 2), -- Richard - Base2
    (3,35, 95, 65, 2, 2), -- Richard - S.O
    (4,25, 85, 34, 3, 3), -- Angelo - Pro4
    (5,12, 78, 36, 3, 1); -- Angelo - Pro4

    drop table notas;
   
SELECT e.nombre AS nombre_estudiante, m.nombre_materia, n.primer_parcial, n.segundo_parcial, n.evaluacion_final
FROM Estudiante e
JOIN Estudiante_Materia em ON e.id_estudiante = em.codigo_estudiante
JOIN Materia m ON em.cod_materia = m.cod_materia
JOIN Notas n ON e.id_estudiante = n.cod_estudiante AND m.cod_materia = n.cod_materia
ORDER BY e.nombre, m.nombre_materia;

select* from materias
select* from estudiante

drop table estudiante_materia  ;






