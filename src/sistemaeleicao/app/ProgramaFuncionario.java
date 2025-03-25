package sistemaeleicao.app;


import sistemaeleicao.menu.MenuPrincipal;

import java.util.Scanner;

public class programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MenuPrincipal menuPrincipal = new MenuPrincipal();

        System.out.println("Iniciando o programa...\n");

        try {
            menuPrincipal.inserirOpcao(sc);
        }
        catch (Exception e){
            System.out.println("Erro inexperado: "+e.getMessage());
        }

    }
}
