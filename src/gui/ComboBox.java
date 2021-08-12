package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
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
		this( lista, gui.colori.suSfondo(), gui.colori.testo(), gui.colori.interagibile(), gui.colori.primario(), gui.bordi.bordoInteragibile(),
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
		setRenderer( new Renderer() );
		setBorder( bordo );
		setFocusable( false );
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

	/*
	 * @Override public void paint( Graphics g ) { super.paint( g ); g.setColor(
	 * sfondo ); g.fillRect( 0, 0, getWidth() - getComponent( 0 ).getWidth(),
	 * getHeight() ); this.getBorder().paintBorder( this, g, 0, 0, WIDTH, HEIGHT );
	 * }
	 */

	private class Renderer extends DefaultListCellRenderer {
		private static final long serialVersionUID = 1L;

		@Override
		public Component getListCellRendererComponent( JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus ) {
			setOpaque( true );
			setText( value.toString() );
			setForeground( testo );
			setBackground( sfondo );
			setBorder( bordo );
			return this;
		}
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
