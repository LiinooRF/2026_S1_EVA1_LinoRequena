package cl.duoc.linorequena.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cl.duoc.linorequena.model.Solicitud;
import cl.duoc.linorequena.repository.SolicitudRepository;

public class SolicitudService {
    @Autowired
    private SolicitudRepository solicitudRepository;

    //Registrar una nueva solicitud
    public void agregarSolicitud(Solicitud nuevaSolicitud) {
        solicitudRepository.agregarSolicitud(nuevaSolicitud);
    }

    //Consultar solicitudes ya almacenadas
    public List<Solicitud> consultarSolicitudes() {
        return solicitudRepository.consultarSolicitudes();
    }

    //Buscar solicitudes por algun criterio relevante en este caso el ID.
    public List<Solicitud> buscarSolicitudes(String idSolicitud) {
        return solicitudRepository.buscarSolicitudes(idSolicitud);
    }

    //Modificar una solicitud existente escribiendo el ID de la solicitud.
    public boolean modificarSolicitud(String idSolicitud, Solicitud solicitudModificada) {  
        return solicitudRepository.modificarSolicitud(idSolicitud, solicitudModificada);
    }

    //Eliminar una solicitud por ID
    public boolean eliminarSolicitud(String idSolicitud) {
        return solicitudRepository.eliminarSolicitud(idSolicitud);
    }
    
    //Buscar cantidad de solicitudes por fecha // OPERACIÓN ESPECIAL
    public int contarSolicitudesPorFecha(String fecha) {
        return solicitudRepository.contarSolicitudesPorFecha(fecha);
    }

}
