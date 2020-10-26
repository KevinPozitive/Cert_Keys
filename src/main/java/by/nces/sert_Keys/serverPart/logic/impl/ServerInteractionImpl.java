package by.nces.sert_Keys.serverPart.logic.impl;

import by.nces.sert_Keys.models.CertSetModel;
import by.nces.sert_Keys.serverPart.connect.Control;

import java.io.*;
import java.net.Socket;

public class ServerInteractionImpl implements by.nces.sert_Keys.serverPart.logic.IServerInteraction{
    private Socket socket;
    private BufferedWriter out;
    private BufferedReader in;
    private Thread thread;


    public ServerInteractionImpl(Socket socket) throws IOException {
        this.socket = socket;
        out = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
        in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
    }

    @Override
    public void sendMessage(String message, String type) throws IOException {
        out.write("data~"+type+message+"\n");
        out.flush();
    }

    @Override
    public void exit() throws IOException {
        out.write("exit\n");
        out.flush();
    }

    @Override
    public String getMessage() throws IOException {
        return null;
    }

    @Override
    public void close() throws IOException {
        try {
            out.write("exit\n");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        socket.close();
        try {
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}