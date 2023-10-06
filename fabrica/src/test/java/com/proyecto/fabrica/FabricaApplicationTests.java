package com.proyecto.fabrica;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.proyecto.fabrica.dao.FabricaDao;
import com.proyecto.fabrica.model.Fabrica;
import com.proyecto.fabrica.model.Modelo;
import com.proyecto.fabrica.service.FabricaServiceImpl;

@SpringBootTest
class FabricaApplicationTests {

	private final FabricaDao dao = mock(FabricaDao.class);
    private final RestTemplate template = mock(RestTemplate.class);
    private final FabricaServiceImpl servicio = new FabricaServiceImpl();  // Asumiendo que este es tu servicio
    private final String urlModelo = "http://localhost:8080/api/modelos/"; // Reemplácelo con su URL base

    @Test
    public void testConsultarPresupuesto() {
        int idFabrica = 1;
        Fabrica fabricaMock = new Fabrica();
        fabricaMock.setPresupuesto(1000.0);

        when(dao.findById(idFabrica)).thenReturn(Optional.of(fabricaMock));

        double resultado = servicio.consultarPresupuesto(idFabrica);

        assertEquals(1000.0, resultado);
    }

    @Test
    public void testActualizarPresupuesto() {
        int idFabrica = 1;
        double nuevoPresupuesto = 2000.0;
        Fabrica fabricaMock = new Fabrica();
        fabricaMock.setPresupuesto(1000.0);

        when(dao.findById(idFabrica)).thenReturn(Optional.of(fabricaMock));

        servicio.actualizarPresupuesto(idFabrica, nuevoPresupuesto);

        assertEquals(nuevoPresupuesto, fabricaMock.getPresupuesto());
        verify(dao).save(fabricaMock);
    }

    @Test
    public void testOptimizarFabricacionModelo() {
        int idModelo = 1;
        Modelo modeloMock = new Modelo();
        modeloMock.setIdModelo(idModelo);
        modeloMock.setCoste(5000.0);
        modeloMock.setPiezasNecesarias(500);

        when(template.getForObject(urlModelo, Modelo[].class))
            .thenReturn(new Modelo[] { modeloMock });

        servicio.optimizarFabricacionModelo(idModelo);

        verify(template).put(eq(urlModelo + "actualizar-coste/" + idModelo + "/" + (modeloMock.getCoste() - 1000.00)), any());
        verify(template).put(eq(urlModelo + "actualizar-piezas-necesarias/" + idModelo  + "/" + (modeloMock.getPiezasNecesarias() - 100)), any());
    }
}
