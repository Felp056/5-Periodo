package base.aula2.netapi.database1.service.CepService;

import base.aula2.netapi.database1.Model.Endereco;
import base.aula2.netapi.database1.Util.EntityManagerUtil;
import base.aula2.netapi.database1.dao.EnderecoDao;
import base.aula2.netapi.database1.dao.EnderecoDaoImpl;
import jakarta.jws.WebService;

import javax.swing.*;
import java.util.List;

@WebService(endpointInterface = "base.aula2.netapi.database1.service.CepService.CepSei")
public class CepSIB implements CepSei{
    private EnderecoDaoImpl implGG = new EnderecoDaoImpl(EntityManagerUtil.getManager());
    // -------- Metodos Automaticos --------
    @Override
    public Endereco AutoconfereCep(String Cep) {
        return implGG.findByCep(Cep);
    }
    @Override
    public String AutoNovoCep(String Cep) {
        try {
            int retorno = implGG.save(HttpCaller.getViaCep(Cep));
            if (retorno == 1) {
                return "Salvo com sucesso";
            } else if (retorno == 0) {
                return "Erro de gravação, consulte os logs";
            }
        }catch (Exception ex){
            return ex.getMessage();
        }
        return null;
    }
    public Endereco AutoNovoCepRet(String Cep) {
        try {

            int retorno = implGG.save(HttpCaller.getViaCep(Cep));
            if (retorno == 1) {
                return implGG.findByCep(Cep);
            } else if (retorno == 0) {
                throw new Exception("Erro ao gravar");
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }
    @Override
    public String AutoUpdateCep(String Cep) {
        int retorno = implGG.update(implGG.findByCep(Cep));
        if(retorno == 1){
            return "Atualizado com sucesso";
        }else if(retorno == 0){
            return "Erro de gravação, consulte os logs";
        }else
            return null;
    }
    @Override
    public String AutoDeletCep(String Cep) {
        try {
            int retorno = implGG.delete(implGG.findByCep(Cep));
            if (retorno == 1) {
                return "Deletado com sucesso";
            } else if (retorno == 0) {
                return "Erro de gravação, consulte os logs";
            }
        }catch (Exception ex){
            System.out.println(ex);
        }
        return null;
    }
    @Override
    public List<Endereco> GetAllCep() {
        return implGG.findAll();
    }
    @Override
    public Endereco GetByIDCep(String Cep) {
        return implGG.findByCep(Cep);
    }


    // ----- Metodos manuais ------------//

    @Override
    public String ManuNovoCep(String cep, String logr, String Compl, String bairo, String localidade, String uf, String IBGE, String gia, String ddd, String siafi) {
        try {
        Endereco end = new Endereco();
        end.setCep(cep);
        end.setLogradouro(logr);
        end.setComplemento(Compl);
        end.setBairro(bairo);
        end.setLocalidade(localidade);
        end.setUf(uf);
        end.setIbge(IBGE);
        end.setGia(gia);
        end.setDdd(ddd);
        end.setSiafi(siafi);
            int ret = implGG.save(end);
            if(ret != 0){
                return "Salvo com sucesso";
            }
        }catch (Exception ex){
            System.out.println(ex);
        }
        return "Erro ao processar";
    }

    @Override
    public String ManuUpdateCep(String cep, String logr, String Compl, String bairo, String localidade, String uf, String IBGE, String gia, String ddd, String siafi) {
        try {
            Endereco end = implGG.findByCep(cep);
            end.setLogradouro(logr);
            end.setComplemento(Compl);
            end.setBairro(bairo);
            end.setLocalidade(localidade);
            end.setUf(uf);
            end.setIbge(IBGE);
            end.setGia(gia);
            end.setDdd(ddd);
            end.setSiafi(siafi);
            int ret = implGG.update(end);
            if(ret != 0){
                return "Atualizado com sucesso";
            }
        }catch (Exception ex){
            System.out.println(ex);
        }
        return "Erro ao processar";
    }

    @Override
    public String ManuDeletCep(String Cep) {
        try {
            int Ret = implGG.delete(implGG.findByCep(Cep));
            if(Ret != 0){
                return "Deletado com sucesso";
            }
        }catch (Exception ex){
            return ex.getMessage();
        }
        return "";
    }

    public String ProcuraCep (String cep)
    {
        try {
            Endereco newCo = null;
            Endereco end = null;
            try {
                newCo = implGG.findByCep(cep);
            }catch (Exception ex){
                end = AutoNovoCepRet(cep);
            }
            if(newCo == null) {
                return end.toString();
            }else{
                return newCo.toString();
            }
        }catch (Exception ex){
            return ex.getMessage();
        }
    }
}
