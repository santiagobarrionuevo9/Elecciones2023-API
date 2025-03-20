package ar.edu.utn.frc.tup.lc.iv.services.imp;

import ar.edu.utn.frc.tup.lc.iv.dtos.common.CargoDTO;
import ar.edu.utn.frc.tup.lc.iv.dtos.common.CargosResponseDTO;
import ar.edu.utn.frc.tup.lc.iv.dtos.common.ResultadoResponseDTO;
import ar.edu.utn.frc.tup.lc.iv.dtos.common.SeccionDTO;
import ar.edu.utn.frc.tup.lc.iv.models.Distrito;
import ar.edu.utn.frc.tup.lc.iv.models.Resultado;
import ar.edu.utn.frc.tup.lc.iv.models.Seccion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EleccionesServiceImpTest {
    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private EleccionesServiceImp distritoServiceImpl;

    private Distrito[] mockDistritos;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockDistritos = new Distrito[]{
                new Distrito(1, "DistritoA"),
                new Distrito(2, "DistritoB")
        };
    }

    @Test
    void obtenerDistritos() {
        when(restTemplate.getForEntity("http://eleccionesApiExterna:8080/distritos", Distrito[].class))
                .thenReturn(new ResponseEntity<>(mockDistritos, HttpStatus.OK));

        Distrito[] distritos = distritoServiceImpl.obtenerDistritos();

        assertNotNull(distritos);
        assertEquals(2, distritos.length);
        assertEquals("DistritoA", distritos[0].getDistritoNombre());
        assertEquals("DistritoB", distritos[1].getDistritoNombre());
    }

    @Test
    void obtenerDistritosPorNombre() {
        String nombre = "DistritoA";
        when(restTemplate.getForEntity("http://eleccionesApiExterna:8080/distritos?distritoNombre=DistritoA", Distrito[].class))
                .thenReturn(new ResponseEntity<>(mockDistritos, HttpStatus.OK));

        Distrito[] distritos = distritoServiceImpl.obtenerDistritosPorNombre(nombre);

        assertNotNull(distritos);
        assertEquals(2, distritos.length);
        assertEquals("DistritoA", distritos[0].getDistritoNombre());
    }

    @Test
    void obtenerCargosPorDistrito() {
        int distritoId = 1;
        CargoDTO[] mockCargos = {
                new CargoDTO(1, "Cargo 1", 1),
                new CargoDTO(2, "Cargo 2", 1)
        };

        Distrito[] mockDistrito = {new Distrito(1, "DistritoA")};

        when(restTemplate.getForEntity("http://eleccionesApiExterna:8080/distritos?distritoId=1", Distrito[].class))
                .thenReturn(new ResponseEntity<>(mockDistrito, HttpStatus.OK));

        when(restTemplate.getForEntity("http://eleccionesApiExterna:8080/cargos?distritoId=1", CargoDTO[].class))
                .thenReturn(new ResponseEntity<>(mockCargos, HttpStatus.OK));

        CargosResponseDTO response = distritoServiceImpl.obtenerCargosPorDistrito(distritoId);

        assertNotNull(response);
        assertEquals("DistritoA", response.getDistrito().getNombre());
        assertEquals(2, response.getCargos().length);
    }

    @Test
    void obtenerSeccionesPorDistrito() {
        Long distritoId = 1L;
        Seccion[] mockSecciones = {
                new Seccion(1, "Seccion 1", 1),
                new Seccion(2, "Seccion 2", 1)
        };

        when(restTemplate.getForEntity("http://eleccionesApiExterna:8080/secciones?distritoId=1", Seccion[].class))
                .thenReturn(new ResponseEntity<>(mockSecciones, HttpStatus.OK));

        List<SeccionDTO> secciones = distritoServiceImpl.obtenerSeccionesPorDistrito(distritoId);

        assertNotNull(secciones);
        assertEquals(2, secciones.size());
        assertEquals("Seccion 1", secciones.get(0).getNombre());
    }

    @Test
    public void testObtenerSeccionDtoPorDistritoYSeccion() {
        // Mock de la respuesta esperada
        Seccion[] mockSecciones = {
                new Seccion(1, "Seccion 1", 1)  // Crea una Sección de ejemplo
        };

        // Simular el comportamiento del RestTemplate
        when(restTemplate.getForEntity("http://eleccionesApiExterna:8080/secciones?seccionId=1&distritoId=1", Seccion[].class))
                .thenReturn(ResponseEntity.ok(mockSecciones));

        // Ejecutar el método
        SeccionDTO seccionDto = distritoServiceImpl.obtenerSeccionDtoPorDistritoYSeccion(1L, 1L);

        // Verificar resultados
        assertNotNull(seccionDto);
        assertEquals(1L, seccionDto.getId());
        assertEquals("Seccion 1", seccionDto.getNombre());
    }
}