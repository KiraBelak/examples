package modules;

public class TextTransformer {
    // Métodos reutilizables para transformación de texto
    public static String capitalizar(String texto) {
        if (texto == null || texto.isEmpty()) return texto;
        return texto.substring(0, 1).toUpperCase() + texto.substring(1).toLowerCase();
    }
    
    public static String invertir(String texto) {
        if (texto == null) return null;
        return new StringBuilder(texto).reverse().toString();
    }
    
    public static String repetir(String texto, int veces) {
        if (texto == null || veces <= 0) return "";
        return texto.repeat(veces);
    }
} 