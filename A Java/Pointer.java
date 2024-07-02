import java.security.Key;

public class Pointer {
    DemoPanel dp;
    KeyHandler kh;
    int x,y,speed;
    public Pointer(DemoPanel dp, KeyHandler kh){
        this.dp = dp;
        this.kh = kh;
    }
    public void setDefaultValues(){
        x=10;
        y=10;
        speed=4;
    }
}
