package ar.edu.utn.frc.tup.lc.iv.controllers;

import ar.edu.utn.frc.tup.lc.iv.dtos.common.*;
import ar.edu.utn.frc.tup.lc.iv.models.Cargo;
import ar.edu.utn.frc.tup.lc.iv.models.Distrito;
import ar.edu.utn.frc.tup.lc.iv.models.Resultado;
import ar.edu.utn.frc.tup.lc.iv.models.Seccion;
import ar.edu.utn.frc.tup.lc.iv.services.EleccionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/elecciones")
public class EleccionesController {
    @Autowired
    private EleccionesService eleccionesService;

    @GetMapping("/distritos")
    public ResponseEntity<Distrito[]> getDistritos(@RequestParam(required = false) String distrito_nombre) {

        Distrito[] distritos;

        if (distrito_nombre == null) {
            distritos = eleccionesService.obtenerDistritos();
        } else {
            distritos = eleccionesService.obtenerDistritosPorNombre(distrito_nombre);
        }
        return ResponseEntity.ok(distritos);
    }

    @GetMapping("/cargos")
    public ResponseEntity<CargosResponseDTO> getCargosPorDistrito(@RequestParam int distrito_id){
        CargosResponseDTO cargosResponseDto;
        cargosResponseDto = eleccionesService.obtenerCargosPorDistrito(distrito_id);
        return ResponseEntity.ok(cargosResponseDto);
    }

    @GetMapping("/secciones")
    public ResponseEntity<List<SeccionDTO>> getSecciones(@RequestParam Long distrito_id, @RequestParam(required = false) Long seccion_id){
        List<SeccionDTO> secciones = new ArrayList<>();
        if (seccion_id == null) {
            secciones = eleccionesService.obtenerSeccionesPorDistrito(distrito_id);
        } else {
            SeccionDTO seccionDto = eleccionesService.obtenerSeccionDtoPorDistritoYSeccion(distrito_id, seccion_id);
            secciones.add(seccionDto);
        }
        return ResponseEntity.ok(secciones);
    }

    @GetMapping("/resultados")
    public ResponseEntity<ResultadoResponseDTO> getResultados(@RequestParam Long seccionId){
        ResultadoResponseDTO resultadoResponseDto = eleccionesService.obtenerResultado(seccionId);
        return ResponseEntity.ok(resultadoResponseDto);
    }
}
