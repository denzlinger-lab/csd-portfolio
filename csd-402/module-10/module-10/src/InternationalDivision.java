public class InternationalDivision extends Division {
    protected String country;
    protected String language;

    public InternationalDivision(String divisionName, int accountNumber, String country, String language) {
        super(divisionName, accountNumber);
        this.country = country;
        this.language = language;
    }

    @Override
    public void display() {
        System.out.println("International Division: " + divisionName +
                " (Acct #" + accountNumber + ")");
        System.out.println("Location: " + country + " | Language: " + language);
        System.out.println();
    }
}