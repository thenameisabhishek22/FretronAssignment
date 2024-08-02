import java.util.*;
public class QuestionTwo {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Integer> apples = new ArrayList<>();
        int totalWeight = 0;
        while(true){
            System.out.print("Enter apple weight in gram (-1 to stop ): ");
            int weight = s.nextInt();
            if(weight == -1){
                break;
            }

            apples.add(weight);
            totalWeight += weight;
        }

        double ramWeight = totalWeight * 50 / 100;
        double shamWeight = totalWeight * 30 / 100;
        double rahimWeight = totalWeight * 20 / 100;

        ArrayList<Integer> ramApples = new ArrayList<>();
        ArrayList<Integer> shamApples = new ArrayList<>();
        ArrayList<Integer> rahimApples = new ArrayList<>();

        double ramCurrWeight = 0;
        double shamCurrWeight = 0;
        double rahimCurrWeight = 0;

        for(int apple : apples){
            double ramDiff = ramWeight - ramCurrWeight;
            double shamDiff = shamWeight - shamCurrWeight;
            double rahimDiff = rahimWeight - rahimCurrWeight;

            if (ramDiff >= shamDiff && ramDiff >= rahimDiff) {
                ramApples.add(apple);
                ramCurrWeight += apple;
            } else if (shamDiff >= ramDiff && shamDiff >= rahimDiff) {
                shamApples.add(apple);
                shamCurrWeight += apple;
            } else if((rahimDiff >= ramDiff && rahimDiff >= shamDiff)){
                rahimApples.add(apple);
                rahimCurrWeight += apple;
            }
        }

        System.out.println("Distribution Result:");
        System.out.print("Ram: ");
        printAppleList(ramApples);
        System.out.print("Sham: ");
        printAppleList(shamApples);
        System.out.print("Rahim: ");
        printAppleList(rahimApples);

        s.close();
    }

    private static void printAppleList(ArrayList<Integer> appleList) {
        for (int i = 0; i < appleList.size(); i++) {
            System.out.print(appleList.get(i));
            if (i < appleList.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
