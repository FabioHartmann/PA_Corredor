package com.bcopstein.ctrlcorredor_v4_camadas.AcessoDados;

import java.util.List;

import com.bcopstein.ctrlcorredor_v4_camadas.LogicaNegocios.ICorredorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CorredorRepository implements ICorredorRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CorredorRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

        this.jdbcTemplate.execute("DROP TABLE corredores IF EXISTS");
        this.jdbcTemplate.execute("CREATE TABLE corredores("
                + "cpf VARCHAR(255), nome VARCHAR(255), genero VARCHAR(255), diaDn int, mesDn int, anoDn int, PRIMARY KEY(cpf))");

        create(new Corredor("10001287","Luiz",22,5,1987,"masculino"));    
    }

    @Override
    public Corredor create(Corredor corredor) {
        this.jdbcTemplate.update("INSERT INTO corredores(cpf,nome,diaDn,mesDn,anoDn,genero) VALUES (?,?,?,?,?,?)",
        corredor.getCpf(), corredor.getNome(), corredor.getDiaDn(), corredor.getMesDn(), corredor.getAnoDn(),
        corredor.getGenero());
        return corredor;
    }

    @Override
    public List<Corredor> recovery() {
        List<Corredor> resp = this.jdbcTemplate.query("SELECT * from corredores",
                (rs, rowNum) -> new Corredor(rs.getString("cpf"), rs.getString("nome"), rs.getInt("diaDn"),
                        rs.getInt("mesDn"), rs.getInt("anoDn"), rs.getString("genero")));
        return resp;
    }

    @Override
    public Corredor update(int id, Corredor object) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean delete(int id) {
        if(id == 0)
            this.jdbcTemplate.batchUpdate("DELETE from Corredores");
        else
            this.jdbcTemplate.batchUpdate("DELETE from Corredores WHERE cpf="+id);
        return true;
    }
}
