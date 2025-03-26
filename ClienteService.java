public class ServiceLocator {
    public static <T> T getService(String jndiName) {
        // Lógica para obtener el EJB remoto o local a través de JNDI
        // ...
        return (T) new InitialContext().lookup(jndiName);
    }
}

// Uso en otra clase:
public class ClienteService {
    private static final String JNDI_NAME = "java:global/miAplicacion/UsuarioService!com.ejemplo.UsuarioService";
    
    public void procesarUsuarios() {
        UsuarioService usuarioService = ServiceLocator.getService(JNDI_NAME);
        // Usar el servicio
    }
}
