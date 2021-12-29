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
 * Sottoclasse di <code>JScrollPane</code> che può impiegare la classe
 * <code>PreferenzeGUI</code>
 *
 */
public class ScrollPane extends JScrollPane implements Observer {

	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore che impiega la classe <code>PreferenzeGUI</code>
	 * 
	 * @param gui  la classe <code>PreferenzeGUI</code> su cui si basa la GUI dello
	 *             <code>ScrollPane</code>
	 * @param view componente da mostrare nello <code>ScrollPane</code>
	 */
	public ScrollPane( PreferenzeGUI gui, JPanel view ) {
		this( view, gui.colori.sfondo(), gui.colori.interagibile(), gui.colori.bordoGenerico(), gui.colori.bordoGenerico() );
		gui.addObserver( this );
	}

	/**
	 * Costruttore con parametri specifici
	 * 
	 * @param view          componente da mostrare nello <code>ScrollPane</code>
	 * @param sfondo        colore sfondo dello <code>ScrollPane</code>
	 * @param bottone       colore dei bottoni delle <code>JScrollBar</code> dello
	 *                      <code>ScrollPane</code>
	 * @param thumb         colore del thumb delle <code>JScrollBar</code> dello
	 *                      <code>ScrollPane</code>
	 * @param coloreFreccia colore freccia dei bottoni
	 */
	public ScrollPane( JPanel view, Color coloreSfondo, Color coloreBottone, Color coloreThumb, Color coloreFreccia ) {
		super( view );
		setBorder( BorderFactory.createEmptyBorder() );
		setBackground( coloreSfondo );
		getHorizontalScrollBar().setUnitIncrement( 20 );
		getHorizontalScrollBar().setUI( new BasicScrollBarUI() {
			@Override
			protected void configureScrollBarColors() {
				this.thumbColor = coloreThumb;
				this.trackColor = coloreSfondo;
			}

			@Override
			protected JButton createDecreaseButton( int orientation ) {
				JButton button = new BasicArrowButton( orientation, coloreSfondo, coloreBottone, coloreFreccia, coloreBottone );
				button.setBorder( BorderFactory.createCompoundBorder( BorderFactory.createLineBorder( coloreSfondo ),
						BorderFactory.createEmptyBorder( 5, 15, 5, 15 ) ) );
				return button;
			}

			@Override
			protected JButton createIncreaseButton( int orientation ) {
				JButton button = new BasicArrowButton( orientation, coloreSfondo, coloreBottone, coloreFreccia, coloreBottone );
				button.setBorder( BorderFactory.createCompoundBorder( BorderFactory.createLineBorder( coloreSfondo ),
						BorderFactory.createEmptyBorder( 5, 15, 5, 15 ) ) );
				return button;
			}
		} );
		getVerticalScrollBar().setUnitIncrement( 20 );
		getVerticalScrollBar().setUI( new BasicScrollBarUI() {
			@Override
			protected void configureScrollBarColors() {
				this.thumbColor = coloreThumb;
				this.trackColor = coloreSfondo;
			}

			@Override
			protected JButton createDecreaseButton( int orientation ) {
				JButton button = new BasicArrowButton( orientation, coloreSfondo, coloreBottone, coloreFreccia, coloreBottone );
				button.setBorder( BorderFactory.createCompoundBorder( BorderFactory.createLineBorder( coloreSfondo ),
						BorderFactory.createEmptyBorder( 5, 15, 5, 15 ) ) );
				return button;
			}

			@Override
			protected JButton createIncreaseButton( int orientation ) {
				JButton button = new BasicArrowButton( orientation, coloreSfondo, coloreBottone, coloreFreccia, coloreBottone );
				button.setBorder( BorderFactory.createCompoundBorder( BorderFactory.createLineBorder( coloreSfondo ),
						BorderFactory.createEmptyBorder( 5, 15, 5, 15 ) ) );
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
