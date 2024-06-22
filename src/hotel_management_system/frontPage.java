package hotel_management_system;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class frontPage extends JFrame implements ActionListener{

    ImageIcon hotelImage;
    JLabel hotelImagePanel, blinkLabel;
    JButton nextButton;
    Timer timer;

    // constructor
    frontPage(){

        setSize(1000,540);
        setLocation(200,100);

        hotelImage = new ImageIcon(ClassLoader.getSystemResource("Hotel/Images/hotel1.jpg"));
        Image image = hotelImage.getImage().getScaledInstance(1000,540,Image.SCALE_DEFAULT);
        hotelImagePanel = new JLabel(new ImageIcon(image));
        add(hotelImagePanel);

        blinkLabel = new JLabel("Stay At Best Hotels In Nepal");
        blinkLabel.setBounds(50,35,500,40);
        blinkLabel.setForeground(Color.black);
        blinkLabel.setFont(new Font("Serif", Font.BOLD, 30));
        hotelImagePanel.add(blinkLabel);


        nextButton = new JButton("Next");
        nextButton.setBounds(850,35,100,35);
        nextButton.setForeground(Color.black);
        nextButton.setBackground(Color.CYAN);
        nextButton.setFocusable(false);
        nextButton.setFont(new Font("Raleway",Font.PLAIN,20));
        // set rounded border
        nextButton.setBorder(new RoundedBorder(15));
        nextButton.addActionListener(this);
        hotelImagePanel.add(nextButton);


        // Setup timer to blink label every 500 milliseconds
        timer = new Timer(700, new ActionListener(){
            boolean visible = true;
            @Override
            public void actionPerformed(ActionEvent e){
                blinkLabel.setVisible(visible);
                visible = !visible;
            }
        });

        timer.start();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


    }

    // Custom border class for rounding the button
    class RoundedBorder implements Border {
        private int radius;

        RoundedBorder(int radius) {
            this.radius = radius;
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
        }

        public boolean isBorderOpaque() {
            return true;
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.setColor(c.getBackground());
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }
    }

    public void actionPerformed(ActionEvent e){
        setVisible(false);
        new login().setVisible(true);
    }


    public static void main(String[] args) {
        new frontPage();
    }
}
