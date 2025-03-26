import modules.MathOperations;
import modules.TextTransformer;

public class ModularExample {
    public static void main(String[] args) {
        // Uso del módulo de matemáticas
        System.out.println("=== Demostración del Módulo de Matemáticas ===");
        int resultadoSuma = MathOperations.sumar(10, 5);
        System.out.println("Suma: " + resultadoSuma);
        
        int resultadoMultiplicacion = MathOperations.multiplicar(4, 3);
        System.out.println("Multiplicación: " + resultadoMultiplicacion);
        
        int[] numeros = {1, 2, 3, 4, 5};
        double promedio = MathOperations.calcularPromedio(numeros);
        System.out.println("Promedio: " + promedio);

        // Uso del módulo de texto
        System.out.println("\n=== Demostración del Módulo de Texto ===");
        String nombre = "juan carlos";
        System.out.println("Texto original: " + nombre);
        System.out.println("Texto capitalizado: " + TextTransformer.capitalizar(nombre));
        System.out.println("Texto invertido: " + TextTransformer.invertir(nombre));
        
        // Creamos una cadena con el texto repetido 3 veces usando StringBuilder
        StringBuilder textoRepetido = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            textoRepetido.append(nombre);
            if (i < 2) textoRepetido.append(" ");
        }
        System.out.println("Texto repetido: " + textoRepetido.toString());
    }
} 