package org.javaacademy.nuclearstation.subdivision;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * SecurityDepartment(отдел безопасности).
 * тот отдел будет фиксировать ошибки из реакторного цеха.
 */
@Component
@RequiredArgsConstructor
public class SecurityDepartment {
    @Lazy
    private final NuclearStation nuclearStation;
    @Getter
    private int accidentCountPeriod;


    public void addAccident() {
        accidentCountPeriod++;
    }

    public void reset() {
        nuclearStation.incrementAccident(accidentCountPeriod);
        accidentCountPeriod = 0;
    }





}
