package LWJGL;


//You might notice a lot of imports here.
//You are probably wondering why I didn't just import org.lwjgl.opengl.GL11.*
//Well, I did it as a hint to you.
//OpenGL has a lot of commands, and it can be kind of intimidating.
//This is a list of all the commands I used when I implemented my project.
//Therefore, if a command appears in this list, you probably need it.
//If it doesn't appear in this list, you probably don't.
//Of course, your milage may vary. Don't feel restricted by this list of imports.
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.Iterator;
import org.lwjgl.input.Keyboard;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_LINES;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex3d;
import static org.lwjgl.opengl.GL11.glViewport;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.util.glu.GLU.gluPerspective;

/**
 *
 * @author Brennan Smith
 */
public class StudentLWJGLController implements CS355LWJGLController 
{
  
  //This is a model of a house.
  //It has a single method that returns an iterator full of Line3Ds.
  //A "Line3D" is a wrapper class around two Point2Ds.
  //It should all be fairly intuitive if you look at those classes.
  //If not, I apologize.
  private WireFrame model = new HouseModel();

  //This method is called to "resize" the viewport to match the screen.
  //When you first start, have it be in perspective mode.
  @Override
  public void resizeGL() 
  {
      //I think this is where I need to put the transfoms.
      //Use the constents define in the shell.
      
      glViewport(0, 0, LWJGLSandbox.DISPLAY_WIDTH, LWJGLSandbox.DISPLAY_HEIGHT);
      glMatrixMode(GL_PROJECTION);
      glLoadIdentity();
      gluPerspective(60.0f, 1.33f, 5f, 100f);
  }

    @Override
    public void update() 
    {
        
    }

    //This is called every frame, and should be responsible for keyboard updates.
    //An example keyboard event is captured below.
    //The "Keyboard" static class should contain everything you need to finish
    // this up.
    @Override
    public void updateKeyboard() 
    {
        if(Keyboard.isKeyDown(Keyboard.KEY_A)) 
        {
            System.out.println("You are pressing A!");
            glTranslatef(1.0f, 0.0f, 0.0f);
        }
        else if(Keyboard.isKeyDown(Keyboard.KEY_D)) 
        {
            System.out.println("You are pressing D!");
            glTranslatef(-1.0f, 0.0f, 0.0f);
        }
        else if(Keyboard.isKeyDown(Keyboard.KEY_W)) 
        {
            System.out.println("You are pressing W!");
            glTranslatef(0.0f, 0.0f, 1.0f);
        }
         else if(Keyboard.isKeyDown(Keyboard.KEY_S)) 
        {
            System.out.println("You are pressing S!");
            glTranslatef(0.0f, 0.0f, -1.0f);
        }
        else if(Keyboard.isKeyDown(Keyboard.KEY_Q)) 
        {
            System.out.println("You are pressing Q!");
        }
         else if(Keyboard.isKeyDown(Keyboard.KEY_E)) 
        {
            System.out.println("You are pressing E!");
        }
        else if(Keyboard.isKeyDown(Keyboard.KEY_R)) 
        {
            System.out.println("You are pressing R!");
            glTranslatef(0.0f, -1.0f, 0.0f);
        }
         else if(Keyboard.isKeyDown(Keyboard.KEY_F)) 
        {
            System.out.println("You are pressing F!");
            glTranslatef(0.0f, 1.0f, 0.0f);
        }
        else if(Keyboard.isKeyDown(Keyboard.KEY_H)) 
        {
            System.out.println("You are pressing H!");
            glLoadIdentity();
            gluPerspective(60.0f, 1.33f, 5f, 100f);
            
        }
         else if(Keyboard.isKeyDown(Keyboard.KEY_O)) 
        {
            System.out.println("You are pressing O!");
              glMatrixMode(GL_MODELVIEW);
              glLoadIdentity();
              glOrtho(5f, 100f, 5f, 100f, 5f, 100f);
        }
        else if(Keyboard.isKeyDown(Keyboard.KEY_P)) 
        {
            System.out.println("You are pressing P!");
              glMatrixMode(GL_PROJECTION);
              glLoadIdentity();
              gluPerspective(60.0f, 1.33f, 5f, 100f);
        }

    }

    //This method is the one that actually draws to the screen.
    @Override
    public void render() 
    {
        float angle = 0;
        //This clears the screen.
        glClear(GL_COLOR_BUFFER_BIT);
        
        //Do your drawing here.
        glColor3f(0, 255, 0);
        glPushMatrix();
        
        //glRotatef(angle, 0.0f, 0.0f, 0.0f);
        glBegin(GL_LINES);
        for(Iterator<Line3D> iter = model.getLines(); iter.hasNext();){
            Line3D l = iter.next();
            glVertex3d(l.start.x, l.start.y, l.start.z);
            glVertex3d(l.end.x, l.end.y, l.end.z);
        }
        glEnd();
        //glPopMatrix();
    }
    
}
