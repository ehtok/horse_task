package com.example.horse.repository.Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

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
    private String type;

    @Column(name = "horse_age")
    private String age;

    @Column(name = "horse_price")
    private String price;
}
