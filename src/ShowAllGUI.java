import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

public class ShowAllGUI extends JFrame {

    private JPanel contentPane;
    private JLabel lblResults;
    private JButton btnClose;

    public ArrayList<Flight> show_contacts() {
        Tracker filemanager = new Tracker();
        ArrayList<Flight> result = filemanager.getValues();
        // for(int i =0; i < result.size(); i++) {
        // System.out.println(result.get(0) + " ");
        // }
        return result;
    }

    public ShowAllGUI() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblResults = new JLabel("");
        lblResults.setVerticalAlignment(SwingConstants.TOP);
        lblResults.setBounds(45, 29, 361, 144);
        contentPane.add(lblResults);

        btnClose = new JButton("Close");
        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnClose.setBounds(170, 202, 117, 29);
        contentPane.add(btnClose);

        JTextArea ListFlights = new JTextArea();
        ListFlights.setBounds(32, 18, 398, 172);
        ArrayList<Flight> r = show_contacts();
        ListFlights.append(
                "Departure | Arrival | Date                | # of Economy Seats | # of Business Class Seats | # of First Class Seats\n");
        for (int i = 0; i < r.size(); i++) {
            ListFlights.append(r.get(i) + "\n");

        }
        JScrollPane scrolltxt = new JScrollPane(ListFlights);
        scrolltxt.setBounds(31, 17, 400, 175);
        contentPane.add(scrolltxt);
    }
}