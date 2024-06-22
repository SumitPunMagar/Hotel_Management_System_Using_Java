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

public class department extends JFrame implements ActionListener {
    JTable table;
    JLabel departmentLabel, budgetLabel;
    JButton backBtn;

    // constructor
    public department(){


        // department
        departmentLabel = new JLabel("Department");
        departmentLabel.setBounds(20,40,150,25);
        departmentLabel.setForeground(Color.black);
        departmentLabel.setFont(new Font("Raleway",Font.BOLD,12));
        add(departmentLabel);

        // budget
        budgetLabel = new JLabel("Budget");
        budgetLabel.setBounds(270,40,150,25);
        budgetLabel.setForeground(Color.black);
        budgetLabel.setFont(new Font("Raleway",Font.BOLD,12));
        add(budgetLabel);



        // table
        table = new JTable();
        table.setBounds(20,65,500,400);
        add(table);

        Conn c = new Conn();
        String query = "select * from department";
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




        setSize(550,600);
        setTitle("Department");
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
        new department();
    }
}
