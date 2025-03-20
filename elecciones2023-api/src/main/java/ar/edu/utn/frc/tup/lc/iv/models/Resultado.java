package ar.edu.utn.frc.tup.lc.iv.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Resultado {
    private Long id;
    private String eleccionTipo;
    private String recuentoTipo;
    private String padronTipo;
    private Long distritoId;
    private String distritoNombre;
    private Long seccionProvincialId;
    private String seccionProvincialNombre;
    private Long seccionId;
    private String seccionNombre;
    private String circuitoId;
    private String circuitoNombre;
    private Long mesaId;
    private String mesaTipo;
    private Long mesaElectores;
    private Long cargoId;
    private String cargoNombre;
    private int agrupacionId;
    private String agrupacionNombre;
    private String listaNumero;
    private String listaNombre;
    private String votosTipo;
    private int votosCantidad;
    private int año;
}
