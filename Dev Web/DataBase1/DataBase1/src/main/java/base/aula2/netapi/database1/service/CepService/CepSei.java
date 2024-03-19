package base.aula2.netapi.database1.service.CepService;

import base.aula2.netapi.database1.Model.Endereco;
import base.aula2.netapi.database1.Util.EntityManagerUtil;
import base.aula2.netapi.database1.dao.EnderecoDaoImpl;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface CepSei {
    @WebMethod
    public Endereco AutoconfereCep(@WebParam(name = "Cep") String Cep);
    public String AutoNovoCep(@WebParam(name = "Cep") String Cep);
    public String AutoUpdateCep(@WebParam(name = "Cep") String Cep);
    public String AutoDeletCep(@WebParam(name = "Cep")String Cep);
    public List<Endereco> GetAllCep();
    public Endereco GetByIDCep(@WebParam(name = "Cep") String Cep);
    public String ManuNovoCep(@WebParam(name = "Cep") String cep, @WebParam(name = "Logradouro")String logr,
                         @WebParam(name = "Complemento")String Compl,  @WebParam(name = "Bairro")String bairro,
                         @WebParam(name = "localidade")String localidade,  @WebParam(name = "Uf")String uf,
                         @WebParam(name = "Ibge")String IBGE,  @WebParam(name = "Gia")String gia,
                         @WebParam(name = "ddd")String ddd,  @WebParam(name = "siafi")String siafi);
    public String ManuUpdateCep(@WebParam(name = "Cep") String cep, @WebParam(name = "Logradouro")String logr,
                           @WebParam(name = "Complemento")String Compl,  @WebParam(name = "Bairro")String bairro,
                           @WebParam(name = "Localidade")String localidade,  @WebParam(name = "Uf")String uf,
                           @WebParam(name = "Ibge")String IBGE,  @WebParam(name = "Gia")String gia,
                           @WebParam(name = "ddd")String ddd,  @WebParam(name = "siafi")String siafi);
    public String ManuDeletCep(@WebParam(name = "Cep")String Cep);
    public String ProcuraCep(@WebParam(name = "Cep")String Cep);


}
