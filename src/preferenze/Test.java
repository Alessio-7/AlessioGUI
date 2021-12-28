package preferenze;

import gui.Finestra;
import gui.Layout;

public class Test {
	public static void main( String[] args ) {
		PreferenzeGUI gui = new PreferenzeGUI( PreferenzeGUI.TEMA_CHIARO );

		Layout l = gui.creaGridBagLayout();

		Finestra f = gui.creaFinestra( "Ciao", 800, 800, l, false );
		l.add( gui.creaDateChooser() );
		f.setVisible( true );
	}
}
