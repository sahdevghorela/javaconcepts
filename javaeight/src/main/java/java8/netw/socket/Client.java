package java8.netw.socket;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try (
                Socket socket = new Socket(InetAddress.getLocalHost(), 9000);
                PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))

        {
            String line = "";
            while((line = br.readLine()) != null && !"".equals(line)){
                printWriter.println(line);
                System.out.println(in.readLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
