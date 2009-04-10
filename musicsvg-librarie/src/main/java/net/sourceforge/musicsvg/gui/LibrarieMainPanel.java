/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sourceforge.musicsvg.gui;

import java.util.List;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sourceforge.musicsvg.gui.listener.PerformAddDirectoryListener;
import net.sourceforge.musicsvg.model.Song;
import org.apache.log4j.Logger;

/**
 *
 * @author Dav
 */
public class LibrarieMainPanel extends JPanel implements PerformAddDirectoryListener {

    private JTable jTable;
    private JComponent statusBar;
    private static final Logger LOG = Logger.getLogger(LibrarieMainPanel.class);

    public LibrarieMainPanel(JComponent statusBar) {
        this.statusBar = statusBar;
        jTable = new javax.swing.JTable();
        jTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{{null, null, null, null}},
                new String[]{"Nom du fichier", "Titre", "Artiste", "Chemin complet"}));

        add(jTable);
        add(statusBar);
    }

    public void publish(List<Song> songs) {
        LOG.debug("Publication de la lecture des " + songs.size() + " morceaux");
        DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
        int nbRow = tableModel.getRowCount();
        for (int i = 0; i < nbRow; i++) {
            tableModel.removeRow(0);
        }

        for (Song s : songs) {
            tableModel.addRow(new String[]{
                        s.getFile().getName(),
                        s.getTitle(),
                        s.getArtist(),
                        s.getFile().getAbsolutePath()
                    });
        }
    }
}
