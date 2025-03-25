package sistemaeleicao.menu;

import sistemaeleicao.Exceptions.ListException;
import sistemaeleicao.models.Funcionario;
import sistemaeleicao.services.CdtFunc;

import java.util.Scanner;

public class MenuPrincipal extends Menu {
    private final CdtFunc cadastrarFuncionario = new CdtFunc();

    @Override
    public void opcoesMenu() {
        System.out.println("-------------------------------");
        System.out.println("------SISTEMA FUNCIONARIOS-----");
        System.out.println("\n1.Adicionar um novo funcionário");
        System.out.println("2.Exibir todos os funcionários ativos");
        System.out.println("3.Sair");
        System.out.print("\nInsira sua opção:");
    }

    @Override
    public void inserirOpcao(Scanner sc) {
        int inputEscolha = 0;

        do {
            opcoesMenu();

            try {
                inputEscolha = Integer.parseInt(sc.nextLine());
                switch (inputEscolha){
                    case 1 -> CdtFunc.adicionarFuncionario(sc);
                    case 2 -> {
                        try {
                            CdtFunc.listarFuncionarios(sc);
                        }
                        catch (NumberFormatException e){
                            System.out.println("Erro: "+e.getMessage());
                        }
                    }
                    case 3 -> {
                        System.out.println("saindo...");
                    }
                }
            }
            catch (IllegalArgumentException e){
                System.out.println("Erro: "+ e.getMessage());
            }
        } while (inputEscolha != 3);
    }
}
