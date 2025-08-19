// Tape.java
public class Tape {
    public static final int NORMAL = 0;
    public static final int LANCAMENTO = 1;
    public static final int INFANTIL = 2;

    private String titulo;
    private Price price;

    public Tape(String titulo, int codigoDePreco) {
        this.titulo = titulo;
        setCodigoDePreco(codigoDePreco);
    }

    public String getTitulo() {
        return titulo;
    }

    public int getCodigoDePreco() {
        return price.getPriceCode();
    }

    public void setCodigoDePreco(int codigoDePreco) {
        switch (codigoDePreco) {
            case NORMAL:
                price = new NormalPrice();
                break;
            case LANCAMENTO:
                price = new LancamentoPrice();
                break;
            case INFANTIL:
                price = new InfantilPrice();
                break;
            default:
                throw new IllegalArgumentException("Código de preço incorreto");
        }
    }

    public double getCharge(int daysRented) {
        return price.getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        return price.getFrequentRenterPoints(daysRented);
    }
}