package by.nces.sert_Keys.core;

import java.io.IOException;
import java.io.InputStream;

public class rootGen {
    String[] str;
    Process p;
    String param;
    public rootGen(String[] str) throws IOException {
        this.str = str;
        genKeys();
        writeToHSM();
        convertToHSM();
        genCVCACert();
    }

    private String funParam(){
        this.param = str[0] + str[4] + str[1] + str[2];
        return this.param;
    }

    public void genKeys() throws IOException {
        String closeKey = "openssl ecparam -out " + funParam()
                + ".priv.pem -name brainpoolP256r1 -genkey -param_enc explicit";
        String openKey = "openssl ec -in " + funParam()
                + ".pem -pubout -out "+ funParam()+ ".pub.pem";
        System.out.println(closeKey);
        System.out.println(openKey);
        try {
            this.p = Runtime.getRuntime().exec(closeKey);
            this.p = Runtime.getRuntime().exec(openKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeToHSM()throws IOException {
        String closeKey = "pkcs11-tool --module /opt/safenet/protecttoolkit5/ptk/lib/libcryptoki.so  --login --login-type 'user' --pin '20Gfcgjhn20' --token-label 'TCC' --write-object "
                + funParam() + ".priv.pem --label '"+funParam()+".priv' --private --extractable -y privkey";
        String openKey = "pkcs11-tool --module /opt/safenet/protecttoolkit5/ptk/lib/libcryptoki.so  --login --login-type 'user' --pin '20Gfcgjhn20' --token-label 'TCC' --write-object "
                + funParam() + "pub.pem --label '"+funParam()+".pub' --extractable -y pubkey";
        System.out.println(closeKey);
        System.out.println(openKey);
        try {
            this.p = Runtime.getRuntime().exec(closeKey);
            this.p = Runtime.getRuntime().exec(openKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void convertToHSM(){
        String fileConv = "openssl pkcs8 -topk8 -nocrypt -in " + funParam() +".pem -outform DER -out "+ funParam()+".pkcs8";
        try {
            this.p = Runtime.getRuntime().exec(fileConv);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void genCVCACert(){
        String genCert = "cvc-create --out-cert="+funParam()+".cvcert --role="+str[4]+" --type="+str[5]+" --chr="+funParam()
                + " --issued="+str[7] + " --expires="+str[8]+" --sign-with="+funParam()+".pkcs8 --scheme="+ str[6] +
                " --read-finger --read-iris";
        try {
            this.p = Runtime.getRuntime().exec(genCert);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
