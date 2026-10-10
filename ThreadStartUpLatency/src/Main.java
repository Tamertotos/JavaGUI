import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        final int WARMUP = 5000;
        final int N = 50000;

        long[] extTimes = new long[N];
        long[] runTimes = new long[N];

        for (int i = 0; i < WARMUP; i++){
            try {
                measureRun();
                measureExt();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        for(int i = 0; i < N;  i++){
            try {
                extTimes[i] = measureExt();
                runTimes[i] = measureRun();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


        FileIO.write("median.csv",N,findMedian(extTimes),findMedian(runTimes));

    }

    public static long measureExt() throws InterruptedException {
        ExtThread thread1 = new ExtThread();
        thread1.start();
        thread1.join();
        return thread1.getTime();
    }

    public static long measureRun() throws InterruptedException {
        RunTask runTask = new RunTask();
        Thread run1 = new Thread(runTask);
        run1.start();
        run1.join();
        return runTask.getTime();
    }

    public static double averageTime(long[] arr){
        int count = arr.length;
        long sum = 0;
        for (long l : arr) {
            sum += l;
        }
        return (double) sum / count;
    }

    public static double findMedian(long[] arr){
        int count = arr.length;
        Arrays.sort(arr);

        if (count % 2 == 0){
            return (double) (arr[count / 2  - 1] + arr[count / 2]) / 2;
        } else {
            return arr[count / 2];
        }
    }
}