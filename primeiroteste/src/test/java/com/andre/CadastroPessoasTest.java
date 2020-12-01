package com.andre;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CadastroPessoasTest {

    @Test
    @DisplayName("Deve criar o Cadastro de pessoas.")
    public void deveCriarOCadastroDePessoas(){
        // Cenário e Execução
        CadastroPessoas cadastro = new CadastroPessoas();

        //Verificação
        Assertions.assertThat(cadastro.getPessoas()).isEmpty();
    }

    @Test
    @DisplayName("Deve adicionar uma pessoa.")
    public void deveAdicionarUmaPessoa(){
        // Cenário
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Andre");

        // Execução
        cadastroPessoas.adicionar(pessoa);

        //Verificação
        Assertions.assertThat(cadastroPessoas.getPessoas())
                .isNotEmpty()
                .hasSize(1)
                .contains(pessoa);
    }

    @Test
    @DisplayName("Não deve adicionar uma pessoa com o nome vazio.")
    public void naoDeveAdicionarPessoaComNomeVazio(){
        // Cenário
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        // Execuçao
        org.junit.jupiter.api.Assertions
                .assertThrows(PessoaSemNomeException.class, () -> cadastroPessoas.adicionar(pessoa) );
    }

    @Test
    @DisplayName("Deve remover uma pessoa.")
    public void deveRemoverUmaPessoa(){
        // Cenário
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("André");
        cadastroPessoas.adicionar(pessoa);

        // Execução
        cadastroPessoas.remover(pessoa);

        // Verificação
        Assertions.assertThat(cadastroPessoas.getPessoas()).isEmpty();
    }

    @Test
    @DisplayName("Deve lançar erro ao tentar remover uma pessoa inexistente.")
    public void deveLancarErroAoTentarRemoverUmaPessoaInexistente(){
        // Cenário
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        // Execução
        org.junit.jupiter.api.Assertions
                .assertThrows(CadastroVazioException.class, () ->  cadastroPessoas.remover(pessoa) );
    }
}
