package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicScrollBarUI;

import preferenze.PreferenzeGUI;

/**
 * Sottoclasse di <code>JScrollPane</code> che pu� impiegare la classe
 * <code>PreferenzeGUI</code>
 *
 */
public class ScrollPane extends JScrollPane implements Observer {

	private static final long serialVersionUID = 1L;

	public ScrollPane( PreferenzeGUI gui, JPanel view ) {
		this( view, gui.colori.sfondo(), gui.colori.interagibile(), gui.colori.bordoGenerico(), gui.colori.bordoGenerico() );
		gui.addObserver( this );
	}

	public ScrollPane( JPanel view, Color sfondo, Color bottone, Color thumb, Color coloreFreccia ) {
		super( view );
		setBorder( BorderFactory.createEmptyBorder() );
		setBackground( sfondo );
		getHorizontalScrollBar().setUnitIncrement( 20 );
		getHorizontalScrollBar().setUI( new BasicScrollBarUI() {
			@Override
			protected void configureScrollBarColors() {
				this.thumbColor = thumb;
				this.trackColor = sfondo;
			}

			@Override
			protected JButton createDecreaseButton( int orientation ) {
				JButton button = new BasicArrowButton( orientation, sfondo, bottone, coloreFreccia, bottone );
				button.setBorder(
						BorderFactory.createCompoundBorder( BorderFactory.createLineBorder( sfondo ), BorderFactory.createEmptyBorder( 5, 15, 5, 15 ) ) );
				return button;
			}

			@Override
			protected JButton createIncreaseButton( int orientation ) {
				JButton button = new BasicArrowButton( orientation, sfondo, bottone, coloreFreccia, bottone );
				button.setBorder(
						BorderFactory.createCompoundBorder( BorderFactory.createLineBorder( sfondo ), BorderFactory.createEmptyBorder( 5, 15, 5, 15 ) ) );
				return button;
			}
		} );
		getVerticalScrollBar().setUnitIncrement( 20 );
		getVerticalScrollBar().setUI( new BasicScrollBarUI() {
			@Override
			protected void configureScrollBarColors() {
				this.thumbColor = thumb;
				this.trackColor = sfondo;
			}

			@Override
			protected JButton createDecreaseButton( int orientation ) {
				JButton button = new BasicArrowButton( orientation, sfondo, bottone, coloreFreccia, bottone );
				button.setBorder(
						BorderFactory.createCompoundBorder( BorderFactory.createLineBorder( sfondo ), BorderFactory.createEmptyBorder( 5, 15, 5, 15 ) ) );
				return button;
			}

			@Override
			protected JButton createIncreaseButton( int orientation ) {
				JButton button = new BasicArrowButton( orientation, sfondo, bottone, coloreFreccia, bottone );
				button.setBorder(
						BorderFactory.createCompoundBorder( BorderFactory.createLineBorder( sfondo ), BorderFactory.createEmptyBorder( 5, 15, 5, 15 ) ) );
				return button;
			}
		} );
	}

	@Override
	public void update( Observable arg0, Object obj ) {
		PreferenzeGUI gui = ( PreferenzeGUI ) obj;
		setBackground( gui.colori.sfondo() );
		getHorizontalScrollBar().setUnitIncrement( 20 );
		getHorizontalScrollBar().setUI( new BasicScrollBarUI() {
			@Override
			protected void configureScrollBarColors() {
				this.thumbColor = gui.colori.bordoGenerico();
				this.trackColor = gui.colori.sfondo();
			}

			@Override
			protected JButton createDecreaseButton( int orientation ) {
				JButton button = new BasicArrowButton( orientation, gui.colori.sfondo(), gui.colori.interagibile(), gui.colori.bordoGenerico(),
						gui.colori.interagibile() );
				button.setBorder( BorderFactory.createCompoundBorder( BorderFactory.createLineBorder( gui.colori.sfondo() ),
						BorderFactory.createEmptyBorder( 5, 15, 5, 15 ) ) );
				return button;
			}

			@Override
			protected JButton createIncreaseButton( int orientation ) {
				JButton button = new BasicArrowButton( orientation, gui.colori.sfondo(), gui.colori.interagibile(), gui.colori.bordoGenerico(),
						gui.colori.interagibile() );
				button.setBorder( BorderFactory.createCompoundBorder( BorderFactory.createLineBorder( gui.colori.sfondo() ),
						BorderFactory.createEmptyBorder( 5, 15, 5, 15 ) ) );
				return button;
			}
		} );
		getVerticalScrollBar().setUnitIncrement( 20 );
		getVerticalScrollBar().setUI( new BasicScrollBarUI() {
			@Override
			protected void configureScrollBarColors() {
				this.thumbColor = gui.colori.bordoGenerico();
				this.trackColor = gui.colori.sfondo();
			}

			@Override
			protected JButton createDecreaseButton( int orientation ) {
				JButton button = new BasicArrowButton( orientation, gui.colori.sfondo(), gui.colori.interagibile(), gui.colori.bordoGenerico(),
						gui.colori.interagibile() );
				button.setBorder( BorderFactory.createCompoundBorder( BorderFactory.createLineBorder( gui.colori.sfondo() ),
						BorderFactory.createEmptyBorder( 5, 15, 5, 15 ) ) );
				return button;
			}

			@Override
			protected JButton createIncreaseButton( int orientation ) {
				JButton button = new BasicArrowButton( orientation, gui.colori.sfondo(), gui.colori.interagibile(), gui.colori.bordoGenerico(),
						gui.colori.interagibile() );
				button.setBorder( BorderFactory.createCompoundBorder( BorderFactory.createLineBorder( gui.colori.sfondo() ),
						BorderFactory.createEmptyBorder( 5, 15, 5, 15 ) ) );
				return button;
			}
		} );
	}
}
