package ex2;

import java.util.Scanner;

public class SistemaPetShop {

    private Scanner sc = new Scanner(System.in);
    private Veterinario[] veterinarios = new Veterinario[50];
    private int quantidadeVeterinarios;

    public SistemaPetShop() {
        this.quantidadeVeterinarios = 0;
    }

    public void cadastrarVeterinario() {
        if (quantidadeVeterinarios < veterinarios.length) {
            System.out.println("Digite o nome do veterinário:");
            String nome = sc.nextLine();

            System.out.println("Digite o salário:");
            float salario = Float.parseFloat(sc.nextLine());
            
            Veterinario veterinario = new Veterinario(nome, salario);
            veterinarios[quantidadeVeterinarios] = veterinario;
            quantidadeVeterinarios++;
            System.out.println("Veterinário cadastrado com sucesso!\n");
        } else {
            System.out.println("Limite de veterinários atingido!\n");
        }
    }

    public void mostrarVeterinarios() {
        if (quantidadeVeterinarios == 0) {
            System.out.println("Nenhum veterinário cadastrado.\n");
        } else {
            System.out.println("Veterinários cadastrados:");
            for (int i = 0; i < quantidadeVeterinarios; i++) {
                System.out.println("[" + i + "] " + veterinarios[i].getNome());
            }
            System.out.println();
        }
    }

    public void cadastrarEnderecoVeterinario() {
        if (quantidadeVeterinarios == 0) {
            System.out.println("Não há veterinários cadastrados.\n");
            return;
        }
        mostrarVeterinarios();
        System.out.println("Digite o índice do veterinário para cadastrar o endereço:");
        int indice = Integer.parseInt(sc.nextLine());
        if (indice >= 0 && indice < quantidadeVeterinarios) {
            System.out.println("Digite a rua:");
            String rua = sc.nextLine();
            System.out.println("Digite o número:");
            int numero = Integer.parseInt(sc.nextLine());
            System.out.println("Digite o bairro:");
            String bairro = sc.nextLine();
            System.out.println("Digite a cidade:");
            String cidade = sc.nextLine();
            System.out.println("Digite o estado:");
            String estado = sc.nextLine();
            System.out.println("Digite o CEP:");
            String cep = sc.nextLine();
            Endereco endereco = new Endereco(rua, numero, bairro, cidade, estado, cep);
            veterinarios[indice].setEndereco(endereco);
            System.out.println("Endereço cadastrado com sucesso!\n");
        } else {
            System.out.println("Índice inválido!\n");
        }
    }

    public void cadastrarAnimal() {
        if (quantidadeVeterinarios == 0) {
            System.out.println("Não há veterinários cadastrados.\n");
            return;
        }
        mostrarVeterinarios();
        System.out.println("Digite o índice do veterinário para cadastrar o animal:");
        int indice = Integer.parseInt(sc.nextLine());
        if (indice >= 0 && indice < quantidadeVeterinarios) {
            Veterinario vet = veterinarios[indice];
            System.out.println("Digite o nome do animal:");
            String nome = sc.nextLine();
            System.out.println("Digite a espécie:");
            String especie = sc.nextLine();
            System.out.println("Digite a descrição:");
            String descricao = sc.nextLine();
            Animal animal = new Animal(nome, especie, descricao);
            if (vet.adicionarAnimal(animal)) {
                System.out.println("Animal cadastrado com sucesso!\n");
            } else {
                System.out.println("Capacidade máxima de animais atingida para este veterinário.\n");
            }
        } else {
            System.out.println("Índice inválido!\n");
        }
    }

    public void mostrarAnimais() {
        if (quantidadeVeterinarios == 0) {
            System.out.println("Não há veterinários cadastrados.\n");
            return;
        }
        mostrarVeterinarios();
        System.out.println("Digite o índice do veterinário para visualizar os animais:");
        int indice = Integer.parseInt(sc.nextLine());
        if (indice >= 0 && indice < quantidadeVeterinarios) {
            Veterinario vet = veterinarios[indice];
            if (vet.getQuantidadeAnimais() == 0) {
                System.out.println("Nenhum animal cadastrado para este veterinário.\n");
            } else {
                System.out.println("Animais atendidos pelo veterinário " + vet.getNome() + ":");
                for (int i = 0; i < vet.getQuantidadeAnimais(); i++) {
                    System.out.println("[" + i + "] " + vet.getAnimal(i).getNome());
                }
                System.out.println();
            }
        } else {
            System.out.println("Índice inválido!\n");
        }
    }

