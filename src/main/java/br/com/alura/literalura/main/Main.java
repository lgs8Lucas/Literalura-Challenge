package br.com.alura.literalura.main;

import br.com.alura.literalura.models.Author;
import br.com.alura.literalura.models.Book;
import br.com.alura.literalura.models.GutendexData;
import br.com.alura.literalura.services.APIConsumption;
import br.com.alura.literalura.services.ConvertData;

import java.util.Scanner;

public class Main {
    private final ConvertData convertData = new ConvertData();
    private final Scanner sc = new Scanner(System.in);

    public void showMenu(){
        int opt = 1;
        while (opt != 0){
            System.out.println("\n ----------");
            System.out.println("""
                    1- Buscar livro pelo título
                    
                    0- Sair
                    """);
            opt = sc.nextInt();
            sc.nextLine();
            switch (opt){
                case 1:
                    searchBook();
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
        System.out.println("Programa Finalizado");
    }

    private void searchBook() {
        System.out.print("Digite o nome do livro: ");
        var bookName = sc.nextLine();
        try{
            var res = APIConsumption.getData("https://gutendex.com/books?search="+bookName.replace(" ","+"));
            GutendexData data = convertData.getData(res, GutendexData.class);
            Author author = new Author(data.books().getFirst().authors().getFirst());
            Book book = new Book(data.books().getFirst(), author);

            System.out.println(book);
        }catch (RuntimeException e){
            System.out.println("Erro ao buscar livro! Tente novamente mais tarde");
        }
    }
}
