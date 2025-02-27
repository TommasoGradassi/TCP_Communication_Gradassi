package tcpcommunication;

import java.net.*;
import java.io.*;

public class MainClient {
    public static void main(String[] args) throws IOException {
  Client c1=new Client("c1","blu",2000,"localhost");
  Thread t1=new Thread(c1);
  t1.start();

    }
}