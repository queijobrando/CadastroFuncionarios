package sistemaeleicao.models;

import sistemaeleicao.enums.Cargos;

import java.util.Date;

public class Funcionario extends PessoaFisica {
    private Cargos cargo;

    public Funcionario(String nome, Date dataDeNascimento, String cpf, String cargo) {
        super(nome, dataDeNascimento, cpf);
        try {
            this.cargo = Cargos.valueOf(cargo.toUpperCase());
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Cargo Inválido, "+ cargo);
        }
    }


    public Cargos getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + ", Cargo: " + cargo + ", Idade: " + calcularIdade();
    }
}

