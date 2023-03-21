package com.example.demoapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "discount")
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "discount", cascade = CascadeType.MERGE)
    private List<Product> products;

    @Column(name = "amount")
    private int amount;

    @Column(name = "duration")
    private int duration;

}
