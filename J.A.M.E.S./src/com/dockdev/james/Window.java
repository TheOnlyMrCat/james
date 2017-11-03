package com.dockdev.james;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class Window extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private static BufferedImage mic() {
		try {
			BufferedImage mic = ImageIO.read(James.class.getResourceAsStream("assets/microphone.png"));
			return  mic;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	MigLayout layout = new MigLayout();
	public JTextField speech = new JTextField("Talk to me!");
	protected JButton confirm = new JButton("Ask");
	protected JButton microphone = new JButton(new ImageIcon(mic()));
	
	public JButton disable = new JButton("Exit James");
	
	public Window(String title, Dimension size) {
		super(title);
		
		setPreferredSize(size);
		setLayout(layout);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				
			}
		});
		
		disable.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				James.james.engine.buttonPush("exit");
			}
		});
		
		add(speech, "span 3");
		add(confirm, "span 2");
		add(microphone, "wrap");
		add(disable, "span 6");
	}
}
