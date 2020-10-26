package by.nces.sert_Keys.core.logic;

import by.nces.sert_Keys.core.service.impl.CreateCertImpl;

public class CheckData {
    private CreateCertImpl createSert;
    public CheckData() {
        createSert = new CreateCertImpl();
    }
    public void request(String model, String type){
        String[] part = model.split("~");
        switch (type){
            case "Корневой": createSert.createRootCert(part);break;
            case "Связующий":  createSert.createBinderCert(part);break;
        }
    }

}
