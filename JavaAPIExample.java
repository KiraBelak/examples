import java.util.*;
import java.util.concurrent.*;
import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.time.LocalDateTime;

public class JavaAPIExample {
    public static void main(String[] args) {
        System.out.println("=== Demostración de Java API ===\n");

        // 1. Manejo de Colecciones
        demonstrarColecciones();

        // 2. Concurrencia
        demonstrarConcurrencia();

        // 3. Manejo de Archivos (I/O)
        demonstrarIO();

        // 4. Redes
        demonstrarRedes();
    }

    // 1. Demostración de Colecciones
    private static void demonstrarColecciones() {
        System.out.println("1. COLECCIONES:");
        
        // ArrayList
        List<String> lista = new ArrayList<>();
        lista.add("Java");
        lista.add("API");
        lista.add("Ejemplo");
        System.out.println("ArrayList: " + lista);

        // HashSet (no permite duplicados)
        Set<String> conjunto = new HashSet<>(lista);
        conjunto.add("Java"); // No se añadirá por ser duplicado
        System.out.println("HashSet: " + conjunto);

        // HashMap
        Map<String, Integer> mapa = new HashMap<>();
        mapa.put("Uno", 1);
        mapa.put("Dos", 2);
        mapa.put("Tres", 3);
        System.out.println("HashMap: " + mapa);

        System.out.println();
    }

    // 2. Demostración de Concurrencia
    private static void demonstrarConcurrencia() {
        System.out.println("2. CONCURRENCIA:");
        
        // Crear un pool de hilos
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Crear dos tareas
        Callable<String> tarea1 = () -> {
            Thread.sleep(1000);
            return "Resultado de Tarea 1 - " + LocalDateTime.now();
        };

        Callable<String> tarea2 = () -> {
            Thread.sleep(1000);
            return "Resultado de Tarea 2 - " + LocalDateTime.now();
        };

        try {
            // Ejecutar tareas de forma asíncrona
            Future<String> futuro1 = executor.submit(tarea1);
            Future<String> futuro2 = executor.submit(tarea2);

            // Obtener resultados
            System.out.println(futuro1.get());
            System.out.println(futuro2.get());

        } catch (Exception e) {
            System.out.println("Error en concurrencia: " + e.getMessage());
        } finally {
            executor.shutdown();
        }

        System.out.println();
    }

    // 3. Demostración de I/O
    private static void demonstrarIO() {
        System.out.println("3. MANEJO DE ARCHIVOS (I/O):");
        
        // Escribir en un archivo
        try {
            // Usando Files (Java NIO)
            Path archivo = Paths.get("ejemplo.txt");
            Files.write(archivo, "¡Hola desde Java API!".getBytes());
            System.out.println("Archivo creado: " + archivo.toAbsolutePath());

            // Leer el archivo
            String contenido = new String(Files.readAllBytes(archivo));
            System.out.println("Contenido del archivo: " + contenido);

            // Listar archivos del directorio actual
            System.out.println("\nArchivos en el directorio actual:");
            Files.list(Paths.get("."))
                 .limit(5)
                 .forEach(path -> System.out.println("  - " + path.getFileName()));

        } catch (IOException e) {
            System.out.println("Error de I/O: " + e.getMessage());
        }

        System.out.println();
    }

    // 4. Demostración de Redes
    private static void demonstrarRedes() {
        System.out.println("4. REDES:");
        
        try {
            // Obtener información del host local
            InetAddress localhost = InetAddress.getLocalHost();
            System.out.println("Nombre del host local: " + localhost.getHostName());
            System.out.println("IP del host local: " + localhost.getHostAddress());

            // Crear un servidor simple (solo demostración)
            try (ServerSocket serverSocket = new ServerSocket(0)) { // Puerto aleatorio
                System.out.println("Servidor creado en puerto: " + serverSocket.getLocalPort());
            }

        } catch (IOException e) {
            System.out.println("Error de red: " + e.getMessage());
        }

        System.out.println();
    }
} 