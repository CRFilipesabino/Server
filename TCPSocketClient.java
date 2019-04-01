


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPSocketClient {

 public static void main(String[] args) {

       try {
	    
            BufferedReader tecladoBR = new BufferedReader(new InputStreamReader(System.in));
            String tecladoStr= tecladoBR.readLine();

            
            Socket socket = new Socket("127.0.0.1", 12345);
    
            
            DataOutputStream paraServidor = new DataOutputStream(socket.getOutputStream());
	   
            BufferedReader doServidor = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    
            
            paraServidor.writeBytes(tecladoStr+ "\n");
    
            
            
            String socketStr = doServidor.readLine();
            System.out.println("Cliente@ Resposta: " + socketStr);

            
            socket.close();   

       } catch (UnknownHostException e) {
          
           e.printStackTrace();
       } catch (IOException e) {
          
           e.printStackTrace();
       }
   } 
    
}
