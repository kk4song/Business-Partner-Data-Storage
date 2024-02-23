import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.IOException;
import java.util.InputMismatchException;
public class FileShelf { // This class displays the bottom panel's partnershelf.

    JPanel partnerShelfPanel;
    JScrollPane scrollPane;
    private ArrayList<String> partnerTitles;
    public FileShelf(DefaultListModel<String> partnerListModel) // Parameter passed in from MainWindow class.
    {
        partnerShelfPanel = new JPanel();
        partnerShelfPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // FlowLayout to display partners.
        scrollPane = new JScrollPane(partnerShelfPanel); // Scroll pane in order to view all the partners.

        for (int i = 0; i < partnerListModel.getSize(); i++) { // Add all elements from JList into ArrayList.
            partnerTitles.add(partnerListModel.getElementAt(i));
        }
    }
}
