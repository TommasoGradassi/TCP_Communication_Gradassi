/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tcpcommunication;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gradassi Tommaso
 */
public class Client {
   public static final String BLUE="\u001B[34m";
   public static final String RESET="\u001B[0m";
    String nome;
    String colore;
    Socket socket;
    InputStream is;
    OutputStream os;
    PrintWriter streamOut = null;
    Scanner streamIn = null;
    String messaggioIn;
    String messaggioOut;
 public Client(String nome,String colore){
   this.nome=nome;
   this.colore=colore;
 }
 
     public void connetti(String nomeServer,int porta){
      try {
          socket=new Socket(nomeServer,porta);
          System.out.println(BLUE+"1) connessione avvenuta con il server"+RESET);
      }
      catch(ConnectException ex){
          System.err.println("Errore server non connesso");
      }
      catch (IOException ex) {
          Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    public void scrivi(){
        try{
            os=socket.getOutputStream();
             streamOut=new PrintWriter(os);
             streamOut.flush();
             messaggioOut="Eccomi";
             System.out.println(BLUE+messaggioOut+RESET);
             streamOut.println(messaggioOut);
             streamOut.flush();
             System.out.println(messaggioOut);
        }
        catch (UnknownHostException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void leggi(){
            try {
                is=socket.getInputStream();
                streamIn=new Scanner(is);
                messaggioIn=streamIn.nextLine();
                System.out.println(BLUE+"messaggio server:" + messaggioIn+RESET);
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public void chiudi(){
     if (socket !=null) {
         try {
             socket.close();
             System.out.println(BLUE+"4) chiusura connessione con il server"+RESET);
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
     }
    }
}
