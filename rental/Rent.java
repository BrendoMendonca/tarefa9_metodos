public class Rent {
    private Tape tape;
    private int diasAlugada;

    public Rent(Tape tape, int diasAlugada) {
        this.tape = tape;
        this.diasAlugada = diasAlugada;
    }

    public Tape getTape() {
        return tape;
    }

    public int getDiasAlugada() {
        return diasAlugada;
    }

    public double getCharge() {
        return tape.getCharge(diasAlugada);
    }

    public int getFrequentRenterPoints() {
        return tape.getFrequentRenterPoints(diasAlugada);
    }
}