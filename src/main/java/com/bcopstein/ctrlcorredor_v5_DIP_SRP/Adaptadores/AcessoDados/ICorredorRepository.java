package com.bcopstein.ctrlcorredor_v5_DIP_SRP.Adaptadores.AcessoDados;

import java.util.List;

import com.bcopstein.ctrlcorredor_v5_DIP_SRP.LogicaNegocios.Corredor;

public interface ICorredorRepository {
    List<Corredor> todos();
    void removeTodos();
    boolean cadastra(Corredor corredor);
}
