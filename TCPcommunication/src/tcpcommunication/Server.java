/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tcpcommunication;
import java.io.IOException;
import java.net.Socket;
import  java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tommaso Gradassi
 */
public class Server {
    ServerSocket serverSocket;
    Socket clientSocket;
    int porta;
   
    public Server(int porta){
        this.porta=porta;
        try {
            serverSocket=new ServerSocket(porta);
            System.out.println("1) server in ascolto");
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("errore nella fase di ascolto");
            
        }
 }
    public Socket attendi(){
        try {
            clientSocket = serverSocket.accept();
            System.out.println("Data Socket creato, connessione avvenuta");
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Problemi di connessione con il client");
        } catch(SecurityException ex){
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("non si ha il permesso per accedere a socket");
        } /*catch(UnknownHostException ex){
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("IP host non individuabile");
        }*/catch(IllegalArgumentException ex){
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Il metodo ha ricevuto un parametro non valido");
        }
        return clientSocket;
    }
  
   public void leggi(){
       
   }

   public void chiudi(){
    try {
        clientSocket.close();
        System.out.println("Chiusura socket con client avvenuta");
    } catch (IOException e) {
        System.err.println("Errore nella chiusura con il server");
    } catch(SecurityException e){
        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
        System.err.println("non si ha il permesso per accedere a chiudi");
    }
   }
}
