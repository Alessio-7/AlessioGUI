package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;

import preferenze.Bordi;
import preferenze.Colori;
import preferenze.Fonts;
import preferenze.PreferenzeGUI;

public class ComboBox extends JComboBox<Object> {

	private static final long serialVersionUID = 1L;

	private Color coloreBottone;
	private Color coloreFreccia;

	public ComboBox( PreferenzeGUI gui, Object[] lista ) {

		this( gui.colori, gui.fonts, gui.bordi, lista );
	}

	public ComboBox( Colori colori, Fonts fonts, Bordi bordi, Object[] lista ) {
		this( colori.suSfondo(), colori.testo(), colori.primario(), fonts.fontGenerico( Fonts.PLAIN ), bordi.bordoInteragibile(),
			bordi.bordoGenericoFocus(), lista );
	}

	public ComboBox( Color coloreSfondo, Color coloreTesto, Color coloreSelezione, Font font, Border bordo, Border bordoFocus, Object[] lista ) {
		super( lista );
		this.coloreBottone = coloreSfondo;
		this.coloreFreccia = coloreTesto;
		setUI( new ComboBoxUI() );
		Object child = this.getAccessibleContext().getAccessibleChild( 0 );
		BasicComboPopup popup = (BasicComboPopup) child;
		JList<?> list = popup.getList();
		list.setBackground( coloreSfondo );
		list.setSelectionBackground( coloreSfondo );
		list.setForeground( coloreTesto );
		list.setSelectionForeground( coloreSelezione );
		setBackground( coloreSfondo );
		setForeground( coloreTesto );
		setBorder( bordo );
		setFont( font );
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

	private class ComboBoxUI extends BasicComboBoxUI {

		@Override
		protected JButton createArrowButton() {
			final JButton button = new BasicArrowButton( BasicArrowButton.SOUTH, coloreBottone, coloreBottone, coloreFreccia, coloreBottone );
			button.setName( "ComboBox.arrowButton" );
			button.setBorder( BorderFactory.createLineBorder( coloreBottone ) );
			return button;
		}
	}
}
