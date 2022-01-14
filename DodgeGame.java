import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
public class DodgeGame extends JFrame implements KeyListener, Runnable{

    //to do
    //doesnt recognize wall intersects player

    JPanel panel=new JPanel();

    public static int lives;
    public static File currentLvl;
    Thread t=new Thread(this);

    boolean up;
    boolean down;
    boolean right;
    boolean left;

    int lvlStartX;
    int lvlStartY;

    int px;
    int py;

    int fx;
    int fy;
    int fh;
    int fw;

    int lvl=1;
    boolean hasWon=false;

    public int speed=2;

    ArrayList<Rectangle>walls=new ArrayList<Rectangle>();
    ArrayList<obstacle>obstacles=new ArrayList<obstacle>();

    Rectangle finish=new Rectangle(570,100,30,100);
    Rectangle player=new Rectangle(px,py,10,10);
    BufferedImage buffer = new BufferedImage(600,400,BufferedImage.TYPE_4BYTE_ABGR);

    public DodgeGame()
    {
        super("Dodge");
        setSize(600,400);
        addKeyListener(this);
        lives=5;
        currentLvl=null;
        up=down=right=left=false;
        panel.setSize(600,400);
        panel.setVisible(true);
        setUndecorated(true);
        add(panel);
        t.start();
        setVisible(true);

    }
    public void loadLevel(int level) {

        if (lvl == 1) {
            try {
                //pathname for school computer
                //File f = new File("C:\\Users\\othscs121\\Dropbox\\compsci2\\DodgeAttemptTwo\\src\\LevelOne.txt");
                //pathname for home
                 File f=new File("C:\\Users\\Reilly\\Dropbox\\compsci2\\DodgeAttemptTwo\\src\\LevelOne.txt");
                Scanner s = new Scanner(f);
                String[] start = s.nextLine().split(",");
                lvlStartX=px = Integer.parseInt(start[0]);
                lvlStartY=py = Integer.parseInt(start[1]);

                while (s.hasNextLine()) {
                    String[] data = s.nextLine().split(",");
                    if (data[0].equals("W")){
                        walls.add(new Rectangle(Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4])));
                    }
                    if (data[0].equals("O"))
                        obstacles.add(new obstacle(Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4]),Integer.parseInt(data[5]),Integer.parseInt(data[6])));

                    if (data[0].equals( "F")) {
                        fx = Integer.parseInt(data[1]);
                        fy = Integer.parseInt(data[2]);
                        fw = Integer.parseInt(data[3]);
                        fh = Integer.parseInt(data[4]);
                        finish=new Rectangle(fx,fy,fw,fh);
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(lvl==2) {
            try {
                //pathname for school computer
                //File f = new File("C:\\Users\\othscs121\\Dropbox\\compsci2\\DodgeAttemptTwo\\src\\LevelTwo.txt");
                //pathname for home
                File f=new File("C:\\Users\\Reilly\\Dropbox\\compsci2\\DodgeAttemptTwo\\src\\LevelTwo.txt");
                Scanner s = new Scanner(f);
                String[] start = s.nextLine().split(",");
                lvlStartX = px = Integer.parseInt(start[0]);
                lvlStartY = py = Integer.parseInt(start[1]);

                while (s.hasNextLine()) {
                    String[] data = s.nextLine().split(",");
                    if (data[0].equals("W")) {
                        walls.add(new Rectangle(Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4])));
                    }
                    if (data[0].equals("O"))
                        obstacles.add(new obstacle(Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4]), Integer.parseInt(data[5]), Integer.parseInt(data[6])));

                    if (data[0].equals("F")) {
                        fx = Integer.parseInt(data[1]);
                        fy = Integer.parseInt(data[2]);
                        fw = Integer.parseInt(data[3]);
                        fh = Integer.parseInt(data[4]);
                        finish = new Rectangle(fx, fy, fw, fh);
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(lvl==3){
            try{
                //pathname for school computer
                //File f = new File("C:\\Users\\othscs121\\Dropbox\\compsci2\\DodgeAttemptTwo\\src\\LevelThreeReal");
                //pathname for home
                File f=new File("C:\\Users\\Reilly\\Dropbox\\compsci2\\DodgeAttemptTwo\\src\\LevelThreeReal");
                Scanner s = new Scanner(f);
                String[] start = s.nextLine().split(",");
                lvlStartX=px = Integer.parseInt(start[0]);
                lvlStartY=py = Integer.parseInt(start[1]);

                while (s.hasNextLine()) {
                    String[] data = s.nextLine().split(",");
                    if (data[0].equals("W")){
                        walls.add(new Rectangle(Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4])));
                    }
                    if (data[0].equals("O"))
                        obstacles.add(new obstacle(Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4]),Integer.parseInt(data[5]),Integer.parseInt(data[6])));

