import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame {
    private BallPanel ballPanel;
    private Panel buttonPanel;
    private Button addBall;
    private Button shakePanel;

    public MyFrame(){
        this.ballPanel = new BallPanel();
        this.addBall = new Button("Add Ball");
        this.shakePanel = new Button("Shake Balls");
        this.buttonPanel = new Panel();

        FlowLayout layout = new FlowLayout();
        buttonPanel.setLayout(layout);

        buttonPanel.add(addBall);
        buttonPanel.add(shakePanel);

        this.setLayout(new BorderLayout());
        add(ballPanel,BorderLayout.CENTER);
        add(buttonPanel,BorderLayout.SOUTH);

        ballPanel.setBackground(Color.YELLOW);
        buttonPanel.setBackground(Color.GREEN);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });

        addBall.addActionListener(ballPanel);
        shakePanel.addActionListener(e -> {ballPanel.shake();
        });

        setSize(500,500);
        setVisible(true);


    }

    public static void main(String[] args) {
        MyFrame f = new MyFrame();
    }
}
