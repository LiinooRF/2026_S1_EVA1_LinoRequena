package cl.duoc.linorequena.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Solicitud {
    @NotEmpty(message = "El idSolicitud no puede estar vacía.")
    private Long idSolicitud; 
    @NotBlank(message = "El nombre del paciente no puede estar vacío.")
    private String nombrePaciente;
    @NotNull(message = "La edad del paciente no puede ser nula.")
    private Integer edadPaciente;
    @NotBlank(message = "El género del paciente no puede estar vacío.")
    private String generoPaciente;
    @NotBlank(message = "La especialidad requerida no puede estar vacía.")
    private String especialidadRequeridaPaciente;
    @NotNull(message = "La fecha de registro no puede ser nula.")
    private Date fechaRegistroSolicitud;
    @NotBlank(message = "El estado de la solicitud no puede estar vacío.")
    private String estadoSolicitud;
    @NotNull(message = "El nivel de prioridad no puede ser nulo.")
    private Integer nivelProridadSolicitud;
}
