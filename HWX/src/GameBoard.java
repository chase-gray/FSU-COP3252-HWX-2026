import java.awt.*;
import javax.swing.*;

enum Tabs { MENU, SETTINGS, PREBOARD, BOARD }

public class GameBoard
{
    private static final JFrame frame = new JFrame("Texas Hold'em");
    private static final CardLayout panels = new CardLayout();
    private static final JPanel root = new JPanel(panels);

    public static void showTabs(Tabs tab)
    {
        panels.show(root, tab.name());
    }

    public static class Menu extends JPanel
    {
        public Menu()
        {
            setBackground(Color.GRAY);
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            JButton playButton = new JButton("Play");
            JButton settingsButton = new JButton("Settings");
            JButton quitButton = new JButton("Quit");

            playButton.addActionListener(e -> showTabs(Tabs.PREBOARD));
            settingsButton.addActionListener(e -> showTabs(Tabs.SETTINGS));
            quitButton.addActionListener(e -> System.exit(0));

            playButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            settingsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

            add(Box.createVerticalGlue());
            add(playButton);
            add(Box.createRigidArea(new Dimension(0, 10)));
            add(settingsButton);
            add(Box.createRigidArea(new Dimension(0, 10)));
            add(quitButton);
            add(Box.createVerticalGlue());
        }
    }

    public static class Settings extends JPanel
    {
        public Settings()
        {
            setBackground(Color.GRAY);
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            JButton returnButton = new JButton("Return");

            returnButton.addActionListener(e -> showTabs(Tabs.MENU));

            returnButton.setAlignmentX(Component.CENTER_ALIGNMENT);

            add(Box.createVerticalGlue());
            add(returnButton);
            add(Box.createVerticalGlue());
        }
    }

    public static class Preboard extends JPanel
    {
        public Preboard()
        {
            setBackground(Color.GRAY);
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            JButton returnButton = new JButton("Return");

            returnButton.addActionListener(e -> showTabs(Tabs.MENU));

            returnButton.setAlignmentX(Component.CENTER_ALIGNMENT);

            add(Box.createVerticalGlue());
            add(returnButton);
            add(Box.createVerticalGlue());
        }
    }

    public static class Board extends JPanel
    {
        public Board()
        {
            setBackground(Color.GRAY);
        }
    }

    public static void main(String[] args) 
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setMinimumSize(new Dimension((int)(screenSize.getWidth() / 2), (int)(screenSize.getHeight() / 1.5)));

        root.add(new Menu(), Tabs.MENU.name());
        root.add(new Settings(), Tabs.SETTINGS.name());
        root.add(new Preboard(), Tabs.PREBOARD.name());
        root.add(new Board(), Tabs.BOARD.name());

        frame.add(root);
        frame.setVisible(true);
    }
}