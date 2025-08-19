public abstract class Price {
    abstract int getPriceCode();

    abstract double getCharge(int daysRented);

    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}

class NormalPrice extends Price {
    @Override
    int getPriceCode() {
        return Tape.NORMAL;
    }

    @Override
    double getCharge(int daysRented) {
        double result = 2;
        if (daysRented > 2) {
            result += (daysRented - 2) * 1.5;
        }
        return result;
    }
}

class LancamentoPrice extends Price {
    @Override
    int getPriceCode() {
        return Tape.LANCAMENTO;
    }

    @Override
    double getCharge(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        //adiciona bônus para aluguel de um lançamento por pelo menos 2 dias
        if (daysRented > 1) {
            return 2;
        }
        return 1;
    }
}

class InfantilPrice extends Price {
    @Override
    int getPriceCode() {
        return Tape.INFANTIL;
    }

    @Override
    double getCharge(int daysRented) {
        double result = 1.5;
        if (daysRented > 3) {
            result += (daysRented - 3) * 1.5;
        }
        return result;
    }
}