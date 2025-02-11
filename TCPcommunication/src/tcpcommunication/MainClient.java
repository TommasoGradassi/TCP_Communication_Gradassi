/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tcpcommunication;

/**
 *
 * @author Gradassi Tommaso
 */
public class MainClient {
    
    public static void main(String[]args){
        Client c=new Client ("localhost","Rosso");
        c.connetti("localhost",2000);
        //c.scrivi();
        c.chiudi();
    }
}
