import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.time.Duration;
import java.time.Instant;

public class StreamExample {
    public static void main(String[] args) {
        // Crear una gran colección de datos para demostrar el procesamiento
        List<Integer> numeros = new ArrayList<>();
        for (int i = 1; i <= 10_000_000; i++) {
            numeros.add(i);
        }

        System.out.println("=== Demostración de Streams y Streams Paralelos ===\n");

        // 1. Stream secuencial - Filtrar números pares y calcular su cuadrado
        Instant inicio = Instant.now();
        List<Integer> resultadoSecuencial = numeros.stream()
            .filter(n -> n % 2 == 0)      // Filtrar pares
            .map(n -> n * n)              // Calcular cuadrado
            .limit(10)                     // Limitar a 10 resultados
            .collect(Collectors.toList());
        
        Duration tiempoSecuencial = Duration.between(inicio, Instant.now());
        
        // 2. Stream paralelo - Misma operación pero en paralelo
        inicio = Instant.now();
        List<Integer> resultadoParalelo = numeros.parallelStream()
            .filter(n -> n % 2 == 0)      // Filtrar pares
            .map(n -> n * n)              // Calcular cuadrado
            .limit(10)                     // Limitar a 10 resultados
            .collect(Collectors.toList());
        
        Duration tiempoParalelo = Duration.between(inicio, Instant.now());

        // Mostrar resultados
        System.out.println("Procesamiento Secuencial:");
        System.out.println("Resultados: " + resultadoSecuencial);
        System.out.println("Tiempo: " + tiempoSecuencial.toMillis() + " ms\n");

        System.out.println("Procesamiento Paralelo:");
        System.out.println("Resultados: " + resultadoParalelo);
        System.out.println("Tiempo: " + tiempoParalelo.toMillis() + " ms\n");

        // 3. Ejemplo de operaciones más complejas con streams
        System.out.println("=== Operaciones Avanzadas con Streams ===");
        
        // Crear una lista de palabras
        List<String> palabras = Arrays.asList(
            "Java", "Stream", "Paralelo", "Procesamiento", 
            "Datos", "Eficiente", "Programación", "Funcional"
        );

        // Procesar palabras en paralelo
        System.out.println("\nProcesamiento de texto en paralelo:");
        palabras.parallelStream()
            .map(String::toUpperCase)                  // Convertir a mayúsculas
            .filter(p -> p.length() > 5)              // Filtrar palabras largas
            .sorted()                                  // Ordenar alfabéticamente
            .forEach(p -> System.out.println("  - " + p));

        // 4. Demostración de reducción paralela
        System.out.println("\nReducción paralela - Suma de números del 1 al 1000:");
        long suma = numeros.parallelStream()
            .limit(1000)
            .reduce(0, Integer::sum);
        System.out.println("Suma total: " + suma);
    }
} 