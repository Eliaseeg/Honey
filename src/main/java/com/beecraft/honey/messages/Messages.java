package com.beecraft.honey.messages;

import com.beecraft.honey.Honey;

public enum Messages {

    // Constants
    SERVER_IP("MESSAGES.CONSTANTS.SERVER_IP"),
    SERVER_NAME("MESSAGES.CONSTANTS.SERVER_NAME"),

    // Chat messages.
    CHAT_JOIN_GAME("MESSAGES.CHAT.JOIN_GAME"),
    CHAT_QUIT_GAME("MESSAGES.CHAT.QUIT_GAME"),
    CHAT_STARTING("MESSAGES.CHAT.STARTING"),

    // Title messages.
    TITLE_STARTING("MESSAGES.TITLE.STARTING_TITLE"),
    TITLE_STARTING_SUBTITLE("MESSAGES.TITLE.STARTING_SUBTITLE");

    private final String path;

    private Messages(String path) {
        this.path = path;
    }

    public String get(String... args) {
        return MessageUtil.format(Honey.getInstance().getConfig().getString(path), args);
    }

}
