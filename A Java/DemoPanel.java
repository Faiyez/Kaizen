import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.Timer;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Toolkit;
import javax.imageio.ImageIO;
// Note: Blue color - large rooms, yellow: medium, green: sitting space
// Note: Maybe we can change the background to the map of the window.
// IF error call search node again
public class DemoPanel<ActionEvent> extends JPanel{
    Image character;
    Image backgroundImage;
    Timer timer;
    int xVelocity = 1;
    int yVelocity = 1;
    int x = 0;
    int y = 0;
    final int maxCol = 35;
    final int maxRow = 30;
    final int nodeSize = 20;
    // final int screenWidth = nodeSize * maxCol;
    // final int screenHeight = nodeSize * maxRow;
    final int screenWidth;
    final int screenHeight;
    int goalRow, goalCol;
    Node[][] node = new Node[maxCol][maxRow];
    Node startNode, goalNode, currentNode;
    ArrayList<Node> openList = new ArrayList<>();
    ArrayList<Node> checkedList = new ArrayList<>();
    ArrayList<Node> openListToCheck = new ArrayList<>();
    boolean goalReached = false;
    int step = 0;
    KeyHandler keyHandler;
    MenuPanel mp;
    locations lc;
    public DemoPanel() {
        lc = new locations(this,node);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        screenWidth = screenSize.width;
        screenHeight = screenSize.height;
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setLayout(new GridLayout(maxRow, maxCol));
        keyHandler = new KeyHandler(this);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
        this.requestFocus();
        this.setBorder(null);
        this.setOpaque(false);
        setNodes();
        setStartNode(13,22);
        setGoalNode(13, 4);
        Pointer pt = new Pointer(this, keyHandler);
        character = new ImageIcon("C:/Users/noorf/OneDrive/Documents/Kaizen/A Java/PointerRed.jpg").getImage();
        timer = new Timer(1000, null);
    }

