package aula2.org;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringReader;

@XmlRootElement(name="xmlcep")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class Cep {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;

    public static Cep unmarshalFromString (String stringXml)
            throws Exception {

        JAXBContext context = null;
        context = JAXBContext.newInstance(Cep.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        StringReader reader = new StringReader(stringXml);

        return (Cep) unmarshaller.unmarshal(reader);
    }

    @Override
    public String toString() {
        return "Cep{\n" +
                " cep='" + cep +  "\',\n" +
                " logradouro='" + logradouro + "\',\n" +
                " complemento='" + complemento + "\',\n" +
                " bairro='" + bairro + "\',\n" +
                " localidade='" + localidade + "\',\n" +
                " uf='" + uf + "\',\n" +
                " ibge='" + ibge + "\',\n" +
                " gia='" + gia + "\',\n" +
                " ddd='" + ddd + "\',\n" +
                " siafi='" + siafi + "\',\n" +
                '}';
    }
}