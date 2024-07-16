import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Dimension;
// implements MouseListener
public class Node extends JButton implements MouseListener{
    Node parent;
    int col;
    int row;
    int gCost;
    int hCost;
    int fCost;
    boolean start;
    boolean goal;
    boolean solid;
    boolean open;
    boolean checked;
    boolean hasText;
    DemoPanel dp;
    KeyHandler kh;
    public Node(int col, int row, KeyHandler keyHandler) {
        this.col = col;
        this.row = row;
        this.kh = keyHandler;
        this.hasText = false;
        this.setBorderPainted(true);
        this.setContentAreaFilled(false);
        this.setOpaque(false);
        addMouseListener(this); // Add the node itself as a mouse listener
        // Dimension size = new Dimension(5,5);
        // this.setPreferredSize(size);
        // setMinimumSize(size);
        // setMaximumSize(size);
    }
    public Boolean isTextPresent(){
        return hasText;
    }
    public void setTextPresent(boolean value){
        this.hasText = value;
    }
    
    public void setAsStart() {
        setBackground(Color.blue);
        setForeground(Color.white);
        setText("Start");
        this.start = true;
    }
    
    public void setAsGoal() {
        setBackground(Color.BLUE);
        setForeground(Color.black);
        setText("Goal");
        this.goal = true;
        ImageIcon icon = new ImageIcon("C:/Users/noorf/OneDrive/Documents/Kaizen/A Java/PointerRed.png");
        this.setIcon(icon);
        
    }
    
    public void setAsSolid(){
        setBackground(Color.white);
        //setForeground(Color.black);
        this.solid = true;
    }
    public void setAsCorridor(){
        //setBackground(Color.black);
        //setForeground(Color.GRAY);
        this.solid = false;
    }
    
    public void setAsOpen(){
        this.open = true;
        //setBackground(Color.pink);
        //setForeground(Color.green);
    }
    
    public void setAsChecked(){
        if(start == false && goal == false){
            //setBackground(Color.gray);
            //setForeground(Color.black);
        }
        this.checked = true;
    }
    
    public void setAsPath(){
        setBackground(Color.green);
        setForeground(Color.black);
    }
    
    public boolean isSolid(){
        return solid;
    }
    
    public boolean isStart(){
        return start;
    }
    
    public void clearAsGoal(){
        this.setBackground(Color.white);
        this.goal = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            //dp.setNodes();
            //this.setAsGoal();
            kh.refreshGoalNode(col,row);
            kh.startAutoSearch();
            System.out.println("Left click on node at (" + col + ", " + row + ")");
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            System.out.println("Right click on node at (" + col + ", " + row + ")");
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}