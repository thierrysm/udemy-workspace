package servicies;

public class BrazilInterestService implements InterestService {

    private static double interestRate = 2.0;

    @Override
    public double getInterestRate() {
        return interestRate;
    }
}
