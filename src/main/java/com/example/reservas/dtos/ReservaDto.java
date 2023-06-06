package com.example.reservas.dtos;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Builder
public class ReservaDto {

    private int id;

    private LocalDateTime horaReserva;

    private String pelicula;

    private String sala;

    private int boletos;

}
