public class ComputeInterest {
    //Principal, interest rate and duration
    public static void main(String[] args){
        double principal = Double.parseDouble(args[0]);
        double interest = Double.parseDouble(args[1]) / 100;
        double duration = Double.parseDouble(args[2]);

        double simple_interest = principal * (1 + (interest * duration));
        double compound_interest = principal * Math.pow((1 + interest), duration);
        double difference = compound_interest - simple_interest;

        System.out.printf("The amount with simple interest is: %.2f\n", simple_interest);
        System.out.printf("The amount with compound interest is: %.2f\n", compound_interest);
        System.out.printf("The difference is: %.2f\n", difference);
    }
}
