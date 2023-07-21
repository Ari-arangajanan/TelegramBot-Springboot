package com.example.telegram;

import com.example.telegram.service.interfaces.TelegramMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.*;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

//Standard Spring component annotation
//  @Component
  public class TelegramBot  {
//
//  @Autowired
//  private TelegramMethodService telegramMethodService;
//  public TelegramBot() {
//    super("6383707863:AAErmpMAw9TbyXBeoY6ipKm-pZszJdpxiz8");
//
//
//  }
//
//  @Override
//  public void onUpdateReceived(Update update) {
//    SendMessage sendMessage = new SendMessage();
//    SendPhoto sendPhoto = new SendPhoto();
//
//    if (update.hasMessage()) {
//      Long chatId = update.getMessage().getChatId();
//      String text = update.getMessage().getText();
//
////    update.getChatMember().
//
//      Chat senderChat = update.getMessage().getSenderChat();
//
//
//      // command based functionalities
//      if (text.equals("/command1") || text.equals("/command1@thrtest_bot")) {
//        sendMessage.setChatId(chatId);
//        sendMessage.setText("This is Command 1");
//        try {
//          execute(sendMessage);
//
//        } catch (TelegramApiException e) {
//          e.printStackTrace();
//        }
//      } else if (text.equals("/command2")) {
//        sendMessage.setChatId(chatId);
//        sendMessage.setText("This is Command 2");
//        try {
//          execute(sendMessage);
//        } catch (TelegramApiException e) {
//          e.printStackTrace();
//        }
//      } else if (text.equals("Categories")) {
//        SendMessage message = telegramMethodService.sendMessageWithCategoriesKeyboard(chatId,telegramMethodService.category());
//        try {
//          execute(message);
//
//        } catch (TelegramApiException e) {
//          e.printStackTrace();
//        }
//      }
////    SendMessage sendMessage = new SendMessage();
////    sendMessage.setChatId(chatId);
////    sendMessage.setText("Hello World ");
//      else if (text.equals("hi")) {
//        String htmlMessage = "<b>Game Rules:</b>\n"
//                + "<i>These are the rules of the game...</i>\n"
//                + "<a href=\"https://www.youtube.com/\">Click here for more details</a>";
//        sendMessage.setChatId(chatId);
//        sendMessage.setText(htmlMessage);
//        sendMessage.setParseMode("HTML");
//
//        InlineKeyboardMarkup res = telegramMethodService.inlineKeyboardButton();
//        sendMessage.setReplyMarkup(res);
//
//        sendPhoto.setChatId(chatId);
//        sendPhoto.setPhoto(telegramMethodService.sendPhoto());
//
//        try {
//          execute(sendPhoto);
//          execute(sendMessage);
//
//        } catch (TelegramApiException e) {
//          e.printStackTrace();
//        }
//      } else {
//
//        sendMessage.setChatId(chatId);
//        sendMessage.setText("Choose one");
//        sendMessage.setReplyMarkup(telegramMethodService.mainCategory());
//        try {
//          execute(sendMessage);
//
//        } catch (TelegramApiException e) {
//          e.printStackTrace();
//        }
//
//
//      }
//
//
//      System.out.println("Ari " + text);
//    } else if (update.hasCallbackQuery()) {  // callback Query for button functionality
//      Message message = update.getCallbackQuery().getMessage();
//      CallbackQuery callbackQuery = update.getCallbackQuery();
//      String data = callbackQuery.getData();
//      String callBackQueryID = callbackQuery.getId();
//      Long chatId = callbackQuery.getMessage().getChatId();
//      Integer messageId = callbackQuery.getMessage().getMessageId();
//
//      SendMessage sendMessage1 = new SendMessage();
//
//      if (data.equals("button1")) {
//        sendMessage1.setText("Button 1 start");
//        sendMessage1.setChatId(message.getChatId());
//        try {
//          execute(sendMessage1);
//
//        } catch (TelegramApiException e) {
//          e.printStackTrace();
//        }
//      } else if (data.equals("button2")) {
//        EditMessageText new_message = new EditMessageText();
//        new_message.setChatId(message.getChatId());
//        new_message.setMessageId(message.getMessageId());
//        new_message.setText("updated the text");
//        new_message.setReplyMarkup(callbackQuery.getMessage().getReplyMarkup());
//
//        try {
//          execute(new_message);
//
//        } catch (TelegramApiException e) {
//          e.printStackTrace();
//        }
//      }
//      if (data.equals("button3")) { // for popup message
//        AnswerCallbackQuery popupAlert = new AnswerCallbackQuery();
//        popupAlert.setCallbackQueryId(callBackQueryID);
//        popupAlert.setText("Message");
//        popupAlert.setShowAlert(true);
//        try {
//          execute(popupAlert);
//
//        } catch (TelegramApiException e) {
//          e.printStackTrace();
//        }
//      }
//    }
//  }
//
//  @Override
//  public String getBotUsername() {
//    return "AriArangajanansbot";
//  }
//  //Bot body.


}