package demo;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.Bottone;
import gui.Finestra;
import gui.Layout;
import gui.PasswordField;
import gui.TextField;
import preferenze.PreferenzeGUI;

public class Login {

	public static void main( String[] args ) {

		PreferenzeGUI gui = new PreferenzeGUI( PreferenzeGUI.TEMA_CHIARO );
		Layout l = gui.creaWrapLayout();

		TextField userName = gui.creaTextField( 10 );
		PasswordField psw = gui.creaPasswordField( 10 );

		l.add( gui.creaGruppoLabelComponenteVerticale( new String[] { "User name:", "Password:", "Tema:" },
				new Component[] { userName, gui.creaPasswordFieldSH( psw ), gui.creaBottoneCambiaTemaChiaroScuro() } ) );

		Finestra f = gui.creaFinestra( "Login", 220, 310, l, false );
		f.setResizable( false );

		f.add( gui.creaPanelloBottoni( new Bottone[] { gui.creaBottone( "Ok", new ActionListener() {

			@Override
			public void actionPerformed( ActionEvent arg0 ) {
				f.dispose();
				System.out.println( "User name: " + userName.getText() + "\n" + "Password: " + new String( psw.getPassword() ) );
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
