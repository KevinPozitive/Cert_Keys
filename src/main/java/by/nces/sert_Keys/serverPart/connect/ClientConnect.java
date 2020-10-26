package by.nces.sert_Keys.serverPart.connect;

import by.nces.sert_Keys.serverPart.logic.impl.ServerInteractionImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;


import java.io.IOException;
import java.net.Socket;

@Component
public class ClientConnect {
    private Socket socket;
    ServerInteractionImpl serverInteractionImpl;

    @Value("${connectConfigs.PORT}")
    private int port;

    @Value("${connectConfigs.IP}")
    private String ip;

    public ClientConnect(){

    }

    public void  setConnect(){
        try{
            System.out.println(port + ip);
            this.socket = new Socket(ip,port);
            serverInteractionImpl = new ServerInteractionImpl(socket);
            new Control(serverInteractionImpl);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void closeConnection(){
        try {
            serverInteractionImpl.close();
            this.socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
