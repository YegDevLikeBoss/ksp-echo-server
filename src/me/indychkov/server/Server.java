package me.indychkov.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(8000);
        System.out.println("Server starting!");
        boolean onWork = true;
        while(onWork){
            Socket client = server.accept();
            DataInputStream in = new DataInputStream(client.getInputStream());
            String message = in.readUTF();
            System.out.println(message);
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            out.writeUTF(message + " (from server)" +(message.equals("exit")?"\nServer was closed":""));
            if(message.equals("exit")){
                onWork=false;
            }

            in.close();
            out.close();
            client.close();
        }
        System.out.println("Server was closed!");
    }
}
