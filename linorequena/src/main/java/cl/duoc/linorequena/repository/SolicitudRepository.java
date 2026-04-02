package cl.duoc.linorequena.repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import cl.duoc.linorequena.model.Solicitud;

@Repository
public class SolicitudRepository {

    private List<Solicitud> solicitudes = new ArrayList<>();
    //Registrar una nueva solicitud
    public void agregarSolicitud(Solicitud nuevaSolicitud) {
        solicitudes.add(nuevaSolicitud);
    }
    //Consultar solicitudes ya almacenadas
    public List<Solicitud> consultarSolicitudes() {
        return solicitudes;
    }
    //Buscar solicitudes por algun criterio relevante en este caso el ID.
    public List<Solicitud> buscarSolicitudes(Long idSolicitud) {
        return solicitudes.stream()
            .filter(s -> s.getIdSolicitud().equals(idSolicitud))
            .toList();
    }
    //Modificar una solicitud existente escribiendo el ID de la solicitud.
    public boolean modificarSolicitud(Long idSolicitud, Solicitud solicitudModificada) {
        for (int i = 0; i < solicitudes.size(); i++) {
            if (solicitudes.get(i).getIdSolicitud().equals(idSolicitud)) {
                solicitudes.set(i, solicitudModificada);
                return true;
            }
        }
        return false;
    }
    //Eliminar una solicitud por ID
    public boolean eliminarSolicitud(Long idSolicitud) {
        return solicitudes.removeIf(s -> s.getIdSolicitud().equals(idSolicitud));
    }
    //OPERACIÓN DE PROCESAMIENTO
    // Contar solicitudes por fecha ingresando la fecha en formato "AÑO-MES-DÍA"
    public int contarSolicitudesPorFecha(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

        return (int) solicitudes.stream()
            .filter(s -> formato.format(s.getFechaRegistroSolicitud()).equals(fecha))
            .count();
    }
}