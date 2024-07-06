package br.gov.sp.fatec.domain.mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import br.gov.sp.fatec.domain.entity.Cliente;
import br.gov.sp.fatec.domain.request.ClienteRequest;
import br.gov.sp.fatec.domain.response.ClienteResponse;

@Mapper(componentModel = SPRING)
public interface ClienteMapper {

    Cliente map(ClienteRequest source);

    ClienteResponse map(Cliente source);

    @Mapping(target = "id", ignore = true)
    void updateClienteFromRequest(ClienteRequest source, @MappingTarget Cliente target);
}

