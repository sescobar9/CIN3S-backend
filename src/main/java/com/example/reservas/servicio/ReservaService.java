package com.example.reservas.servicio;

import com.example.reservas.model.Reserva;
import com.example.reservas.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public Reserva create(Reserva reserva){
        Reserva newReserva = reservaRepository.save(reserva);
        return newReserva;
    }

    public Reserva update(Reserva reserva){
        Reserva newReserva = reservaRepository.save(reserva);
        return newReserva;
    }

    public Reserva getById(int id){
        return reservaRepository.findById(id).orElse(null);
    }

    public List<Reserva> getAllReservas(){
        return reservaRepository.findAll();
    }

    public void delete(int id){
        reservaRepository.deleteById(id);
    }
    public List<Reserva> getByHoraReserva(LocalDateTime hora){
        return reservaRepository.findByHoraReserva(hora);
    }

}
