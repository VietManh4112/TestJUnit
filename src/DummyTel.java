import java.util.Calendar;
import java.util.Date;

public class DummyTel {

    private Date startPhoneCall;
    private double fee;
    private long duration;
    private Calendar fromEighteenth;
    private Calendar toTwentyThree;
    private Calendar fromZero;
    private Calendar toEight;
    private final double TAX = 0.05;
    private final double SPECIFIC_HOUR_DISCOUNT = 0.5;
    private final double LONG_DURATION_DISCOUNT = 0.15;
    private final double FEE = 0.50;



    /**
     * Hàm tính toán cước phí cuộc gọi phát sinh
     * @return
     */
    protected double feeCalculator() {



        boolean firstTimeCondition = startPhoneCall.compareTo(fromEighteenth.getTime()) == 1 && startPhoneCall.compareTo(toTwentyThree.getTime()) == -1;
        boolean secondTimeCondition = startPhoneCall.compareTo(fromZero.getTime()) == 1 && startPhoneCall.compareTo(toEight.getTime()) == -1;

        fee = duration * (FEE / 60);
        System.out.println("Calling time: "+ startPhoneCall + " Duration: "+ duration + "  total fee: " + fee);

        // Kiểm tra giờ gọi có nằm trong khoảng thời gian được giảm giá không (Từ 18h đến 8h)
        if (firstTimeCondition || secondTimeCondition) {
            fee = fee * SPECIFIC_HOUR_DISCOUNT;
            System.out.println("Calling satisfied discount condition. Fee: "+ fee);
        }

        // Kiểm tra thời lượng cuộc gọi có lớn hơn 60 phút không
        if (duration > 3600) {
            fee = fee * LONG_DURATION_DISCOUNT;
            System.out.println("Duration longer than 60 minutes, after being discount: "+ fee);
        }
        double feeAfterTax = (double) Math.round(fee * TAX * 100) / 100;

        System.out.println("Fee to pay: " + feeAfterTax);
        return feeAfterTax;
    }

    public DummyTel(Date startPhoneCall, long duration) {

        if (fromEighteenth == null) {
            fromEighteenth = Calendar.getInstance();
            fromEighteenth.set(Calendar.HOUR_OF_DAY, 18);
            fromEighteenth.set(Calendar.MINUTE, 0);
            fromEighteenth.set(Calendar.SECOND, 0);
        }

        if (toTwentyThree == null) {
            toTwentyThree = Calendar.getInstance();
            toTwentyThree.set(Calendar.HOUR_OF_DAY, 23);
            toTwentyThree.set(Calendar.MINUTE, 59);
            toTwentyThree.set(Calendar.SECOND, 59);
        }

        if (fromZero == null) {
            fromZero = Calendar.getInstance();
            fromZero.set(Calendar.HOUR_OF_DAY, 23);
            fromZero.set(Calendar.MINUTE, 59);
            fromZero.set(Calendar.SECOND, 59);
        }

        if (toEight == null) {
            toEight = Calendar.getInstance();
            toEight.set(Calendar.HOUR_OF_DAY, 8);
            toEight.set(Calendar.MINUTE, 0);
            toEight.set(Calendar.SECOND, 0);
        }


        this.startPhoneCall = startPhoneCall;
        this.duration = duration;
    }

    public Date getStartPhoneCall() {
        return startPhoneCall;
    }

    public void setStartPhoneCall(Date startPhoneCall) {
        this.startPhoneCall = startPhoneCall;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "PhoneCall{" +
                "\n" + "startPhoneCall= " + startPhoneCall + "" +
                "\nfee= " + fee +
                "\nduration= " + duration +
                "\n}";
    }
}