import java.util.ArrayList;

public class Child {
    private String attitude;
    private final String name;
    private ArrayList<Gift> gifts = new ArrayList<Gift>();


    public Child(String attitude, String name){
        this.attitude = attitude;
        this.name = name;
    }

    public String getAttitude(){
        return this.attitude;
    }

    public String getName() {
        return name;
    }

    public void setGifts(Gift gift) {
        /*
            Accepts gifts via public method.

            @param gift is a given gift as a String
         */
        this.gifts.add(gift);
    }

    public void openGift() {
        for (Gift elem: gifts){
            System.out.println("Gift ----> " + elem.name());
        }
    }

    public void changeAttitude(){
        if (this.attitude.equals("nice")){
            this.attitude = "naughty";
        } else if (this.attitude.equals("naughty")){
            this.attitude = "nice";
        }
    }

    @Override
    public String toString() {
        return "Child{" +
                "attitude='" + attitude + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
