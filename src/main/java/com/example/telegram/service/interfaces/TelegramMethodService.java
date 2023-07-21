package com.example.telegram.service.interfaces;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

public interface TelegramMethodService {
    public ReplyKeyboardMarkup category();
    public SendMessage sendMessageWithCategoriesKeyboard(Long chatId, ReplyKeyboardMarkup replyKeyboardMarkup);
    public InlineKeyboardMarkup inlineKeyboardButton();
    public InputFile sendPhoto();
    public ReplyKeyboardMarkup mainCategory();
}
