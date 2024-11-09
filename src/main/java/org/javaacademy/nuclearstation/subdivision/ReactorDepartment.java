package org.javaacademy.nuclearstation.subdivision;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.javaacademy.nuclearstation.exception.NuclearFuelIsEmptyException;
import org.javaacademy.nuclearstation.exception.ReactorWorkException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Реакторный цех
 * Данный цех отвечает за производство электроэнергии.
 */
@AllArgsConstructor
@NoArgsConstructor
@Component
@Slf4j
public class ReactorDepartment {
    private boolean isWork = false;
    private static int runCounter;

    /**
     * В реакторном цехе есть метод run (запустить реактор)
     * - (проверяет, что реактор не включен,
     * иначе выбрасывает ошибку ReactorWorkException, с текстом - "Реактор уже работает").
     * Метод меняет состояние реактора и возвращает 10 миллионов киловатт/часов.
     * Каждый 100 запуск - выдает ошибку NuclearFuelIsEmptyException.
     */
    public BigDecimal run() throws ReactorWorkException, NuclearFuelIsEmptyException {
        if (isWork) {
            throw new ReactorWorkException("Реактор уже работает");
        } else if (runCounter == 100) {
            runCounter = 0;
            throw new NuclearFuelIsEmptyException("Достигнут предел запусков - 100. " +
                    "Необходимы профилактические работы");
        }
        isWork = true;
        runCounter += 1;
        return BigDecimal.valueOf(10_000_000);
    }

    /**
     * Второй метод реакторного цеха stop (остановить реактор)
     * - (проверяет, что реактор включен, иначе выбрасывает ошибку ReactorWorkException,
     * с текстом - "ReactorWorkException").
     * Метод меняет состояние реактора и ничего не возвращает.
     */
    public void stop() throws ReactorWorkException {
        if (!isWork) {
            throw new ReactorWorkException("ReactorWorkException");
        }
        isWork = false;
     }
}
