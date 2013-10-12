package alpro2.desenhador.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * 
 * @author marco.mangan@pucrs.br
 * 
 */
public class JDesenhadorFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final Action sairAction = new SwingAction();
	private final Action sobreAction = new SwingAction_2(this);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JDesenhadorFrame frame = new JDesenhadorFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JDesenhadorFrame() {
		setTitle("Desenhador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Arquivo");
		mnNewMenu.setMnemonic('A');
		menuBar.add(mnNewMenu);

		JMenuItem menuItem_1 = mnNewMenu.add(sairAction);

		JMenu mnNewMenu_1 = new JMenu("Ajuda");
		mnNewMenu_1.setMnemonic('j');

		menuBar.add(mnNewMenu_1);

		JMenuItem menuItem_2 = mnNewMenu_1.add(sobreAction);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	private class SwingAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public SwingAction() {
			putValue(NAME, "Sair");
			putValue(SHORT_DESCRIPTION, "Encerra a aplicação");
			putValue(MNEMONIC_KEY, KeyEvent.VK_S);
		}

		public void actionPerformed(ActionEvent e) {
			System.out.println("Sair");
			System.exit(0);
		}
	}

		private class SwingAction_2 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JFrame frame;

		public SwingAction_2(JFrame frame) {
			this.frame = frame;
			putValue(NAME, "Sobre...");
			putValue(SHORT_DESCRIPTION, "Sobre o desenhador");
			putValue(MNEMONIC_KEY, KeyEvent.VK_S);
		}

		public void actionPerformed(ActionEvent e) {
			System.out.println("Sobre");
			JOptionPane.showMessageDialog(frame,
					"v. 0.1 (c)  2013, PUCRS/FACIN.", "Sobre o desenhador",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
