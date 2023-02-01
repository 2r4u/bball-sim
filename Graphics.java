
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

class Graphics  implements ActionListener{

    Icon icon;
    JFrame frame;
    JLabel lbl;
    TextField input;
    TextArea output;
    JPanel ip;
    JPanel tp;
    JPanel op;
    public final String newline="\n";

    public Graphics(){
        frame=new JFrame();
        frame.setSize(700,800);
        frame.setLayout(null);

        tp=new JPanel();
        tp.setSize(700,400);
        tp.setLocation(0,725);
        Font font1 = new Font("SansSerif", Font.BOLD, 20);
        input=new TextField();
        input.setFont(font1);
        input.setPreferredSize(new Dimension(700,100));
        tp.add(input,BorderLayout.CENTER);
        frame.add(tp,SwingConstants.CENTER);

        ip=new JPanel();
        ip.setSize(700,400);
        ip.setLocation(0,0);
        lbl=new JLabel();
        ip.add(lbl);
        frame.add(ip);

        op=new JPanel();
        op.setSize(700,300);
        op.setLocation(0,400);
        output=new TextArea();
        op.add(output);
        frame.add(op);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void setImage(String filename){
        icon=new ImageIcon(filename);
        lbl.setIcon(icon);
    }
    public void actionPerformed(ActionEvent evt) {
        String text = input.getText();
        output.append(text + newline);
    }
}