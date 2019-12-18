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
        System.out.println("Client starting");
        while (onWork) {
            Socket server = new Socket("127.0.0.1", 8000);
            DataInputStream in = new DataInputStream(server.getInputStream());
            DataOutputStream out = new DataOutputStream(server.getOutputStream());
            Scanner inConsole = new Scanner(System.in);
            String toSend = inConsole.next();
            out.writeUTF(toSend);
            String m = in.readUTF();
            System.out.println(m);
            if(toSend.equals("exit")){
                onWork=false;
            }
            in.close();
            out.close();
            server.close();
        }
    }
}
