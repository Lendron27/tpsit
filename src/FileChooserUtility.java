import javax.swing.*;
import java.io.File;

public class FileChooserUtility extends JPanel{

    public static File chooseFile() {
        JFileChooser c = new JFileChooser();
        c.setDialogTitle("Scegli il file in cui salvare l'output: ");

        int s = c.showSaveDialog(null);

        if (s == JFileChooser.APPROVE_OPTION) {
            return c.getSelectedFile();
        } else {
            return null;
        }
    }
}