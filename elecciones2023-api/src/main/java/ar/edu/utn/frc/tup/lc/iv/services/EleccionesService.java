package ar.edu.utn.frc.tup.lc.iv.services;

import ar.edu.utn.frc.tup.lc.iv.dtos.common.*;
import ar.edu.utn.frc.tup.lc.iv.models.Cargo;
import ar.edu.utn.frc.tup.lc.iv.models.Distrito;
import ar.edu.utn.frc.tup.lc.iv.models.Resultado;
import ar.edu.utn.frc.tup.lc.iv.models.Seccion;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EleccionesService {
    Distrito[] obtenerDistritos();
    Distrito[] obtenerDistritosPorNombre(String nombre);
    CargosResponseDTO obtenerCargosPorDistrito(int distrito_id);
    List<SeccionDTO> obtenerSeccionesPorDistrito(Long distrito_id);
    SeccionDTO obtenerSeccionDtoPorDistritoYSeccion(Long distrito_id, Long seccion_id);
    ResultadoResponseDTO obtenerResultado(Long seccionId);

}
