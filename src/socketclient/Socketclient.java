/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketclient;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Socketclient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String temp = "";
        do {
            try {
                Socket client = new Socket(InetAddress.getLocalHost(),1234);
                InputStream clientIn = client.getInputStream();
                OutputStream clientOut = client.getOutputStream();
                PrintWriter pw = new PrintWriter(clientOut, true);
                BufferedReader br = new BufferedReader(new InputStreamReader(clientIn));
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Typessage for the server: ");
                temp = stdIn.readLine();
                pw.println(temp);
                System.out.println("Serverage: ");
                System.out.println(br.readLine());
                pw.close();
                br.close();
                client.close();
            } catch (ConnectException ce) {
                System.out.println("Cannotect to the server.");
            } catch (IOException ie) {
                System.out.println("I/Or.");
            }
        }
        while (!temp.matches("EXIT"));

    }

}

 
