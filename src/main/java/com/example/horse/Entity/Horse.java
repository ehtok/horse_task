package com.example.horse.Entity;

import com.example.horse.Enum.TypeEnum;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Horse implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "horse_name")
    private String name;

    @Column(name = "horse_type")
    @Enumerated(EnumType.STRING)
    private TypeEnum type;

    @Column(name = "horse_age")
    private Integer age;

    @Column(name = "horse_price")
    private BigDecimal price;
}
