package view.components.chatsView;

import entity.User;
import view.MainView;
import view.commonComponents.ScrollPane;
import view.components.chatsView.components.listOfFriends.ListOfFriends;
import view.components.chatsView.components.listOfUsers.ListOfUsers;
import view.components.chatsView.components.searchPeople.SearchPeople;
import view.utils.Colors;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ChatsView extends JPanel {
    private final User user;
    private JPanel panelOfChats;
    private final MainView mainView;
    private ScrollPane scroll;

    public ChatsView(User user, MainView mainView) {
        this.user = user;
        this.mainView = mainView;
        initialize();
    }

    private void initialize() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(300, 1));
        setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));
        setBackground(Colors.secondColor);

        var searchPanel = new SearchPeople(this, mainView);
        searchPanel.setPreferredSize(new Dimension(getWidth(), 60));

        add(searchPanel, BorderLayout.NORTH);

        addPanelWithFriends();
    }

    public void addPanelWithFriends() {
        panelOfChats = new ListOfFriends(user, mainView);
        addPanelInScroll(panelOfChats);
    }

    private void addPanelInScroll(JPanel panel) {
        scroll = new ScrollPane(panel);
        scroll.getVerticalScrollBar().setUnitIncrement(10);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        add(scroll, BorderLayout.CENTER);
    }

    public void deletePanelWithPeople() {
        remove(scroll);
        revalidate();
    }

    public void showResults(List<User> list) {
        panelOfChats = new ListOfUsers(list, mainView);
        addPanelInScroll(panelOfChats);
    }
}
