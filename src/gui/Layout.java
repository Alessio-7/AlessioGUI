package gui;

import java.awt.Color;
import java.awt.LayoutManager;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import preferenze.PreferenzeGUI;

/**
 * Sottoclasse di <code>JPanel</code> instanziabile con un
 * <code>LayoutManager</code> che può impiegare la classe
 * <code>PreferenzeGUI</code>
 *
 */
public class Layout extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore che impiega la classe <code>PreferenzeGUI</code>
	 *
	 * @param gui     la classe <code>PreferenzeGUI</code> su cui si basa la GUI del
	 *                <code>Layout</code>
	 * @param manager la classe <code>LayoutManager</code> che viene aggiunta al
	 *                <code>Layout</code>
	 */
	public Layout( PreferenzeGUI gui, LayoutManager manager ) {
		this( gui, manager, false );
	}

	/**
	 * Costruttore che impiega la classe <code>PreferenzeGUI</code>
	 *
	 * @param gui         la classe <code>PreferenzeGUI</code> su cui si basa la GUI
	 *                    del <code>Layout</code>
	 * @param manager     la classe <code>LayoutManager</code> che viene aggiunta al
	 *                    <code>Layout</code>
	 * @param trasparente se lo sfondo del <code>Layout</code> deve essere
	 *                    trasparente, il colore trasparente è il seguente:
	 *                    <code>new Color( 0f, 0f, 0f, 1f )</code>
	 */
	public Layout( PreferenzeGUI gui, LayoutManager manager, boolean trasparente ) {
		super( manager );
		if ( trasparente ) {
			setBackground( new Color( 0f, 0f, 0f, 1f ) );
			setOpaque( true );
		} else {
			setBackground( gui.colori.sfondo() );
			gui.addObserver( this );
		}
	}

	@Override
	public void update( Observable arg0, Object obj ) {
		PreferenzeGUI gui = ( PreferenzeGUI ) obj;
		setBackground( gui.colori.sfondo() );
		repaint();
	}
}
