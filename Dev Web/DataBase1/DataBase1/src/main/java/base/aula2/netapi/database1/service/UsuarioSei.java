package base.aula2.netapi.database1.service;

import base.aula2.netapi.database1.Model.Usuario;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService
public interface UsuarioSei {
    @WebMethod
    String boasVindas(@WebParam(name = "nome") String Nome);
    Usuario consultaUsuario(@WebParam(name = "idUsuario")Long idUsuario);

}
