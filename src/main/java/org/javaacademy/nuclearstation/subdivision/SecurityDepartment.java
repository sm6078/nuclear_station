package org.javaacademy.nuclearstation.subdivision;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * SecurityDepartment(отдел безопасности). Этот отдел будет фиксировать ошибки из реакторного цеха.
 */
@RequiredArgsConstructor
@AllArgsConstructor
//TODO: доработать закончил на 2.1
public class SecurityDepartment {
    private final NuclearStation nuclearStation;
    private int accidentCountPeriod;


}
