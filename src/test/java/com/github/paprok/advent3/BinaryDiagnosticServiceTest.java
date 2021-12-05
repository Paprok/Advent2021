package com.github.paprok.advent3;

import com.github.paprok.commons.FileReader;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class BinaryDiagnosticServiceTest {
    @InjectMocks
    private BinaryDiagnosticService binaryDiagnostic;
    @Mock
    private FileReader<Integer[]> reader;

    @BeforeEach
    public void init()
    {
        MockitoAnnotations.initMocks( this );
    }

    @Test
    @SneakyThrows
    public void getPowerConsumptionReturnsExpected() {
        // given
        when(reader.produceWith(any())).thenReturn(List.of(
                new Integer[]{0, 0, 1, 0, 0},
                new Integer[]{1, 1, 1, 1, 0},
                new Integer[]{1, 0, 1, 1, 0},
                new Integer[]{1, 0, 1, 1, 1},
                new Integer[]{1, 0, 1, 0, 1},
                new Integer[]{0, 1, 1, 1, 1},
                new Integer[]{0, 0, 1, 1, 1},
                new Integer[]{1, 1, 1, 0, 0},
                new Integer[]{1, 0, 0, 0, 0},
                new Integer[]{1, 1, 0, 0, 1},
                new Integer[]{0, 0, 0, 1, 0},
                new Integer[]{0, 1, 0, 1, 0}));

        //when
        int actual = binaryDiagnostic.getPowerConsumption();

        // then
        assertEquals(198, actual);
    }

    @Test
    @SneakyThrows
    public void executeBinaryMapper() {
        // given
        BinaryMapper mapper = new BinaryMapper();
        FileReader<Integer[]> reader = new FileReader<>(mapper);
        BinaryDiagnosticService service = new BinaryDiagnosticService(reader);

        // when
        int actual = service.getPowerConsumption();

        //then
        assertEquals(2648450, actual);
    }

}