                    if (data[0].equals( "F")) {
                        fx = Integer.parseInt(data[1]);
                        fy = Integer.parseInt(data[2]);
                        fw = Integer.parseInt(data[3]);
                        fh = Integer.parseInt(data[4]);
                        finish=new Rectangle(fx,fy,fw,fh);
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (lvl == 4) {
            try {
                //pathname for school computer
                //File f = new File("C:\\Users\\othscs121\\Dropbox\\compsci2\\DodgeAttemptTwo\\src\\LevelFour.txt");
                //pathname for home
                File f=new File("C:\\Users\\Reilly\\Dropbox\\compsci2\\DodgeAttemptTwo\\src\\LevelFour.txt");
                Scanner s = new Scanner(f);
                String[] start = s.nextLine().split(",");
                lvlStartX=px = Integer.parseInt(start[0]);
                lvlStartY=py = Integer.parseInt(start[1]);

                while (s.hasNextLine()) {
                    String[] data = s.nextLine().split(",");
                    if (data[0].equals("W")){
                        walls.add(new Rectangle(Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4])));
                    }
                    if (data[0].equals("O"))
                        obstacles.add(new obstacle(Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4]),Integer.parseInt(data[5]),Integer.parseInt(data[6])));

                    if (data[0].equals( "F")) {
                        fx = Integer.parseInt(data[1]);
                        fy = Integer.parseInt(data[2]);
                        fw = Integer.parseInt(data[3]);
                        fh = Integer.parseInt(data[4]);
                        finish=new Rectangle(fx,fy,fw,fh);
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(lvl==5){
            try{
                //pathname for school computer
                //File f = new File("C:\\Users\\othscs121\\Dropbox\\compsci2\\DodgeAttemptTwo\\src\\LevelThree.txt");
                //pathname for home
                File f=new File("C:\\Users\\Reilly\\Dropbox\\compsci2\\DodgeAttemptTwo\\src\\LevelThree.txt");
                Scanner s = new Scanner(f);
                String[] start = s.nextLine().split(",");
                lvlStartX=px = Integer.parseInt(start[0]);
                lvlStartY=py = Integer.parseInt(start[1]);

                while (s.hasNextLine()) {
                    String[] data = s.nextLine().split(",");
                    if (data[0].equals("W")){
                        walls.add(new Rectangle(Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4])));
                    }
                    if (data[0].equals("O"))
                        obstacles.add(new obstacle(Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4]),Integer.parseInt(data[5]),Integer.parseInt(data[6])));

                    if (data[0].equals( "F")) {
                        fx = Integer.parseInt(data[1]);
                        fy = Integer.parseInt(data[2]);
                        fw = Integer.parseInt(data[3]);
                        fh = Integer.parseInt(data[4]);
                        finish=new Rectangle(fx,fy,fw,fh);
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (lvl == 6) {
            try {
                //pathname for school computer
                //File f = new File("C:\\Users\\othscs121\\Dropbox\\compsci2\\DodgeAttemptTwo\\src\\LevelSiz.txt");
                //pathname for home
                File f=new File("C:\\Users\\Reilly\\Dropbox\\compsci2\\DodgeAttemptTwo\\src\\LevelSiz.txt");
                Scanner s = new Scanner(f);
                String[] start = s.nextLine().split(",");
                lvlStartX=px = Integer.parseInt(start[0]);
                lvlStartY=py = Integer.parseInt(start[1]);

                while (s.hasNextLine()) {
                    String[] data = s.nextLine().split(",");
                    if (data[0].equals("W")){
                        walls.add(new Rectangle(Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4])));
                    }
                    if (data[0].equals("O"))
                        obstacles.add(new obstacle(Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4]),Integer.parseInt(data[5]),Integer.parseInt(data[6])));

