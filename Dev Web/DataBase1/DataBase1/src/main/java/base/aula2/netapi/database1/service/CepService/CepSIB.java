package base.aula2.netapi.database1.service.CepService;

import base.aula2.netapi.database1.Model.Endereco;
import base.aula2.netapi.database1.Util.EntityManagerUtil;
import base.aula2.netapi.database1.dao.EnderecoDaoImpl;
import jakarta.jws.WebService;

import java.util.List;

@WebService(endpointInterface = "base.aula2.netapi.database1.service.CepService.CepSei")
public class CepSIB implements CepSei{
    private EnderecoDaoImpl impl = new EnderecoDaoImpl(EntityManagerUtil.getManager());
    // -------- Metodos Automaticos --------
    @Override
    public Endereco AutoconfereCep(String Cep) {
        return impl.findByCep(Cep);
    }
    @Override
    public String AutoNovoCep(String Cep) {
        int retorno = impl.save(impl.findByCep(Cep));
        if(retorno == 1){
            return "Salvo com sucesso";
        }else if(retorno == 0){
            return "Erro de gravação, consulte os logs";
        }else
        return null;
    }
    @Override
    public String AutoUpdateCep(String Cep) {
        int retorno = impl.update(impl.findByCep(Cep));
        if(retorno == 1){
            return "Atualizado com sucesso";
        }else if(retorno == 0){
            return "Erro de gravação, consulte os logs";
        }else
            return null;
    }
    @Override
    public String AutoDeletCep(String Cep) {
        int retorno = impl.delete(impl.findByCep(Cep));
        if(retorno == 1){
            return "Deletado com sucesso";
        }else if(retorno == 0){
            return "Erro de gravação, consulte os logs";
        }else
            return null;
    }
    @Override
    public List<Endereco> GetAllCep() {
        return impl.findAll();
    }
    @Override
    public Endereco GetByIDCep(String Cep) {
        return impl.findByCep(Cep);
    }
    // ----- Metodos manuais ------------//
}
