package base.aula2.netapi.database1.dao;

import base.aula2.netapi.database1.Model.Usuario;

import java.util.List;

public interface UsuarioDao {
    void save(Usuario usuario);
    void update(Usuario usuario);
    void delete(Usuario usuario);

    Usuario findById(Long id);
    List<Usuario> findAll();
}
