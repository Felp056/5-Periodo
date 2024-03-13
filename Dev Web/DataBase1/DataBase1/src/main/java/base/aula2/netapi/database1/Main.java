package base.aula2.netapi.database1;

import base.aula2.netapi.database1.Model.Endereco;
import base.aula2.netapi.database1.Model.Usuario;
import base.aula2.netapi.database1.Util.EntityManagerUtil;
import base.aula2.netapi.database1.dao.UsuarioDao;
import base.aula2.netapi.database1.dao.UsuarioDaoImpl;
import base.aula2.netapi.database1.service.CepService.HttpCaller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

public class Main {
    public static void main(String[] args){
        //salvarUsuario();
        //AtualizarUsuario(1);
        //DeletUser(1);
        //GetByIdUser(1);
        //GetAllFromTable();
       try {
            HttpCaller.getViaCep("85807700");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
    public static void GetByIdUser(long id)
    {
        try{
            EntityManagerUtil.getEntityManagerFactory();
            UsuarioDao usDao = new UsuarioDaoImpl(EntityManagerUtil.getManager());
            Usuario user = usDao.findById(id);
            EntityManagerUtil.closeEntityMangerFactory();
            System.out.println(user.getNome()+" "+user.getId()+" "+user.getLogin());
        }catch (Exception ex)
        {
            System.out.println(ex.getMessage() + " \n"+ ex.getStackTrace());
        }

    }


    public static void AtualizarUsuario(long id){
        try{
            EntityManagerUtil.getEntityManagerFactory();
            UsuarioDao usDao = new UsuarioDaoImpl(EntityManagerUtil.getManager());
            Usuario user = usDao.findById(id);
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

    public static void GetAllFromTable()
    {
        try{
            EntityManagerUtil.getEntityManagerFactory();
            UsuarioDao usDao = new UsuarioDaoImpl(EntityManagerUtil.getManager());
            List<Usuario> listUSer = usDao.findAll();
            EntityManagerUtil.closeEntityMangerFactory();
            String user = null;
            for(Usuario usr : listUSer){
              user += usr.getId()+" "+usr.getNome() + " "+ usr.getLogin()+"\n";
            }
            System.out.println(user);
        }catch (Exception ex)
        {
            System.out.println(ex.getMessage() + " \n"+ ex.getStackTrace());
        }
    }

    public static void DeletUser(long id)
    {
        try{
            EntityManagerUtil.getEntityManagerFactory();
            UsuarioDao usDao = new UsuarioDaoImpl(EntityManagerUtil.getManager());
            Usuario user = usDao.findById(id);
            usDao.delete(user);
            EntityManagerUtil.closeEntityMangerFactory();
        }catch (Exception ex)
        {
            System.out.println(ex.getMessage() + " \n"+ ex.getStackTrace());
        }
    }
}

