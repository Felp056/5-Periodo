package base.aula2.netapi.database1.service;

import jakarta.xml.ws.Endpoint;

public class UsuarioPublisehr {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/usuario",new UsuarioSIB());
        System.out.println("usuario endpoitn publicado com sucesso");
    }
}
