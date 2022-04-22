package com.bcopstein.ctrlcorredor_v5_DIP_SRP.Aplicacao;

import java.util.List;

import com.bcopstein.ctrlcorredor_v5_DIP_SRP.Adaptadores.AcessoDados.IEventoRepository;
import com.bcopstein.ctrlcorredor_v5_DIP_SRP.LogicaNegocios.Evento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicoEvento {
    private IEventoRepository eventoRep;

    @Autowired
    public ServicoEvento(IEventoRepository eventoRep){
        this.eventoRep = eventoRep;
    } 

    public List<Evento> todos(){
        return eventoRep.todos();
    }

    public void cadastra(Evento evento){
        eventoRep.cadastra(evento);
    }
    
}
