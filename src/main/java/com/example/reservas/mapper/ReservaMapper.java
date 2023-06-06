package com.example.reservas.mapper;

import com.example.reservas.dtos.ReservaDto;
import com.example.reservas.model.Reserva;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ReservaMapper {

    ReservaDto modelToDto(Reserva reserva);

    List<ReservaDto> modelListToDtoList(List<Reserva> reservas);

    Reserva dtoToModel(ReservaDto reservaDto);
}
