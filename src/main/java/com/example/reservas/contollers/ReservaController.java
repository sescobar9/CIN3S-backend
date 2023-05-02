package com.example.reservas.contollers;

import com.example.reservas.model.Reserva;
import com.example.reservas.servicio.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/reserva")
public class ReservaController{

    @Autowired
    private ReservaService reservaService;

    @PostMapping("/create")
    public ResponseEntity<Reserva> create(@RequestBody Reserva reserva){
        Reserva newReserva = reservaService.create(reserva);
        return new ResponseEntity<>(newReserva, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Reserva> update(@RequestBody Reserva reserva){
        Reserva newReserva = reservaService.create(reserva);
        return new ResponseEntity<>(newReserva, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Reserva> getById(@PathVariable("id") int id){
        Reserva newReserva = reservaService.getById(id);
        if (newReserva == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(newReserva, HttpStatus.OK);
    }

    @GetMapping("/obtenerTodos")
    public ResponseEntity<List<Reserva>> getAll(){
        List<Reserva> reservas = reservaService.getAllReservas();
        if (reservas.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(reservas, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id){
        reservaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/obtenerPorHora/{hora}")
    public ResponseEntity<List<Reserva>> getByHoraReserva(@PathVariable("hora") LocalDateTime hora){
        List<Reserva> reservas = reservaService.getByHoraReserva(hora);
        if (reservas.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(reservas, HttpStatus.OK);
    }

}
