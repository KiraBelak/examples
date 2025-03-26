import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.function.Function;

public class FunctionalProgrammingExample {
    public static void main(String[] args) {
        // 1. Funciones Puras - siempre retornan el mismo resultado para los mismos argumentos
        System.out.println("\n1. Ejemplo de Función Pura:");
        int resultado = sumarNumeros(5, 3);
        System.out.println("Suma de 5 + 3 = " + resultado);

        // 2. Inmutabilidad - usando final para crear datos inmutables
        System.out.println("\n2. Ejemplo de Inmutabilidad:");
        final List<Integer> numerosInmutables = Arrays.asList(1, 2, 3, 4, 5);
        // Creamos una nueva lista en lugar de modificar la original
        List<Integer> numerosDuplicados = numerosInmutables.stream()
                                                          .map(n -> n * 2)
                                                          .collect(Collectors.toList());
        System.out.println("Lista original: " + numerosInmutables);
        System.out.println("Nueva lista duplicada: " + numerosDuplicados);

        // 3. Expresiones Lambda - funciones anónimas
        System.out.println("\n3. Ejemplo de Expresiones Lambda:");
        List<String> nombres = Arrays.asList("juan", "maria", "pedro");
        List<String> nombresCapitalizados = nombres.stream()
                                                  .map(nombre -> nombre.substring(0, 1).toUpperCase() + nombre.substring(1))
                                                  .collect(Collectors.toList());
        System.out.println("Nombres capitalizados: " + nombresCapitalizados);

        // 4. Funciones de Orden Superior - funciones que aceptan otras funciones como argumentos
        System.out.println("\n4. Ejemplo de Funciones de Orden Superior:");
        Function<Integer, Integer> duplicar = x -> x * 2;
        Function<Integer, Integer> sumarUno = x -> x + 1;
        
        // Componemos las funciones
        Function<Integer, Integer> duplicarYSumarUno = duplicar.andThen(sumarUno);
        System.out.println("Resultado de duplicar y sumar uno a 5: " + duplicarYSumarUno.apply(5));
    }

    // Ejemplo de función pura
    private static int sumarNumeros(int a, int b) {
        return a + b;
    }
} 