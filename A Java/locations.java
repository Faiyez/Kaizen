import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Dimension;
//9,17
public class locations {
    DemoPanel demoPanel;
    static Node[][] node;
    public locations(DemoPanel dp, Node[][] node){
        this.demoPanel = dp;
        this.node = node;
    }
    public static Node[][] setLocations(){
        node[6][6].setText("Test 2");
        node[6][6].setTextPresent(true);
        node[6][6].setBackground(Color.YELLOW);
        node[8][15].setText("FIR");
        node[8][15].setTextPresent(true);
        node[8][15].setBackground(Color.YELLOW);
        node[6][15].setText("GUARANA");
        node[6][15].setTextPresent(true);
        node[6][15].setBackground(Color.YELLOW);
        // Dimension size = new Dimension(20,20);
        // node[6][15].setPreferredSize(size);
        // node[6][15].setMinimumSize(size);
        // node[6][15].setMaximumSize(size);
        ImageIcon icon = new ImageIcon("C:/Users/noorf/OneDrive/Documents/Kaizen/A Java/desk1.jpg");
        node[6][12].setIcon(icon);
        return node;
    }
}
