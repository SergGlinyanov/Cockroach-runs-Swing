package Tarakan;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Main extends JPanel implements ActionListener {

    Image img = new ImageIcon("t2.png").getImage();

    Timer timer = new Timer(20, this);

    Player player = new Player();

    JFrame frame;

    public Main(JFrame frame) {
        this.frame = frame;
        timer.start();
        frame.addKeyListener(new KeyAdapter() {


            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub
                player.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                player.keyReleased(e);
            }

        });
    }

    public void paint(Graphics g) {
        g.drawImage(img, player.getMapX(), player.getMapY(),10, 10, null);
        repaint();
        validate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        repaint();
        player.move();
    }

}