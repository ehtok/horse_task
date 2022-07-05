package com.example.horse.Enum;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum TypeEnum {
    DRAFT("Драфт"),
    HANOVERIAN("Ганноверский"),
    AKHAL("Ахалтекин"),
    ARABIAN("Арабский"),
    LUSITANO("Лузитано");

    private String name;

    TypeEnum(String name) {
        this.name = name;
    }
}
