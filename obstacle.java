import java.awt.*;

public class obstacle {

    public int x;
    public int y;

    public int height=10;
    public int width=10;

    public final int MOVINGBLOCK=0;
    public final int WHIRLINGBLOCK=1;
    public final int LASER=2;
    public int type;

    public final int UP=0;
    public final int SIDE=1;
    public int direction;

    public final int speed=20;

    boolean up;
    boolean down;
    boolean right;
    boolean left;

    int time;
    public boolean toggled=true;

    public obstacle(int x,int y,int type,int direction,int time,int height){
        this.y=y;
        this.x=x;
        this.type=type;
        this.direction=direction;

        if(direction==SIDE)
           width=height;
        else if(type==LASER)
        this.height=height;
        else
            this.height=height;
        this.time=time;

        up=down=left=right=false;
        if(direction==UP)
            up=true;
        if(direction==SIDE)
            left=true;
        int dir=(int)Math.random()*5;
        if(type==1) {
            if (dir == 1) {
                up = true;
                down = false;
                left = false;
                right = false;
            }
            if (dir == 2) {
                up = false;
                down = true;
                left = false;
                right = false;
            }
            if (dir == 3) {
                up = false;
                down = false;
                left = true;
                right = false;
            }
            if (dir == 4) {
                up = false;
                down = false;
                left = false;
                right = true;
            }
        }


    }
    public Rectangle getRectangle(){
        return new Rectangle(x,y,width,height);
    }

    public void update(){

        if(type==MOVINGBLOCK) {
            if (up)
                y -= 2;
            if (down)
                y += 2;
            if (left)
                x -= 2;
            if (right)
                x += 2;
        }
        if(type==WHIRLINGBLOCK){

            if(time%50==0)
            if(up){
                up=false;
                left=true;
            }
            else if(left){
                left=false;
                down=true;
            }
            else if(down){
                down=false;
                right=true;
            }
            else if(right){
                right=false;
                up=true;
            }

            if (up)
                y -= 2;
            if (down)
                y += 2;
            if (left)
                x -= 2;
            if (right)
                x += 2;

            if(x<10)
                x=20;
        }
        if(type==LASER)
        {
            if(time%50==0) {
                if (toggled)
                    toggled = false;
                else
                    toggled = true;
            }

        }


        time+=1;
    }
    public void changeDirection(){
        if(down)
        {
        y-=2;
            down=false;
            up=true;
        }
        else if(up){
            y+=2;

            up=false;
            down=true;
        }
        if(left){
            left=false;
            right=true;
        }
        else if(right){
            right=false;
            left=true;
        }
    }
    public boolean checkCollision(Rectangle player){
        Rectangle rect=new Rectangle(x,y,height,width);
        return rect.intersects(player);
    }


}
