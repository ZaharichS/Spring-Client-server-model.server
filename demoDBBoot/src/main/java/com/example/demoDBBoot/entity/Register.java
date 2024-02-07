package com.example.demoDBBoot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "register")
public class Register {
    @Column(name = "register_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numFlight") // Номер рейса
    private String numFlight;

    @Column(name = "trip")     // Маршрут
    private String trip;

    @Column(name = "stopoverPoints")
    private String stopoverPoints;     // Пункты промежуточной посадки

    @Column(name = "timeFlight")
    private String timeFlight;     // Время отправления

    @Column(name = "dayFlight")
    private String dayFlight;     // Дни отправления

    @Column(name = "AvailabilitySeatsFlight")
    private String AvailabilitySeatsFlight;     // Количество свободных мест на каждом рейсе

}
