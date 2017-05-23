
package othello.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class GUIConsole extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel consolePanel;
	private JTextArea textArea;
	private JScrollPane scrollPane;

	public GUIConsole() {
		initUI();
	}

	private void initUI() {
		consolePanel = new JPanel();
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		scrollPane = new JScrollPane(textArea);

		consolePanel.setLayout(new BorderLayout());
		consolePanel.add(scrollPane);
		
		add(consolePanel, BorderLayout.CENTER);
		setTitle("Othello - Console");
		setSize(300, 300);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void append(String message) {
		textArea.append(message + ", ");
	}

	public void addLine(String message) {
		textArea.append("\n" + message);
	}
}
