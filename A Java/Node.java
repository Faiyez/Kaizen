import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
    DemoPanel dp;
    KeyHandler kh;
    public Node(int col, int row, KeyHandler keyHandler) {
        this.col = col;
        this.row = row;
        this.kh = keyHandler;
        setBackground(Color.white);
        setForeground(Color.black);
        addMouseListener(this); // Add the node itself as a mouse listener
    }
    
    public void setAsStart() {
        setBackground(Color.blue);
        setForeground(Color.white);
        setText("Start");
        start = true;
    }
    
    public void setAsGoal() {
        setBackground(Color.BLUE);
        setForeground(Color.black);
        setText("Goal");
        this.goal = true;
    }
    
    public void setAsSolid(){
        setBackground(Color.black);
        setForeground(Color.black);
        solid = true;
    }
    
    public void setAsOpen(){
        open = true;
        //setBackground(Color.pink);
        //setForeground(Color.green);
    }
    
    public void setAsChecked(){
        if(start == false && goal == false){
            //setBackground(Color.gray);
            //setForeground(Color.black);
        }
        checked = true;
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