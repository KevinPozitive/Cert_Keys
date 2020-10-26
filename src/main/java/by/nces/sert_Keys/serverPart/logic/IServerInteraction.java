package by.nces.sert_Keys.serverPart.logic;

import by.nces.sert_Keys.models.CertSetModel;

import java.io.IOException;

public interface IServerInteraction {
    public void sendMessage(String message, String type) throws IOException;
    public void exit() throws IOException;
    public String getMessage() throws IOException;
    public void close() throws IOException;
}