                    if (data[0].equals( "F")) {
                        fx = Integer.parseInt(data[1]);
                        fy = Integer.parseInt(data[2]);
                        fw = Integer.parseInt(data[3]);
                        fh = Integer.parseInt(data[4]);
                        finish=new Rectangle(fx,fy,fw,fh);
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }






    }
    public void paint(Graphics g) {
        Graphics bg = buffer.getGraphics();
        bg.setColor(Color.BLACK);


        bg.setColor(Color.GRAY);
        bg.fillRect(0,0,600,400);
        bg.setColor(Color.BLACK);
        for(int x=0; x<walls.size();x++)
            bg.fillRect((int)walls.get(x).getX(),(int)walls.get(x).getY(),(int)walls.get(x).getWidth(),(int)walls.get(x).getHeight());
        bg.setColor(Color.RED);
        for(int x=0; x<obstacles.size();x++) {
            obstacle o=obstacles.get(x);
            if(o.type==0 || o.type==1) {
                bg.setColor(Color.BLUE);
                bg.fillRect(o.x, o.y, o.width, o.height);
            }

            if(o.type==2 && o.toggled)
            {
                bg.setColor(Color.RED);
                bg.fillRect(o.x,o.y,o.width,o.height);

            }



        }
        bg.setColor(Color.GREEN);
        bg.fillRect((int)finish.getX(),(int)finish.getY(),(int)finish.getWidth(),(int)finish.getHeight());
        bg.setFont(new Font("TimesRoman", Font.PLAIN, 18));
        bg.drawString("Lives "+lives,50,50);

        bg.setColor(Color.YELLOW);
        bg.fillRect(px,py,10,10);
        g.drawImage(buffer,0,0,null);


    }
    public void keyPressed(KeyEvent e){
        char c=e.getKeyChar();

        if(c=='w')
            up=true;
        if(c=='a')
            left=true;
        if(c=='s')
            down=true;
        if(c=='d')
            right=true;
        if(c=='n') {
            walls.clear();
            obstacles.clear();
            loadLevel(lvl++);
        }

    }
    public void keyReleased(KeyEvent e){
        char c=e.getKeyChar();
        if(c=='w')
            up=false;
        if(c=='a')
            left=false;
        if(c=='s')
            down=false;
        if(c=='d')
            right=false;
    }
    public void keyTyped(KeyEvent e){}


    public void run() {
        loadLevel(lvl);
        while(true) {

            update();
            repaint();
            try {
                Thread.sleep(1000/60 );
            }
            catch(Exception e) {
                e.printStackTrace();
            }
            if(lives==0)
                break;
        }
    }
    public void update(){
        if (up)
            py-=speed;
        if (down)
            py+=speed;
        if (right)
            px+=speed;
        if (left)
            px-=speed;

        for(int x=0;x<obstacles.size();x++)
            obstacles.get(x).update();




        for(int x=0; x<obstacles.size();x++) {
            obstacle o=obstacles.get(x);
            if(o.type==0) {
                if (o.getRectangle().intersects(new Rectangle(px, py, 10, 10))) {
                    px = lvlStartX;
                    py = lvlStartY;
                    lives--;}

            }
            if(o.type==1) {
                if (o.getRectangle().intersects(new Rectangle(px, py, 10, 10))) {
                    px = lvlStartX;
                    py = lvlStartY;
                    lives--;}

            }
            if (o.type == 2) {
                if (o.getRectangle().intersects(new Rectangle(px, py, 10, 10)) && o.toggled) {
                    px = lvlStartX;
                    py = lvlStartY;
                    lives--;
                }
            }
        }
        //obstacles intersecting walls
        for(int xx=0; xx<obstacles.size();xx++){
            for(int yy=0;yy<walls.size();yy++){
                if(obstacles.get(xx).type==0 && obstacles.get(xx).getRectangle().intersects(walls.get(yy)))
                {
                    obstacles.get(xx).changeDirection();
                    break;
                }
            }
        }


        //intersecting with wall
        for(int x=0;x<walls.size();x++){
            Rectangle wal=walls.get(x);

            if(wal.intersects(new Rectangle(px,py,10,10)))
            {
                if(up)
                    py+=speed;
                if(down)
                    py-=speed;
                if(right)
                    px-=speed;
                if(left)
                    px+=speed;



            }
        }

        if(finish.intersects(new Rectangle(px,py,10,10))) {
            hasWon = true;
            walls.clear();
            obstacles.clear();
            loadLevel(lvl++);
            lives++;

            hasWon=false;
        }

    }
    public static void main(String[]args){
        DodgeGame g=new DodgeGame();
    }
}
