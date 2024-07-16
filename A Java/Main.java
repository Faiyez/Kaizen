import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.Dimension;
public class Main{
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        JPanel mainPanel = new JPanel(new BorderLayout());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) (screenSize.width * 0.9);
        int height = (int) (screenSize.height * 0.9);
        window.setSize(new Dimension(width, height));
        DemoPanel dp = new DemoPanel();
        KeyHandler kh = new KeyHandler(dp);
        MenuPanel mp = new MenuPanel(dp,kh);
        mainPanel.add(dp, BorderLayout.CENTER);
        mainPanel.add(mp, BorderLayout.SOUTH);
        window.add(mainPanel);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
    
}