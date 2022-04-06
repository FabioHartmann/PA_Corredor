package com.bcopstein.ctrlcorredor_v4_camadas.LogicaNegocios;

import java.util.List;

public interface ICRUDRepository<T> {
    T create(T object);
    List<T> recovery();
    T update(int id, T object);
    boolean delete(int id);
}
