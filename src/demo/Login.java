package demo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.Bottone;
import gui.Finestra;
import gui.Layout;
import preferenze.PreferenzeGUI;
import utility.Form;

public class Login {

	public static void main( String[] args ) {

		PreferenzeGUI gui = new PreferenzeGUI( PreferenzeGUI.TEMA_CHIARO );
		Form form = gui.creaForm();
		form.aggiungiParametro( "User name:", gui.creaTextField( 10 ) );
		form.aggiungiParametro( "Password:", gui.creaPasswordField( 10 ) );
		form.aggiungiParametro( "Data di nascita:", gui.creaDateChooser() );
		form.aggiungiParametro( "", gui.creaRadioButton( gui.creaLabel( "Mantieni accesso" ), false ) );
		form.aggiungiParametro( "Tema:", gui.creaBottoneCambiaTemaChiaroScuro() );

		Layout l = gui.creaWrapLayout();
		l.add( form.getFormOrizzontale() );
		Finestra f = gui.creaFinestra( "Login", 300, 310, l, false );
		f.setResizable( false );

		f.add( gui.creaPanelloBottoni( new Bottone[] { gui.creaBottone( "Ok", new ActionListener() {

			@Override
			public void actionPerformed( ActionEvent arg0 ) {
				f.dispose();
				System.out.println( "User name: " + form.getParametroTesto( "User name:" ) );
				System.out.println( "Password: " + form.getParametroTesto( "Password:" ) );
				System.out.println( "Data di nascita: " + form.getParametroTesto( "Data di nascita:" ) );
				System.out.println( "Mantieni accesso: " + form.getParametroBooleano( "Mantieni accesso:" ) );
			}

		} ), gui.creaBottone( "Cancella", new ActionListener() {

			@Override
			public void actionPerformed( ActionEvent arg0 ) {
				f.dispose();
				System.out.println( "Operazione annullata" );
			}

		} ) } ), BorderLayout.SOUTH );
		f.setVisible( true );
	}
}
