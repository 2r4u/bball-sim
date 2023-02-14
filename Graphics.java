import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.CountDownLatch;

class Graphics{
    static Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    static CountDownLatch ar;
    static Icon icon=new ImageIcon();
    static JFrame frame = new JFrame();
    static JLabel i1 = new JLabel();
    static JLabel i2 = new JLabel();
    static JLabel i3 = new JLabel();
    static TextField input= new TextField();
    static TextArea output=new TextArea();
    static JPanel ip1 = new JPanel();
    static JPanel ip2 = new JPanel();
    static JPanel ip3 = new JPanel();
    static JPanel tp=new JPanel();
    static JPanel op=new JPanel();
    static JScrollPane scroll=new JScrollPane(output);
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
    MouseWheelListener mw = e -> scroll.dispatchEvent(e);
//    private static boolean isMaximized(int state) {
//        return (state & Frame.MAXIMIZED_BOTH) == Frame.MAXIMIZED_BOTH;
//    }


    public static final String newline="\n";

    public Graphics(int t){

        if(t==1){
            frame.setName("Basketball Simulator");
            frame.setSize(sw,sh);
            frame.setLayout(null);
            Font font1 = new Font("SansSerif", Font.BOLD, 27);
            Font font2 = new Font("SansSerif", Font.PLAIN, 27);

//        tp.setBackground(new Color(128, 170, 255));
//        op.setBackground(new Color(128, 170, 255));
            ip1.setBackground(Color.white);
            ip2.setBackground(Color.white);
            ip3.setBackground(Color.white);

            tp.setSize(sw,(int)(sh*0.1));
            tp.setLocation(0,(int)(sh*0.9));
            input.setFont(font1);
            input.setPreferredSize(new Dimension(sw-30,(int)(sh/21.6)));
            input.addActionListener(action);
            tp.add(input);
            frame.add(tp);

            ip1.setSize((sw/3),(sh/2));
            ip1.setLocation(0,0);
            ip1.add(i1);
            frame.add(ip1);

            ip2.setSize((sw/3),(sh/2));
            ip2.setLocation((sw/3),0);
            ip2.add(i2);
            frame.add(ip2);

            ip3.setSize((sw/3),(sh/2));
            ip3.setLocation((2*(sw/3)),0);
            ip3.add(i3);
            frame.add(ip3);

            op.setSize(sw,(sh/2));
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
            frame.setVisible(true);
            input.requestFocusInWindow();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else if (t==2) {
            //add trade gui layout here
        }

    }
    public static void reset(int t){
        i1.setIcon(null);
        i2.setIcon(null);
        i3.setIcon(null);
        if(t==1) {
            i2.setIcon(new ImageIcon("src/warriors.gif"));
        } else if (t==2) {
            i2.setIcon(new ImageIcon("src/lakers.gif"));
        } else if (t==3) {
            i2.setIcon(new ImageIcon("src/grizzlies.gif"));
        } else if (t==4) {
            i2.setIcon(new ImageIcon("src/nuggets.gif"));
        } else if (t==0) {
            i2.setIcon(new ImageIcon("src/logo.gif"));
        }
    }
    public static void setImage(String filename,int panel){
        icon=new ImageIcon(filename);
        if(panel==1) {
            i1.setIcon(icon);
        } else if (panel==2) {
            i2.setIcon(icon);
        } else if (panel==3) {
            i3.setIcon(icon);
        }
        else {
            System.exit(80085);
        }
    }
    public static void write(String s){
        output.append(s+newline);
        ar=new CountDownLatch(1);
    }
}