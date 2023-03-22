package employee_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Updateemployee extends JFrame implements ActionListener {
    
    JTextField  tffname, tfaddress, tfcontact,  tfemail, tfsalary, tfdesignation;
    JLabel lblempid;
    JButton add, back;
    String empid;
    JComboBox cbeducation;
    
    Updateemployee(String empid){
        
        this.empid = empid;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("UPDATE EMPLOYEE DETAIL");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(25, 200, 150, 30);
        labelname.setFont(new Font("serif", Font.BOLD, 18));
        add(labelname);
        
        JLabel lblname = new JLabel();
        lblname.setBounds(200, 200, 150, 30);
        add(lblname);
        
        JLabel labelfname = new JLabel("Father's name");
        labelfname.setBounds(450, 200, 150, 30);
        labelfname.setFont(new Font("serif", Font.BOLD, 18));
        add(labelfname);
        
        JLabel lblfname = new JLabel();
        lblfname.setBounds(650, 200, 150, 30);
        add(lblfname);
        
        JLabel labeldob = new JLabel("Date of Birth");
        labeldob.setBounds(25, 250, 150, 30);
        labeldob.setFont(new Font("serif", Font.BOLD, 18));
        add(labeldob);
        
        JLabel lbldob = new JLabel();
        lbldob.setBounds(200, 250, 150, 30);
        add(lbldob);
        
        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(450, 250, 150, 30);
        labelsalary.setFont(new Font("serif", Font.BOLD, 18));
        add(labelsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(650, 250, 150, 30);
        add(tfsalary);
        
        JLabel labeladdresss = new JLabel("Address");
        labeladdresss.setBounds(25, 300, 150, 30);
        labeladdresss.setFont(new Font("serif", Font.BOLD, 18));
        add(labeladdresss);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 300, 150, 30);
        add(tfaddress);
        
        JLabel labelcontact = new JLabel("Contact no.");
        labelcontact.setBounds(450, 300, 150, 30);
        labelcontact.setFont(new Font("serif", Font.BOLD, 18));
        add(labelcontact);
        
        tfcontact = new JTextField();
        tfcontact.setBounds(650, 300, 150, 30);
        add(tfcontact);
        
        JLabel labelemail = new JLabel("E-mail");
        labelemail.setBounds(25, 350, 150, 30);
        labelemail.setFont(new Font("serif", Font.BOLD, 18));
        add(labelemail);
        
        tfemail= new JTextField();
        tfemail.setBounds(200, 350, 150, 30);
        add(tfemail);
        
        JLabel labeleducation = new JLabel("Highest Education");
        labeleducation.setBounds(450, 350, 150, 30);
        labeleducation.setFont(new Font("serif", Font.BOLD, 18));
        add(labeleducation);
        
        String courses[] = {"B.tech", "BBA", "BCA", "B.Com", "BSC", "MBA", "MCA", "MA", "M.tech", "MSC", "PHD"};
        cbeducation = new JComboBox(courses);
        cbeducation.setBackground(Color.WHITE);
        cbeducation.setBounds(650, 350, 150, 30);
        add(cbeducation);
        
        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(25, 400, 150, 30);
        labeldesignation.setFont(new Font("serif", Font.BOLD, 18));
        add(labeldesignation);
        
        tfdesignation = new JTextField();
        tfdesignation.setBounds(200, 400, 150, 30);
        add(tfdesignation);
        
        JLabel labelaadhar = new JLabel("Aadhar no.");
        labelaadhar.setBounds(450, 400, 150, 30);
        labelaadhar.setFont(new Font("serif", Font.BOLD, 18));
        add(labelaadhar);
        
        JLabel lblaadhar = new JLabel();
        lblaadhar.setBounds(650, 400, 150, 30);
        add(lblaadhar);
        
        JLabel labelempid = new JLabel("Employee Id");
        labelempid.setBounds(25, 150, 150, 30);
        labelempid.setFont(new Font("serif", Font.BOLD, 18));
        add(labelempid);
        
        lblempid = new JLabel();
        lblempid.setBounds(200, 150, 150, 30);
        lblempid.setFont(new Font("serif", Font.BOLD, 18));
        add(lblempid);
        
        try{
           Conn c = new Conn();
           String query = "select * from employee where empid = '"+empid+"'";
           ResultSet rs = c.s.executeQuery(query);
           while(rs.next()){
               lblname.setText(rs.getString("name"));
               lblfname.setText(rs.getString("fname"));
               lbldob.setText(rs.getString("dob"));
               tfsalary.setText(rs.getString("salary"));
               tfaddress.setText(rs.getString("address"));
               tfcontact.setText(rs.getString("contact"));
               tfemail.setText(rs.getString("email"));
               cbeducation.setSelectedItem(rs.getString("education"));
               tfdesignation.setText(rs.getString("designation"));
               lblaadhar.setText(rs.getString("aadhar"));
               lblempid.setText(rs.getString("empid"));
               
           }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        add = new JButton("Update Details");
        add.setBounds(250, 550, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        setSize(900, 700);
        setLocation(230, 15);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String contact = tfcontact.getText();
            String email = tfemail.getText();
            String education = (String)cbeducation.getSelectedItem();
            String designation = tfdesignation.getText();
            
            try{
                Conn conn = new Conn();
                String query = "update employee set salary='"+salary+"',address='"+address+"',contact='"+contact+"',email='"+email+"',education='"+education+"',designation='"+designation+"'where empid='"+empid+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                setVisible(false);
                new Viewemployee();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String[] args){
        new Updateemployee("");
    }
    
}