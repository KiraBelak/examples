package examples;
public class Singleton {
    // Instancia privada y estática
    private static Singleton instancia;

    // Constructor privado para evitar instanciación externa
    private Singleton() {}

        // Método público y sincronizado para obtener la instancia única
    public static synchronized Singleton getInstancia() {
        if (instancia == null) {
            instancia = new Singleton();
        }
        return instancia;
    }

    public void mostrarMensaje() {
        System.out.println("Hola, soy el Singleton");
    }
}

//factory pattern
// Definición de una interfaz común
public interface Vehiculo {
    void conducir();
}

// Implementaciones concretas
public class Coche implements Vehiculo {
    public void conducir() {
        System.out.println("Conduciendo un coche");
    }
}

public class Moto implements Vehiculo {
    public void conducir() {
        System.out.println("Conduciendo una moto");
    }
}

// Fábrica que decide qué objeto crear
public class VehiculoFactory {
    public static Vehiculo crearVehiculo(String tipo) {
        if ("coche".equalsIgnoreCase(tipo)) {
            return new Coche();
        } else if ("moto".equalsIgnoreCase(tipo)) {
            return new Moto();
        }
        throw new IllegalArgumentException("Tipo de vehículo desconocido");
    }
}



//builder pattern
public class Computadora {
    // Atributos obligatorios
    private String procesador;
    private int ram;
    // Atributos opcionales
    private int almacenamiento;
    private boolean tarjetaGrafica;

    // Constructor privado para forzar el uso del Builder
    private Computadora(Builder builder) {
        this.procesador = builder.procesador;
        this.ram = builder.ram;
        this.almacenamiento = builder.almacenamiento;
        this.tarjetaGrafica = builder.tarjetaGrafica;
    }

    // Clase interna Builder
    public static class Builder {
        // Atributos obligatorios
        private final String procesador;
        private final int ram;
        // Atributos opcionales
        private int almacenamiento = 256; // valor por defecto
        private boolean tarjetaGrafica = false;

        public Builder(String procesador, int ram) {
            this.procesador = procesador;
            this.ram = ram;
        }

        public Builder setAlmacenamiento(int almacenamiento) {
            this.almacenamiento = almacenamiento;
            return this;
        }

        public Builder setTarjetaGrafica(boolean tarjetaGrafica) {
            this.tarjetaGrafica = tarjetaGrafica;
            return this;
        }

        public Computadora build() {
            return new Computadora(this);
        }
    }

    @Override
    public String toString() {
        return "Computadora [procesador=" + procesador + ", ram=" + ram +
               ", almacenamiento=" + almacenamiento + ", tarjetaGrafica=" + tarjetaGrafica + "]";
    }
}
