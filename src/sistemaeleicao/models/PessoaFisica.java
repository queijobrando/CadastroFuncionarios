package sistemaeleicao.models;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public abstract class PessoaFisica {
    private String nome;
    private Date dataDeNascimento;
    private String cpf;

    public PessoaFisica(){

    }

    public PessoaFisica(String nome, Date dataDeNascimento, String cpf) {
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public Integer calcularIdade(){
        LocalDate nascimento = dataDeNascimento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate hoje = LocalDate.now();

        return Period.between(nascimento, hoje).getYears();
    }

}

