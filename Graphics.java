
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.CountDownLatch;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

class Graphics{
    static CountDownLatch ar;
    static Icon icon=new ImageIcon();
    static JFrame frame = new JFrame();
    static JLabel lbl = new JLabel();
    static TextField input= new TextField();
    static TextArea output=new TextArea();
    static JPanel ip = new JPanel();
    static JPanel tp=new JPanel();
    static JPanel op=new JPanel();
    static JScrollPane scroll=new JScrollPane();
    Action action = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e){
            try {


                String text = input.getText();
                Main.input(text);
                ar.countDown();
            }
            catch(Exception ex){
                System.exit(69);
            }
        }
    };

    public static final String newline="\n";

    public Graphics(){
        frame.setSize(700,800);
        frame.setLayout(null);

        Font font1 = new Font("SansSerif", Font.BOLD, 20);
        Font font2 = new Font("SansSerif", Font.PLAIN, 20);

        tp.setSize(700,50);
        tp.setLocation(0,700);
        input.setFont(font1);
        input.setPreferredSize(new Dimension(700,50));
        input.addActionListener(action);
        tp.add(input);
        frame.add(tp);

        ip.setSize(700,400);
        ip.setLocation(0,0);
        ip.add(lbl);
        frame.add(ip);

        op.setSize(700,300);
        op.setLocation(0,400);
        output.setPreferredSize(new Dimension(700,300));
        output.setEditable(false);
        output.setFont(font2);
        op.add(output);
        op.add(scroll);
        frame.add(op);




        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public static void setImage(String filename){
        icon=new ImageIcon(filename);
        lbl.setIcon(icon);
    }
    public static void write(String s){
        output.append(s+newline);
        ar=new CountDownLatch(1);
        //Make sure the new text is visible, even if there
        //was a selection in the text area.
    }
}