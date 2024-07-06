package br.gov.sp.fatec.domain.mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import br.gov.sp.fatec.domain.entity.Carro;
import br.gov.sp.fatec.domain.request.CarroRequest;
import br.gov.sp.fatec.domain.response.CarroResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = SPRING)
public interface CarroMapper {

    Carro map(CarroRequest source);

    CarroResponse map(Carro source);

    @Mapping(target = "id", ignore = true)
    void updateCarroFromRequest(CarroRequest source, @MappingTarget Carro target);
}


