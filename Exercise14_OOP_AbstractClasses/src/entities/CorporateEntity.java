package entities;

public class CorporateEntity extends TaxPayer {
    private Integer employeesNo;

    public CorporateEntity(){}

    public CorporateEntity(String name, Double annualIncome, Integer employeesNo) {
        super(name, annualIncome);
        this.employeesNo = employeesNo;
    }

    public Integer getEmployeesNo() {
        return employeesNo;
    }

    public void setEmployeesNo(Integer employeesNo) {
        this.employeesNo = employeesNo;
    }

    @Override
    public Double annualTax() {
        if (getEmployeesNo() > 10) {
            return getAnnualIncome() * 0.14;
        } else {
            return getAnnualIncome() * 0.16;
        }
    }


}
