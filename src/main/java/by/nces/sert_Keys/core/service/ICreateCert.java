package by.nces.sert_Keys.core.service;

import java.io.IOException;

public interface ICreateCert {
    String createRootCert(String[] str) throws IOException;
    String createBinderCert(String[] str);
}
