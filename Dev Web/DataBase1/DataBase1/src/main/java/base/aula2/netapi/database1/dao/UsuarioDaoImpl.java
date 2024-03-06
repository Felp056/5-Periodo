package base.aula2.netapi.database1.dao;

import base.aula2.netapi.database1.Model.Usuario;
import base.aula2.netapi.database1.Util.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class UsuarioDaoImpl implements UsuarioDao{

    private EntityManager em = EntityManagerUtil.getManager();

    public UsuarioDaoImpl(EntityManager em)
    {
        this.em = em;
    }

    @Override
    public void save(Usuario usuario) {
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        em.persist(usuario);
        trans.commit();
        System.out.println("Usuário "+ usuario.getNome() +" salvo com sucesso!");
    }

    @Override
    public void update(Usuario usuario) {

    }

    @Override
    public void delete(Usuario usuario) {

    }

    @Override
    public Usuario findById(Long id) {
        return null;
    }

    @Override
    public List<Usuario> findAll() {
        return null;
    }
}
