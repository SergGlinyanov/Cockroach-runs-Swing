package Tarakan;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;

public class MovingBall extends JPanel implements MouseListener {

    BufferedImage img;
    int WIDTH;
    int HEIGHT;
    int X, Y, dx, dy, R;
    static boolean beg=false;
    final Random random = new Random();

    MovingBall() {
        WIDTH = 1500;
        HEIGHT = 150;

        X = 0;
        Y = 75;
        dx = 1;
        dy = 1;
        R = 10;

        JFrame frame = new JFrame("movement");
        JTextField start = new JTextField("START");
        JTextField finish = new JTextField("FINISH");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        img = new BufferedImage(WIDTH + R, HEIGHT + R, BufferedImage.TYPE_INT_BGR);

        frame.add(this);
        frame.pack();
        //finish.isEditable();

        frame.add(start,BorderLayout.WEST);
        frame.add(finish,BorderLayout.EAST);
        start.setBackground(Color.GREEN);
        finish.setBackground(Color.GREEN);



        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (X + R < 0 | X+60  > WIDTH) {
                    dx *= (-1);

                }

                if (Y + R < 0 | Y+60  > HEIGHT) {
                    dy *= (-1);

                }

                X += dx;
                Y += dy;

                paintOnImg();
            }
        });

        timer.start();

        frame.setResizable(false);
        frame.setVisible(true);

    }

    private Image image;

    public void paintOnImg() {


        if (dy<0){
        try
        {
            image = ImageIO.read(new File("src/t4.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        Graphics g = img.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDTH + R, HEIGHT + R); //cleaning the image;

        g.drawImage(image,X + R, Y + R,null);

        g.dispose();

        repaint();}

        else if (dy>=0){
            try
            {
                image = ImageIO.read(new File("src/t3.png"));
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
            Graphics g = img.createGraphics();
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, WIDTH + R, HEIGHT + R); //cleaning the image;

            g.drawImage(image,X + R, Y + R,null);

            g.dispose();

            repaint();

        }
        else if (beg=true) {
            try
            {
                image = ImageIO.read(new File("src/t2.png"));
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
            Graphics g = img.createGraphics();
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, WIDTH + R, HEIGHT + R); //cleaning the image;

            g.drawImage(image,X + R, Y + R,null);

            g.dispose();

            repaint();}



    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    public static void main(String[] args) {
        new MovingBall();
        System.out.println(beg);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        beg=true;

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        beg=false;

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}