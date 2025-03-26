package modules;

public class MathOperations {
    // Operaciones básicas reutilizables
    public static int sumar(int a, int b) {
        return a + b;
    }
    
    public static int multiplicar(int a, int b) {
        return a * b;
    }
    
    public static double calcularPromedio(int[] numeros) {
        if (numeros.length == 0) return 0;
        int suma = 0;
        for (int num : numeros) {
            suma = sumar(suma, num);
        }
        return (double) suma / numeros.length;
    }
} 