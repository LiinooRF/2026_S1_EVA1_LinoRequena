package cl.duoc.linorequena.repository;

import java.util.ArrayList;
import java.util.List;

import cl.duoc.linorequena.model.Solicitud;

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
    public List<Solicitud> buscarSolicitudes(String idSolicitud) {
        return solicitudes.stream()
            .filter(s -> s.getIdSolicitud().equals(idSolicitud))
            .toList();
    }

    //Modificar una solicitud existente escribiendo el ID de la solicitud.
    public boolean modificarSolicitud(String idSolicitud, Solicitud solicitudModificada) {
        for (int i = 0; i < solicitudes.size(); i++) {
            if (solicitudes.get(i).getIdSolicitud().equals(idSolicitud)) {
                solicitudes.set(i, solicitudModificada);
                return true;
            }
        }
        return false;
    }

    //Eliminar una solicitud por ID
    public boolean eliminarSolicitud(String idSolicitud) {
        return solicitudes.removeIf(s -> s.getIdSolicitud().equals(idSolicitud));
    }
}


