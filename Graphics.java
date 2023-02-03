
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.CountDownLatch;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

class Graphics{
    static Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    static CountDownLatch ar;
    static Icon icon=new ImageIcon();
    static JFrame frame = new JFrame();
    static JLabel lbl = new JLabel();
    static TextField input= new TextField();
    static TextArea output=new TextArea();
    static JPanel ip = new JPanel();
    static JPanel tp=new JPanel();
    static JPanel op=new JPanel();
    static JScrollPane scroll=new JScrollPane(output);
    static JScrollBar vs=scroll.getVerticalScrollBar();
    static int sw = (int)size.getWidth();
    static int sh = (int)size.getHeight();
    Action action = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e){
            try {


                String text = input.getText();
                Main.input(text);
                input.setText("");
                ar.countDown();
            }
            catch(Exception ex){
                System.exit(69);
            }
        }
    };
    MouseWheelListener mw = new MouseWheelListener() {
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            scroll.dispatchEvent(e);
        }
    };
    private static boolean isMaximized(int state) {
        return (state & Frame.MAXIMIZED_BOTH) == Frame.MAXIMIZED_BOTH;
    }


    public static final String newline="\n";

    public Graphics(){
        frame.setSize(sw,sh);
        frame.setLayout(null);

        Font font1 = new Font("SansSerif", Font.BOLD, 27);
        Font font2 = new Font("SansSerif", Font.PLAIN, 27);

        tp.setBackground(new Color(128, 170, 255));
        op.setBackground(new Color(128, 170, 255));
        ip.setBackground(new Color(128, 170, 255));

        tp.setSize(sw,(int)(sh*0.1));
        tp.setLocation(0,(int)(sh*0.9));
//
        input.setFont(font1);
        input.setPreferredSize(new Dimension(sw-30,(int)(sh/21.6)));
        input.addActionListener(action);
        tp.add(input);
        frame.add(tp);

        ip.setSize(sw,(int)(400));
        ip.setLocation(0,0);
        ip.add(lbl);
        frame.add(ip);

        op.setSize(sw,(int)(sh/2));
        op.setLocation(0,(int)(sh*0.5));
        output.setPreferredSize(new Dimension(sw-30,(int)(sh*0.4)));
        output.setEditable(false);
        output.setFont(font2);
        op.add(output);

        scroll.addMouseWheelListener(mw);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setAutoscrolls(true);
        frame.add(op);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        frame.setUndecorated(true);
        frame.setVisible(true);
        input.requestFocusInWindow();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
//    public static void maximize(int sw, int sh){
//        frame.setSize(sw,sh);
//        frame.setLayout(null);
//
//        Font font1 = new Font("SansSerif", Font.BOLD, 20);
//        Font font2 = new Font("SansSerif", Font.PLAIN, 20);
//
//        tp.setSize(sw,120);
//        tp.setLocation(0,980);
//        input.setFont(font1);
//        input.setPreferredSize(new Dimension(sw,100));
//
//        ip.setSize(sw,400);
//        ip.setLocation(0,0);
//
//        op.setSize(sw,540);
//        op.setLocation(0,540);
//        output.setPreferredSize(new Dimension(sw,540));
//    }
    public static void setImage(String filename){
        icon=new ImageIcon(filename);
//        lbl.setSize(new Dimension((int)(sw/3),(int)(sh*0.45)));
        lbl.setIcon(icon);
    }
    public static void write(String s){
        output.append(s+newline);
        ar=new CountDownLatch(1);
        //Make sure the new text is visible, even if there
        //was a selection in the text area.
    }
}