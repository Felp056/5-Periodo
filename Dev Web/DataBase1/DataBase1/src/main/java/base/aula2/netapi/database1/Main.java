package base.aula2.netapi.database1;

import base.aula2.netapi.database1.Model.Usuario;
import base.aula2.netapi.database1.Util.EntityManagerUtil;
import base.aula2.netapi.database1.dao.UsuarioDao;
import base.aula2.netapi.database1.dao.UsuarioDaoImpl;

public class Main {
    public static void main(String[] args){
        try{
            EntityManagerUtil.getEntityManagerFactory();
            UsuarioDao usDao = new UsuarioDaoImpl(EntityManagerUtil.getManager());
            Usuario user = new Usuario();
            user.setNome("Ze filipe");
            user.setLogin("Z-Flip");
            user.setSenha("123456");
            usDao.save(user);
            EntityManagerUtil.closeEntityMangerFactory();
        }catch (Exception ex)
        {
            System.out.println(ex.getMessage() + " \n"+ ex.getStackTrace());
        }
    }
}
