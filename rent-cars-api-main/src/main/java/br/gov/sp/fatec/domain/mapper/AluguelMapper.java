package br.gov.sp.fatec.domain.mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import br.gov.sp.fatec.domain.entity.Aluguel;
import br.gov.sp.fatec.domain.request.AluguelRequest;
import br.gov.sp.fatec.domain.response.AluguelResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = SPRING)
public interface AluguelMapper {

    @Mapping(target = "carro.id", source = "carroId")
    @Mapping(target = "cliente.id", source = "clienteId")
    @Mapping(target = "status", source = "status", defaultExpression = "java(br.gov.sp.fatec.domain.entity.AluguelStatus.valueOf(source.getStatus()))")
    Aluguel map(AluguelRequest source);

    @Mapping(target = "carroId", source = "carro.id")
    @Mapping(target = "clienteId", source = "cliente.id")
    @Mapping(target = "status", source = "status.name")
    AluguelResponse map(Aluguel source);

    @Mapping(target = "carro.id", source = "carroId")
    @Mapping(target = "cliente.id", source = "clienteId")
    @Mapping(target = "status", source = "status", defaultExpression = "java(br.gov.sp.fatec.domain.entity.AluguelStatus.valueOf(source.getStatus()))")
    void updateAluguelFromRequest(AluguelRequest source, @MappingTarget Aluguel target);
}

