package com.example.reservas.service;

import com.example.reservas.dtos.ReservaDto;
import com.example.reservas.mapper.ReservaMapper;
import com.example.reservas.model.Reserva;
import com.example.reservas.repository.ReservaRepository;
import com.sun.jdi.request.DuplicateRequestException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private ReservaMapper reservaMapper;

    private void existsByHoraReserva(LocalDateTime horaReserva){
        if (reservaRepository.existsByHoraReserva(horaReserva)){
            throw new DuplicateRequestException("La hora de reserva no está dispónible");
        }
    }

    private void existsByPelicula(String pelicula){
        if (reservaRepository.existsByPelicula(pelicula)){
            throw new DuplicateRequestException("El nombre de la pelicula ya se encuentra registrado");
        }
    }

    public ReservaDto create(ReservaDto reservaDto){
        Reserva reserva = reservaMapper.dtoToModel(reservaDto);
        this.existsByHoraReserva(reserva.getHoraReserva());
        this.existsByPelicula(reserva.getPelicula());

        Reserva newReserva = reservaRepository.save(reserva);

        ReservaDto savedReservaDto = reservaMapper.modelToDto(newReserva);
        return savedReservaDto;
    }

    public ReservaDto update(ReservaDto reservaDto){
        Reserva reserva = reservaMapper.dtoToModel(reservaDto);

        Reserva newReserva = reservaRepository.save(reserva);

        ReservaDto savedReservaDto = reservaMapper.modelToDto(newReserva);
        return savedReservaDto;
    }

    public ReservaDto getById(int id){
        Reserva reserva = reservaRepository.findById(id).orElse(null);
        if (reserva == null){
            throw new EntityNotFoundException("La reserva con id: "+id+"no existe");
        }
        ReservaDto reservaDto = reservaMapper.modelToDto(reserva);
        return reservaDto;
    }

    public List<ReservaDto> getAllReservas(){
        List<Reserva> reservas = reservaRepository.findAll();
        return reservas.stream().map(reserva -> reservaMapper.modelToDto(reserva)).collect(Collectors.toList());
    }

    public void delete(int id){
        this.getById(id);
        reservaRepository.deleteById(id);
    }

}