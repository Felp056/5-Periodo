package aula2.org;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Endereço :\n " + getViaCep("8580000"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static String getViaCep(String cep) throws Exception {
        URL url = new URL("http://viacep.com.br/ws/"+cep.replace("-", "")
                .replace(".", "")+"/xml/");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(url.openStream())
        );

        String inputLine;
        String result = "";

        while ((inputLine = in.readLine()) != null)
            result += inputLine;

        in.close();

        Cep objCep =  Cep.unmarshalFromString(result);

        return objCep.toString();

    }
}