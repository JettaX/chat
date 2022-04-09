package repository;

import entity.Chat;
import entity.Message;

import java.util.List;

public interface ChatRepository {
    public void saveChat(Chat chat);

    public List<Chat> getAllChatsByUserId(String userName);

    public Chat getChatByOwnerIdAndFriendId(String ownerUserName, String friendUserName);

    public void addMessage(String FromUserName, String ToUserName, Message message);

    public boolean deleteChatByUserIdAndFriendId(String ownerUserName, String friendUserName);
}
