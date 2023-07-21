package com.example.telegram.service;

import com.example.telegram.service.interfaces.TelegramMethodService;
import org.jvnet.hk2.annotations.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.io.File;
import java.util.*;

@Service
public class TelegramMethodsImpl implements TelegramMethodService {
    public ReplyKeyboardMarkup category() {

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setSelective(true);
        List<KeyboardRow> keyboardRowList = new ArrayList<>();

        KeyboardRow keyboardRow = new KeyboardRow();
        KeyboardButton keyboardButton1 = new KeyboardButton("Category 1");
        KeyboardButton keyboardButton2 = new KeyboardButton("Category 2");
        keyboardRow.add(keyboardButton1);
        keyboardRow.add(keyboardButton2);
        keyboardRowList.add(keyboardRow);

        KeyboardRow keyboardRow1 = new KeyboardRow();
        KeyboardButton keyboardButton3 = new KeyboardButton("Category 3");
        KeyboardButton keyboardButton4 = new KeyboardButton("Category 4");
        keyboardRow1.add(keyboardButton3);
        keyboardRow1.add(keyboardButton4);
        keyboardRowList.add(keyboardRow1);

        replyKeyboardMarkup.setKeyboard(keyboardRowList);
//       sendMessageWithCategoriesKeyboard(chatId,replyKeyboardMarkup);

        return replyKeyboardMarkup;
    }

    public SendMessage sendMessageWithCategoriesKeyboard(Long chatId, ReplyKeyboardMarkup replyKeyboardMarkup) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.setText("You selected categories");
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    public InlineKeyboardMarkup inlineKeyboardButton() {
        // inline button ; this is for the button below the message
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> inlineButtons = new ArrayList<>();
        List<InlineKeyboardButton> inlineKeyboardButtonList = new ArrayList<>();

        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();

        String link = "https://www.youtube.com/";
        inlineKeyboardButton1.setText("Button 1");
        inlineKeyboardButton1.setUrl(link);
        inlineKeyboardButton2.setText("Button 2");
        inlineKeyboardButton3.setText("Button 3");


        inlineKeyboardButton1.setCallbackData("button1");
        inlineKeyboardButton2.setCallbackData("button2");
        inlineKeyboardButton3.setCallbackData("button3");

        inlineKeyboardButtonList.add(inlineKeyboardButton1);
        inlineKeyboardButtonList.add(inlineKeyboardButton2);
        inlineKeyboardButtonList.add(inlineKeyboardButton3);

        inlineButtons.add(inlineKeyboardButtonList);
        inlineKeyboardMarkup.setKeyboard(inlineButtons);

        return inlineKeyboardMarkup;
    }

    public ReplyKeyboardMarkup mainCategory(){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setSelective(true);
        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyboardRow = new KeyboardRow();
        KeyboardRow keyboardRow1 = new KeyboardRow();
        KeyboardRow keyboardRow2 = new KeyboardRow();
        KeyboardButton keyboardButton1 = new KeyboardButton();
        KeyboardButton keyboardButton2 = new KeyboardButton();
        KeyboardButton keyboardButton3 = new KeyboardButton();
        KeyboardButton keyboardButton4 = new KeyboardButton();
        KeyboardButton keyboardButton5 = new KeyboardButton();

        keyboardButton1.setText("Categories");
        keyboardButton2.setText("Games List");
        keyboardButton3.setText("Settings");
        keyboardButton4.setText("Api");
        keyboardButton5.setText("Api2");

        keyboardRow.add(keyboardButton1);
        keyboardRow.add(keyboardButton2);

        keyboardRow1.add(keyboardButton3);
        keyboardRow1.add(keyboardButton4);

        keyboardRow2.add(keyboardButton5);

        keyboardRowList.add(keyboardRow);
        keyboardRowList.add(keyboardRow1);
        keyboardRowList.add(keyboardRow2);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);

        return replyKeyboardMarkup;
    }

    public InputFile sendPhoto() {
        InputFile file = new InputFile();
        file.setMedia(new File("D:\\Project\\ChatBot\\welcome.webp"));
        return file;
    }
}
