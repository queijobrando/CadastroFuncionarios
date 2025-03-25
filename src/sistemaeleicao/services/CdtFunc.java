package sistemaeleicao.services;

import sistemaeleicao.enums.Cargos;
import sistemaeleicao.models.Funcionario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CdtFunc {
    List<Funcionario> listafuncionarios = new ArrayList<>();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private static String getNomeFuncionario(Scanner sc){
        do {
            System.out.print("Nome: ");
            String nome = sc.nextLine();

            if (nome.isEmpty()){
                System.out.println("ERRO: O campo deve ser preenchido. Tente novamente");
            } else {
                return nome;
            }
        }while (true);
    }

    private Date getDataNascimentoFuncionario(Scanner sc){
        do {
            try {
                System.out.print("Data de nascimento (dd/mm/yyyy): ");
                Date data = sdf.parse(sc.nextLine());

                if (data == null) {
                    System.out.println("ERRO: O campo deve ser preenchido. Tente novamente");
                } else {
                    return data;
                }
            }
            catch (ParseException | IllegalArgumentException e){
                System.out.println("Erro: "+ e.getMessage());
            }
        }while (true);
    }

    private String getCpfFuncionario(Scanner sc){
        do {
            System.out.print("CPF: ");
             String cpf = sc.nextLine().trim();
            if (cpf.isEmpty()){
                System.out.println("ERRO: O campo deve ser preenchido. Tente novamente");
            } else if (!cpf.matches("\\d{11}")) {
                System.out.println("ERRO: CPF Inválido, digite os 11 numeros corretamente");
            } else {
                return cpf;
            }
        }while (true);
    }

    private String getCargoFuncionario(Scanner sc){
        do {
            System.out.print("Cargo: ");
            String cargo = sc.nextLine().toUpperCase();
            if (cargo.isEmpty()){
                System.out.println("ERRO: O campo deve ser preenchido. Tente novamente");
            } else {
                try {
                    Cargos.valueOf(cargo.toUpperCase());
                    return cargo.toUpperCase();
                }
                catch (IllegalArgumentException e){
                    System.out.println("ERRO: Cargo não encontrado, tente novamente");
                }
            }
        }while (true);
    }

    //RETORNA NOVO FUNCIONARIO
    public void adicionarFuncionario(Scanner sc){
        String nome = getNomeFuncionario(sc);
        Date data = getDataNascimentoFuncionario(sc);
        String cpf = getCpfFuncionario(sc);
        String cargo = getCargoFuncionario(sc);
        listafuncionarios.add(new Funcionario(nome, data, cpf, cargo));

    }



    public void listarFuncionarios(Scanner sc){
        int menuescolha = 0;
        do {
            System.out.println("\nFUNCIONARIOS REGISTRADOS: ");
            if (listafuncionarios.isEmpty()){
                System.out.println("Lista vazia");;
            } else {
                for (Funcionario i : listafuncionarios) {
                    System.out.println(i);
                }
            }

            System.out.print("Para voltar digite [1]: ");
            try {
                menuescolha = Integer.parseInt(sc.nextLine());
                if (menuescolha == 1){
                    System.out.println("Voltando...");
                    break;
                } else {
                    System.out.print("Opção inválida, digite novamente: ");
                }
            }
            catch (NumberFormatException e){
                System.out.println("Entrada inválida!");
            }

        }while (true);


    }
}
