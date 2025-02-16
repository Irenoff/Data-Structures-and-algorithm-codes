
public class RecursionApplication {
    static void towerOfHanoi(char source_rod, char destination_rod, char auxiliary_rod, int n) {
        if (n == 1) {
            System.out.println("Move disk from " + source_rod + " to " + destination_rod);
            return;
        }
        towerOfHanoi(source_rod, auxiliary_rod, destination_rod, n - 1);
        System.out.println("Move disk from " + source_rod + " to " + destination_rod);
        towerOfHanoi(auxiliary_rod, destination_rod, source_rod, n - 1);
    }

    public static void main(String args[]) {
        int noOfDisks = 4;
        towerOfHanoi('A', 'B', 'C', noOfDisks);
    }
}