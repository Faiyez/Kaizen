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
        node[11][22].setText("FIR");
        node[11][22].setTextPresent(true);
        node[11][22].setBackground(Color.YELLOW);
        node[8][15].setBorder(null);
        node[8][15].setBorderPainted(false);
        node[8][15].setContentAreaFilled(false);
        node[8][15].setOpaque(false);
        /*
         * ROWS ON THE BOTTOM 
         */
        node[9][22].setText("GUARANA");
        node[9][22].setTextPresent(true);
        node[9][22].setBackground(Color.YELLOW);
        node[11][22].setText("FIR");
        node[11][22].setTextPresent(true);
        node[11][22].setBackground(Color.YELLOW);
        node[25][22].setText("DOGWOOD");
        node[25][22].setTextPresent(true);
        node[25][22].setBackground(Color.YELLOW);
        node[27][22].setText("BUTTERCUP");
        node[27][22].setTextPresent(true);
        node[27][22].setBackground(Color.YELLOW);
        node[11][15].setText("BLUEBELI");
        node[11][15].setTextPresent(true);
        node[11][15].setBackground(Color.YELLOW);
        /*
         * END OF ROWS ON THE BOTTOM END
         */
        node[8][22].setText("HEMLOCK");
        node[8][22].setTextPresent(true);
        node[8][22].setBackground(Color.YELLOW);
        node[10][22].setText("FIREWEED");
        node[10][22].setTextPresent(true);
        node[10][22].setBackground(Color.YELLOW);
        node[12][22].setText("EUCALYPTUS");
        node[12][22].setTextPresent(true);
        node[12][22].setBackground(Color.YELLOW);
        node[14][22].setText("ELDERBERRY");
        node[14][22].setTextPresent(true);
        node[14][22].setBackground(Color.BLUE);
        node[6][22].setText("IVY");
        node[6][22].setTextPresent(true);
        node[6][22].setBackground(Color.YELLOW);
        node[4][22].setText("JACKPINE");
        node[4][22].setTextPresent(true);
        node[4][22].setBackground(Color.YELLOW);
        node[7][15].setText("JASMINE");
        node[7][15].setTextPresent(true);
        node[7][15].setBackground(Color.YELLOW);
        node[7][13].setText("JUNIPER");
        node[7][13].setTextPresent(true);
        node[7][13].setBackground(Color.YELLOW);
        node[7][10].setText("MAHOGANY");
        node[7][10].setTextPresent(true);
        node[7][10].setBackground(Color.YELLOW);
        node[7][10].setText("MAHOGANY");
        node[7][10].setTextPresent(true);
        node[7][10].setBackground(Color.YELLOW);
        node[7][10].setText("MAHOGANY");
        node[7][10].setTextPresent(true);
        node[7][10].setBackground(Color.YELLOW);
        node[5][8].setText("NIP APALM");
        node[5][8].setTextPresent(true);
        node[5][8].setBackground(Color.YELLOW);
        /*
         * Start of TOP ROW
         */
        node[4][8].setText("ORCHID");
        node[4][8].setTextPresent(true);
        node[4][8].setBackground(Color.YELLOW);
        node[6][8].setText("PALM");
        node[6][8].setTextPresent(true);
        node[6][8].setBackground(Color.YELLOW);
        node[8][8].setText("POPPY");
        node[8][8].setTextPresent(true);
        node[8][8].setBackground(Color.YELLOW);
        node[10][8].setText("RESTHARROW");
        node[10][8].setTextPresent(true);
        node[10][8].setBackground(Color.YELLOW);
        node[11][8].setText("ROCKROSE");
        node[11][8].setTextPresent(true);
        node[11][8].setBackground(Color.YELLOW);
        // node[15][8].setText("SCOTSPINE");
        // node[15][8].setTextPresent(true);
        // node[15][8].setBackground(Color.YELLOW);
        node[27][8].setText("ALDER");
        node[27][8].setTextPresent(true);
        node[27][8].setBackground(Color.YELLOW);
        node[28][8].setText("AMARANTH");
        node[28][8].setTextPresent(true);
        node[28][8].setBackground(Color.YELLOW);
        node[30][8].setText("ASPEN");
        node[30][8].setTextPresent(true);
        node[30][8].setBackground(Color.YELLOW);
        node[30][10].setText("BAMBO");
        node[30][10].setTextPresent(true);
        node[30][10].setBackground(Color.YELLOW);
        node[28][10].setText("BALSAM");
        node[28][10].setTextPresent(true);
        node[28][10].setBackground(Color.YELLOW);
        node[28][13].setText("DEERBERRY");
        node[28][13].setTextPresent(true);
        node[28][13].setBackground(Color.YELLOW);
        node[28][18].setText("BEECH");
        node[28][18].setTextPresent(true);
        node[28][18].setBackground(Color.YELLOW);
        node[28][22].setText("BLUEBELI");
        node[28][22].setTextPresent(true);
        node[28][22].setBackground(Color.YELLOW);
        
        /*
         * End of TOP ROW
         */
        node[16][22].setText("COTTONWOOD");
        node[16][22].setTextPresent(true);
        node[16][22].setBackground(Color.BLUE);
        node[15][18].setText("CYATHEA");
        node[15][18].setTextPresent(true);
        node[15][18].setBackground(Color.BLUE);
        node[19][22].setText("CLOVER");
        node[19][22].setTextPresent(true);
        node[19][22].setBackground(Color.BLUE);
        node[16][8].setText("SCOTS PINE");
        node[16][8].setTextPresent(true);
        node[16][8].setBackground(Color.BLUE);
        node[17][8].setText("SPRUCE");
        node[17][8].setTextPresent(true);
        node[17][8].setBackground(Color.BLUE);
        node[15][2].setText("SASSFRAS");
        node[15][2].setTextPresent(true);
        node[15][2].setBackground(Color.BLUE);
        node[21][22].setText("CLOUDBERRY");
        node[21][22].setTextPresent(true);
        node[21][22].setBackground(Color.BLUE);
        node[23][22].setText("CHICORY");
        node[23][22].setTextPresent(true);
        node[23][22].setBackground(Color.BLUE);
        /*
         * Columns on the Right End
         */
        node[28][9].setText("PINE");
        node[28][9].setTextPresent(true);
        node[28][9].setBackground(Color.YELLOW);
        node[28][12].setText("CEDAR");
        node[28][12].setTextPresent(true);
        node[28][12].setBackground(Color.YELLOW);
        node[28][15].setText("CHERRY");
        node[28][15].setTextPresent(true);
        node[28][15].setBackground(Color.YELLOW);
        node[28][20].setText("MAPDE");
        node[28][20].setTextPresent(true);
        node[28][20].setBackground(Color.YELLOW);

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
