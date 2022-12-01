package servicies;

public class UsaInterestService implements InterestService {

    private static double interestRate = 1.0;

    @Override
    public double getInterestRate() {
        return interestRate;
    }
}
