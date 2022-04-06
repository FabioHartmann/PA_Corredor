package com.bcopstein.ctrlcorredor_v4_camadas.LogicaNegocios;

import java.util.List;

import com.bcopstein.ctrlcorredor_v4_camadas.AcessoDados.Corredor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CorredoresServicos {
    ICorredorRepository corredorRep;

    @Autowired
    public CorredoresServicos(ICorredorRepository corredorRepository){
        this.corredorRep = corredorRepository;
    }

    public List<Corredor> corredores(){
        return corredorRep.recovery();
    }

    public boolean cadastraCorredor(Corredor corredor){
        corredorRep.delete(0);
        corredorRep.create(corredor);
        return true;
    }
}
