package com.bcopstein.ctrlcorredor_v4_camadas.LogicaNegocios;

public interface IEstatistica {
    EstatisticasDTO calculaEstatisticas(int distancia);
    PerformanceDTO calculaAumentoPerformance(int distancia, int ano);
}
