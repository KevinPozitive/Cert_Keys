package by.nces.sert_Keys.serverPart.connect;

import by.nces.sert_Keys.serverPart.logic.IServerInteraction;

public class Control {
    protected static IServerInteraction serverInteraction;
    public Control(){
    }
    public Control(IServerInteraction iServerInteraction){
        this.serverInteraction = iServerInteraction;
    }
}
