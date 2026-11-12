import java.awt.*;
import javax.swing.*;

enum Tabs { MENU, SETTINGS, PREBOARD, BOARD }

public class GameBoard
{
    // frame and panel creation
    private static final JFrame frame = new JFrame("Texas Hold'em");
    private static final CardLayout panels = new CardLayout();
    private static final JPanel root = new JPanel(panels);

    // object creation
    static GameSettings gameSettings = new GameSettings();
    static GameLogic game = new GameLogic();

    // tab switching for frame
    public static void showTabs(Tabs tab) { panels.show(root, tab.name()); }

    // main menu
    public static class Menu extends JPanel
    {
        public Menu()
        {
            // panel setup
            setBackground(Color.GRAY);
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            // interactables
            JButton playButton = new JButton("Play");
            JButton settingsButton = new JButton("Settings");
            JButton quitButton = new JButton("Quit");

            // event listeners
            playButton.addActionListener(e -> showTabs(Tabs.PREBOARD));
            settingsButton.addActionListener(e -> showTabs(Tabs.SETTINGS));
            quitButton.addActionListener(e -> System.exit(0));

            // interactable alignment
            playButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            settingsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

            // interactable creation
            add(Box.createVerticalGlue());
            add(playButton);
            add(Box.createRigidArea(new Dimension(0, 10)));
            add(settingsButton);
            add(Box.createRigidArea(new Dimension(0, 10)));
            add(quitButton);
            add(Box.createVerticalGlue());
        }
    }

    // settings menu
    public static class Settings extends JPanel
    {
        public Settings()
        {
            // panel setup
            setBackground(Color.GRAY);
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            // interactables
            JSlider playerCountSlider = new JSlider(2, 8, 2);
            JButton returnButton = new JButton("Return");

            // event listeners
            playerCountSlider.addChangeListener(e -> gameSettings.setPlayers(playerCountSlider.getValue()));
            returnButton.addActionListener(e -> showTabs(Tabs.MENU));

            // interactable alignment
            playerCountSlider.setAlignmentX(Component.CENTER_ALIGNMENT);
            returnButton.setAlignmentX(Component.CENTER_ALIGNMENT);

            // interactable settings
            playerCountSlider.setMajorTickSpacing(1);
            playerCountSlider.setMinorTickSpacing(1);
            playerCountSlider.setPaintTicks(true);
            playerCountSlider.setPaintLabels(true);
            playerCountSlider.setSnapToTicks(true);
            playerCountSlider.setMaximumSize(new Dimension(300, 100));

            // interactable creation
            add(Box.createVerticalGlue());
            add(playerCountSlider);
            add(Box.createRigidArea(new Dimension(0, 10)));
            add(returnButton);
            add(Box.createVerticalGlue());
        }
    }

    // pregame menu
    public static class Preboard extends JPanel
    {
        public Preboard()
        {
            // panel setup
            setBackground(Color.GRAY);
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            // interactables
            JButton returnButton = new JButton("Return");

            // event listeners
            returnButton.addActionListener(e -> showTabs(Tabs.MENU));

            // interactable alignment
            returnButton.setAlignmentX(Component.CENTER_ALIGNMENT);

            // interactable creation
            add(Box.createVerticalGlue());
            add(returnButton);
            add(Box.createVerticalGlue());
        }
    }

    // game board screen
    public static class Board extends JPanel
    {
        public Board()
        {
            setBackground(Color.GRAY);
        }
    }

    // frame and application creation and settings
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