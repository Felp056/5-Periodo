package base.aula2.netapi.database1.dao;

import base.aula2.netapi.database1.Model.Endereco;

import java.util.List;

public interface EnderecoDao {
    void save(Endereco edereco);
    void update(Endereco edereco);
    void delete(Endereco edereco);

    Endereco findById(Long id);
    List<Endereco> findAll();
}
