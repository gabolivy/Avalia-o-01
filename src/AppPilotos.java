import java.io.IOException;
import java.util.Scanner;
import Avião.Pessoa;
import Avião.Piloto;

public class AppPilotos {
    public static void main(String[] args) throws InterruptedException, IOException {
        final int MAX_ELEMENTOS = 20;
        int opcao, qtdCadastrados = 0;
        Pessoa[] pilotos = new Pessoa[MAX_ELEMENTOS];
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("\n**\nMENU\n**\n");
            System.out.println("1 - Cadastrar piloto");
            System.out.println("2 - Listar pilotos cadastrados");
            System.out.println("3 - Localizar piloto pelo CPF");
            System.out.println("4 - Aumentar espaço de armazenamento");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = in.nextInt();
            in.nextLine(); // Tira o ENTER que ficou na entrada na instrução anterior

            if (opcao == 1) {
                // Se não tem mais espaço no vetor, caio fora
                if (qtdCadastrados == MAX_ELEMENTOS) {
                    System.out.println("\nNão há espaço para cadastrar novos pilotos.");
                    voltarMenu(in);
                    continue;
                }

                try{
                //Cadastre seu piloto aqui
                Piloto piloto = new Piloto();
                System.out.println("\nDigite o nome do piloto:");
                piloto.setNome(in.nextLine());
                System.out.println("\nDigite o CPF do piloto:");
                piloto.setCpf(in.nextLine());
                System.out.println("\nDigite o breve do piloto:");
                piloto.setBreve(in.nextLine());
                System.out.println("\nDigite a matrícula do piloto");
                piloto.setMatricula(qtdCadastrados);in.nextLine();
                
                pilotos[qtdCadastrados] = piloto;
                qtdCadastrados++;

                System.out.println("\nPiloto cadastrado com sucesso.");
                voltarMenu(in);

            } catch (Exception e) {
                in.nextLine();
                System.out.println("Falha ao cadastrar. \nTente novamente.");
                voltarMenu(in);
            }
    }
            
            else if (opcao == 2) {
                // Se não tem ninguém cadastrado no vetor, caio fora
                if (qtdCadastrados == 0) {
                    System.out.println("\nNão há motoristas cadastrados para exibir.");
                    voltarMenu(in);
                    continue;
                }

                // Exiba os pilotos aqui
                for(Pessoa piloto : pilotos){
                    if(piloto != null){
                        System.out.printf("\nNome: %s\n", piloto.getNome());
                        System.out.printf("CPF: %s\n", piloto.getCpf());
                        System.out.printf("Matrícula: %s\n", ((Piloto)piloto).getMatricula());
                        System.out.printf("Breve: %s\n", ((Piloto)piloto).getBreve());

                    }
                }

                voltarMenu(in);
            } else if (opcao == 3) {
                System.out.println("\nDigite o CPF do piloto para buscar: ");
                String CpfDigitado = in.nextLine();

                for(int i = 0; i  < pilotos.length + 1; i++){
                    try{
                        if (pilotos[i].getCpf().toString().equals(CpfDigitado)){
                            System.out.printf("\nNome: %S\n", pilotos[i].getNome());
                            System.out.printf("\nCPF: %S\n", pilotos[i].getCpf());
                            pilotos[i].getNome();
                            pilotos[i].getCpf();
                            voltarMenu(in);

                break;
                    } else if (i < pilotos.length + 1) {
                        continue;
                    }

            
                    } catch (Exception e) {
                        in.nextLine();
                        System.out.println("Falha ao buscar piloto. \nTente novamente.");
                        voltarMenu(in);
                    }
                }
             
                
            } else if (opcao == 4) {
                //Eu fiquei horas nessa e não consegui fazer.
                // Corrige com carinho <3

                System.out.println("\nOpção em manutenção.\nTente novamente outro dia.");
                voltarMenu(in);
                    continue;
                
            }
            else if (opcao != 0) {
                System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);

        System.out.println("Fim do programa!");

        in.close();
    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
        
        System.out.flush();
    }
}