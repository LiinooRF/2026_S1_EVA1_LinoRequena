package cl.duoc.linorequena.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cl.duoc.linorequena.model.Solicitud;
import cl.duoc.linorequena.service.SolicitudService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/solicitud")
public class SolicitudController {
  
    private final SolicitudService solicitudService;

    public SolicitudController(SolicitudService solicitudService) {
        this.solicitudService = solicitudService;
    }

    // Consultar solicitudes ya almacenadas
    @GetMapping
    public List<Solicitud> consultarSolicitudes() {
        return solicitudService.consultarSolicitudes();
    }

    // Buscar solicitudes por ID
    @GetMapping("/buscar/{idSolicitud}")
    public ResponseEntity<?> buscarSolicitudes(@PathVariable Long idSolicitud) {
        List<Solicitud> solicitudes = solicitudService.buscarSolicitudes(idSolicitud);

        if (solicitudes.isEmpty()) {
            return ResponseEntity.badRequest().body("Solicitud no encontrada");
        } else {
            return ResponseEntity.ok(solicitudes);
        }
    }
    
    // Contar solicitudes por fecha ingresando la fecha en formato "AÑO-MES-DÍA"
    @GetMapping("/contarPorFecha/{fecha}")
    public ResponseEntity<Integer> contarSolicitudesPorFecha(@PathVariable String fecha) {
        int total = solicitudService.contarSolicitudesPorFecha(fecha);
        return ResponseEntity.ok(total);
    }

    // Registrar una solicitud
    @PostMapping("/registrar")
    public ResponseEntity<String> agregarSolicitud(@Valid @RequestBody Solicitud nuevaSolicitud) {
        solicitudService.agregarSolicitud(nuevaSolicitud);
        return ResponseEntity.ok("Solicitud registrada");
    }

    // Modificar una solicitud con el id
    @PutMapping("/modificar/{idSolicitud}")
    public ResponseEntity<String> modificarSolicitud( @PathVariable Long idSolicitud,
            @Valid @RequestBody Solicitud solicitudModificada) {

        boolean modificado = solicitudService.modificarSolicitud(idSolicitud, solicitudModificada);

        if (modificado) {
            return ResponseEntity.ok("Solicitud modificada");
        } else {
            return ResponseEntity.badRequest().body("Solicitud no encontrada");
        }
    }

    // Eliminar una solicitud por ID
    @DeleteMapping("/eliminar/{idSolicitud}")
    public ResponseEntity<String> eliminarSolicitud(@PathVariable Long idSolicitud) {
        boolean eliminado = solicitudService.eliminarSolicitud(idSolicitud);

        if (eliminado) {
            return ResponseEntity.ok("Solicitud eliminada");
        } else {
            return ResponseEntity.badRequest().body("Solicitud no encontrada");
        }
    }
}