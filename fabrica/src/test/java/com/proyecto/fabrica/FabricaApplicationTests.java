package com.proyecto.fabrica;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.proyecto.fabrica.dao.FabricaDao;
import com.proyecto.fabrica.model.Fabrica;
import com.proyecto.fabrica.service.FabricaServiceImpl;

@SpringBootTest
class FabricaApplicationTests {
    @Mock
    private FabricaDao dao;

    @InjectMocks
    private FabricaServiceImpl service;

    @Test
    public void testActualizarStockPiezas() {
        // Paso 1
        Fabrica fabrica = new Fabrica();
        fabrica.setStockPiezas(10);

        // Paso 2
        when(dao.findById(1)).thenReturn(Optional.of(fabrica));

        // Paso 3
        service.actualizarStockPiezas(1, 20);

        // Paso 4
        verify(dao).findById(1);
        verify(dao).save(argThat(updatedFabrica -> updatedFabrica.getStockPiezas() == 20));

        // Paso 5
        verifyNoMoreInteractions(dao);
    }
}
