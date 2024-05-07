import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.GridLayout;
public class DemoPanel extends JPanel{
    final int maxCol = 15;
    final int maxRow = 10;
    final int nodeSize = 70;
    final int screenWidth = nodeSize * maxCol;
    final int screenHeight = nodeSize * maxRow;

    Node[][] node = new Node[maxCol][maxRow];
    Node startNode, goalNode, currentNode;
    public DemoPanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setLayout(new GridLayout(maxRow, maxCol));

        int col = 0;
        int row = 0;
        while(col < maxCol && row < maxRow){
            node[col][row] = new Node(col,row);
            this.add(node[col][row]);
            col++;
            if(col == maxCol){
                col=0;
                row++;
            }
        }
        setStartNode(3,6);
        setGoalNode(9,6);
        setSolidNode(10,2);
        setSolidNode(10,4);
        setSolidNode(10,3);
        setSolidNode(10,5);
        setSolidNode(10,6);
        setSolidNode(10,7);
        setCostOnNodes();
    }
    private void setStartNode(int col, int row){
        node[col][row].setAsStart();
        startNode = node[col][row];
        currentNode = startNode;
    }
    private void setGoalNode(int col, int row){
        node[col][row].setAsGoal();
        goalNode = node[col][row];
        
    }
    private void setSolidNode(int col, int row){
        node[col][row].setAsSolid();
    }
    private void setCostOnNodes(){
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

        xDistance = Math.abs(goalNode.col - node.col);
        yDistance = Math.abs(goalNode.row - node.row); 
        node.hCost = xDistance + yDistance;

        node.fCost = node.gCost + node.hCost;
        if(node != startNode && node != goalNode ){
            node.setText("<html>F: " + node.fCost + "<br>G:" + node.gCost + "</html>");

        }

    }
    // H Cost = Distance between current position and finish node
    

    // F Cost = (G + h)
}