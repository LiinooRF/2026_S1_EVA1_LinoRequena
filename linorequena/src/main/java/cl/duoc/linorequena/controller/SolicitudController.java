package cl.duoc.linorequena.controller;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.duoc.linorequena.model.Solicitud;
import cl.duoc.linorequena.service.SolicitudService;

@Service
@RequestMapping("api/solicitud")
public class SolicitudController {
  
    private final SolicitudService solicitudService;

    public SolicitudController(SolicitudService solicitudService) {
        this.solicitudService = solicitudService;
    }

    //Consultar solicitudes ya almacenadas.
    @GetMapping
    public List<Solicitud> consultarSolicitudes() {
        return solicitudService.consultarSolicitudes();
    }

    //Buscar solicitudes por algun criterio relevante en este caso el ID.
    @GetMapping("/buscar")
    public List<Solicitud> buscarSolicitudes(String idSolicitud) {
        return solicitudService.buscarSolicitudes(idSolicitud);
    }
    
    //Buscar cantidad de solicitudes por fecha // OPERACIÓN ESPECIAL
    @GetMapping("/contarPorFecha")
    public int contarSolicitudesPorFecha(String fecha) {
        return solicitudService.contarSolicitudesPorFecha(fecha);
    }

    //Registrar una solicitud.
    @PostMapping("/registrar")
    public void agregarSolicitud(@RequestBody Solicitud nuevaSolicitud) {
        solicitudService.agregarSolicitud(nuevaSolicitud);
    }

    //modificar una solicitud con el id
    @PostMapping("/modificar")
    public boolean modificarSolicitud(String idSolicitud, @RequestBody Solicitud solicitudModificada) {
        return solicitudService.modificarSolicitud(idSolicitud, solicitudModificada);
    }

    //Eliminar una solicitud por ID
    @PostMapping("/eliminar")   
    public boolean eliminarSolicitud(String idSolicitud) {
        return solicitudService.eliminarSolicitud(idSolicitud);
    }


}
