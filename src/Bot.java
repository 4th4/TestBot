import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

public class Bot  extends TelegramLongPollingBot {

    public static void main(String args[]){
        ApiContextInitializer.init();
        TelegramBotsApi api = new TelegramBotsApi();
        try {
            api.registerBot(new Bot());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onUpdateReceived(Update update) {
        System.out.println("Working!");
        Message message = update.getMessage();
        if (message != null){
            System.out.println("hello");
            switch (message.getText()){
                case "влад пидор":
                    sendMessage(message,"Я согласен с тем что Влад пидор!");
                    break;
                case "керя даун":
                    sendMessage(message,"Керя даун... Ну да как бы!");
                    break;
                case "саня хуй соси":
                    sendMessage(message,"Все и так знают что Саня хуй сосет!");
                    break;
                case "тест":
                    sendMessage(message,"Все работает не переживай!");
                    break;
                case "бот реши англишку":
                    sendMessage(message,"Мне сейчас лень.");
                    break;
                case "но у нас кр":
                    sendMessage(message,"А ну надо было готовиться.");
                    break;
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "Test2bot";
    }

    @Override
    public String getBotToken() {
        return "452477805:AAFKIBWl_tPfy6yQvZHiHKwEQRqMhrL2hY8";
    }

    public void sendMessage(Message message, String text){
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(text);
        try{
            execute(sendMessage);
        }catch (Exception e){}
    }

}
