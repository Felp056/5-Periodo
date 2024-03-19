package base.aula2.netapi.database1.dao;

import base.aula2.netapi.database1.Model.Endereco;
import base.aula2.netapi.database1.Util.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class EnderecoDaoImpl implements EnderecoDao{
    private EntityManager em = EntityManagerUtil.getManager();

    public EnderecoDaoImpl(EntityManager em)
    {
        this.em = em;
    }

    @Override
    public int save(Endereco endereco) {
            try {
                Endereco teste = findByCep(endereco.getCep());
                if (teste != null) {
                    throw new Exception("Registro já existente");
                }
            }catch (Exception ex){
                try {
                    EntityTransaction trans = em.getTransaction();
                    trans.begin();
                    em.persist(endereco);
                    trans.commit();
                    return 1;
                }catch (Exception Nex){
                    System.out.println(Nex);
                    return 0;
                }
            }
            return 0;
    }

    @Override
    public int update(Endereco endereco) {
        try {
            EntityTransaction trans = em.getTransaction();
            trans.begin();
            em.merge(endereco);
            trans.commit();
           return 1;
        }catch (Exception ex){
            System.out.println(ex);
            return 0;
        }
    }

    @Override
    public int delete(Endereco endereco) {
       try{
           EntityTransaction trans = em.getTransaction();
           trans.begin();
           em.remove(endereco);
           trans.commit();
           return 1;
       }catch (Exception ex){
           System.out.println(ex);
           return 0;
       }
    }

    @Override
    public Endereco findById(Long id) {
        return em.find(Endereco.class, id);
    }

    @Override
    public Endereco findByCep(String cep){return em.createQuery("select u From Endereco u WHERE u.cep like \'"+cep+"\'", Endereco.class).getSingleResult();}

    @Override
    public List<Endereco> findAll() {
        return em.createQuery("Select u From Endereco u", Endereco.class).getResultList();
    }
}
