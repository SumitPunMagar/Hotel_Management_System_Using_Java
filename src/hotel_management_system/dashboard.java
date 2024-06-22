package hotel_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class dashboard extends JFrame implements ActionListener {


    // constructor
    dashboard(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hotel/Images/frontPic.jpg"));
        Image image = i1.getImage().getScaledInstance(1367,740,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(image);

        JLabel imageLabel = new JLabel(i2);
        imageLabel.setBounds(0,0,1367,740);
        add(imageLabel);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0,0,1367,30);
        imageLabel.add(menuBar);

        JMenu hotelManagement = new JMenu("Hotel Management");
        hotelManagement.setForeground(Color.red);
        menuBar.add(hotelManagement);

        JMenuItem reception = new JMenuItem("Reception");
        reception.addActionListener(this);
        hotelManagement.add(reception);

        JMenu admin = new JMenu("Admin");
        hotelManagement.setForeground(Color.green);
        menuBar.add(admin);

        JMenuItem employee = new JMenuItem("Add Employee");
        employee.addActionListener(this);
        admin.add(employee);

        JMenuItem room = new JMenuItem("Add Room");
        room.addActionListener(this);
        admin.add(room);

        JMenuItem driver = new JMenuItem("Add Driver");
        driver.addActionListener(this);
        admin.add(driver);

        setBounds(0,0,1367,740);
        setTitle("Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Add Employee")){
            new addEmployee();
        } else if (e.getActionCommand().equals("Add Room")) {
            new addRoom();
        } else if (e.getActionCommand().equals("Add Driver")) {
            new addDriver();
        } else if (e.getActionCommand().equals("Reception")) {
            new reception();
        }


    }

    public static void main(String[] args) {
        new dashboard();
    }


}
