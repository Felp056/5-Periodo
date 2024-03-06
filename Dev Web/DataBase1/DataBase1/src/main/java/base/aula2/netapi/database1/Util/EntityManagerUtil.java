package base.aula2.netapi.database1.Util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerUtil {
    private static EntityManagerFactory efm;
    private static EntityManager em;

    private EntityManagerUtil() {}

    public static EntityManagerFactory getEntityManagerFactory() {
        if (efm == null) {
            efm = Persistence.createEntityManagerFactory("HibernateJava");
            System.out.println("Conexão aberta");
        }
        return efm;
    }

    public static EntityManager getManager() {
        if (em == null || !em.isOpen()) {
            em = efm.createEntityManager();
            System.out.println("Entity manager aberta");
        }
        return em;
    }
    public static void closeEntityMangerFactory(){
        try {
            if (efm != null && efm.isOpen()) {
                efm.close();
                System.out.println("Conexão fechada");
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage() + "  \n"+ ex.getStackTrace());
        }
    }

}