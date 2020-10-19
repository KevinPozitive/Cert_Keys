package by.nces.sert_Keys.serverPart.logic;

import java.io.IOException;

public interface IServerInteraction {
    public void sendMessage(String message) throws IOException;
    public void exit();
    public String getMessage() throws IOException;
}
