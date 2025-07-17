package med.voll.api.domain.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoModel {
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String uf;
    private String complemento;
    private String cep;


    public EnderecoModel(Endereco endereco) {
        this.logradouro = endereco.logradouro();
        this.numero = endereco.numero();
        this.bairro = endereco.bairro();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
        this.complemento = endereco.complemento();
        this.cep = endereco.cep();
    }

    public void atualizarInformacoes(EnderecoModel enderco) {
        if (enderco.logradouro != null) {
            this.logradouro = enderco.logradouro;
        }
        if (enderco.numero != null) {
            this.numero = enderco.numero;
        }
        if (enderco.bairro != null) {
            this.bairro = enderco.bairro;
        }
        if (enderco.cidade != null) {
            this.cidade = enderco.cidade;
        }
        if (enderco.uf != null) {
            this.uf = enderco.uf;
        }
        if (enderco.complemento != null) {
            this.complemento = enderco.complemento;
        }
        if (enderco.cep != null) {
            this.cep = enderco.cep;
        }
    }
}
