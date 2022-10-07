public class ProblemC {
    public static void main(String[] args){
        int n1 = 3;
        int m1 = 4;
        int result1 = n1 * (++m1);

        int n2 = 3;
        int m2 = 4;
        int result2 = n2 * (m2++);

        System.out.println("Segment 1: " + result1 + "\nSegment 2: " + result2);
    }
}
