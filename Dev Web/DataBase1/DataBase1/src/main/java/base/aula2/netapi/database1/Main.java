package base.aula2.netapi.database1;

import base.aula2.netapi.database1.Model.Usuario;
import base.aula2.netapi.database1.Util.EntityManagerUtil;
import base.aula2.netapi.database1.dao.UsuarioDao;
import base.aula2.netapi.database1.dao.UsuarioDaoImpl;

public class Main {
    public static void main(String[] args){
        AtulizarUsuario();
    }
    public static void salvarUsuario(){
        try{
            EntityManagerUtil.getEntityManagerFactory();
            UsuarioDao usDao = new UsuarioDaoImpl(EntityManagerUtil.getManager());
            Usuario user = new Usuario();
            user.setNome("Ze filipe");
            user.setLogin("Z-Flip o update");
            user.setSenha("123456");
            usDao.save(user);
            EntityManagerUtil.closeEntityMangerFactory();
        }catch (Exception ex)
        {
            System.out.println(ex.getMessage() + " \n"+ ex.getStackTrace());
        }
    }

    public static void AtulizarUsuario(){
        try{
            EntityManagerUtil.getEntityManagerFactory();
            UsuarioDao usDao = new UsuarioDaoImpl(EntityManagerUtil.getManager());
            Usuario user = usDao.findById(1L);
            user.setNome("Ze filipe");
            user.setLogin("Z-Flip o update");
            user.setSenha("123456");
            usDao.update(user);
            EntityManagerUtil.closeEntityMangerFactory();
        }catch (Exception ex)
        {
            System.out.println(ex.getMessage() + " \n"+ ex.getStackTrace());
        }
    }
}

