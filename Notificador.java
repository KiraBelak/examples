package examples;
import java.util.ArrayList;
import java.util.List;

// Sujeto (Observable)
public class Notificador {
    private List<Observador> observadores = new ArrayList<>();
    private String mensaje;

    public void agregarObservador(Observador observador) {
        observadores.add(observador);
    }

    public void eliminarObservador(Observador observador) {
        observadores.remove(observador);
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
        notificarObservadores();
    }

    private void notificarObservadores() {
        for (Observador obs : observadores) {
            obs.actualizar(mensaje);
        }
    }
}

// Interfaz Observador
public interface Observador {
    void actualizar(String mensaje);
}

// Implementación concreta de un observador
public class Usuario implements Observador {
    private String nombre;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void actualizar(String mensaje) {
        System.out.println(nombre + " recibió el mensaje: " + mensaje);
    }
}




//decorator 
// Componente base
public interface Notificacion {
    void enviar(String mensaje);
}

// Implementación concreta del componente
public class NotificacionBasica implements Notificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("Notificación: " + mensaje);
    }
}

// Decorador abstracto que implementa la misma interfaz
public abstract class NotificacionDecorator implements Notificacion {
    protected Notificacion notificacionDecorada;

    public NotificacionDecorator(Notificacion notificacion) {
        this.notificacionDecorada = notificacion;
    }

    public void enviar(String mensaje) {
        notificacionDecorada.enviar(mensaje);
    }
}

// Decorador concreto que añade funcionalidad adicional (por ejemplo, log)
public class NotificacionConLog extends NotificacionDecorator {
    public NotificacionConLog(Notificacion notificacion) {
        super(notificacion);
    }

    @Override
    public void enviar(String mensaje) {
        super.enviar(mensaje);
        registrarLog(mensaje);
    }

    private void registrarLog(String mensaje) {
        System.out.println("Registrando log: " + mensaje);
    }
}
