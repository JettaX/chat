package repository;

import entity.Chat;
import entity.Message;

import java.util.ArrayList;
import java.util.List;

public class ChatRepositoryInMemory {
    public static ArrayList<Chat> chatList = new ArrayList<>();


    public static void saveChat(Chat chat) {
        chatList.add(chat);
    }

    public static List<Chat> getAllChatsByUserId(String userName) {
        List<Chat> list = new ArrayList<>();
        chatList.forEach(chat -> {
            if (chat.getOwnerUser().getUserLogin().equals(userName)) {
                list.add(chat);
            }
        });
        return list;
    }

    public static Chat getChatByOwnerIdAndFriendId(String ownerUserName, String friendUserName) {
        for (Chat chat : chatList) {
            if (chat.getOwnerUser().getUserLogin().equals(ownerUserName)) {
                if (chat.getFriendUser().getUserLogin().equals(friendUserName)) {
                    return chat;
                }
            }
        }
        return null;
    }

    public static void addMessage(String FromUserName, String ToUserName, Message message) {
        chatList.forEach(chat -> {
            if (chat.getOwnerUser().getUserLogin().equals(FromUserName)) {
                if (chat.getFriendUser().getUserLogin().equals(ToUserName)) {
                    chat.addMessage(message);
                }
            }
            if (chat.getOwnerUser().getUserLogin().equals(ToUserName)) {
                if (chat.getFriendUser().getUserLogin().equals(FromUserName)) {
                    chat.addMessage(message);
                }
            }
        });
    }

    public static boolean deleteChatByUserIdAndFriendId(String ownerUserName, String friendUserName) {
        for (Chat chat : chatList) {
            if (chat.getOwnerUser().getUserLogin().equals(ownerUserName)) {
                if (chat.getFriendUser().getUserLogin().equals(friendUserName)) {
                    return chatList.remove(chat);
                }
            }
        }
        return false;
    }
}
