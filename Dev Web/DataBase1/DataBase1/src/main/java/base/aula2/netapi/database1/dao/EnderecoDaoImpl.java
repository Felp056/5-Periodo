package base.aula2.netapi.database1.dao;

import base.aula2.netapi.database1.Model.Endereco;
import base.aula2.netapi.database1.Model.Usuario;
import base.aula2.netapi.database1.Util.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class EnderecoDaoImpl implements EnderecoDao{
    private EntityManager em = EntityManagerUtil.getManager();

    public EnderecoDaoImpl(EntityManager em)
    {
        this.em = em;
    }

    @Override
    public void save(Endereco endereco) {
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        em.persist(endereco);
        trans.commit();
        System.out.println("Endereco salvo com sucesso!");
    }

    @Override
    public void update(Endereco endereco) {
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        em.merge(endereco);
        trans.commit();
        System.out.println("Endereco atualizado com sucesso!");
    }

    @Override
    public void delete(Endereco endereco) {
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        em.remove(endereco);
        trans.commit();
        System.out.println("Endereco removido com sucesso!");
    }

    @Override
    public Endereco findById(Long id) {
        return em.find(Endereco.class, id);
    }

    @Override
    public List<Endereco> findAll() {
        return em.createQuery("Select u From Endereco u", Endereco.class).getResultList();
    }
}
