package by.nces.sert_Keys.serverPart.logic.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.Socket;

public class ServerInteraction implements by.nces.sert_Keys.serverPart.logic.IServerInteraction {
    private Socket socket;
    private BufferedWriter out;
    private BufferedReader in;
    private String message;
    private Thread thread;

    @Override
    public void sendMessage(String message) throws IOException {

    }

    @Override
    public void exit() {

    }

    @Override
    public String getMessage() throws IOException {
        return null;
    }
}