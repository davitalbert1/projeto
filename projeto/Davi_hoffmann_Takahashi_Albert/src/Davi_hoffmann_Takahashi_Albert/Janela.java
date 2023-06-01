package Davi_hoffmann_Takahashi_Albert;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Janela extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela frame = new Janela();
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
	public Janela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 403);
		
		JMenuBar menuBar_1 = new JMenuBar();
		setJMenuBar(menuBar_1);
		
		JMenu mnNewMenu = new JMenu("New menu");
		menuBar_1.add(mnNewMenu);
		
		JMenuItem aluno = new JMenuItem("aluno");
		mnNewMenu.add(aluno);
		
		JMenuItem pessoa = new JMenuItem("pessoa");
		mnNewMenu.add(pessoa);
		
		JMenuItem professor = new JMenuItem("professor");
		mnNewMenu.add(professor);
		
		JMenuItem sala = new JMenuItem("sala");
		mnNewMenu.add(sala);
		
		JMenuItem disciplina = new JMenuItem("disciplina");
		mnNewMenu.add(disciplina);
		
		JMenuItem curso = new JMenuItem("curso");
		mnNewMenu.add(curso);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}

}
