public class PerimeterfromArea {
    public static void main(String[] args){
        double area = Double.parseDouble(args[0]);
        double edge = Math.sqrt(area);
        System.out.printf("%.2f", 4*edge);
    }
}
