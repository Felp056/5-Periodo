package base.aula2.netapi.database1.service;

import base.aula2.netapi.database1.service.UserService.UsuarioSIB;
import jakarta.xml.ws.Endpoint;

public class UsuarioPublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/usuario",new UsuarioSIB());
        System.out.println("usuario endpoitn publicado com sucesso");
    }
}
