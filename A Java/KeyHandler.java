import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class KeyHandler implements KeyListener{
    public DemoPanel dp;
    public Node node;
    int goalCol, goalRow;
    
    public KeyHandler(DemoPanel dp) {
        this.dp = dp;
    }
    public void refreshGoalNode(int col, int row){
        dp.refreshPanel();
        dp.setGoalNode(col, row);
        dp.autoSearch();
        System.out.println("From Node to kh");
    }
    public void refreshPanel(){
        dp.refreshPanel();
    }
    public void startAutoSearch(){
        dp.autoSearch();
        dp.autoSearch();
    }
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_ENTER) {
            try{
                dp.autoSearch();
            }
            catch(NullPointerException x){
                System.out.println("Please try again.");
                dp.autoSearch();
            }
            //dp.autoSearch();
        }
    }

    
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }
    /* 
    public void mouseClicked(MouseEvent e) {
        int col = e.getX();
        int row = e.getY();
        if (e.getButton() == MouseEvent.BUTTON1) {
            //dp.setNodes();
            //dp.autoSearch();
            System.out.println("From Key Handler Left click on node at (" + col + ", " + row + ")");
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            System.out.println("From Key Handler Right click on node at (" + col + ", " + row + ")");
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
    */
}

