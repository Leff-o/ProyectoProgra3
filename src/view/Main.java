package view;

import java.util.Scanner;

public class Main {
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

    }

    public void menu(){
        int option;
         System.out.println("Bienvenidos a CineparkAguazul");
        System.out.println("1. Ver películas en cartelera\n2. Comprar entradas\n3. Salir");
        option = Integer.parseInt(sc.nextLine());
        switch (option){
            case 1:
                System.out.println("opcion 1");
                break;
            case 2:
                System.out.println("opcion 2");
                break;
            case 3:
                System.out.println("Hasta pronto\n");
                System.exit(0);
                break;
        }
    }
}
