/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.pkg445.pkgfinal.project;

import static org.lwjgl.opengl.GL11.*;

/**
 *
 * @author Kevin
 */
public class Cube {
    

    public void render(){
        glBegin(GL_QUADS);
        
            //Top        
            glColor3f(0.0f,0.0f,1.0f);
            glVertex3f( 1.0f, 1.0f,-1.0f);
            glVertex3f(-1.0f, 1.0f,-1.0f);
            glVertex3f(-1.0f, 1.0f, 1.0f);
            glVertex3f( 1.0f, 1.0f, 1.0f);
            //Bottom
            glColor3f(1.0f, 0.0f, 0.0f);
            glVertex3f( 1.0f,-1.0f, 1.0f);
            glVertex3f(-1.0f,-1.0f, 1.0f);
            glVertex3f(-1.0f,-1.0f,-1.0f);
            glVertex3f( 1.0f,-1.0f,-1.0f);
             //Left
            glColor3f(0.0f, 1.0f, 0.0f);
            glVertex3f(-1.0f, 1.0f,1.0f);
            glVertex3f(-1.0f, 1.0f,-1.0f);
            glVertex3f(-1.0f,-1.0f,-1.0f);
            glVertex3f(-1.0f,-1.0f, 1.0f);
            //Right
            glColor3f(1.0f, 1.0f, 0.0f);
            glVertex3f( 1.0f, 1.0f,-1.0f);
            glVertex3f( 1.0f, 1.0f, 1.0f);
            glVertex3f( 1.0f,-1.0f, 1.0f);
            glVertex3f( 1.0f,-1.0f,-1.0f);
            //Back
            glColor3f(1.0f, 0.0f, 1.0f);
            glVertex3f( 1.0f,-1.0f,-1.0f);
            glVertex3f(-1.0f,-1.0f,-1.0f);
            glVertex3f(-1.0f, 1.0f,-1.0f);
            glVertex3f( 1.0f, 1.0f,-1.0f);
            //Front
            glColor3f(0.0f, 1.0f, 1.0f);
            glVertex3f( 1.0f, 1.0f,1.0f);
            glVertex3f(-1.0f, 1.0f,1.0f);
            glVertex3f(-1.0f, -1.0f,1.0f);
            glVertex3f( 1.0f, -1.0f,1.0f);           

        glEnd();
        
    }
    
}
