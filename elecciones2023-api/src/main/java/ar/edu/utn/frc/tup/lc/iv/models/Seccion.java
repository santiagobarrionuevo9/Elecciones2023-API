package ar.edu.utn.frc.tup.lc.iv.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Seccion {
    private int seccionId;
    private String seccionNombre;
    private int distritoId;
}
