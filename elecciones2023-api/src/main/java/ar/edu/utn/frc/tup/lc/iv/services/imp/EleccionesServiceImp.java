package ar.edu.utn.frc.tup.lc.iv.services.imp;

import ar.edu.utn.frc.tup.lc.iv.dtos.common.*;
import ar.edu.utn.frc.tup.lc.iv.models.*;
import ar.edu.utn.frc.tup.lc.iv.services.EleccionesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EleccionesServiceImp implements EleccionesService {
    private final String URL = "http://eleccionesApiExterna:8080";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Distrito[] obtenerDistritos() {
        Distrito[] distritos = restTemplate.getForEntity(URL + "/distritos", Distrito[].class).getBody();
        return distritos;
    }

    @Override
    public Distrito[] obtenerDistritosPorNombre(String nombre) {
        Distrito[] distritos = restTemplate.getForEntity(URL + "/distritos?distritoNombre=" + nombre, Distrito[].class).getBody();
        return distritos;
    }

    @Override
    public CargosResponseDTO obtenerCargosPorDistrito(int distrito_id) {
        Distrito[] distrito = restTemplate.getForEntity(URL + "/distritos?distritoId=" + distrito_id, Distrito[].class).getBody();

        DistritoDTO distritoDto = new DistritoDTO();
        distritoDto.setId(distrito[0].getDistritoId());
        distritoDto.setNombre(distrito[0].getDistritoNombre());


        CargoDTO[] cargoGetDtos = restTemplate.getForEntity(URL + "/cargos?distritoId=" + distrito_id, CargoDTO[].class).getBody();

        Cargo[] cargos = new Cargo[cargoGetDtos.length];
        int i = 0;

        for (CargoDTO cargoGetDto : cargoGetDtos) {
            Cargo cargo = new Cargo();
            cargo.setId(cargoGetDto.getCargoId());
            cargo.setNombre(cargoGetDto.getCargoNombre());
            cargos[i] = cargo;
            i++;
        }

        CargosResponseDTO cargosResponseDto = new CargosResponseDTO();
        cargosResponseDto.setDistrito(distritoDto);
        cargosResponseDto.setCargos(cargos);

        return cargosResponseDto;
    }

    @Override
    public List<SeccionDTO> obtenerSeccionesPorDistrito(Long distrito_id) {
        Seccion[] secciones = restTemplate.getForEntity(URL + "/secciones?distritoId=" + distrito_id, Seccion[].class).getBody();
        List<SeccionDTO> seccionesDto = new ArrayList<>();

        for (Seccion seccion : secciones) {
            SeccionDTO seccionDto = new SeccionDTO();
            seccionDto.setId(seccion.getSeccionId());
            seccionDto.setNombre(seccion.getSeccionNombre());
            seccionesDto.add(seccionDto);
        }
        return seccionesDto;
    }

    @Override
    public SeccionDTO obtenerSeccionDtoPorDistritoYSeccion(Long distrito_id, Long seccion_id) {
        Seccion[] seccion = restTemplate.getForEntity(URL + "/secciones?seccionId=" + seccion_id + "&distritoId=" + distrito_id, Seccion[].class).getBody();
        SeccionDTO seccionDto = new SeccionDTO();
        seccionDto.setId(seccion[0].getSeccionId());
        seccionDto.setNombre(seccion[0].getSeccionNombre());
        return seccionDto;
    }

    @Override
    public ResultadoResponseDTO obtenerResultado(Long seccionId) {
        Resultado[] resultados = restTemplate.getForEntity(URL + "/resultados?seccionId=" + seccionId, Resultado[].class).getBody();

        int LLA = 0;
        int JPC = 0;
        int HPNP = 0;
        int ULP = 0;
        int IZQ = 0;
        int Blanco = 0;
        int Nulo = 0;
        int Impugnado = 0;
        int Recurrido = 0;

        for (Resultado resultado : resultados) {
            if (resultado.getAgrupacionId() == 135) {
                LLA += resultado.getVotosCantidad();
            } else if (resultado.getAgrupacionId() == 132) {
                JPC += resultado.getVotosCantidad();
            } else if (resultado.getAgrupacionId() == 133) {
                HPNP += resultado.getVotosCantidad();
            } else if (resultado.getAgrupacionId() == 134) {
                ULP += resultado.getVotosCantidad();
            } else if (resultado.getAgrupacionId() == 136) {
                IZQ += resultado.getVotosCantidad();
            } else if (resultado.getAgrupacionId() == 0) {
                if (Objects.equals(resultado.getVotosTipo(), "EN BLANCO")) {
                    Blanco += resultado.getVotosCantidad();
                } else if (Objects.equals(resultado.getVotosTipo(), "NULO")) {
                    Nulo += resultado.getVotosCantidad();
                } else if (Objects.equals(resultado.getVotosTipo(), "IMPUGNADO")) {
                    Impugnado += resultado.getVotosCantidad();
                } else if (Objects.equals(resultado.getVotosTipo(), "RECURRIDO")) {
                    Recurrido += resultado.getVotosCantidad();
                }
            }
        }

        String[] nombre = {"LA LIBERTAD AVANZA", "JUNTOS POR EL CAMBIO", "HACEMOS POR NUESTRO PAIS", "UNION POR LA PATRIA", "FRENTE DE IZQUIERDA Y DE TRABAJADORES - UNIDAD",
                "EN BLANCO", "NULO", "IMPUGNADO", "RECURRIDO"};
        int[] votos = new int[]{LLA, JPC, HPNP, ULP, IZQ, Blanco, Nulo, Impugnado, Recurrido};

        int votosTotales = 0;
        for (int i = 0; i < 9; i++) {
            votosTotales += votos[i];
        }

        List<ResultadoDTO> resultadoDtos = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            ResultadoDTO resultadoDto = new ResultadoDTO();
            resultadoDto.setOrden(i);
            resultadoDto.setNombre(nombre[i - 1]);
            resultadoDto.setVotos(votos[i - 1]);
            resultadoDto.setPorcentaje((double) resultadoDto.getVotos() / votosTotales);
            resultadoDtos.add(resultadoDto);
        }

        ResultadoResponseDTO resultadoResponseDto = new ResultadoResponseDTO();
        resultadoResponseDto.setDistrito(resultados[0].getDistritoNombre());
        resultadoResponseDto.setSeccion(resultados[0].getSeccionNombre());
        resultadoResponseDto.setResultados(resultadoDtos);

        return resultadoResponseDto;
    }
}
