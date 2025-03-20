package ar.edu.utn.frc.tup.lc.iv.dtos.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultadoDTO {
    private int orden;
    private String nombre;
    private int votos;
    private double porcentaje;

}
