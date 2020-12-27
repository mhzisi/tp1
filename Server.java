package zaoui_socket;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import static java.lang.Integer.parseInt;

public class Server {

    static final int port = 1200;

    public static void main(String[] args) throws Exception {

        // Listen to a specific port

        ServerSocket s = new ServerSocket(port);
        System.out.println("Waiting for connection");
        Socket socClient = s.accept(); // Accept a client socket
        System.out.println("Connection established");

        // Initialize in / out

        BufferedReader inServer = new BufferedReader(new InputStreamReader(socClient.getInputStream()));
        PrintWriter outServer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socClient.getOutputStream())), true);

        // Read message sent by the client
        String str = inServer.readLine();
        int number=parseInt(str);
        // find all the prime numbers between 1 to number
        System.out.print("1"+" ");
       for (int i=2;i<=number;i++)
       {int estpremier=1;
          for(int j = 2; j <=i; j++) {
            if((i % j) == 0 && j!=i) {
               estpremier = 0;
            }
         }
         if (estpremier != 0){
            System.out.print(i+" ");
            
         }
        
      }
        

        // Close in / out
        inServer.close();
        outServer.close();

        // Close client socket
        socClient.close();
    }
}