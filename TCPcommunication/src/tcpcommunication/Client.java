/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tcpcommunication;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gradassi Tommaso
 */
public class Client {
  String nome;
 String colore;
 Socket socket;
 public Client(String nome,String colore){
   this.nome=nome;
   this.colore=colore;
 }
 
     public void connetti(String nomeServer,int porta){
      try {
          socket=new Socket(nomeServer,porta);
          System.out.println("1) connessione avvenuta con il server");
      }
      catch(ConnectException ex){
          System.err.println("Errore server non connesso");
      }
      catch (IOException ex) {
          Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    public void scrivi(){

    }
    public void leggi(){

    }
    public void chiudi(){
     if (socket !=null) {
         try {
             socket.close();
             System.out.println("4) chiusura connessione con il server");
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
     }
    }
}
