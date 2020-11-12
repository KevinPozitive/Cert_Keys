package by.nces.sert_Keys.core.logic;

import by.nces.sert_Keys.core.service.impl.CreateCertImpl;

import java.io.IOException;

public class CheckData {
    private CreateCertImpl createSert;
    public CheckData() {
        createSert = new CreateCertImpl();
    }
    public void request(String model, String type) throws IOException {
        String[] part = model.split("~");
        switch (type){
            case "1": createSert.createRootCert(part);break;
            case "2":  createSert.createBinderCert(part);break;
        }
    }

}
