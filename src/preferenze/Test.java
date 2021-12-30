package preferenze;

import java.awt.Component;

import gui.Layout;

public class Test {
	public static void main( String[] args ) {
		PreferenzeGUI gui = new PreferenzeGUI( PreferenzeGUI.TEMA_CHIARO );
		Layout l = gui.creaWrapLayout();

		// l.add( gui.creaDateChooser() );
		// l.add( gui.creaLabelComponenteVerticale( "password :", gui.creaBottone(

		l.add( gui.creaGruppoLabelComponente( new String[] { "SCB<,jkvbkvdsb", "ciao", "data" },
				new Component[] { gui.creaTextField( 10 ), gui.creaBottone( "coias<hdj", null ), gui.creaDateChooser() } ) );
		gui.creaFinestra( "Ciao", 800, 800, l, true );
	}
}
