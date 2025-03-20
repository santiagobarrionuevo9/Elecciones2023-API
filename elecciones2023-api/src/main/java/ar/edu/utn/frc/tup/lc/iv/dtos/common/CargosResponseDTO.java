package ar.edu.utn.frc.tup.lc.iv.dtos.common;

import ar.edu.utn.frc.tup.lc.iv.models.Cargo;
import lombok.*;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CargosResponseDTO {
    private DistritoDTO distrito;
    private Cargo[] cargos;

}
