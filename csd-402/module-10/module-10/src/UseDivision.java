public class UseDivision {
    public static void main(String[] args) {
        InternationalDivision intDiv1 = new InternationalDivision("Global Tech", 101, "Germany", "German");
        InternationalDivision intDiv2 = new InternationalDivision("APAC Sales", 102, "Japan", "Japanese");

        DomesticDivision domDiv1 = new DomesticDivision("East Coast Logistics", 201, "New York");
        DomesticDivision domDiv2 = new DomesticDivision("Central Marketing", 202, "Texas");

        intDiv1.display();
        intDiv2.display();
        domDiv1.display();
        domDiv2.display();
    }
}