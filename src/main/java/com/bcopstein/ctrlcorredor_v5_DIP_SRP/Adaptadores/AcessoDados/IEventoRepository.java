package com.bcopstein.ctrlcorredor_v5_DIP_SRP.Adaptadores.AcessoDados;

import java.util.List;

import com.bcopstein.ctrlcorredor_v5_DIP_SRP.LogicaNegocios.Evento;

public interface IEventoRepository {
    List<Evento> todos();
    boolean cadastra(Evento evento);
}
