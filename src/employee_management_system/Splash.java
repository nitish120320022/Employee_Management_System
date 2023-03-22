package employee_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener{
    
    Splash(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(590, 30, 1200, 60);
        heading.setFont(new Font("serif", Font.PLAIN, 30));
            heading.setForeground(Color.RED);
        add(heading);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1180, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(00,00, 1170, 650);
        add(image);
        
        JButton clickhere = new JButton("CLICK HERE TO CONTINUE");
        clickhere.setBounds(800, 520, 200, 50);
        clickhere.setBackground(Color.BLACK);
        clickhere.setForeground(Color.WHITE);
        clickhere.addActionListener(this);
        image.add(clickhere);
        
        setSize(1170, 650);
        setLocation(100, 25);
        setVisible(true);
        
        while(true){
            heading.setVisible(false);
            try{
                    Thread.sleep(800);
                    }catch(Exception e){
                            
                            }
            heading.setVisible(true);
             try{
                    Thread.sleep(500);
                    }catch(Exception e){
                            
                            }
            
        }
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }
    
    public static void main(String args[]){
        new Splash();
        
    }
}