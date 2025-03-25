/*package sistemaeleicao.services;


import sistemaeleicao.models.Funcionario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CadastrarFuncionario {
    List<Funcionario> listafuncionarios = new ArrayList<>();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public void adicionarFuncionario(Scanner sc) {
        try {
            System.out.println("Dados do funcionrio(a):");
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("Data de nascimento (dd/mm/yyyy): ");
            Date data = sdf.parse(sc.nextLine());
            System.out.print("CPF: ");
            long cpf = Long.parseLong(sc.nextLine());
            System.out.print("Cargo: ");
            String cargo = sc.nextLine().toUpperCase();
            try {
                listafuncionarios.add(new Funcionario(nome, data, cpf, cargo));
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        catch (ParseException | IllegalArgumentException e){
            System.out.println("Erro: "+ e.getMessage());
        }
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

