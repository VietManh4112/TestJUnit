import java.util.Date;

public class Main {
    public static void main(String[] args) {

        DummyTel dummyTel = new DummyTel(new Date(), 158);
        double fee = dummyTel.feeCalculator();
        System.out.println(fee);
    }
}