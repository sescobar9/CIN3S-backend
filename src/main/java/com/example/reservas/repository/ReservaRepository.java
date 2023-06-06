package com.example.reservas.repository;

import com.example.reservas.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

    Boolean existsByHoraReserva(LocalDateTime horaReserva);

    Boolean existsByPelicula(String pelicula);

    Reserva findReservaById(int id);

}