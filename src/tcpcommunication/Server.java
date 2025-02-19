/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tcpcommunication;
import java.io.*;
import java.net.Socket;
import  java.net.ServerSocket;
import java.util.Scanner;
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
    InputStream is;
    OutputStream os;
    PrintWriter streamOut = null;
    Scanner streamIn = null;
    String messaggioIn;
    String messaggioOut;
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
    try {
        os=clientSocket.getOutputStream();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    streamOut=new PrintWriter(os);
    try {
        is= clientSocket.getInputStream();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    streamIn=new Scanner(is);
   System.out.println("sto leggeggendo il messaggio del client");
   messaggioIn=streamIn.next();
   System.out.println("messaggio del client"+ messaggioIn);
   System.out.println("-----");
}
   public void scrivi(){
           try {
               OutputStream os = clientSocket.getOutputStream();
               PrintWriter streamOut = new PrintWriter(os);
               InputStream is = clientSocket.getInputStream();
                streamIn = new Scanner(is);
               System.out.println("messaggio   al client");
               String messaggioOut = "ciao";
               streamOut.println(messaggioOut);
               streamOut.flush();
           } catch (IOException e) {
               throw new RuntimeException(e);
           }

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
   public void termina() {
    try {
        serverSocket.close();
        System.out.println("6) chiusura Server");
    } catch (IOException ex) {
        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
}
