package alpro2.desenhador.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
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
	private final Action sairAction = new SairSwingAction();
	private final Action sobreAction = new SobreSwingAction(this);
	private final Action quadradoAction = new CriarQuadradoSwingAction(this);
	private final Action circuloAction = new CriarCirculoSwingAction(this);

	
	
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

		setIconImage(Toolkit.getDefaultToolkit().getImage(
				JDesenhadorFrame.class
						.getResource("/alpro2/desenhador/gui/left.gif")));

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("Arquivo");
		mnFile.setMnemonic('A');
		menuBar.add(mnFile);

		mnFile.add(sairAction);
		
		JMenu mnShapes = new JMenu("Figuras");
		mnShapes.setMnemonic('F');
		menuBar.add(mnShapes);

		mnShapes.add(quadradoAction);
		mnShapes.add(circuloAction);

		JMenu mnHelp = new JMenu("Ajuda");
		mnHelp.setMnemonic('j');

		menuBar.add(mnHelp);

		mnHelp.add(sobreAction);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	private class SairSwingAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public SairSwingAction() {
			putValue(NAME, "Sair");
			putValue(SHORT_DESCRIPTION, "Encerra a aplicação");
			putValue(MNEMONIC_KEY, KeyEvent.VK_S);
			putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_X,
					ActionEvent.CTRL_MASK));
		}

		public void actionPerformed(ActionEvent e) {
			System.out.println("Sair");
			System.exit(0);
		}
	}

	private class SobreSwingAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JFrame frame;

		public SobreSwingAction(JFrame frame) {
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
	
	
	private class CriarQuadradoSwingAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JFrame frame;

		public CriarQuadradoSwingAction(JFrame frame) {
			this.frame = frame;
			putValue(NAME, "Criar quadrado...");
			putValue(SHORT_DESCRIPTION, "Criar quadrado");
			putValue(MNEMONIC_KEY, KeyEvent.VK_Q);
		}

		public void actionPerformed(ActionEvent e) {
			System.out.println("Criar quadrado");
		}
	}	
	
	private class CriarCirculoSwingAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JFrame frame;

		public CriarCirculoSwingAction(JFrame frame) {
			this.frame = frame;
			putValue(NAME, "Criar círculo...");
			putValue(SHORT_DESCRIPTION, "Criar círculo");
			putValue(MNEMONIC_KEY, KeyEvent.VK_C);
		}

		public void actionPerformed(ActionEvent e) {
			System.out.println("Criar quadrado");
		}
	}	
}
