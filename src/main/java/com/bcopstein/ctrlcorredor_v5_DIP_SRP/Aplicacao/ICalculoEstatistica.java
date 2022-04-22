package com.bcopstein.ctrlcorredor_v5_DIP_SRP.Aplicacao;

import com.bcopstein.ctrlcorredor_v5_DIP_SRP.Aplicacao.Dto.EstatisticasDTO;

public interface ICalculoEstatistica {
    EstatisticasDTO calculaEstatisticas(int distancia);
}
