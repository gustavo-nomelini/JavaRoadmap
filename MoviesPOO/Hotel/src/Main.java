import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Classe Quarto
class Quarto {
    private int numero;
    private String tipo;
    private double precoDiario;
    private boolean disponivel;

    public Quarto(int numero, String tipo, double precoDiario) {
        this.numero = numero;
        this.tipo = tipo;
        this.precoDiario = precoDiario;
        this.disponivel = true; // Inicialmente, todos os quartos estão disponíveis
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecoDiario() {
        return precoDiario;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "Quarto " + numero + " (" + tipo + ") - R$ " + precoDiario + " - " +
                (disponivel ? "Disponível" : "Ocupado");
    }
}

// Classe Reserva
class Reserva {
    private String nomeHospede;
    private String checkIn;
    private String checkOut;
    private int numeroQuartosReservados;
    private String tipoQuartoReservado;

    public Reserva(String nomeHospede, String checkIn, String checkOut, int numeroQuartosReservados, String tipoQuartoReservado) {
        this.nomeHospede = nomeHospede;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.numeroQuartosReservados = numeroQuartosReservados;
        this.tipoQuartoReservado = tipoQuartoReservado;
    }

    public String getNomeHospede() {
        return nomeHospede;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public int getNumeroQuartosReservados() {
        return numeroQuartosReservados;
    }

    public String getTipoQuartoReservado() {
        return tipoQuartoReservado;
    }

    @Override
    public String toString() {
        return "Reserva de " + nomeHospede + ": " + tipoQuartoReservado + " | Check-in: " + checkIn + " | Check-out: " + checkOut;
    }
}

// Classe Hospede
class Hospede {
    private String nome;
    private List<Reserva> historicoReservas;

    public Hospede(String nome) {
        this.nome = nome;
        this.historicoReservas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<Reserva> getHistoricoReservas() {
        return historicoReservas;
    }

    public void adicionarReserva(Reserva reserva) {
        historicoReservas.add(reserva);
    }
}

// Classe Hotel
class Hotel {
    private List<Quarto> quartos;
    private List<Reserva> reservas;

    public Hotel() {
        this.quartos = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    // Cadastro de quartos
    public void cadastrarQuarto(int numero, String tipo, double precoDiario) {
        Quarto quarto = new Quarto(numero, tipo, precoDiario);
        quartos.add(quarto);
        System.out.println("Quarto " + numero + " cadastrado com sucesso!");
    }

    // Cadastro de reservas
    public void cadastrarReserva(String nomeHospede, String checkIn, String checkOut, int numeroQuartos, String tipoQuarto) {
        Reserva reserva = new Reserva(nomeHospede, checkIn, checkOut, numeroQuartos, tipoQuarto);
        reservas.add(reserva);
        atualizarDisponibilidade(tipoQuarto, false);
        System.out.println("Reserva para " + nomeHospede + " cadastrada com sucesso!");
    }

    // Gerenciamento de check-in e check-out
    public void realizarCheckIn(String nomeHospede) {
        System.out.println("Check-in realizado para " + nomeHospede);
    }

    public void realizarCheckOut(String nomeHospede) {
        System.out.println("Check-out realizado para " + nomeHospede);
        atualizarDisponibilidade(null, true);
    }

    // Atualiza a disponibilidade dos quartos
    private void atualizarDisponibilidade(String tipo, boolean disponivel) {
        for (Quarto quarto : quartos) {
            if (tipo == null || quarto.getTipo().equals(tipo)) {
                quarto.setDisponivel(disponivel);
            }
        }
    }

    // Relatório de ocupação de quartos
    public void gerarRelatorioOcupacao() {
        System.out.println("Relatório de Ocupação de Quartos:");
        for (Quarto quarto : quartos) {
            if (!quarto.isDisponivel()) {
                System.out.println(quarto);
            }
        }
    }

    // Histórico de reservas
    public void listarTodasReservas() {
        if (reservas.isEmpty()) {
            System.out.println("Nenhuma reserva registrada.");
        } else {
            System.out.println("Lista de todas as reservas:");
            for (Reserva reserva : reservas) {
                System.out.println(reserva);
            }
        }
    }
}

// Classe Main (Interface de linha de comando)
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Hotel hotel = new Hotel();

    public static void main(String[] args) {
        boolean executando = true;

        while (executando) {
            System.out.println("\n--- Sistema de Gerenciamento de Hotel ---");
            System.out.println("1. Cadastrar Quarto");
            System.out.println("2. Cadastrar Reserva");
            System.out.println("3. Realizar Check-in");
            System.out.println("4. Realizar Check-out");
            System.out.println("5. Gerar Relatório de Ocupação");
            System.out.println("6. Gerar Histórico de Reservas");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    cadastrarQuarto();
                    break;
                case 2:
                    cadastrarReserva();
                    break;
                case 3:
                    realizarCheckIn();
                    break;
                case 4:
                    realizarCheckOut();
                    break;
                case 5:
                    hotel.gerarRelatorioOcupacao();
                    break;
                case 6:
                    hotel.listarTodasReservas();
                    break;
                case 7:
                    executando = false;
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void cadastrarQuarto() {
        System.out.print("Número do quarto: ");
        int numero = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Tipo de quarto (solteiro/casal/suite): ");
        String tipo = scanner.nextLine();
        System.out.print("Preço diário: ");
        double preco = scanner.nextDouble();
        hotel.cadastrarQuarto(numero, tipo, preco);
    }

    private static void cadastrarReserva() {
        System.out.print("Nome do hóspede: ");
        String nomeHospede = scanner.nextLine();
        System.out.print("Data de check-in: ");
        String checkIn = scanner.nextLine();
        System.out.print("Data de check-out: ");
        String checkOut = scanner.nextLine();
        System.out.print("Número de quartos reservados: ");
        int numeroQuartos = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Tipo de quarto reservado: ");
        String tipoQuarto = scanner.nextLine();
        hotel.cadastrarReserva(nomeHospede, checkIn, checkOut, numeroQuartos, tipoQuarto);
    }

    private static void realizarCheckIn() {
        System.out.print("Nome do hóspede: ");
        String nomeHospede = scanner.nextLine();
        hotel.realizarCheckIn(nomeHospede);
    }

    private static void realizarCheckOut() {
        System.out.print("Nome do hóspede: ");
        String nomeHospede = scanner.nextLine();
        hotel.realizarCheckOut(nomeHospede);
    }

//    private static void gerarHistoricoReservas() {
//        System.out.print("Nome do hóspede: ");
//        String nomeHospede = scanner.nextLine();
//        hotel.gerarHistoricoReservas(nomeHospede);
//    }
}
