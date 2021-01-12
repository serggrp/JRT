package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    private static class Handler extends Thread{
        private Socket socket;
        public Handler(Socket socket){
            this.socket = socket;
        }
        public void run(){
            ConsoleHelper.writeMessage(socket.getRemoteSocketAddress() + "... connection established");
            String name = null;
            try(Connection conn = new Connection(socket)){
                name = serverHandshake(conn);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, name));
                notifyUsers(conn, name);
                serverMainLoop(conn, name);

            }
            catch (IOException | ClassNotFoundException e){
                ConsoleHelper.writeMessage("Some error occurs");
            }
            finally {
                if (name != null && connectionMap.containsKey(name)){
                    connectionMap.remove(name);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, name));
                }
                ConsoleHelper.writeMessage(socket.getRemoteSocketAddress() + "... connection closed");
            }
        }
        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{
            String requestName = "Hello! Please, type your name here";
            boolean needRepeat = true;
            while(needRepeat) {
                Message reqNameMessage = new Message(MessageType.NAME_REQUEST, requestName);
                connection.send(reqNameMessage);
                Message response = connection.receive();
                if (response.getType() == MessageType.USER_NAME){
                    String name = response.getData();
                    if (name == null || name.equals("") || connectionMap.keySet().contains(name)) {
                        requestName = "Entered name is empty or already in use. Please, try again...";
                    }
                    else{
                        connectionMap.put(name, connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED, "Your name is accepted successfully!"));
                        return name;
                    }
                }
                else{
                    requestName = "Please, type your name again";
                }
            }
            return null;
        }
        private void notifyUsers(Connection connection, String userName) throws IOException{
            for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
                if (!entry.getKey().equals(userName)){
                    Message addMessage = new Message(MessageType.USER_ADDED, entry.getKey());
                    connection.send(addMessage);
                }
            }
        }
        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            while (true) {
                Message mes = connection.receive();
                if (mes.getType() == MessageType.TEXT){
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName+": "+mes.getData()));
                }
                else{
                    ConsoleHelper.writeMessage("This message contains errors");
                }
            }
        }
    }
    public static void sendBroadcastMessage(Message message){
        try{
            for (Connection conn : connectionMap.values()) {
                conn.send(message);
            }
        }
        catch (IOException e){
            ConsoleHelper.writeMessage("Message cann't be delivered");
        }
    }
    public static void main(String[] args) {
        int port = ConsoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(port)){
            ConsoleHelper.writeMessage("Server started");
            while(true){
                Socket clientSocket = serverSocket.accept();
                Handler h = new Handler(clientSocket);
                h.start();
            }
        }
        catch (UnknownHostException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
