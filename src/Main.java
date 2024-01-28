import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    //variaveis globais
    public static Scanner input_text = new Scanner(System.in);
    public static Scanner input_number = new Scanner(System.in);
    public static DecimalFormat df2 = new DecimalFormat("0.00");
    public static final int TEMPO = 2500;

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenu();
            System.out.print("\nOpcao: ");
            opcao = input_number.nextInt();
            limpa();

            switch (opcao){
                case 1: exercicio09(); break;
                case 2: exercicio10(); break;
                case 3: exercicio11(); break;
                case 4: exercicio21(); break;
                case 0: sair(); break;

                default:
                    System.out.println("--- Opcao invalida ---");
                    aguarde(TEMPO);
                    break;
            }
            limpa();
        }while(opcao != 0);
    }

    //funcoes
    public static void exibirMenu(){
        System.out.println("\n\t***** TRABALHO 11 MIGUEL MARTINS *****\n");
        System.out.println(">>> MENU <<<");
        System.out.println("1 - Exercicio salario com reajuste");
        System.out.println("2 - Exercicio valor carros");
        System.out.println("3 - Exercicio salario com comissoes");
        System.out.println("4 - Exercicio xadrez");
        System.out.println("\n0 - Sair");
    }

    public static void exercicio09(){
        double salario, percentual, salarioFinal;

        System.out.println(">>> SALARIO COM REAJUSTE <<<\n");
        System.out.print("Digite o salario do funcionario: ");
        salario = input_number.nextDouble();
        System.out.print("Digite o percentual de reajuste: ");
        percentual = input_text.nextDouble();

        salarioFinal = ((salario * percentual)/100) + salario;

        aCalcular();
        limpa();
        if(salario < 740){
            System.out.println("O salario minimo em Portugal e de setecentos e quarenta (740) euros. Deve colocar um valor igual ou superior a este.");
            aguarde(3500);
        }
        else if (percentual < 0){
            System.out.println("O percentual de reajuste nao pode ser inferior a zero.");
            aguarde(TEMPO);
        }
        else if (percentual > 100){
            System.out.println("O percentual de reajuste nao pode ser superior a cem (100).");
            aguarde(TEMPO);
        }
        else {
            System.out.println("O salario final com reajuste e: (" + df2.format(salarioFinal) + " €)");
            aguarde(4000);
        }
    }

    public static void exercicio10(){
        double custoFabrica, percentDist, impostos, valorFinal;

        System.out.println(">>> VALOR DOS CARROS <<<\n");
        System.out.print("Digite o custo de fabrica do automovel: ");
        custoFabrica = input_number.nextDouble();

        percentDist = (custoFabrica * 28)/100;
        impostos = (custoFabrica * 45)/100;

        valorFinal = custoFabrica + percentDist + impostos;

        aCalcular();
        limpa();
        if(custoFabrica <= 0){
            System.out.println("O custo de fabrica deve ser superior a zero (0) euros.");
        }
        else {
            System.out.println("O valor final do veiculo para o consumidor e: (" + df2.format(valorFinal) + " €)");
        }
        enter();
    }

    public static void exercicio11(){
        double salario, totalVendas, comissaoPorCarro, salarioFinal, comissaoVendas, adicionalVendasCarro;
        int carrosVendidos;

        System.out.println(">>> SALARIO COM COMISSOES <<<\n");
        System.out.print("Digite o valor (em euros) do salario fixo do colaborador: ");
        salario = input_number.nextDouble();
        System.out.print("Numero de carros vendidos pelo colaborador: ");
        carrosVendidos = input_number.nextInt();
        System.out.print("Valor (em euros) que o colaborador recebe por cada carro vendido: ");
        comissaoPorCarro = input_number.nextDouble();
        System.out.print("Valor (em euros) total das vendas efetuadas pelo colaborador: ");
        totalVendas = input_number.nextDouble();

        comissaoVendas = (totalVendas * 5)/100;
        adicionalVendasCarro = carrosVendidos * comissaoPorCarro;

        salarioFinal = salario + comissaoVendas + adicionalVendasCarro;

        aCalcular();
        limpa();
        if(salario < 740){
            System.out.println("O salario minimo em Portugal e de setecentos e quarenta (740) euros. Deve colocar um valor igual ou superior a este.");
            aguarde(3500);
        }
        else if(carrosVendidos < 0){
            System.out.println("O numero de carros vendidos nao pode ser negativo. Coloque um numero igual ou superior a zero (0).");
            aguarde(3500);
        }
        else if(comissaoPorCarro < 0){
            System.out.println("O valor da comissao nao pode ser negativo. Coloque um numero igual ou superior a zero (0).");
            aguarde(3500);
        }
        else if(totalVendas < 0){
            System.out.println("O valor total de vendas nao pode ser negativo. Coloque um numero igual ou superior a zero (0).");
            aguarde(3500);
        }
        else {
            System.out.println("O valor final do salario do colaborador e: (" + df2.format(salarioFinal) + " €)");
            enter();
        }
    }

    public static void exercicio21(){
        int horaInicio, horaFim, tempoJogo;

        System.out.println(">>> DURACAO PARTIDA XADREZ <<<\n");
        System.out.print("Digite a hora de INICIO da partida de xadrez (ignore os minutos e os segundos): ");
        horaInicio = input_number.nextInt();
        System.out.print("Digite a hora de FIM da partida de xadrez (ignore os minutos e os segundos): ");
        horaFim = input_number.nextInt();

        if(horaFim < horaInicio){
            horaInicio = (24 - horaInicio);
            tempoJogo = horaFim + horaInicio;
        }

        else{
            tempoJogo = horaFim - horaInicio;
        }

        aCalcular();
        limpa();

        if(tempoJogo > 24){
            System.out.println("O tempo maximo de uma partida nao pode exceder as vinte e quatro (24) horas.");
            aguarde(3000);
        }
        else if(horaFim < 0 || horaInicio < 0 || horaFim > 24 || horaInicio > 24){
            System.out.println("As horas devem estar compreendidas entre zero (0) e vinte e quatro (24).");
            aguarde(3000);
        }
        else{
            System.out.println("A duracao do jogo de Xadrez foi de (" + tempoJogo + ") horas\n");
            enter();
        }

    }

    public static void sair(){
        System.out.print("A sair");
        for(int i = 0; i < 3; i++){
            System.out.print(".");
            aguarde(200);
        }
        aguarde(1000);
    }

    public static void limpa(){
        for(int i=0; i<25; i++){
            System.out.println();
        }
    }

    public static void aguarde(int ms){
        try{
            Thread.sleep(ms);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void enter(){
        System.out.println("Pressione <ENTER> para continuar...");
        input_text.nextLine();
    }

    public static void aCalcular(){
        System.out.print("A calcular");
        for(int g = 0; g < 3; g++){
            System.out.print(".");
            aguarde(200);
        }
        aguarde(1000);
    }
}