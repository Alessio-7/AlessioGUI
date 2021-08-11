package gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;

import preferenze.PreferenzeGUI;

public class Test extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void main( String[] args ) {
		new Test();
	}

	private Test() {
		super( "Test" );
		pack();
		setSize( 500, 500 );
		setLocationRelativeTo( null );
		setLayout( new BorderLayout() );
		setDefaultCloseOperation( DISPOSE_ON_CLOSE );

		PreferenzeGUI gui = new PreferenzeGUI( PreferenzeGUI.TEMA_SCURO );

		JPanel grid = gui.creaGridBagLayout();
		add( gui.creaScrollPane( grid ), BorderLayout.CENTER );

		for ( int i = 0; i < 100; i++ ) {
			grid.add( gui.creaBottone( "pòjkhòaskjhflòakjhdlzkjhdlaskjhdalkjhdkajhsdkajshd", null ), new GridBagConstraints( 0, i, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets( 25, 25, 25, 25 ), 0, 0 ) );
		}

		setVisible( true );
	}
}
