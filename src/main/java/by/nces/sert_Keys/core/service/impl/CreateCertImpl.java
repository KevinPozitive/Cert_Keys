package by.nces.sert_Keys.core.service.impl;

import by.nces.sert_Keys.core.service.ICreateCert;
import by.nces.sert_Keys.core.rootGen;

import java.io.IOException;


public class CreateCertImpl implements ICreateCert {
    @Override
    public String createRootCert(String[] str) throws IOException {
        new rootGen(str);
        return null;
    }

    @Override
    public String createBinderCert(String[] str) {

        return null;
    }
}
