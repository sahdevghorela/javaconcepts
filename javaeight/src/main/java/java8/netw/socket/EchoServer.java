package java8.netw.socket;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    /*
    - Listening in main thread, In real world may be you accept and spawn new thread for processing.
     */
    public static void main(String[] args) {
        try (
                ServerSocket echoServer = new ServerSocket(9000);
                Socket client = echoServer.accept();
                BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter printWriter = new PrintWriter(client.getOutputStream(), true)) {

            String line = "";
            System.out.println("connected");
            while ((line = br.readLine()) != null) {
                printWriter.println("You Said:" + line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
