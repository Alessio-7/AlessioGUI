package preferenze;

import gui.Layout;

public class Test {
	public static void main( String[] args ) {
		PreferenzeGUI gui = new PreferenzeGUI( PreferenzeGUI.TEMA_CHIARO );
		Layout l = gui.creaGridBagLayout();

		l.add( gui.creaDateChooser() );

		l.add( gui.creaBottoneCambiaTemaChiaroScuro( new PreferenzeGUI( PreferenzeGUI.TEMA_CHIARO ), new PreferenzeGUI( PreferenzeGUI.TEMA_SCURO ) ) );
<<<<<<< HEAD
		gui.creaFinestra( "Ciao", 800, 800, l, true );
=======
		f.setVisible( true );

>>>>>>> branch 'main' of git@github.com:Alessio-7/AlessioGUI.git
	}
}
