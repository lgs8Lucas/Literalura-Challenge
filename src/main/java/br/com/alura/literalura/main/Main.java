package br.com.alura.literalura.main;

import br.com.alura.literalura.services.APIConsumption;

public class Main {
    public void showMenu(){
        System.out.println("LITERALURA");
        String res = APIConsumption.getData("https://gutendex.com/books?search=dom+casmurro");
        System.out.println("RES "+res);
    }
}
