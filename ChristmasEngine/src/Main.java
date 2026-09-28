public class Main {
    public static void main(String[] args) {

        Child child = new Child("nice","tamer");
        ChristmasEngine test = new ChristmasEngine("a");


        Reindeer[] reindeer = new Reindeer[5];
        for (int i = 0; i < 5; i++) {
            reindeer[i] = new Reindeer(100);
        }

        Santa santa = new Santa("Tomasz", 60, reindeer, test);

        String[] gifts = {"Toy","Socks","Game"};
        int[] weights = {1,2,3};
        test.createGifts(gifts,weights);

        System.out.println(test.countGifts());
        System.out.println(test.getGifts());
        System.out.println(test.countAverageWeight());

        santa.giveGift(child);
        santa.giveGift(child);

        child.openGift();
    }
}
