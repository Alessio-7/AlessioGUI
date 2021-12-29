package preferenze;

import gui.Layout;

public class Test {
	public static void main( String[] args ) {
		PreferenzeGUI gui = new PreferenzeGUI( PreferenzeGUI.TEMA_CHIARO );
		Layout l = gui.creaGridBagLayout();

		l.add( gui.creaDateChooser() );
		l.add( gui.creaPasswordFieldSH() );
		gui.creaFinestra( "Ciao", 800, 800, l, true );
	}
}
