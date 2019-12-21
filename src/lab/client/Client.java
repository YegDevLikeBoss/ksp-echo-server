package lab.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        boolean onWork=true;
        System.out.println("Client starting!");
        while (onWork) {
            Socket server = new Socket("localhost", 8000);
            DataInputStream in = new DataInputStream(server.getInputStream());
            DataOutputStream out = new DataOutputStream(server.getOutputStream());
            Scanner inConsole = new Scanner(System.in);

            String request = inConsole.next();

            out.writeUTF(request);

            String response = in.readUTF();

            System.out.println(response);

            if(toSend.equals("exit")){
                onWork=false;
            }

            in.close();
            out.close();
            server.close();
        }
    }
}
