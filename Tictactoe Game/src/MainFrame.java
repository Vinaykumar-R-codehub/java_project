import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainFrame extends JFrame implements ActionListener {
    JButton b0 = new JButton();
    JButton b1 = new JButton();
    JButton b2 = new JButton();
    JButton b3 = new JButton();
    JButton b4 = new JButton();
    JButton b5 = new JButton();
    JButton b6 = new JButton();
    JButton b7 = new JButton();
    JButton b8 = new JButton();
    JButton resetButton = new JButton("Reset");
    JButton launchButton = new JButton("Launch Game");

    JLabel player1Label = new JLabel("Player 1:");
    JLabel player2Label = new JLabel("Player 2:");
    JTextField player1TextField = new JTextField(15);
    JTextField player2TextField = new JTextField(15);

    String player1Name = "";
    String player2Name = "";
    String currentPlayer = "";

    String[] Values = { "", "", "", "", "", "", "", "", "" };

    ImageIcon x = new ImageIcon("img/x.png");
    ImageIcon o = new ImageIcon("img/o.png");
    ImageIcon clear = new ImageIcon("img/clear.png");

    LookWhoWins winnerChecker = new LookWhoWins(); 

    MainFrame() {
        setTitle("Tic-Tac-Toe Game");

        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(3, 3));
        boardPanel.add(b0);
        boardPanel.add(b1);
        boardPanel.add(b2);
        boardPanel.add(b3);
        boardPanel.add(b4);
        boardPanel.add(b5);
        boardPanel.add(b6);
        boardPanel.add(b7);
        boardPanel.add(b8);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(resetButton);
        buttonPanel.add(launchButton);

        JPanel playerPanel = new JPanel(new GridLayout(2, 2));
        playerPanel.add(player1Label);
        playerPanel.add(player1TextField);
        playerPanel.add(player2Label);
        playerPanel.add(player2TextField);

        setLayout(new BorderLayout());
        add(playerPanel, BorderLayout.NORTH);
        add(boardPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        b0.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        resetButton.addActionListener(this);
        launchButton.addActionListener(this);

        setSize(650, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == resetButton) {
            resetGame();
        }
       
        else if (source == launchButton) {
            player1Name = player1TextField.getText().trim();
            player2Name = player2TextField.getText().trim();
            if (!player1Name.isEmpty() && !player2Name.isEmpty()) {
                currentPlayer = player1Name;
                JOptionPane.showMessageDialog(this, "Game launched! " + currentPlayer + " starts first.");
            } else {
                JOptionPane.showMessageDialog(this, "Please enter names for both players.");
            }
        }
        
        else if (source instanceof JButton) {
            JButton button = (JButton) source;
            int index = -1;

            if (button == b0) index = 0;
            else if (button == b1) index = 1;
            else if (button == b2) index = 2;
            else if (button == b3) index = 3;
            else if (button == b4) index = 4;
            else if (button == b5) index = 5;
            else if (button == b6) index = 6;
            else if (button == b7) index = 7;
            else if (button == b8) index = 8;

            if (index != -1 && Values[index].isEmpty() && !currentPlayer.isEmpty()) {
                Values[index] = currentPlayer;
                button.setIcon(currentPlayer.equals(player1Name) ? x : o);
                checkWinner();
                currentPlayer = currentPlayer.equals(player1Name) ? player2Name : player1Name;
            }
        }
    }


    private void resetGame() {
        for (int i = 0; i < Values.length; i++) {
            Values[i] = "";
        }
        b0.setIcon(null);
        b1.setIcon(null);
        b2.setIcon(null);
        b3.setIcon(null);
        b4.setIcon(null);
        b5.setIcon(null);
        b6.setIcon(null);
        b7.setIcon(null);
        b8.setIcon(null);
        currentPlayer = "";
        player1TextField.setText("");
        player2TextField.setText("");
    }

    private void checkWinner() {
        winnerChecker.WhoWins(Values, this);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainFrame();
        });
    }
}
