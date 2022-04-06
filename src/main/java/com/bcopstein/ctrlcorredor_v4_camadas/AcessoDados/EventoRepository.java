package com.bcopstein.ctrlcorredor_v4_camadas.AcessoDados;

import java.util.List;

import com.bcopstein.ctrlcorredor_v4_camadas.LogicaNegocios.IEventoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class EventoRepository implements IEventoRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public EventoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;  
        this.jdbcTemplate.execute("DROP TABLE eventos IF EXISTS");
        this.jdbcTemplate.execute("CREATE TABLE eventos("
                + "id int, nome VARCHAR(255), dia int, mes int, ano int, distancia int, horas int, minutos int, segundos int,PRIMARY KEY(id))");
        // Insere eventos
        create(new Evento(1,"Poa Day Run",22,5,2019,5,0,35,32));
        create(new Evento(2,"Poa Night Run",12,6,2019,5,0,31,10));
        create(new Evento(3,"Winter Day Run",9,7,2019,5,0,29,17));
        create(new Evento(4,"Summer Night Run",18,12,2019,5,0,32,25));
    }  


    @Override
    public Evento create(Evento evento) {
        this.jdbcTemplate.update(
            "INSERT INTO eventos(id,nome,dia,mes,ano,distancia,horas,minutos,segundos) VALUES (?,?,?,?,?,?,?,?,?)",
            evento.getId(), evento.getNome(), evento.getDia(), evento.getMes(), evento.getAno(),
            evento.getDistancia(), evento.getHoras(), evento.getMinutos(), evento.getSegundos());
        return evento;
    }

    @Override
    public List<Evento> recovery() {
        List<Evento> resp = this.jdbcTemplate.query("SELECT * from eventos",
                (rs, rowNum) -> new Evento(rs.getInt("id"), rs.getString("nome"), rs.getInt("dia"), rs.getInt("mes"),
                        rs.getInt("ano"), rs.getInt("distancia"), rs.getInt("horas"), rs.getInt("minutos"),
                        rs.getInt("segundos")));
        return resp;
    }

    @Override
    public Evento update(int id, Evento object) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        return false;
    }
}
