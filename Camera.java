/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.pkg445.pkgfinal.project;

import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.Sys;


public class Camera {
    
    private Vector3f position = null;
    private Vector3f lPosition = null;
    private float yaw = 0.0f;
    private float pitch = 0.0f;
    private Vector3Float me;

    public Camera(float x, float y, float z) {
        
        position = new Vector3f(x, y, z);
        lPosition = new Vector3f(x, y, z);
        lPosition.x = 0f;
        lPosition.y = 15f;
        lPosition.z = 0f;
        
    }
    
    public void yaw(float amount){
        
        yaw += amount;
    }
    
    public void pitch(float amount){
        
        pitch -= amount;
    }
    
    public void walkForward(float distance){
        
        float xOffset = distance * (float)Math.sin(Math.toRadians(yaw));
        float zOffset = distance * (float)Math.cos(Math.toRadians(yaw));
        position.x -= xOffset;
        position.z += zOffset;
    }
    
    public void walkBackwards(float distance){
        
        float xOffset = distance * (float)Math.sin(Math.toRadians(yaw));
        float zOffset = distance * (float)Math.cos(Math.toRadians(yaw));
        position.x += xOffset;
        position.z -= zOffset;
    }
        
    public void strafeLeft(float distance){
        
        float xOffset = distance * (float)Math.sin(Math.toRadians(yaw-90));
        float zOffset = distance * (float)Math.cos(Math.toRadians(yaw-90));
        position.x -= xOffset;
        position.z += zOffset;
    }
            
    public void strafeRight(float distance){
        
        float xOffset = distance * (float)Math.sin(Math.toRadians(yaw+90));
        float zOffset = distance * (float)Math.cos(Math.toRadians(yaw+90));
        position.x -= xOffset;
        position.z += zOffset;
    }
    
    public void moveUp(float distance){
        position.y -= distance;
    }
    
    public void moveDown(float distance){
        position.y += distance;
    }
    
    
    public void lookThrough(){
        
        glRotatef(pitch, 1.0f, 0.0f, 0.0f);
        
        glRotatef(yaw, 0.0f, 1.0f, 0.0f);
        
        glTranslatef(position.x, position.y, position.z);
        
    }
    
}