    public void cadastrarDono() {
        if (quantidadeVeterinarios == 0) {
            System.out.println("Não há veterinários cadastrados.\n");
            return;
        }
        mostrarVeterinarios();
        System.out.println("Digite o índice do veterinário que atende o animal:");
        int indiceVet = Integer.parseInt(sc.nextLine());
        if (indiceVet >= 0 && indiceVet < quantidadeVeterinarios) {
            Veterinario vet = veterinarios[indiceVet];
            if (vet.getQuantidadeAnimais() == 0) {
                System.out.println("Nenhum animal cadastrado para este veterinário.\n");
                return;
            }
            System.out.println("Animais atendidos pelo veterinário " + vet.getNome() + ":");
            for (int i = 0; i < vet.getQuantidadeAnimais(); i++) {
                System.out.println("[" + i + "] " + vet.getAnimal(i).getNome());
            }
            System.out.println("Digite o índice do animal para cadastrar o dono:");
            int indiceAnimal = Integer.parseInt(sc.nextLine());
            if (indiceAnimal >= 0 && indiceAnimal < vet.getQuantidadeAnimais()) {
                Animal animal = vet.getAnimal(indiceAnimal);
                System.out.println("Digite o nome do dono:");
                String nome = sc.nextLine();
                System.out.println("Digite o CPF do dono:");
                String cpf = sc.nextLine();
                Dono dono = new Dono(nome, cpf);
                animal.setDono(dono);
                System.out.println("Dono cadastrado com sucesso!\n");
            } else {
                System.out.println("Índice de animal inválido!\n");
            }
        } else {
            System.out.println("Índice de veterinário inválido!\n");
        }
    }

    public void cadastrarEnderecoDono() {
        if (quantidadeVeterinarios == 0) {
            System.out.println("Não há veterinários cadastrados.\n");
            return;
        }
        mostrarVeterinarios();
        System.out.println("Digite o índice do veterinário que atende o animal:");
        int indiceVet = Integer.parseInt(sc.nextLine());
        if (indiceVet >= 0 && indiceVet < quantidadeVeterinarios) {
            Veterinario vet = veterinarios[indiceVet];
            if (vet.getQuantidadeAnimais() == 0) {
                System.out.println("Nenhum animal cadastrado para este veterinário.\n");
                return;
            }
            System.out.println("Animais atendidos pelo veterinário " + vet.getNome() + ":");
            for (int i = 0; i < vet.getQuantidadeAnimais(); i++) {
                System.out.println("[" + i + "] " + vet.getAnimal(i).getNome());
            }
            System.out.println("Digite o índice do animal cujo dono deseja cadastrar o endereço:");
            int indiceAnimal = Integer.parseInt(sc.nextLine());
            if (indiceAnimal >= 0 && indiceAnimal < vet.getQuantidadeAnimais()) {
                Animal animal = vet.getAnimal(indiceAnimal);
                if (animal.getDono() == null) {
                    System.out.println("Este animal ainda não possui um dono cadastrado.\n");
                    return;
                }
                System.out.println("Cadastrando endereço para o dono " + animal.getDono().getNome() + ":");
                System.out.println("Digite a rua:");
                String rua = sc.nextLine();
                System.out.println("Digite o número:");
                int numero = Integer.parseInt(sc.nextLine());
                System.out.println("Digite o bairro:");
                String bairro = sc.nextLine();
                System.out.println("Digite a cidade:");
                String cidade = sc.nextLine();
                System.out.println("Digite o estado:");
                String estado = sc.nextLine();
                System.out.println("Digite o CEP:");
                String cep = sc.nextLine();
                Endereco endereco = new Endereco(rua, numero, bairro, cidade, estado, cep);
                animal.getDono().setEndereco(endereco);
                System.out.println("Endereço do dono cadastrado com sucesso!\n");
            } else {
                System.out.println("Índice de animal inválido!\n");
            }
        } else {
            System.out.println("Índice de veterinário inválido!\n");
        }
    }

    public void iniciarSistema() {
        int opcao;
        do {
            System.out.println("=== Sistema Pet-Shop ===");
            System.out.println("1. Cadastrar Veterinário");
            System.out.println("2. Mostrar Veterinários");
            System.out.println("3. Cadastrar Endereço de Veterinário");
            System.out.println("4. Cadastrar Animal");
            System.out.println("5. Mostrar Animais");
            System.out.println("6. Cadastrar Dono");
            System.out.println("7. Cadastrar Endereço do Dono");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            try {
                opcao = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                opcao = -1;
            }
            System.out.println();
            switch (opcao) {
                case 1:
                    cadastrarVeterinario();
                    break;
                case 2:
                    mostrarVeterinarios();
                    break;
                case 3:
                    cadastrarEnderecoVeterinario();
                    break;
                case 4:
                    cadastrarAnimal();
                    break;
                case 5:
                    mostrarAnimais();
                    break;
                case 6:
                    cadastrarDono();
                    break;
                case 7:
                    cadastrarEnderecoDono();
                    break;
                case 0:
                    System.out.println("Encerrando o sistema. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida!\n");
                    break;
            }
        } while (opcao != 0);
    }

    public static void main(String[] args) {
        SistemaPetShop sistema = new SistemaPetShop();
        sistema.iniciarSistema();
    }
}