    private void initializePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setLayout(new GridLayout(maxRow, maxCol));
        keyHandler = new KeyHandler(this);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
        this.requestFocus();
        setNodes();
        setStartNode(13, 22);
        setGoalNode(1, 1);
        setSolidNode(10, 2);
        setSolidNode(10, 4);
        setSolidNode(10, 3);
        setSolidNode(10, 5);
        setSolidNode(10, 6);
        setSolidNode(10, 7);

    }
    void setNodes(){
        int col = 0;
        int row = 0;
        int [][] locationsCorridors = locations.getCorridorNodes();
        while(col < maxCol && row < maxRow){
            node[col][row] = new Node(col,row,keyHandler);
            node[col][row].setAsSolid();
            //node[col][row].setBackground(Color.black);
            /*
             * Nodes can be made transparent below
             */
            node[col][row].setBorder(null);
            node[col][row].setBorderPainted(false);
            node[col][row].setContentAreaFilled(false);
            node[col][row].setOpaque(false);
            this.add(node[col][row]);
            //node[col][row].setText("<html>C: " + col + "<br>R:" + row + "</html>");
            node[col][row].setText("<html>C: " + col + "</html>");
            col++;
            if(col == maxCol){
                col=0;
                row++;
            }
        }
        Node[][] locationsNode = locations.setLocations();
        col = 0;
        row = 0;
        while(col < maxCol && row < maxRow){
            //node[col][row].setText(Integer.toString(row));
            if(locationsNode[col][row].isTextPresent()){
                node[col][row].setText(locationsNode[col][row].getText());
            }
            /*
            Corridors can be set below: 
            */                
            if(locationsCorridors[col][row] == 1){
                node[col][row].setAsCorridor();
                //node[col][row].setBorder(null);
                node[col][row].setBorderPainted(true);
                node[col][row].setContentAreaFilled(true);
                node[col][row].setOpaque(true);
                //node[col][row].setBackground(Color.black);
            }
            col++;
            if(col == maxCol){
                col=0;
                row++;
            } 
        }
    }
    void setStartNode(int col, int row){
        node[col][row].setAsStart();
        startNode = node[col][row];
        currentNode = startNode;
    }

    void setSolidNode(int col, int row){
        node[col][row].setAsSolid();
    }
    void setCostOnNodes(){
        int col = 0;
        int row = 0;
        while(col < maxCol && row < maxRow){
            getCost(node[col][row]);
            col++;
            if(col == maxCol){
                col = 0;
                row++;
            }
        }
    }
    // G Cost = Distance between current node and starting node
    private void getCost(Node node){
        // Calculating G Cost
        if (goalNode != null){
            int xDistance = Math.abs(startNode.col - node.col);
            int yDistance = Math.abs(startNode.row - node.row);
            node.gCost = xDistance + yDistance;
            // H Cost = Distance between current position and finish node
            xDistance = Math.abs(goalNode.col - node.col);
            yDistance = Math.abs(goalNode.row - node.row); 
            node.hCost = xDistance + yDistance;
            // F Cost = (G + h)
            node.fCost = node.gCost + node.hCost;
            
            if(node != startNode && node != goalNode ){
                //node.setText("<html>F: " + node.fCost + "<br>G:" + node.gCost + "</html>");

            }
        }
    

    }
    
    public void autoSearch() {
        while (!goalReached) {
            int col = currentNode.col;
            int row = currentNode.row;
            currentNode.setAsChecked();
            checkedList.add(currentNode);
            openList.remove(currentNode);
    
            if (row - 1 >= 0) {
                openNode(node[col][row - 1]);
            }
            if (col - 1 >= 0) {
                openNode(node[col - 1][row]);
            }
            if (row + 1 < maxRow) {
                openNode(node[col][row + 1]);
            }
            if (col + 1 < maxCol) {
                openNode(node[col + 1][row]);
            }
    
            int bestNodeIndex = 0;
            int bestNodefCost = Integer.MAX_VALUE;
            for (int i = 0; i < openList.size(); i++) {
                if (openList.get(i).fCost < bestNodefCost) {
                    bestNodeIndex = i;
                    bestNodefCost = openList.get(i).fCost;
                } else if (openList.get(i).fCost == bestNodefCost) {
                    if (openList.get(i).gCost < openList.get(bestNodeIndex).gCost) {
                        bestNodeIndex = i;
                    }
                }
            }
    
            currentNode = openList.get(bestNodeIndex);
            currentNode.setOpaque(true);
            currentNode.setBorder(null);
            currentNode.setBorderPainted(false);
            currentNode.setContentAreaFilled(false);
            currentNode.setOpaque(false);
            //currentNode.setBackground(Color.BLUE);
            if (currentNode == goalNode) {
                goalReached = true;
                currentNode.setBackground(Color.WHITE);
                currentNode.setForeground(Color.black);
                trackPath(currentNode);
            }
        }
    }
    private void openNode(Node node){
        if(node.open == false && node.checked == false && node.solid == false){
            node.setAsOpen();
            node.parent = currentNode;
            openList.add(node);
        }
    }
    private void trackPath(Node goalNodeFinal) {
        Node current = goalNodeFinal;
        while (current != startNode) {
            current = current.parent;
            current.setBorderPainted(true);
            current.setContentAreaFilled(true);
            current.setOpaque(true);
            current.setBackground(Color.GREEN);
            if (current != startNode) {
                current.setAsPath();
            }
        }
        
       
    }
    void setGoalNode(int col, int row) {
        if (!node[col][row].isSolid() && !node[col][row].isStart()) {
            // Clear previous goal node
            if (goalNode != null) {
                goalNode.clearAsGoal();
            }
            // Set new goal node
            node[col][row].setAsGoal();
            goalNode = node[col][row];
            goalReached = false; // Reset goal reached flag
            System.out.println("Goal node set at column " + col + ", row " + row);
            // Optionally, you can trigger the search algorithm here if needed
        } else {
            System.out.println("Cannot set goal node on a solid or start node.");
        }
        setCostOnNodes();
    }
    public void refreshPanel() {
        node = new Node[maxCol][maxRow];
        startNode = null;
        goalNode = null;
        currentNode = null;
        openList.clear();
        checkedList.clear();
        openListToCheck.clear();
        goalReached = false;
        step = 0;
        // Reinitialize the panel
        initializePanel();
        // Revalidate and repaint the panel to reflect changes
        this.revalidate();
        this.repaint();
        goalReached = false;
        this.removeAll();
        setNodes();
        setStartNode(13,22);
        this.revalidate();
        this.repaint();
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        BufferedImage background;
        try {
            background = ImageIO.read(new File("C:/Users/noorf/OneDrive/Documents/Kaizen/A Java/rooms.png"));
            //g.drawImage(background,x,y,this);
            int panelWidth = getWidth();
            int panelHeight = getHeight();
            g.drawImage(background, 0, 0, panelWidth, panelHeight, this);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //Image background = new ImageIcon("C:/Users/noorf/OneDrive/Documents/Kaizen/A Java/map.jpg");
        //g.drawImage(background,x,y,this);
    }
    
    public void actionPerformed(ActionEvent e){

    }
}