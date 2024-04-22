CREATE TABLE Estudiante (
    registro SERIAL PRIMARY KEY,
    nombre VARCHAR(100),
    apellidoMat VARCHAR(100),
    apellidoPat VARCHAR(100),
    ci INT,
    carrera VARCHAR(100),
    fechaNac DATE
);

CREATE TABLE Materias (
    codigo SERIAL PRIMARY KEY,
    nombre VARCHAR(100),
    creditos INT
);

CREATE TABLE Estudiantes_Materias (
    id SERIAL PRIMARY KEY,
    registro_estudiante INT REFERENCES Estudiante(registro),
    codigo_materia INT REFERENCES Materias(codigo),
    CONSTRAINT fk_estudiante FOREIGN KEY (registro_estudiante) REFERENCES Estudiante(registro),
    CONSTRAINT fk_materia FOREIGN KEY (codigo_materia) REFERENCES Materias(codigo)
);

CREATE TABLE Notas (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100),
    puntaje INT,
    materia_codigo INT REFERENCES Materias(codigo)
);

INSERT INTO Notas (nombre, puntaje, materia_codigo)
VALUES 
    ('Examen Parcial 1', 85, 1),
    ('Examen Parcial 2', 78, 1),
    ('Final', 95, 1);
    
select* from materias
select* from estudiante 
ALTER USER postgres WITH PASSWORD '123456';

INSERT INTO Materias (nombre, creditos)
VALUES 
    ('Matemáticas', 4),
    ('Física', 3),
    ('Programación', 5),
    ('Historia', 3),
    ('Química', 4);
DELETE FROM Estudiante WHERE registro = 1234567;

   INSERT INTO Estudiante (nombre, apellidoMat, apellidoPat, ci, carrera, fechaNac)
VALUES 
    ('Juan', 'González', 'Pérez', 3234567, 'Ingeniería Informática', '1998-05-10'),
    ('María', 'López', 'Martínez', 9876543, 'Medicina', '1997-09-22'),
    ('Carlos', 'Sánchez', 'Fernández', 5555555, 'Derecho', '1999-12-01'),
    ('Laura', 'Ramírez', 'Gómez', 4444444, 'Arquitectura', '2000-03-15'),
    ('Pedro', 'Martín', 'Rodríguez', 7777777, 'Economía', '1996-07-28');

   
   
   
   