package com.anilgubbala.web.mappers;


import com.anilgubbala.domain.Beer;
import com.anilgubbala.web.model.BeerDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {DateMapper.class})
public interface BeerMapper {
    @Mapping(source = "createdDate", target = "createdDate")
    BeerDto toBeerDto(Beer beer);

    @Mapping(source = "lastModifiedDate", target = "lastModifiedDate")
    Beer toBeer(BeerDto beerDto);
}
