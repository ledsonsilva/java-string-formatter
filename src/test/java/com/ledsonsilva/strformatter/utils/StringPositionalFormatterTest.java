package com.ledsonsilva.strformatter.utils;

import com.ledsonsilva.strformatter.exception.PositionSizeException;
import com.ledsonsilva.strformatter.utils.model.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StringPositionalFormatterTest {

    public static final LocalDate now = LocalDate.now();

    public static Car getMockObject() {
        Car argo = new Car();
        argo.setId(1L);
        argo.setBrand("FIAT");
        argo.setName("ARGO 2.0");
        argo.setDtFabrication(now);
        argo.setPrice(new BigDecimal("150.00"));

        return argo;
    }

    @Test
    void checkIfStringWasFormattedCorrectly() {
        Car argo = getMockObject();
        String test = "1  FIAT      ARGO 2.0            " + now.format(DateTimeFormatter.ofPattern("dd/MM/YYYY")) + "     150.00";

        try {
            Assertions.assertEquals(test, StringPositionalFormatter.format(argo));
        } catch (PositionSizeException e) {
            e.printStackTrace();
        }
    }

    @Test
    void checkExceptionIfPassingDataGreaterThanPosition() {
        Car argo = getMockObject();
        Assertions.assertThrows(PositionSizeException.class, () -> {
            argo.setId(1234L); // 3 position annotate attribute
           StringPositionalFormatter.format(argo);
        });
    }

}
