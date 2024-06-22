package Reception;


import hotel_management_system.Conn;
import hotel_management_system.reception;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class employeeInfo extends JFrame implements ActionListener {

    JTable table;
    JLabel nameLabel, ageLabel, genderLabel, jobLabel, salaryLabel, phoneLabel, emailLabel;
    JButton backBtn;

    // constructor
    public employeeInfo(){


        // name
        nameLabel = new JLabel("Name");
        nameLabel.setBounds(20,40,150,25);
        nameLabel.setForeground(Color.black);
        nameLabel.setFont(new Font("Raleway",Font.BOLD,12));
        add(nameLabel);

        // age
        ageLabel = new JLabel("Age");
        ageLabel.setBounds(160,40,150,25);
        ageLabel.setForeground(Color.black);
        ageLabel.setFont(new Font("Raleway",Font.BOLD,12));
        add(ageLabel);

        // gender
        genderLabel = new JLabel("Gender");
        genderLabel.setBounds(290,40,150,25);
        genderLabel.setForeground(Color.black);
        genderLabel.setFont(new Font("Raleway",Font.BOLD,12));
        add(genderLabel);

        // job
        jobLabel = new JLabel("Job");
        jobLabel.setBounds(430,40,150,25);
        jobLabel.setForeground(Color.black);
        jobLabel.setFont(new Font("Raleway",Font.BOLD,12));
        add(jobLabel);

        // salary
        salaryLabel = new JLabel("Salary");
        salaryLabel.setBounds(565,40,150,25);
        salaryLabel.setForeground(Color.black);
        salaryLabel.setFont(new Font("Raleway",Font.BOLD,12));
        add(salaryLabel);

        // phone
        phoneLabel = new JLabel("Phone");
        phoneLabel.setBounds(700,40,150,25);
        phoneLabel.setForeground(Color.black);
        phoneLabel.setFont(new Font("Raleway",Font.BOLD,12));
        add(phoneLabel);

        // email
        emailLabel = new JLabel("Email");
        emailLabel.setBounds(835,40,150,25);
        emailLabel.setForeground(Color.black);
        emailLabel.setFont(new Font("Raleway",Font.BOLD,12));
        add(emailLabel);




        // table
        table = new JTable();
        table.setBounds(20,65,950,400);
        add(table);

        Conn c = new Conn();
        String query = "select * from employee";
        try {
            ResultSet rs = c.s.executeQuery(query);

            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            System.out.println(e);
        }


        backBtn = new JButton("Back");
        backBtn.setBounds(20,500,120,37);
        backBtn.setForeground(Color.black);
        backBtn.setBackground(Color.CYAN);
        backBtn.setFocusable(false);
        backBtn.setFont(new Font("Raleway",Font.PLAIN,17));
        // Set rounded border
        backBtn.setBorder(new RoundedBorder(15)); // 15 is the radius of the border
        backBtn.addActionListener(this);
        add(backBtn);




        setSize(1000,600);
        setTitle("Employee Info");
        getContentPane().setBackground(Color.white);
        setLocationRelativeTo(null);
        setLayout(null);
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

    @Override
    public void actionPerformed(ActionEvent e) {

        setVisible(false);
        new reception();
    }

    public static void main(String[] args) {
        new employeeInfo();
    }
}
