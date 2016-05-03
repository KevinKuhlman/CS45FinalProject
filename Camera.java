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


//instance of the camera for the user
public class Camera {
    
    //position the location and look vector
    private Vector3f position = null;
    private Vector3f lPosition = null;
    //the amount of rotation
    private float yaw = 0.0f;
    private float pitch = 0.0f;
    private Vector3Float me;

    //intializes the camera to some given location
    public Camera(float x, float y, float z) {
        
        position = new Vector3f(x, y, z);
        lPosition = new Vector3f(x, y, z);
        lPosition.x = 0f;
        lPosition.y = 15f;
        lPosition.z = 0f;
        
    }
    
    //increases yaw by the given amount
    public void yaw(float amount){
        
        yaw += amount;
    }
    
    //changes pitch by the given amount
    public void pitch(float amount){
        
        pitch -= amount;
    }
    
    //makes the camera move in a forward direction
    public void walkForward(float distance){
        
        float xOffset = distance * (float)Math.sin(Math.toRadians(yaw));
        float zOffset = distance * (float)Math.cos(Math.toRadians(yaw));
        position.x -= xOffset;
        position.z += zOffset;
    }
    
    //makes the camera move in a backwards direction
    public void walkBackwards(float distance){
        
        float xOffset = distance * (float)Math.sin(Math.toRadians(yaw));
        float zOffset = distance * (float)Math.cos(Math.toRadians(yaw));
        position.x += xOffset;
        position.z -= zOffset;
    }
        
    //makes the camera move in a left-strafing direction
    public void strafeLeft(float distance){
        
        float xOffset = distance * (float)Math.sin(Math.toRadians(yaw-90));
        float zOffset = distance * (float)Math.cos(Math.toRadians(yaw-90));
        position.x -= xOffset;
        position.z += zOffset;
    }
            
    //makes the camera move in a right-strafing direction
    public void strafeRight(float distance){
        
        float xOffset = distance * (float)Math.sin(Math.toRadians(yaw+90));
        float zOffset = distance * (float)Math.cos(Math.toRadians(yaw+90));
        position.x -= xOffset;
        position.z += zOffset;
    }
    
    //makes the camera move in an upward direction
    public void moveUp(float distance){
        position.y -= distance;
    }
    
    //makes the camera move in a downward direction
    public void moveDown(float distance){
        position.y += distance;
    }
    
    //Makes the user look from the correct perspective
    public void lookThrough(){
        
        glRotatef(pitch, 1.0f, 0.0f, 0.0f);
        
        glRotatef(yaw, 0.0f, 1.0f, 0.0f);
        
        glTranslatef(position.x, position.y, position.z);
        
    }
    
}
