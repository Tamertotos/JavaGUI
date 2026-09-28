import java.util.Arrays;

public class Santa {
    private final String name;
    private final int age;
    Reindeer[] reindeer = new Reindeer[5];
    ChristmasEngine engine;

    public Santa(String name, int age, Reindeer[] reindeer, ChristmasEngine engine){
        this.name = name;
        this.age = age;
        this.reindeer = reindeer;
        this.engine = engine;
    }

    public ChristmasEngine getChristmasEngine() {
        return engine;
    }

    public Reindeer[] getReindeer() {
        return reindeer;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void fly(){
        boolean allHealthy = true;
        for (Reindeer deer: reindeer){
            allHealthy = deer.health() == 100;
        }

        boolean full = reindeer.length == 5;

        String text = allHealthy && full ? "Let's Go": "We have an injured deer!";
        System.out.println(text);
    }

    public void giveGift(Child c){
        if (c.getAttitude().equals("naughty")){
            System.out.println("No gift for naughty children!");
        } else if (c.getAttitude().equals("nice")){
            System.out.println("What a nice boy! Here is your gift");
            c.setGifts(getLastGift());
        }
    }

    private Gift getLastGift(){
        /*
            Gets the last gift from the engine object's array.
         */
        Gift gift = engine.takeOldestGift();
        return gift;
    }

    @Override
    public String toString() {
        return "Santa{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", reindeer=" + Arrays.toString(reindeer) +
                ", engine=" + engine +
                '}';
    }
}
