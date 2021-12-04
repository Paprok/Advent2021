package com.github.paprok.advent1;

import com.github.paprok.commons.AdventMapper;
import com.github.paprok.commons.FileReader;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class SonarSweepServiceTest {

    public static final String fileName = "day1.txt";
    @InjectMocks
    private SonarSweepService sonarSweepService;
    @Spy
    private FileReader fileReader = new FileReader();
    @Spy
    private AdventMapper<Integer> integerAdventMapper = new IntegerMapper();

    @Test
    @SneakyThrows
    void measurementIncreasesReturnsExpected() {
        // given
        doReturn(List.of(199, 200, 208, 210, 200, 207, 240, 269, 260, 263)).when(fileReader).produceWith(any(), integerAdventMapper);
        int expected = 7;

        // when
        int actual = sonarSweepService.measurementIncreases();

        //then
        assertEquals(expected, actual);
    }

    @Test
    @SneakyThrows
    public void testExecution() {
        FileReader fileReader = new FileReader();
        AdventMapper<Integer> sonarMapper = new IntegerMapper();
        SonarSweepService sonarSweep = new SonarSweepService(fileReader, sonarMapper);
        int actual = sonarSweep.summedMeasurementIncreases();
        assertEquals(1457, actual);
    }

    @Test
    @SneakyThrows
    void summedMeasurementIncreasesReturnsExpected() {
        doReturn(List.of(199, 200, 208, 210, 200, 207, 240, 269, 260, 263)).when(fileReader).produceWith(any(), any());
        int expected = 5;

        // when
        int actual = sonarSweepService.summedMeasurementIncreases();

        //then
        assertEquals(expected, actual);
    }
}