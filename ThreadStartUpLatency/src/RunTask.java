public class RunTask implements Runnable{
    private long objCreationTime;
    private long firstInstruction;

    public RunTask(){
        this.objCreationTime = System.nanoTime();
    }

    @Override
    public void run()
    {
        this.firstInstruction = System.nanoTime();
    }

    public long getTime(){
        return firstInstruction - objCreationTime;
    }
}
