package com.bcopstein.ctrlcorredor_v5_DIP_SRP.Config;

import com.bcopstein.ctrlcorredor_v5_DIP_SRP.Adaptadores.AcessoDados.IEventoRepository;
import com.bcopstein.ctrlcorredor_v5_DIP_SRP.Aplicacao.EstatisticaDesconsidera;
import com.bcopstein.ctrlcorredor_v5_DIP_SRP.Aplicacao.EstatisticaNormal;
import com.bcopstein.ctrlcorredor_v5_DIP_SRP.Aplicacao.ICalculoEstatistica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguradorCalculoEstatistica {
    private IEventoRepository eventoRep;

    @Autowired
    public ConfiguradorCalculoEstatistica(IEventoRepository eventoRep) {
        this.eventoRep = eventoRep;
    }

    @Bean
    @ConditionalOnProperty(name = "calculo.estatistica", havingValue = "original", matchIfMissing = true)
    public ICalculoEstatistica opcaoRegraClassica() {
        System.out.println("original");
        return new EstatisticaNormal(eventoRep);
    }

    @Bean
    @ConditionalOnProperty(name = "calculo.estatistica", havingValue = "desconsidera")
    public ICalculoEstatistica opcaoDesconsidera() {
        System.out.println("desconsidera");
        return new EstatisticaDesconsidera(eventoRep);
    }
}
