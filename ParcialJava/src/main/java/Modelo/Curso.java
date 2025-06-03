package Modelo;

public class Curso {

        private int id;
        private String nombre;

        public Curso(int id, String nombre) {
            this.id = id;
            this.nombre = nombre;
        }

        // Getters y setters
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
}


