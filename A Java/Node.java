// Each node is a JButton
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Node extends JButton implements ActionListener, MouseListener{
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
    DemoPanel demoPanel = KeyHandler.getDemopanel();

    public Node(int col, int row){
        this.col = col;
        this.row = row;
        setBackground(Color.white);
        setForeground(Color.black);
        addActionListener(this);
        addMouseListener(this); 
    
    }

    public void actionPerformed(ActionEvent e){
        setBackground(Color.orange);
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
        goal = true;
    }
    public void setAsSolid(){
        setBackground(Color.black);
        setForeground(Color.black);
        solid = true;
    }
    public void setAsOpen(){
        open = true;
        setBackground(Color.pink);
        setForeground(Color.green);
    }
    public void setAsChecked(){
        if(start == false && goal == false){
            setBackground(Color.orange);
            setForeground(Color.black);
        }
        checked=true;
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
        int col = e.getX();
        int row = e.getY();
        System.out.println("******** Mouse clicked ********");
        System.out.println(col);
        System.out.println(row);
        demoPanel.setGoalNode(col, row);
        demoPanel.autoSearch();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
    }

}
