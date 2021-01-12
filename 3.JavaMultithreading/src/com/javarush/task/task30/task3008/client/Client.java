package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;
    public class SocketThread extends Thread{
        public void run(){
            try {
                String ip = getServerAddress();
                int port = getServerPort();
                Socket socket = new Socket(ip, port);
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            }
            catch (IOException | ClassNotFoundException e){
                notifyConnectionStatusChanged(false);
            }
        }
        protected void processIncomingMessage(String message){
            ConsoleHelper.writeMessage(message);
        }
        protected void informAboutAddingNewUser(String userName){
            ConsoleHelper.writeMessage(userName + " are joined to chat.");
        }
        protected void informAboutDeletingNewUser(String userName){
            ConsoleHelper.writeMessage(userName + " are disconnected.");
        }
        protected void notifyConnectionStatusChanged(boolean clientConnected){
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this){
                Client.this.notify();
            }
        }
        protected void clientHandshake() throws IOException, ClassNotFoundException{
            while (true) {
                Message msg = connection.receive();
                if (msg.getType() == MessageType.NAME_REQUEST){
                    String name = getUserName();
                    connection.send(new Message(MessageType.USER_NAME, name));
                }
                else
                    if (msg.getType() == MessageType.NAME_ACCEPTED) {
                        notifyConnectionStatusChanged(true);
                        return;
                    }
                    else
                        throw new IOException("Unexpected MessageType");
            }
        }
        protected void clientMainLoop() throws IOException, ClassNotFoundException{
            while(true){
                Message msg = connection.receive();
                if (msg.getType() == null)
                    throw new IOException("Unexpected MessageType");
                switch (msg.getType()){
                    case TEXT: processIncomingMessage(msg.getData()); break;
                    case USER_ADDED: informAboutAddingNewUser(msg.getData()); break;
                    case USER_REMOVED: informAboutDeletingNewUser(msg.getData()); break;

                    default: throw new IOException("Unexpected MessageType");
                }
            }
        }
    }

    public static void main(String[] args) {
        Client cl = new Client();
        cl.run();
    }

    public void run(){
        SocketThread st = getSocketThread();
        st.setDaemon(true);
        st.start();
        synchronized (this){
            try {
                    wait();
            } catch (InterruptedException e) {
                ConsoleHelper.writeMessage("Unexpected error");
                return;
            }
        }
        if (clientConnected){
            ConsoleHelper.writeMessage("Соединение установлено.\nДля выхода наберите команду 'exit'.");
        }
        else {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
            return;
        }
        while(clientConnected){
            String msg = ConsoleHelper.readString();
            if (msg.equals("exit"))
                return;
            if (shouldSendTextFromConsole())
                sendTextMessage(msg);
        }
    }

    protected String getServerAddress(){
        ConsoleHelper.writeMessage("Please, enter server ip-address.");
        return ConsoleHelper.readString();
    }
    protected int getServerPort(){
        ConsoleHelper.writeMessage("Please, enter server's port.");
        return ConsoleHelper.readInt();
    }
    protected String getUserName(){
        ConsoleHelper.writeMessage("Please, enter your name.");
        return ConsoleHelper.readString();
    }
    protected boolean shouldSendTextFromConsole(){
        return true;
    }
    protected SocketThread getSocketThread(){
        return new SocketThread();
    }
    protected void sendTextMessage(String text){
        try{
            connection.send(new Message(MessageType.TEXT, text));
        }
        catch (IOException e){
            ConsoleHelper.writeMessage("Some error occurs");
            clientConnected = false;
        }
    }
}
