import org.omg.CORBA.DataInputStream;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",100100);
        DataOutputStream dos ;
        DataInputStream dis ;
    }
}
