import java.util.Arrays;
import java.util.Random;

public class ChristmasEngine {
    private final String name;
    private final Gift[] gifts = new Gift[10];
    private int count = 0;
    private static final String[] NAMES = {"Car","Doll","Baby"};
    private final Random random = new Random();


    public ChristmasEngine(String name) {
        this.name = name;
    }

    public double countAverageWeight(){
        if (countGifts() == 0) return 0.0;

        int sum = 0;
        for (int i = 0; i < this.count; i++){
            sum += gifts[i].weight();
        }

        return (double) sum / countGifts();
    }

    public void createGift(String giftContent, int weight){
        this.gifts[count++] = new Gift(giftContent,weight);
    }

    public void createGift(){
        int randomNumber = random.nextInt(NAMES.length);
        int randomWeight = random.nextInt(10) + 1;

        createGift(NAMES[randomNumber], randomWeight);
    }

    public void createGift(String giftContent){
        createGift(giftContent,5);
    }

    public void createGifts(String[] names, int[] weights){
        if (names.length != weights.length){
            throw new IllegalArgumentException("Arrays length must be equal!");
        }

        for (int i = 0; i < names.length; i++) {
            createGift(names[i], weights[i]);
        }
    }

    public void showName() {
        System.out.println("The name of the factory is " + this.name);
    }

    public int countGifts(){
        return this.count;
    }

    public String getGifts() {
        return Arrays.toString(gifts);
    }

    public Gift takeOldestGift(){
        /*
            Take the last non-null element in the array, return it as a gift and make it null later on.
         */
        this.count--;
        Gift lastGift = gifts[this.count];
        this.gifts[this.count] = null;

        return lastGift;
    }

    @Override
    public String toString() {
        return "ChristmasEngine{" +
                "name='" + name + '\'' +
                ", gifts=" + Arrays.toString(gifts) +
                ", count=" + count +
                '}';
    }
}
