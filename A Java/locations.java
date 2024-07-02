import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Dimension;
//9,17
public class locations {
    DemoPanel demoPanel;
    static Node[][] node;
    static int[][] corridorNodes;
    static int dpCol;
    static int dpRow;
    public locations(DemoPanel dp, Node[][] node){
        this.demoPanel = dp;
        this.node = node;
        this.dpCol = dp.maxCol;
        this.dpRow = dp.maxRow;
    }
    
    public static Node[][] setLocations(){
        node[8][15].setText("FIR");
        node[8][15].setTextPresent(true);
        //node[8][15].setBackground(Color.YELLOW);
        node[8][15].setBorder(null);
        node[8][15].setBorderPainted(false);
        node[8][15].setContentAreaFilled(false);
        node[8][15].setOpaque(false);
        node[8][15].setText("GUARANA");
        node[8][15].setTextPresent(true);
        node[8][15].setBackground(Color.YELLOW);
        node[8][13].setText("HEMLOCK");
        node[8][13].setTextPresent(true);
        node[8][13].setBackground(Color.YELLOW);
        node[7][13].setText("FIREWEED");
        node[7][13].setTextPresent(true);
        node[7][13].setBackground(Color.YELLOW);
        node[9][13].setText("EUCALYPTUS");
        node[9][13].setTextPresent(true);
        node[9][13].setBackground(Color.YELLOW);
        node[11][13].setText("ELDERBERRY");
        node[11][13].setTextPresent(true);
        node[11][13].setBackground(Color.BLUE);
        node[11][12].setTextPresent(true);
        node[11][12].setBackground(Color.BLUE);
        node[11][11].setTextPresent(true);
        node[11][11].setBackground(Color.BLUE);
        node[3][13].setText("IVY");
        node[3][13].setTextPresent(true);
        node[3][13].setBackground(Color.YELLOW);
        node[1][13].setText("JACKPINE");
        node[1][13].setTextPresent(true);
        node[1][13].setBackground(Color.YELLOW);
        node[4][10].setText("JASMINE");
        node[4][10].setTextPresent(true);
        node[4][10].setBackground(Color.YELLOW);
        node[4][8].setText("JUNIPER");
        node[4][8].setTextPresent(true);
        node[4][8].setBackground(Color.YELLOW);
        node[4][7].setText("MAHOGANY");
        node[4][7].setTextPresent(true);
        node[4][7].setBackground(Color.YELLOW);
        node[4][6].setText("MAHOGANY");
        node[4][6].setTextPresent(true);
        node[4][6].setBackground(Color.YELLOW);
        node[4][5].setText("MAHOGANY");
        node[3][5].setTextPresent(true);
        node[3][5].setBackground(Color.YELLOW);
        node[4][5].setText("NIP APALM");
        node[4][5].setTextPresent(true);
        node[4][5].setBackground(Color.YELLOW);
        node[4][3].setText("ORCHID");
        node[4][3].setTextPresent(true);
        node[4][3].setBackground(Color.YELLOW);
        node[6][3].setText("PALM");
        node[6][3].setTextPresent(true);
        node[6][3].setBackground(Color.YELLOW);
        node[8][3].setText("POPPY");
        node[8][3].setTextPresent(true);
        node[8][3].setBackground(Color.YELLOW);
        node[6][3].setText("RESTHARROW");
        node[6][3].setTextPresent(true);
        node[6][3].setBackground(Color.YELLOW);
        node[7][3].setText("ROCKROSE");
        node[7][3].setTextPresent(true);
        node[7][3].setBackground(Color.YELLOW);
        node[16][13].setText("COTTONWOOD");
        node[16][13].setTextPresent(true);
        node[16][13].setBackground(Color.BLUE);
        node[16][11].setText("CYATHEA");
        node[16][11].setTextPresent(true);
        node[16][11].setBackground(Color.BLUE);
        node[15][13].setText("CLOVER");
        node[15][13].setTextPresent(true);
        node[15][13].setBackground(Color.BLUE);
        node[13][3].setText("SCOTS PINE");
        node[13][3].setTextPresent(true);
        node[13][3].setBackground(Color.BLUE);
        node[14][3].setText("SPRUCE");
        node[14][3].setTextPresent(true);
        node[14][3].setBackground(Color.BLUE);
        node[14][1].setText("SASSFRAS");
        node[14][1].setTextPresent(true);
        node[14][1].setBackground(Color.BLUE);
        node[17][13].setText("CLOUDBERRY");
        node[17][13].setTextPresent(true);
        node[17][13].setBackground(Color.BLUE);
        node[19][13].setText("CHICORY");
        node[19][13].setTextPresent(true);
        node[19][13].setBackground(Color.BLUE);
        node[0][9].setText("DESK");
        node[0][9].setTextPresent(true);
        node[0][9].setBackground(Color.GREEN);
        node[1][9].setText("SPACE");
        node[1][9].setTextPresent(true);
        node[1][9].setBackground(Color.GREEN);
        node[1][10].setBackground(Color.GREEN);
        node[0][10].setBackground(Color.GREEN);
        node[1][11].setBackground(Color.GREEN);
        node[0][11].setBackground(Color.GREEN);
        // Dimension size = new Dimension(20,20);
        // node[6][15].setPreferredSize(size);
        // node[6][15].setMinimumSize(size);
        // node[6][15].setMaximumSize(size);
        //ImageIcon icon = new ImageIcon("C:/Users/noorf/OneDrive/Documents/Kaizen/A Java/chair3.png");
        // ImageIcon icon = new ImageIcon("C:/Users/noorf/OneDrive/Documents/Kaizen/A Java/Pointer.png");

        // node[6][12].setIcon(icon);
        return node;
    }
    public static int[][] getCorridorNodes(){
        corridorNodes = new int[dpCol][dpRow];
        for(int i = 2; i < 29;i++){
            corridorNodes[i][22] = 1;
        }
        for(int i = 7; i < 22;i++){
            corridorNodes[7][i] = 1;
        }
        for(int i = 2; i < 29;i++){
            corridorNodes[i][8] = 1;
        }
        for(int i = 9; i < 22;i++){
            corridorNodes[20][i] = 1;
        }
        for(int i = 9; i < 22;i++){
            corridorNodes[26][i] = 1;
        }
        for(int i = 9; i < 25;i++){
            corridorNodes[28][i] = 1;
        }
        for(int i = 2; i < 22;i++){
            corridorNodes[15][i] = 1;
        }
        for(int i = 28; i < 31;i++){
            corridorNodes[i][9] = 1;
        }
        return corridorNodes;
    }
    
}
