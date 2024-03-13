package base.aula2.netapi.database1.service.CepService;

import base.aula2.netapi.database1.Model.Endereco;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class HttpCaller {
    public static Endereco getViaCep(String cep) throws Exception{
        URL url = new URL("http://viacep.com.br/ws/"
                +cep.replace("-", "")
                .replace(".", "")
                +"/xml/");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(url.openStream()));

        String inputLine;
        String result = "";
        while ((inputLine = in.readLine()) != null)
            result += inputLine;

        in.close();
        //  return result;
        Endereco objCep = new Endereco();
        objCep = Endereco.unmarshalFromString(result);

        return objCep;
    }
}
