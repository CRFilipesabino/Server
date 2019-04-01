
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPSocketServer {
    
    public static void main(String[] args) {

       try {
 
	  
           ServerSocket socket = new ServerSocket(12345);
   
           while(true) {    
   		
		Socket socketConectado = socket.accept();
    
               	BufferedReader doClienteBF = new BufferedReader(new InputStreamReader(socketConectado.getInputStream()));
               	DataOutputStream paraCliente = new DataOutputStream(socketConectado.getOutputStream());
    
                String lidoDoCliente = doClienteBF.readLine();
                System.out.println("Servidor@ Mensagem recebida: " + lidoDoCliente);

                paraCliente.writeBytes(lidoDoCliente = "Confirmacao de Recepcao(" + lidoDoCliente + ")\n");
           } 
      
       } catch (IOException e) {
          
           e.printStackTrace();
       }  
   }    
}
