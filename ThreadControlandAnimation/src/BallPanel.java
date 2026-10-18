import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class BallPanel extends Panel implements Runnable, ActionListener {

    private List<Ball> ballList;

    public BallPanel(){
        this.ballList = new ArrayList<>();

        new Thread(this).start();
    }

    @Override
    public void paint(Graphics g){
        for (int i = 0; i < ballList.size() ; i++){
            ballList.get(i).draw(g);
        }
    }

    @Override
    public void run(){
        while (true){
            try{
                Thread.sleep(33);
                repaint();
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        Ball ball = new Ball(this.getWidth()/2,this.getHeight()/2) {

            @Override
            public boolean collidingX() {
                return x >= getWidth() || x <= 0;
            }

            @Override
            public boolean collidingY() {
                return y >= getHeight() || y <= 0;
            }
        };
        ballList.add(ball);
    };

    public void shake(){
       synchronized (Ball.MONITOR){
           Ball.MONITOR.notify();
       }
    }
}
