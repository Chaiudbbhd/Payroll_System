//made by lakshmi prasanna kumar//

package SystemDB;
import java.awt.BorderLayout;
import java.awt.Image;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import org.sqlite.*;

/**
 *
 * @author  lakshmi prasanna kumar
 */
public class DBconnection {
    Connection conn;
    
    public Connection getconnection() throws IOException {
        try {
             
            //embed db to this java system
            Class.forName("org.sqlite.JDBC");            
            
            SQLiteDataSource urlsql = new SQLiteDataSource();
            urlsql.setUrl("jdbc:sqlite::resource:"+DBconnection.class.getResource("/SystemDB/database.sqlite").toString());
            conn = urlsql.getConnection();
       
            } catch (ClassNotFoundException | SQLException e) {
                final JProgressBar progressBar1 = new JProgressBar();
                progressBar1.setIndeterminate(true);
                final JOptionPane optionPane1 = new JOptionPane("<html><center>Can't connect to the database!<br>ERR: "+e+"<br>Exiting now...</center></html>", JOptionPane.ERROR_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
                final JDialog dialog1 = new JDialog();
                optionPane1.add(progressBar1, BorderLayout.CENTER);
                progressBar1.setIndeterminate(true);
                dialog1.setTitle("SYSTEM ERROR | ECoders");
                dialog1.setAlwaysOnTop(true);
                dialog1.setModal(true);
                dialog1.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
                dialog1.setContentPane(optionPane1);
                dialog1.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                dialog1.pack();
                Image imageloadingtop1;
                imageloadingtop1 = ImageIO.read(getClass().getResource("/Images/wait_16px.png"));
                dialog1.setIconImage(imageloadingtop1); //set icon to dialog
                dialog1.setLocationRelativeTo(null); //center the dialog
    
                // Set a timer
                new Thread(() -> {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException err) {
                    }
                    dialog1.dispose();
                    System.exit(0);
                }).start();
                dialog1.setVisible(true);
            }
        return conn;
    }
}
