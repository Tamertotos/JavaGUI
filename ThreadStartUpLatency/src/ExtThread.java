public class ExtThread extends Thread{
    private long objCreationTime;
    private long firstInstruction;

    public ExtThread(){
        this.objCreationTime = System.nanoTime();
    }

    public void run(){
        this.firstInstruction = System.nanoTime();
    }

    public long getTime(){
        return firstInstruction - objCreationTime;
    }
}
