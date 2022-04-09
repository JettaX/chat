package common;

import com.formdev.flatlaf.FlatDarkLaf;
import entity.Chat;
import entity.Message;
import entity.User;
import entity.UserSecure;
import repository.ChatRepositoryInMemory;
import repository.UserRepositoryInMemory;
import repository.UserSecureRepositoryImpl;
import view.MainView;

import javax.swing.*;
import java.awt.*;

public class Main {
    // TODO сделать обновление плашки чата при отправлении сообщения
    // TODO при наборе текста в поиске и стирании его происходит обновление ChatsView
    // TODO всплывашка с информации не блокирует интерфейс (need make modal)
    // TODO сделать регистрацию
    // TODO сделать один источник данных

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }

    public Main() {
        FlatDarkLaf.setup();
        JFrame.setDefaultLookAndFeelDecorated(true);
        initializerData();
        var frame = new MainView();
        frame.setTitle("RocketChat");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screeHeight = screenSize.height / 2;
        frame.setPreferredSize(new Dimension(900, screeHeight));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setVisible(true);
    }

    private static void initializerData() {
        User mainUser = new User("admin", "Max", "Maxon");
        User userOne = new User("lilyPit", "Lily", "Pitersky");
        userOne.setImage(new ImageIcon("src/main/resources/Images/1.jpg"));
        User userTwo = new User("Karmenchik", "Karen", "Mamonage");
        userTwo.setImage(new ImageIcon("src/main/resources/Images/2.jpg"));
        User userThree = new User("SteveApple", "Steve", "Jobs");
        userThree.setImage(new ImageIcon("src/main/resources/Images/3.jpg"));
        User userFour = new User("Jonson@Lol", "Jon", "Ar");
        User userFive = new User("KittyClair", "Karen", "Clair");
        User userSix = new User("KekLol", "Sara", "Bond");

        UserSecure userOneSecure = new UserSecure(userOne.getUserLogin(), "1234");
        UserSecure userTwoSecure = new UserSecure(userTwo.getUserLogin(), "1234");
        UserSecure userThreeSecure = new UserSecure(userThree.getUserLogin(), "1234");
        UserSecure mainUserSecure = new UserSecure(mainUser.getUserLogin(), "1234");
        UserSecure userFourSecure = new UserSecure(userFour.getUserLogin(), "1234");
        UserSecure userFiveSecure = new UserSecure(userFive.getUserLogin(), "1234");
        UserSecure userSixSecure = new UserSecure(userSix.getUserLogin(), "1234");

        UserSecureRepositoryImpl.createUserSecure(userOneSecure);
        UserSecureRepositoryImpl.createUserSecure(userTwoSecure);
        UserSecureRepositoryImpl.createUserSecure(userThreeSecure);
        UserSecureRepositoryImpl.createUserSecure(userFourSecure);
        UserSecureRepositoryImpl.createUserSecure(userFiveSecure);
        UserSecureRepositoryImpl.createUserSecure(userSixSecure);
        UserSecureRepositoryImpl.createUserSecure(mainUserSecure);

        Chat chatWithOne = new Chat(mainUser, userOne);
        Chat chatWithTwo = new Chat(mainUser, userTwo);

        Chat chatWithThree = new Chat(userOne, mainUser);
        Chat chatWithFour = new Chat(userOne, userThree);

        Message message1 = new Message(userOne.getUserLogin(), mainUser.getUserLogin(), "Hi");
        Message message2 = new Message(mainUser.getUserLogin(), userOne.getUserLogin(), "Lol");
        Message message3 = new Message(userOne.getUserLogin(), mainUser.getUserLogin(), "Bye");
        Message message4 = new Message(mainUser.getUserLogin(), userOne.getUserLogin(), "Kek");
        Message message5 = new Message(userOne.getUserLogin(), mainUser.getUserLogin(), "Chill");
        Message message6 = new Message(userTwo.getUserLogin(), mainUser.getUserLogin(), "Sleep");
        Message message7 = new Message(mainUser.getUserLogin(), userTwo.getUserLogin(), "Go");
        Message message8 = new Message(userTwo.getUserLogin(), mainUser.getUserLogin(), "Work");
        Message message9 = new Message(mainUser.getUserLogin(), userTwo.getUserLogin(), "Dance");
        Message message11 = new Message(mainUser.getUserLogin(), userTwo.getUserLogin(), "Конструктор поля JFormattedTextField в " +
                "качестве параметра" +
                " " +
                "получает форматирующий объект, унаследованный от абстрактного внутреннего класса AbstractFormatter. Когда в форматированное текстовое поле вводятся символы, то сразу же вызывается форматирующий объект, в задачу которого входит анализ введенного значения и принятие решения о соответствии этого значения некоторому формату. Основными составляющими форматирующего объекта являются фильтр документа DocumentFilter, который принимает решение, разрешать или нет очередное изменение в документе, а также навигационный фильтр NavigationFilter. Навигационный фильтр получает исчерпывающую информацию о перемещениях курсора в текстовом поле и способен запрещать курсору появляться в некоторых областях поля (таких как разделители номеров, дат и других данных, которые не должны редактироваться). Форматирующий объект также отвеачет за действие, которое предпринимается в случае ввода пользователем неверного значения (по умолчанию раздается звуковой сигнал).");
        Message message10 = new Message(userTwo.getUserLogin(), mainUser.getUserLogin(), "Out");

        chatWithOne.addMessage(message1);
        chatWithOne.addMessage(message2);
        chatWithOne.addMessage(message3);
        chatWithOne.addMessage(message4);
        chatWithOne.addMessage(message5);


        chatWithTwo.addMessage(message6);
        chatWithTwo.addMessage(message7);
        chatWithTwo.addMessage(message8);
        chatWithTwo.addMessage(message9);
        chatWithTwo.addMessage(message10);
        chatWithTwo.addMessage(message11);

        UserRepositoryInMemory.saveUser(mainUser);
        UserRepositoryInMemory.saveUser(userOne);
        UserRepositoryInMemory.saveUser(userTwo);
        UserRepositoryInMemory.saveUser(userThree);
        UserRepositoryInMemory.saveUser(userFour);
        UserRepositoryInMemory.saveUser(userFive);
        UserRepositoryInMemory.saveUser(userSix);

        ChatRepositoryInMemory.saveChat(chatWithOne);
        ChatRepositoryInMemory.saveChat(chatWithTwo);
        ChatRepositoryInMemory.saveChat(chatWithThree);
        ChatRepositoryInMemory.saveChat(chatWithFour);
    }
}
