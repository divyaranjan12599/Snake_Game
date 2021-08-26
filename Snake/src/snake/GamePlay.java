package snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePlay extends JPanel implements KeyListener,ActionListener
{
    private final int snakeXlength[] = new int[750];
    private final int snakeYlength[] = new int[750];
    private final int exposition[] = {25,50,75,100,125,150,175,225,250,275,325,350,375,425,450,475,525,550,575,625,650,675,725,750,775,825,850};
    private final int eyposition[] = {75,100,125,150,175,225,250,275,325,350,375,425,450,475,525,550,575};
    private int moves = 0;
    private boolean left=false;
    private boolean right=false;
    private boolean up=false;
    private boolean down=false;
    private ImageIcon enemy;
    
    private final Random random = new Random();
    
    private int xpos = random.nextInt(34);
    private int ypos = random.nextInt(23);
    
    private int score =0;
    private ImageIcon rmouth;
    private ImageIcon lmouth;
    private ImageIcon umouth;
    private ImageIcon dmouth;
    private ImageIcon title;
    private int lenOfSnake = 3;
    private Timer timer;
    private int delay = 100;
    private ImageIcon snakeImage;
    
    
    public GamePlay() 
    {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }
    public void paint(Graphics g)
    {
        //g.setColor(Color.white);
        //g.drawRect(24, 10, 750, 60);
        if(moves == 0)
        {
            snakeXlength[0]= 100;
            snakeXlength[1]= 75;
            snakeXlength[2]= 50;
            snakeYlength[0]= 100;
            snakeYlength[1]= 100;
            snakeYlength[2]= 100;
        }
        
        title = new ImageIcon("C:\\Users\\Divyaranjan\\Desktop\\AWT\\Snake\\src\\snake\\img\\snaketitle.jpg");
        title.paintIcon(this, g, 25, 11);

        
        g.setColor(Color.WHITE);
        g.drawRect(24, 74, 851, 576);
        
        g.setColor(Color.BLACK);
        g.fillRect(25, 75, 850, 575);
        
        g.setColor(Color.white);
        g.setFont(new Font("arial",Font.PLAIN,14));
        g.drawString("Scores: "+score,780,30);
        
        g.setColor(Color.white);
        g.setFont(new Font("arial",Font.PLAIN,14));
        g.drawString("Length: "+lenOfSnake,780,50);
        
        rmouth = new ImageIcon("C:\\Users\\Divyaranjan\\Desktop\\AWT\\Snake\\src\\snake\\img\\rightmouth.png");
        rmouth.paintIcon(this, g, snakeXlength[0], snakeYlength[0]);
        
        for(int i=0;i<lenOfSnake;i++)
        {
            if(i==0 && right)
            {
                rmouth = new ImageIcon("C:\\Users\\Divyaranjan\\Desktop\\AWT\\Snake\\src\\snake\\img\\rightmouth.png");
                rmouth.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);  
            }
            if(i==0 && left)
            {
                lmouth = new ImageIcon("E:\\AWT\\Snake\\src\\snake\\img\\leftmouth.png");
                lmouth.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);  
            }
            if(i==0 && up)
            {
                umouth = new ImageIcon("E:\\AWT\\Snake\\src\\snake\\img\\upmouth.png");
                umouth.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);  
            }
            if(i==0 && down)
            {
                dmouth = new ImageIcon("E:\\AWT\\Snake\\src\\snake\\img\\downmouth.png");
                dmouth.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);  
            }
            if(i!=0)
            {
                snakeImage = new ImageIcon("E:\\AWT\\Snake\\src\\snake\\img\\snakeimage.png");
                snakeImage.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);  
            }
        }
        
        enemy = new ImageIcon("E:\\AWT\\Snake\\src\\snake\\img\\enemy.png");
        if(exposition[xpos]==snakeXlength[0] && eyposition[ypos]==snakeYlength[0])
        {
            score++;
        	lenOfSnake++;
            xpos = random.nextInt(34);
            ypos = random.nextInt(23);
        }
        enemy.paintIcon(this, g, exposition[xpos], eyposition[ypos]);
        
        for(int b=1;b<lenOfSnake;b++)
        {
        	if(snakeXlength[b]==snakeXlength[0] && snakeYlength[b]==snakeYlength[0])
        	{
        		up=false;
        		down=false;
        		right=false;
        		left=false;
        		
        		g.setColor(Color.RED);
        		g.setFont(new Font("arial",Font.BOLD,50));
        		g.drawString("GAME OVER", 300, 300);
        		
        		g.setColor(Color.white);
        		g.setFont(new Font("arial",Font.BOLD,20));
        		g.drawString("Space to RESTART", 350, 340);
        	}
        }
        
        g.dispose();
    }
    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_SPACE)
        {
        	moves=0;
        	score=0;
        	lenOfSnake=3;
        	repaint();
        }
    	if(e.getKeyCode()==KeyEvent.VK_RIGHT)
        {
            moves++;
            right=true;
            
            if(!left)
            {
                right=true;
            }
            else
            {
                right=false;
                left=true;
            }
            
            up=false;
            down=false;
        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT)
        {
            moves++;
            left=true;
            
            if(!right)
            {
                left=true;
            }
            else
            {
                right=true;
                left=false;
            }
            
            up=false;
            down=false;        
        }
        if(e.getKeyCode()==KeyEvent.VK_UP)
        {
            moves++;
            up=true;
            
            if(!down)
            {
                up=true;
            }
            else
            {
                up=false;
                down=true;
            }
            
            right=false;
            left=false;
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN)
        {
            moves++;
            down=true;
            
            if(!up)
            {
                down=true;
            }
            else
            {
                down=false;
                up=true;
            }
            
            right=false;
            left=false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       timer.start();
       if(right)
       {
           for(int r=lenOfSnake-1;r>=0;r--)
           {
               snakeYlength[r+1]=snakeYlength[r];
           }
           for(int r= lenOfSnake-1;r>=0;r--)
           {
               if(r==0)
               {
                   snakeXlength[r]+=25;
               } 
               else
               {
                   snakeXlength[r]=snakeXlength[r-1];
               }
               if(snakeXlength[r]>850)
               {
                   snakeXlength[r]=25;
               }
           }
           repaint();
       }   
       if(left)
       {
           for(int r=lenOfSnake-1;r>=0;r--)
           {
               snakeYlength[r+1]=snakeYlength[r];
           }
           for(int r= lenOfSnake-1;r>=0;r--)
           {
               if(r==0)
               {
                   snakeXlength[r]-=25;
               }
               else
               {
                   snakeXlength[r]=snakeXlength[r-1];
               }
               if(snakeXlength[r]<25)
               {
                   snakeXlength[r]=850;
               }
           }
           repaint();
       }
       if(up)
       {
           for(int r=lenOfSnake-1;r>=0;r--)
           {
               snakeXlength[r+1]=snakeXlength[r];
           }
           for(int r= lenOfSnake-1;r>=0;r--)
           {
               if(r==0)
               {
                   snakeYlength[r]-=25;
               }
               else
               {
                   snakeYlength[r]=snakeYlength[r-1];
               }
               if(snakeYlength[r]<75)
               {
                   snakeYlength[r]=625;
               }
           }
           repaint();
       }
       if(down)
       {
           for(int r=lenOfSnake-1;r>=0;r--)
           {
               snakeXlength[r+1]=snakeXlength[r];
           }
           for(int r= lenOfSnake-1;r>=0;r--)
           {
               if(r==0)
               {
                   snakeYlength[r]+=25;
               }
               else
               {
                   snakeYlength[r]=snakeYlength[r-1];
               }
               if(snakeYlength[r]>625)
               {
                   snakeYlength[r]=75;
               }
           }
           repaint();
       }
    }
}
