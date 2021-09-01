package gui;

import java.awt.Color;
import java.awt.LayoutManager;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import preferenze.PreferenzeGUI;

public class Layout extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;

	public Layout( PreferenzeGUI gui, LayoutManager manager ) {
		this( gui, manager, false );
	}

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
