/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.pkg445.pkgfinal.project;

import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.util.glu.GLU;


public class Game {

    //Camera object to be the player's perspective
    static Camera camera = new Camera(0,0,0);
    static DisplayMode displayMode;
    
    //creates a window for the game, sets up default values
    public static void createWindow() throws Exception{
        Display.setFullscreen(false);
        DisplayMode d[] = Display.getAvailableDisplayModes();
        for(int i = 0; i<d.length; i++){
            if(d[i].getWidth() == 640 && d[i].getHeight()==480 && d[i].getBitsPerPixel()==32){
                displayMode = d[i];
                break;
            }
        }
        
        Display.setDisplayMode(displayMode);
        Display.setTitle("CS445 Final Project");
        Display.create();
    }
    
    //Initializes GL 
    public static void initGL(){
        glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        GLU.gluPerspective(100.0f, (float)displayMode.getWidth()/(float)displayMode.getHeight(), 0.1f, 300.0f);
        glMatrixMode(GL_MODELVIEW);
        glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);
    }
    
    //creates and renders the cube
    public static void render(){
        Cube cube = new Cube();
        cube.render();
    }
       
    //updates the visual based on user movement; repeates until ESC is pressed or told to quit
    public static void gameLoop(){
        
        //initliazes camera
        Camera camera = new Camera(0,0,0);
        //Change in x, y and time
        float dx = 0.0f;
        float dy = 0.0f;
        float dt = 0.0f;
        //Time values
        float lastTime = 0.0f;
        long time = 0;
        //How fast the mouse makes us move; how fast we move
        float mouseSensitivity = 0.09f;
        float movementSpeed = 0.35f;
        //Disallow the mouse from being seen
        Mouse.setGrabbed(true);   
        
        //continue to refresh and update the visual until told to quit or ESC is pressed
        while(!Display.isCloseRequested() && !Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
            
            //gets time for future usage
            time = Sys.getTime();
            lastTime = time;
            //gets how much the mouse has moved in each direction
            dx = Mouse.getDX();
            dy = Mouse.getDY();
            //updates the camera based off the movement
            camera.yaw(dx*mouseSensitivity);
            camera.pitch(dy*mouseSensitivity);
            
            //moves the camera based on keyboard presses
            if(Keyboard.isKeyDown(Keyboard.KEY_W)){
                camera.walkForward(movementSpeed);
            }
            if(Keyboard.isKeyDown(Keyboard.KEY_S)){
                camera.walkBackwards(movementSpeed);
            }            
            if(Keyboard.isKeyDown(Keyboard.KEY_A)){
               camera.strafeLeft(movementSpeed);

            }            
            if(Keyboard.isKeyDown(Keyboard.KEY_D)){
               camera.strafeRight(movementSpeed);
            }
            if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
                camera.moveUp(movementSpeed);
            }
            if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
                camera.moveDown(movementSpeed);
            }
            
            //finalizes visuals
            glLoadIdentity();
            camera.lookThrough();
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            //draws the cube
            render();
            //updates the visuals, synchs it at 60 fps
            Display.update();
            Display.sync(60);
        }
    }
    
    
    //creates window, intializes gl, and runs the gameloop
    public static void start() throws Exception{
        
        createWindow();
        initGL();
        gameLoop();
    }
    
}

