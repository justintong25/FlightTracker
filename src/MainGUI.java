import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainGUI extends JFrame {

	private JPanel contentPane;
	private JButton btnSearch;
	private JButton btnShow;
	private JButton btnExit;
	public void btnShowAll_click() {
		ShowAllGUI showallgui= new ShowAllGUI();
		showallgui.show_contacts();
		showallgui.show();
	}
	
	public void btnSearch_click() {
		SearchGUI searchgui=new SearchGUI();
		searchgui.show();
	}
	
	public MainGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnSearch = new JButton("Search For Flights");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSearch_click();
			}
		});
		btnSearch.setBounds(122, 54, 172, 29);
		contentPane.add(btnSearch);
//		
//		btnSearch = new JButton("Search");
//		btnSearch.setBounds(153, 73, 117, 29);
//		contentPane.add(btnSearch);
		
		btnShow = new JButton("Show All Flights");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnShowAll_click();
			}
		});
		btnShow.setBounds(122, 101, 172, 29);
		contentPane.add(btnShow);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(122, 148, 172, 29);
		contentPane.add(btnExit);
	}
}