package br.com.alura.literalura.main;

import br.com.alura.literalura.models.GutendexData;
import br.com.alura.literalura.services.APIConsumption;
import br.com.alura.literalura.services.ConvertData;

public class Main {
    private final ConvertData convertData = new ConvertData();

    public void showMenu(){
        System.out.println("LITERALURA");
        var res = APIConsumption.getData("https://gutendex.com/books?search=dom+casmurro");
        System.out.println("RES "+res);
        GutendexData data = convertData.getData(res, GutendexData.class);
        System.out.println(data);
    }
}
