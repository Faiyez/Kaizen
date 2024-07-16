import javax.swing.JPanel;
import javax.swing.Action;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.Graphics;
public class MenuPanel extends JPanel{
    private DemoPanel dPanel;
    Node[][] roomNames;
    int col;
    int row;
    int totalRooms;
    JButton[] buttonsArray;
    KeyHandler kh;
    public MenuPanel(DemoPanel dp, KeyHandler kh){
        this.dPanel = dp;
        this.kh = kh;
        roomNames = dp.getAllLocations();
        col = dp.maxCol;
        row = dp.maxRow;
        //setPreferredSize(new Dimension(800, 300));
        setLayout(new GridLayout(5,12));
        //setLayout(null);
        buttonsArray = new JButton[col+row];
        setButtons();
        
    }
    
    public void setButtons(){
        totalRooms = 0;
        for(int i = 0; i < col;i++){
            for(int j = 0; j < row;j++){
                if(roomNames[i][j].isTextPresent()){
                    int roomColLocation = i;
                    int roomRowLocation = j;
                    JButton roomButton = new JButton(roomNames[i][j].getText());
                    roomButton.setBounds(50,100,100,20);
                    roomButton.setFont(new Font("Tahoma",Font.BOLD,10));
                    
                    roomButton.addActionListener(e -> kh.refreshGoalNode(roomColLocation, roomRowLocation));
                    buttonsArray[totalRooms] = roomButton;
                    add(roomButton);
                    totalRooms++;
                }
            }
        }
        // for(int i = 0; i< totalRooms; i++){
        //     JButton button = new JButton(buttonsArray[i].getText());
        //     add(button);
        // }
        System.out.println("Total Buttons");
        System.out.println(buttonsArray.length);
        System.out.println(totalRooms);
    }
    public void setGoalAndSearch(int x, int y){
        dPanel.refreshPanel();
        dPanel.setGoalNode(x,y);
        dPanel.autoSearch();
    }
}
