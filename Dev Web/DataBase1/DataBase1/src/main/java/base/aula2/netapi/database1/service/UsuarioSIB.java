package base.aula2.netapi.database1.service;

import base.aula2.netapi.database1.Model.Usuario;
import base.aula2.netapi.database1.Util.EntityManagerUtil;
import base.aula2.netapi.database1.dao.UsuarioDao;
import base.aula2.netapi.database1.dao.UsuarioDaoImpl;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.persistence.EntityManager;

@WebService(endpointInterface = "base.aula2.netapi.database1.service.UsuarioSei")
public class UsuarioSIB implements UsuarioSei{
    @Override
    public String boasVindas(String Nome) {
        return "Bem vindo "+Nome+"!";
    }

    @Override
    public Usuario consultaUsuario(Long idUsuario) {
        UsuarioDao usdao = new UsuarioDaoImpl(EntityManagerUtil.getManager());
        Usuario user = usdao.findById(idUsuario);
        return user;
    }
}
