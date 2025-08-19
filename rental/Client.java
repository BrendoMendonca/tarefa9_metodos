// Client.java
import java.util.*;

public class Client {
    private String nome;
    private Collection<Rent> tapesAlugadas = new Vector<>();

    public Client(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void adicionaRent(Rent rent) {
        tapesAlugadas.add(rent);
    }

    public String extrato() {
        final String fimDeLinha = System.getProperty("line.separator");
        String resultado = "Registro de Alugueis de " + getNome() + fimDeLinha;

        for (Rent aluguel : tapesAlugadas) {
            // Mostra valores para este aluguel
            resultado += "\t" + aluguel.getTape().getTitulo() + "\t" + aluguel.getCharge() + fimDeLinha;
        }

        // Adiciona rodapé
        resultado += "Valor total devido: " + getTotalCharge() + fimDeLinha;
        resultado += "Voce acumulou " + getTotalFrequentRenterPoints() + " pontos de alugador frequente";
        return resultado;
    }

    private double getTotalCharge() {
        double result = 0;
        for (Rent aluguel : tapesAlugadas) {
            result += aluguel.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        for (Rent aluguel : tapesAlugadas) {
            result += aluguel.getFrequentRenterPoints();
        }
        return result;
    }
}