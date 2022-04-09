package com.bcopstein.ctrlcorredor_v4_camadas.LogicaNegocios;

import java.util.List;
import java.util.stream.Collectors;

import com.bcopstein.ctrlcorredor_v4_camadas.AcessoDados.Evento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicoEstatistica {
    @Autowired
    private IEstatistica estatistica;

    public EstatisticasDTO calculaEstatisticas(int distancia){
        return estatistica.calculaEstatisticas(distancia);
    }

    public PerformanceDTO calculaAumentoPerformance(int distancia,int ano){
        return estatistica.calculaAumentoPerformance(distancia, ano);
    }
}
