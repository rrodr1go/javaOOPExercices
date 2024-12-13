package entities;

public class NaturalPerson extends TaxPayer {

    private Double healthcareExpenses;

    public NaturalPerson(){}

    public NaturalPerson(String name, Double annualIncome, Double healthcareExpenses) {
        super(name, annualIncome);
        this.healthcareExpenses = healthcareExpenses;
    }

    public Double getHealthcareExpenses() {
        return healthcareExpenses;
    }

    public void setHealthcareExpenses(Double healthcareExpenses) {
        this.healthcareExpenses = healthcareExpenses;
    }
    @Override
    public Double annualTax() {
        if (getAnnualIncome() < 20000.0 && getHealthcareExpenses() == 0) {
          return getAnnualIncome() * 0.15;
        } else if (getAnnualIncome() < 20.000) {
            return getAnnualIncome() * 0.15 - getHealthcareExpenses() * 0.5;
        } else if (getAnnualIncome() >= 20000.0 && getHealthcareExpenses() == 0) {
            return getAnnualIncome() * 0.25;
        } else {
            return getAnnualIncome() * 0.25 - getHealthcareExpenses() * 0.5;
        }
    }
}
