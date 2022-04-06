package com.bcopstein.ctrlcorredor_v4_camadas.LogicaNegocios;

import java.util.List;

import com.bcopstein.ctrlcorredor_v4_camadas.AcessoDados.Evento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventosServicos {
    IEventoRepository eventoRep;
    @Autowired
    public EventosServicos(IEventoRepository eventoRepository){
        this.eventoRep = eventoRepository;
    }

    public List<Evento> eventos(){
        return eventoRep.recovery();
    }

    public boolean cadastraEvento(Evento evento){
        eventoRep.create(evento);
        return true;
    }
}
