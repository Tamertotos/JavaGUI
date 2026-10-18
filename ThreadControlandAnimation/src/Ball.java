import java.awt.*;
import java.util.Random;

public abstract class Ball implements Runnable{
    protected int x,y,vx,vy,speed;
    protected Thread thread;
    protected static final Object MONITOR = new Object();

    public Ball(int x, int y){
        this.x = x;
        this.y = y;
        this.vx = new Random().nextInt(-3,4);
        this.vy = new Random().nextInt(-3,4);
        this.speed = new Random().nextInt(20,31);

        this.thread = new Thread(this);
        this.thread.start();
    }

    public void draw(Graphics g){
        g.fillOval(x-5, y-5, 10, 10);
    }

    public void run(){
        while (true){
            this.x += vx;
            this.y += vy;

            if (collidingX()){
                vx *= -1;
                x += vx;
                synchronized (MONITOR){
                    try {
                        MONITOR.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            if (collidingY()){
                vy *= -1;
                y += vy;
                synchronized (MONITOR){
                    try {
                        MONITOR.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }


            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void wakeUp(){
        synchronized (thread) {
            thread.notify();
        }
    }

    public abstract boolean collidingX();
    public abstract boolean collidingY();
}
