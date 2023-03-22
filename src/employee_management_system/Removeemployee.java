package employee_management_system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class Removeemployee extends JFrame implements ActionListener {
    
    Choice cempid;
    JButton delete, back;
    
    Removeemployee(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel labelempid = new JLabel("Employee Id");
        labelempid.setBounds(50, 50, 100, 30);
        add(labelempid);
        
        cempid = new Choice();
        cempid.setBounds(200, 50, 150, 30);
        add(cempid);
        
        try{
            Conn c = new Conn();
            String query = "select * from employee";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                cempid.add(rs.getString("empid"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 100, 100, 30);
        add(labelname);
        
        JLabel lblname = new JLabel();
        lblname.setBounds(200, 100, 100, 30);
        add(lblname);
        
        JLabel labelcontact = new JLabel("Contact");
        labelcontact.setBounds(50, 150, 100, 30);
        add(labelcontact);
        
        JLabel lblcontact = new JLabel();
        lblcontact.setBounds(200, 150, 100, 30);
        add(lblcontact);
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 200, 100, 30);
        add(labelemail);
        
        JLabel lblemail= new JLabel();
        lblemail.setBounds(200, 200, 200, 30);
        add(lblemail);
        
        try{
            Conn c = new Conn();
            String query = "select * from employee where empid = '"+cempid.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                lblcontact.setText(rs.getString("contact"));
                lblemail.setText(rs.getString("email"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        cempid.addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent ie){
                    try{
                            Conn c = new Conn();
                            String query = "select * from employee where empid = '"+cempid.getSelectedItem()+"'";
                            ResultSet rs = c.s.executeQuery(query);
                            while(rs.next()){
                                lblname.setText(rs.getString("name"));
                                lblcontact.setText(rs.getString("contact"));
                                lblemail.setText(rs.getString("email"));
                            }
                        }catch(Exception e){
                            e.printStackTrace();
        } 
            }
        });
        
        delete = new JButton("Delete");
        delete.setBounds(80, 300, 100, 30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        
        back = new JButton("Back");
        back.setBounds(220, 300, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(420, 0, 570, 400);
        add(image);
        
        setSize(1000, 400);
        setLocation(200, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == delete){
            try{
                Conn c = new Conn();
                String query = "delete from employee where empid = '"+cempid.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Information deleted successfully");
                setVisible(false);
                new Home();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Home(); 
        }
    }
    
    public static void main(String[] args){
        new Removeemployee();
    }
    
}