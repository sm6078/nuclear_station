package org.javaacademy.nuclearstation.subdivision;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.javaacademy.nuclearstation.exception.NuclearFuelIsEmptyException;
import org.javaacademy.nuclearstation.exception.ReactorWorkException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Атомная станци
 * Данный bean класс содержит зависимость
 * (поле ReactorDepartment и конструктор на это поле) на реакторный цех.
 * У атомной станции есть атрибут - общее количество выработанной энергии.
 * При создании станции, количество выработанной энергии равно 0.
 */
@Component
@Data
@Slf4j
public class NuclearStation {
    private final ReactorDepartment reactorDepartment;
    private BigDecimal totalAmountEnergyGenerated = BigDecimal.ZERO;
    private static final int COUNT_DAY_IN_YEAR = 365;

    /**
     * Выводит на экран: "Атомная станция начала работу".
     * Запускает годовой цикл производства электричества.
     * 365 раз запускает и выключает реакторный цех.
     * В случае ошибки, цех в данный день электричества не дает.
     * Публикуется сообщение: "Внимание! Происходят работы на атомной станции! Электричества нет!".
     * Количество произведенной электроэнергии за год должно быть просуммированно в отдельной переменной.
     * Выводит на экран: "Атомная станция закончила работу. За год Выработано n киловатт/часов".
     */
    public void startYear() {
        BigDecimal yearEnergyGenerated = BigDecimal.ZERO;
        log.info("Атомная станция начала работу");
        for (int i = 0; i < COUNT_DAY_IN_YEAR; i++) {
            try {
                yearEnergyGenerated = yearEnergyGenerated.add(reactorDepartment.run());
                reactorDepartment.stop();
            } catch (NuclearFuelIsEmptyException | ReactorWorkException e) {
                log.info("Внимание! Происходят работы на атомной станции! Электричества нет!");
            }
        }
        totalAmountEnergyGenerated = totalAmountEnergyGenerated.add(yearEnergyGenerated);
        log.info("Атомная станция закончила работу. За год Выработано {} киловатт/часов", yearEnergyGenerated);
    }

    /**
     * start(int year) - запускает в цикле year раз метод startYear
     */
    public void start(int count) {
        for (int i = 0; i < count; i++) {
            startYear();
        }
    }
}
