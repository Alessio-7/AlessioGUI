package gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;

import preferenze.PreferenzeGUI;

public class ComboBox extends JComboBox<Object> {

	private static final long serialVersionUID = 1L;

	// TODO risolvere

	private Color sfondo;
	private Color testo;
	private Color bottone;
	private Color coloreFreccia;
	private Border bordo;

	public ComboBox( PreferenzeGUI gui, Object[] lista ) {
		this( lista, gui.colori.suSfondo(), gui.colori.testo(), gui.colori.interagibile(), gui.colori.testo(), gui.bordi.bordoInteragibile(),
			gui.bordi.bordoInteragibileFocus() );
	}

	public ComboBox( Object[] lista, Color sfondo, Color testo, Color bottone, Color coloreFreccia, Border bordo, Border bordoFocus ) {
		super( lista );
		this.sfondo = sfondo;
		this.testo = testo;
		this.bordo = bordo;
		this.bottone = bottone;
		this.coloreFreccia = coloreFreccia;
		setUI( new ComboBoxUI() );
		setForeground( testo );
		setBorder( bordo );
		// setRenderer( new MyComboBoxRenderer() );
		addMouseListener( new MouseListener() {

			@Override
			public void mouseClicked( MouseEvent arg0 ) {
			}

			@Override
			public void mouseEntered( MouseEvent e ) {
				setBorder( bordoFocus );
			}

			@Override
			public void mouseExited( MouseEvent e ) {
				setBorder( bordo );
			}

			@Override
			public void mousePressed( MouseEvent e ) {
			}

			@Override
			public void mouseReleased( MouseEvent e ) {
			}
		} );
	}

	private class ComboBoxUI extends BasicComboBoxUI {
		@Override
		protected JButton createArrowButton() {

			final JButton button = new BasicArrowButton( BasicArrowButton.SOUTH, bottone, bottone, coloreFreccia, bottone );
			button.setBorder( BorderFactory.createLineBorder( bottone ) );

			return button;
		}
	}
}
