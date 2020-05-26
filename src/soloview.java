import java.awt.event.ActionListener;
import javax.swing.*;

public class soloview extends JFrame {
    private JPanel panel1;
    private JButton option1;
    private JButton option2;
    private JTextArea story;

//    soloview() {
//        JPanel soloPanel = new JPanel();
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setSize(800, 400);
//        soloPanel.add(story);
//
//    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("soloview");
        frame.setContentPane(new soloview().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void addSoloListener(solocontroller.Sololistener sololistener) {
        option1.addActionListener(sololistener);
        option2.addActionListener(sololistener);
    }
}
