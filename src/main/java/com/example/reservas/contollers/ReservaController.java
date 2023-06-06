package com.example.reservas.contollers;

import com.example.reservas.dtos.ReservaDto;
import com.example.reservas.model.Reserva;
import com.example.reservas.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/reserva")
public class ReservaController{

    @Autowired
    private ReservaService reservaService;

    @PostMapping("/create")
    public ResponseEntity<ReservaDto> create(@RequestBody ReservaDto reservaDto){
        return new ResponseEntity<>(reservaService.create(reservaDto), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ReservaDto> update(@RequestBody ReservaDto reservaDto){
        return new ResponseEntity<>(reservaService.update(reservaDto), HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<ReservaDto> getById(@PathVariable("id") int id){
        return new ResponseEntity<>(reservaService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/obtenerTodos")
    public ResponseEntity<List<ReservaDto>> getAll(){
        return new ResponseEntity<>(reservaService.getAllReservas(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id){
        reservaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
