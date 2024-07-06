import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LookWhoWins {

    public void WhoWins(String[] values, JFrame jf) {
        if (values[0] == values[1] && values[1] == values[2] && values[0] != "") {
            JOptionPane.showMessageDialog(null, values[0] + " got Wins");
            Restart(jf);
        } else if (values[3] == values[4] && values[4] == values[5] && values[3] != "") {
            JOptionPane.showMessageDialog(null, values[3] + " got Wins");
            Restart(jf);
        } else if (values[6] == values[7] && values[7] == values[8] && values[6] != "") {
            JOptionPane.showMessageDialog(null, values[6] + " got Wins");
            Restart(jf);
        } else if (values[0] == values[3] && values[3] == values[6] && values[0] != "") {
            JOptionPane.showMessageDialog(null, values[0] + " got Wins");
            Restart(jf);
        } else if (values[1] == values[4] && values[4] == values[7] && values[1] != "") {
            JOptionPane.showMessageDialog(null, values[1] + " got Wins");
            Restart(jf);
        } else if (values[2] == values[5] && values[5] == values[8] && values[2] != "") {
            JOptionPane.showMessageDialog(null, values[2] + " got Wins");
            Restart(jf);
        } else if (values[0] == values[4] && values[4] == values[8] && values[0] != "") {
            JOptionPane.showMessageDialog(null, values[0] + " got Wins");
            Restart(jf);
        } else if (values[2] == values[4] && values[4] == values[6] && values[2] != "") {
            JOptionPane.showMessageDialog(null, values[2] + " got Wins");
            Restart(jf);
        } else if (values[0] == values[1] && values[1] == values[2] && values[2] == values[3] && values[3] == values[4]
                && values[4] == values[5] && values[5] == values[6] && values[6] == values[7] && values[7] == values[8]
                && values[8] == values[0]) {
            JOptionPane.showMessageDialog(null, "You both Tie");
            Restart(jf);
        }
    }

    public void Restart(JFrame JF) {
        JF.dispose();
        new MainFrame();

    }
}

