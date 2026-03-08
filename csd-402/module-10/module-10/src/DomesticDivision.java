public class DomesticDivision extends Division {
    protected String state;

    public DomesticDivision(String divisionName, int accountNumber, String state) {
        super(divisionName, accountNumber);
        this.state = state;
    }

    @Override
    public void display() {
        System.out.println("Domestic Division: " + divisionName +
                " (Acct #" + accountNumber + ")");
        System.out.println("Location: " + state);
        System.out.println();
    }
}