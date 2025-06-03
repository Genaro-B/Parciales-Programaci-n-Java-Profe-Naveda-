package Principal;

import Logica.AlumnoService;
import Logica.CursoService;
import Modelo.Alumno;
import Modelo.Curso;

import java.util.List;
import java.util.Scanner;

/**
 * Clase principal que sirve como consola interactiva para gestionar
 * Alumnos y Cursos usando los servicios y la capa de persistencia.
 */
public class Principal {

    // Servicios que encapsulan la lógica de negocio
    private static AlumnoService alumnoService = new AlumnoService();
    private static CursoService cursoService = new CursoService();

    // Scanner para lectura de entrada de usuario
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            mostrarMenu();

            int opcion = leerEntero("Ingrese opción: ");

            try {
                switch (opcion) {
                    case 1 -> crearCurso();
                    case 2 -> listarCursos();
                    case 3 -> crearAlumno();
                    case 4 -> listarAlumnos();
                    case 0 -> {
                        System.out.println("Saliendo...");
                        scanner.close(); // Cerrar Scanner antes de salir
                        System.exit(0);
                    }
                    default -> System.out.println("Opción inválida, intente nuevamente.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                e.printStackTrace(); // Para facilitar debugging en consola
            }
        }
    }

    /**
     * Método para mostrar el menú de opciones al usuario
     */
    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ ---");
        System.out.println("1 - Crear curso");
        System.out.println("2 - Listar cursos");
        System.out.println("3 - Crear alumno");
        System.out.println("4 - Listar alumnos");
        System.out.println("0 - Salir");
    }

    /**
     * Método seguro para leer un entero desde consola con manejo de error
     */
    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine();

            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida, debe ingresar un número entero.");
            }
        }
    }

    /**
     * Método para crear un nuevo curso desde consola y guardarlo
     */
    private static void crearCurso() throws Exception {
        int id = leerEntero("Ingrese ID del curso: ");

        System.out.print("Ingrese nombre del curso: ");
        String nombre = scanner.nextLine().trim();

        if (nombre.isEmpty()) {
            System.out.println("El nombre no puede estar vacío.");
            return;
        }

        Curso curso = new Curso(id, nombre);

        // Crear curso usando servicio
        cursoService.crearCurso(curso);

        System.out.println("Curso creado exitosamente.");
    }

    /**
     * Lista todos los cursos en consola
     */
    private static void listarCursos() throws Exception {
        List<Curso> cursos = cursoService.listarCursos();

        if (cursos.isEmpty()) {
            System.out.println("No hay cursos registrados.");
            return;
        }

        System.out.println("\nCursos registrados:");
        for (Curso c : cursos) {
            System.out.println("ID: " + c.getId() + ", Nombre: " + c.getNombre());
        }
    }

    /**
     * Crea un nuevo alumno leyendo datos desde consola
     */
    private static void crearAlumno() throws Exception {
        int id = leerEntero("Ingrese ID del alumno: ");

        System.out.print("Ingrese nombre del alumno: ");
        String nombre = scanner.nextLine().trim();

        if (nombre.isEmpty()) {
            System.out.println("El nombre no puede estar vacío.");
            return;
        }

        int cursoId = leerEntero("Ingrese ID del curso al que pertenece el alumno: ");

        // Buscar el curso por id
        Curso curso = cursoService.buscarCursoPorId(cursoId);

        if (curso == null) {
            System.out.println("Curso no encontrado. No se puede crear alumno.");
            return;
        }

        Alumno alumno = new Alumno(id, nombre, curso);

        alumnoService.crearAlumno(alumno);

        System.out.println("Alumno creado exitosamente.");
    }

    /**
     * Lista todos los alumnos en consola
     */
    private static void listarAlumnos() throws Exception {
        List<Alumno> alumnos = alumnoService.listarAlumnos();

        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
            return;
        }

        System.out.println("\nAlumnos registrados:");
        for (Alumno a : alumnos) {
            System.out.println("ID: " + a.getId() + ", Nombre: " + a.getNombre()
                    + ", Curso: " + a.getCurso().getNombre());
        }
    }
}

