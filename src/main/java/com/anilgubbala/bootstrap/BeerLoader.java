package com.anilgubbala.bootstrap;

import com.anilgubbala.domain.Beer;
import com.anilgubbala.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {

        if(beerRepository.count() ==0) {
            beerRepository.save(
                    Beer.builder()
                            .beerName("White Zombie")
                            .beerStyle("IPA")
                            .quantityToBrew(200)
                            .onHand(12)
                            .upc(1001L)
                            .price(new BigDecimal("23.59"))
                            .build()
            );

            beerRepository.save(
                    Beer.builder()
                            .beerName("Modelo")
                            .beerStyle("LAGER")
                            .quantityToBrew(120)
                            .onHand(19)
                            .upc(1002L)
                            .price(new BigDecimal("13.59"))
                            .build()
            );
        }

    }
}
