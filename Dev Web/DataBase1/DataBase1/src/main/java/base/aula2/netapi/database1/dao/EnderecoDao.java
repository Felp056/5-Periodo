package base.aula2.netapi.database1.dao;

import base.aula2.netapi.database1.Model.Endereco;

import java.util.List;

public interface EnderecoDao {
    int save(Endereco edereco);
    int update(Endereco edereco);
    int delete(Endereco edereco);

    Endereco findById(Long id);
    List<Endereco> findAll();
}
