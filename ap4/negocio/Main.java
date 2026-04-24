package ap4.negocio;

import java.util.List;
import java.util.Scanner;

import ap4.dados.*;

public class Main {
    public static void main(String[] args) {

        Zoologico z = new Zoologico();
        Scanner sc = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("\nSistema de gestao de Zoo");
            System.out.println("1- Cadastrar Viveiro");
            System.out.println("2- Cadastrar um aquario");
            System.out.println("3- Cadastrar Animal");
            System.out.println("4- Cadastrar um peixe");
            System.out.println("5- Alocar animal a um viveiro");
            System.out.println("6- Ver todos os aquarios");
            System.out.println("7- Ver viveiros comuns");
            System.out.println("0- Sair");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Comprimento: ");
                    float comp = sc.nextFloat();

                    System.out.print("Largura: ");
                    float larg = sc.nextFloat();
                    sc.nextLine();

                    z.cadastrarViveiro(new Viveiro(nome, comp, larg));
                    break;

                case 2:
                    System.out.print("Nome: ");
                    nome = sc.nextLine();

                    System.out.print("Comprimento: ");
                    comp = sc.nextFloat();

                    System.out.print("Largura: ");
                    larg = sc.nextFloat();

                    System.out.print("Altura: ");
                    float alt = sc.nextFloat();

                    System.out.print("Temperatura: ");
                    float temp = sc.nextFloat();
                    sc.nextLine();

                    z.cadastrarViveiro(new Aquario(nome, comp, larg, alt, temp));
                    break;

                case 3:
                    System.out.print("Nome: ");
                    String n = sc.nextLine();

                    System.out.print("Cor: ");
                    String cor = sc.nextLine();

                    System.out.print("Especie: ");
                    String esp = sc.nextLine();

                    System.out.print("Idade: ");
                    int idade = sc.nextInt();

                    System.out.print("Largura: ");
                    float la = sc.nextFloat();

                    System.out.print("Comprimento: ");
                    float co = sc.nextFloat();

                    System.out.print("Altura: ");
                    float al = sc.nextFloat();
                    sc.nextLine();

                    z.cadastrarAnimal(new Animal(n, cor, esp, idade, la, co, al));
                    break;

                case 4:
                    System.out.print("Nome: ");
                    n = sc.nextLine();

                    System.out.print("Cor: ");
                    cor = sc.nextLine();

                    System.out.print("Especie: ");
                    esp = sc.nextLine();

                    System.out.print("Idade: ");
                    idade = sc.nextInt();

                    System.out.print("Largura: ");
                    la = sc.nextFloat();

                    System.out.print("Comprimento: ");
                    co = sc.nextFloat();

                    System.out.print("Altura: ");
                    al = sc.nextFloat();

                    System.out.print("Temperatura ideal: ");
                    float ti = sc.nextFloat();
                    sc.nextLine();

                    z.cadastrarAnimal(new Peixe(n, cor, esp, idade, la, co, al, ti));
                    break;

                case 5:
                    if (z.getAnimais().isEmpty() || z.getViveiros().isEmpty()) {
                        break;
                    }

                    System.out.println("Escolha o animal:");
                    for (int i = 0; i < z.getAnimais().size(); i++) {
                        System.out.println(i + " - " + z.getAnimais().get(i).getNome());
                    }
                    int idxAnimal = sc.nextInt();

                    System.out.println("Escolha o viveiro:");
                    for (int i = 0; i < z.getViveiros().size(); i++) {
                        System.out.println(i + " - " + z.getViveiros().get(i).getNome());
                    }
                    int idxViveiro = sc.nextInt();
                    sc.nextLine();

                    z.alocarAnimal(
                        z.getAnimais().get(idxAnimal),
                        z.getViveiros().get(idxViveiro)
                    );
                    break;

                case 6:
                    List<Aquario> aquarios = z.getSoAquarios();

                    if (aquarios.isEmpty()) {
                        System.out.println("Nao existem aquarios cadastrados.");
                        break;
                    }

                    for (Aquario a : aquarios) {
                        System.out.println("\nAquario: " + a.getNome());

                        if (a.getAnimais().isEmpty()) {
                            System.out.println("Aquario vazio");
                        } else {
                            for (Animal a1 : a.getAnimais()) {
                                System.out.println("Nome: " + a1.getNome());
                                System.out.println("Cor: " + a1.getCor());
                                System.out.println("Especie: " + a1.getEspecie());

                                if (a1 instanceof Peixe) {
                                    System.out.println("Temp ideal: " + ((Peixe) a1).getTemperaturaIdeal());
                                }
                            }
                        }
                    }
                    break;

                case 7:
                    List<Viveiro> viveiros = z.getSoViveiros();

                    if (viveiros.isEmpty()) {
                        System.out.println("Nao existem viveiros comuns cadastrados.");
                        break;
                    }

                    for (Viveiro v : viveiros) {
                        System.out.println("\nViveiro: " + v.getNome());

                        if (v.getAnimais().isEmpty()) {
                            System.out.println("Viveiro vazio");
                        } else {
                            for (Animal a1 : v.getAnimais()) {
                                System.out.println("Nome: " + a1.getNome());
                                System.out.println("Cor: " + a1.getCor());
                                System.out.println("Especie: " + a1.getEspecie());
                            }
                        }
                    }
                    break;

                case 0:
                    break;

                default:
                    break;
            }

        } while (opcao != 0);

        sc.close();
    }
}