import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;
public class MenuPanel extends JPanel{
    DemoPanel dPanel;
    public MenuPanel(DemoPanel dp, KeyHandler kh){
        this.dPanel = dp;
        setPreferredSize(new Dimension(200, 300));
        setLayout(new GridLayout(3,1));
        JButton testRoom = new JButton("Room 5,5");
        testRoom.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setGoalAndSearch(5, 5);
                System.out.println("Goal set from menupanel");
            }
        });
        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                kh.refreshPanel();
                System.out.println("Refresh button clicked");
            }
        });
        add(testRoom);
        add(refreshButton);
    }
    public void setGoalAndSearch(int x, int y){
        dPanel.setGoalNode(x,y);
        dPanel.autoSearch();
    }
}
