package base.aula2.netapi.database1.service.CepService;

import base.aula2.netapi.database1.Model.Endereco;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
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
        result = result.replace("-", "");
        Endereco objCep = unmarshalFromString(result);

        return objCep;
    }

    public static Endereco unmarshalFromString(String stringxml)
        throws Exception{
        JAXBContext content = JAXBContext.newInstance(Endereco.class);
        Unmarshaller unmarshaller = content.createUnmarshaller();
        StringReader reader = new StringReader(stringxml);
        return (Endereco) unmarshaller.unmarshal(reader);
    }

}
