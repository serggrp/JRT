package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BotClient extends Client {
    public class BotSocketThread extends Client.SocketThread{
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            if (message.contains(": ")) {
                String[] arrStr = message.split(": ");
                SimpleDateFormat sdf = null;
                switch (arrStr[1].toLowerCase()){
                    case "дата": sdf = new SimpleDateFormat("d.MM.YYYY"); break;
                    case "день": sdf = new SimpleDateFormat("d"); break;
                    case "месяц": sdf = new SimpleDateFormat("MMMM"); break;
                    case "год": sdf = new SimpleDateFormat("YYYY"); break;
                    case "время": sdf = new SimpleDateFormat("H:mm:ss"); break;
                    case "час": sdf = new SimpleDateFormat("H"); break;
                    case "минуты": sdf = new SimpleDateFormat("m"); break;
                    case "секунды": sdf = new SimpleDateFormat("s"); break;
                }
                if (sdf != null){
                    sendTextMessage(String.format("Информация для %s: %s", arrStr[0], sdf.format(Calendar.getInstance().getTime())));
                }
            }
        }
    }

    @Override
    protected String getUserName() {
        return "date_bot_"+(int)(Math.random()*100);
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    public static void main(String[] args) {
        BotClient bc = new BotClient();
        bc.run();
    }
}
