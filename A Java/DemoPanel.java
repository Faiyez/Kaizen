import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.ArrayList;
// Note: Maybe we can change the background to the map of the window.
// IF error call search node again
public class DemoPanel extends JPanel{
    final int maxCol = 15;
    final int maxRow = 15;
    final int nodeSize = 70;
    final int screenWidth = nodeSize * maxCol;
    final int screenHeight = nodeSize * maxRow;
    int goalRow, goalCol;
    Node[][] node = new Node[maxCol][maxRow];
    Node startNode, goalNode, currentNode;
    ArrayList<Node> openList = new ArrayList<>();
    ArrayList<Node> checkedList = new ArrayList<>();
    ArrayList<Node> openListToCheck = new ArrayList<>();
    boolean goalReached = false;
    int step = 0;
    KeyHandler keyHandler;
    public DemoPanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setLayout(new GridLayout(maxRow, maxCol));
        keyHandler = new KeyHandler(this);
        this.addKeyListener(keyHandler);
        //this.addMouseListener(keyHandler);        
        this.setFocusable(true);
        this.requestFocus();
        setNodes();
        setStartNode(3,6);
        setGoalNode(11,3);
        setSolidNode(10,2);
        setSolidNode(10,4);
        setSolidNode(10,3);
        setSolidNode(10,5);
        setSolidNode(10,6);
        setSolidNode(10,7);
    }
    void setNodes(){
        int col = 0;
        int row = 0;
        while(col < maxCol && row < maxRow){
            node[col][row] = new Node(col,row,keyHandler);
            this.add(node[col][row]);
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
            node.setText("<html>F: " + node.fCost + "<br>G:" + node.gCost + "</html>");

        }

    }
    
    public void autoSearch(){
        while(goalReached == false){
            int col = currentNode.col;
            int row = currentNode.row;
            currentNode.setAsChecked();
            checkedList.add(currentNode);
            openList.remove(currentNode);
            if(row-1>0){
                openNode(node[col][row-1]);
            }
            if(col-1 > 0){
                openNode(node[col-1][row]);
            }
            if(row+1 < maxRow){
                openNode(node[col][row+1]);
            }
            if(col+1< maxCol){
                openNode(node[col+1][row]);
            }
            int bestNodeIndex = 0;
            int bestNodefCost = 999;
            for(int i = 0; i < openList.size(); i++){
                if(openList.get(i).fCost < bestNodefCost){
                    bestNodeIndex = i;
                    bestNodefCost = openList.get(i).fCost;
                }
                else if(openList.get(i).fCost == bestNodefCost){
                    if(openList.get(i).gCost < openList.get(bestNodeIndex).gCost){
                        bestNodeIndex = i;
                    }
                }
            }
            currentNode = openList.get(bestNodeIndex);
            currentNode.setBackground(Color.red);
            if(currentNode == goalNode){
                goalReached = true;
                trackPath(currentNode);
                System.out.println("*        *        ***************        Goal reached           **************************");
                System.out.println(currentNode.col);
                System.out.println(currentNode.row);
                System.out.println(goalNode.col);
                System.out.println(goalNode.row);
            }
        }
        System.out.println("*        *        ***************The content in open list is: **************************");
        for(Node e : openList){
            System.out.print(e.row);
            System.out.print(",");
            System.out.print(e.col);
            System.out.println();
        }
    }
    private void openNode(Node node){
        if(node.open == false && node.checked == false && node.solid == false){
            node.setAsOpen();
            node.parent = currentNode;
            openList.add(node);
        }
    }
    private void trackPath(Node goalNodeFinal){
        Node current = goalNodeFinal;
        while(current != startNode){
            current = current.parent;
            if(current != startNode){
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
        this.removeAll();
        setNodes();
        setStartNode(3,6);
        setSolidNode(10,2);
        setSolidNode(10,4);
        setSolidNode(10,3);
        setSolidNode(10,5);
        setSolidNode(10,6);
        setSolidNode(10,7);
        this.revalidate();
        this.repaint();
    }
}