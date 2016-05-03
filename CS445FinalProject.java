/***************************************************************
* file: CS445FinalProject.java
* author: Names
* class: CS 445 – Computer Graphics
*
* assignment: Final Project
* date last modified: 5/2/2016
*
* purpose: The purpose of the program is to generate a scene similar
* to one within Minecraft
****************************************************************/

package cs.pkg445.pkgfinal.project;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.util.glu.GLU;


public class CS445FinalProject {

    //runs the program
    public static void main(String[] args) throws Exception{

        Game game = new Game();
        game.start();

    }
    
}
