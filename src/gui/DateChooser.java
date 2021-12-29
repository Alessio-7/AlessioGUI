package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPopupMenu;

import preferenze.PreferenzeGUI;

/**
<<<<<<< HEAD
 * Classe per agevolare la scelta di una data che impiega la classe
=======
 * Classe per agevolare la scelta di una data che può impiegare la classe
>>>>>>> branch 'main' of git@github.com:Alessio-7/AlessioGUI.git
 * <code>PreferenzeGUI</code>
 *
 */
public class DateChooser extends Layout implements Observer {

	private static final long serialVersionUID = 1L;

	private PreferenzeGUI gui;

	private Calendar cal;

	private int giorno;
	private int mese;
	private int anno;

	private int giornoCorrente;
	private int meseCorrente;
	private int annoCorrente;

	private Label dataLabel;
	private Bottone scegliData;

	private JPopupMenu popup;
	private Layout calendario;
	private Label testoMese;
	private Layout meseLayout;

	private Bottone bottoneGiornoCorrente;

	/**
	 * Ritorna il giorno selezionato
	 * 
	 * @return il giorno selezionato
	 */
	public int getGiorno() {
		return giorno;
	}

	/**
	 * Ritorna il mese selezionato
	 * 
	 * @return il mese selezionato
	 */
	public int getMese() {
		return mese;
	}

	/**
	 * Ritorna l'anno selezionato
	 * 
	 * @return l'anno selezionato
	 */
	public int getAnno() {
		return anno;
	}

	/**
	 * Costruttore che impiega la classe <code>PreferenzeGUI</code>
	 * 
	 * @param gui la classe <code>PreferenzeGUI</code> su cui si basa la GUI del
	 *            <code>DateChooser</code>
	 */
	public DateChooser( PreferenzeGUI gui ) {
		super( gui, new GridBagLayout() );
		gui.addObserver( this );

		this.gui = gui;

		cal = Calendar.getInstance();

		giornoCorrente = cal.get( Calendar.DATE );
		meseCorrente = cal.get( Calendar.MONTH );
		annoCorrente = cal.get( Calendar.YEAR );

		dataLabel = gui.creaLabel( giornoCorrente + "/" + meseCorrente + "/" + annoCorrente + " " );

		cal.set( cal.get( Calendar.YEAR ), cal.get( Calendar.MONTH ), 1 );

		scegliData = gui.creaBottone( "📆", new ActionListener() {

			@Override
			public void actionPerformed( ActionEvent e ) {
				popup.show( scegliData, 0, scegliData.getHeight() + 3 );
			}
		} );
		scegliData.setName( "bottone emoji" );
		scegliData.setFont( new Font( "Segoe UI Emoji", Font.PLAIN, 11 ) );

		add( dataLabel );
		add( scegliData );

		popup = gui.creaPopupMenu();
		popup.setBorderPainted( true );
		popup.setBorder( gui.bordi.bordoInteragibile() );
		generaCalendario();
		popup.setBackground( calendario.getBackground() );

	}

	@Override
	public void update( Observable arg0, Object obj ) {
		PreferenzeGUI gui = ( PreferenzeGUI ) obj;
		setBackground( gui.colori.sfondo() );
		popup.setBackground( getBackground() );
		bottoneGiornoCorrente.setForeground( gui.colori.primario() );
		popup.setBorder( gui.bordi.bordoInteragibile() );
		repaint();
	}

	private void generaCalendario() {
		Layout lSceltaMese = gui.creaLayout( new BorderLayout() );

		String s = cal.getDisplayName( Calendar.MONTH, Calendar.LONG, Locale.getDefault() ) + " " + cal.get( Calendar.YEAR );
		s = s.substring( 0, 1 ).toUpperCase() + s.substring( 1 );
		testoMese = gui.creaLabel( s );

		Bottone indietroMese = gui.creaBottone( "<", new ActionListener() {

			@Override
			public void actionPerformed( ActionEvent e ) {
				cambiaMese( -1 );
			}

		} );
		Bottone avantiMese = gui.creaBottone( ">", new ActionListener() {

			@Override
			public void actionPerformed( ActionEvent e ) {
				cambiaMese( 1 );
			}

		} );

		lSceltaMese.add( indietroMese, BorderLayout.WEST );
		testoMese.setHorizontalAlignment( Label.CENTER );
		lSceltaMese.add( testoMese, BorderLayout.CENTER );
		lSceltaMese.add( avantiMese, BorderLayout.EAST );

		calendario = gui.creaGridBagLayout();
		calendario.add( lSceltaMese,
				new GridBagConstraints( 0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets( 0, 0, 5, 0 ), 0, 0 ) );
		meseLayout = gui.creaGridLayout( 6, 7 );
		aggiornaMese();
		calendario.add( meseLayout,
				new GridBagConstraints( 0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets( 0, 0, 0, 0 ), 0, 0 ) );
		popup.add( calendario );
	}

	private void cambiaMese( int i ) {

		cal.set( cal.get( Calendar.YEAR ), cal.get( Calendar.MONTH ) + i, 1 );
		aggiornaMese();

	}

	private void aggiornaMese() {

		String s = cal.getDisplayName( Calendar.MONTH, Calendar.LONG, Locale.getDefault() ) + " " + cal.get( Calendar.YEAR );
		s = s.substring( 0, 1 ).toUpperCase() + s.substring( 1 );

		testoMese.setText( s );

		meseLayout.removeAll();
		meseLayout.setLayout( new GridBagLayout() );

		String[] giorniNellaSettimana = { "Lun", "Mar", "Mer", "Gio", "Ven", "Sab", "Dom" };

		for ( int i = 0; i < 7; i++ ) {
			meseLayout.add( gui.creaLabel( giorniNellaSettimana[i] ),
					new GridBagConstraints( i, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets( 2, 2, 2, 2 ), 0, 0 ) );
		}

		int giorniMese = cal.getActualMaximum( Calendar.DAY_OF_MONTH );
		int giorniPrimaLunedi;

		if ( cal.get( Calendar.DAY_OF_WEEK ) == 1 ) {
			giorniPrimaLunedi = 6;
		} else {
			giorniPrimaLunedi = cal.get( Calendar.DAY_OF_WEEK ) - 2;
		}

		for ( int i = giorniPrimaLunedi, r = 0, c = 0; i < giorniMese + giorniPrimaLunedi; i++ ) {

			if ( i % 7 == 0 && i != 0 ) {
				r++ ;
			}
			c = i - ( r * 7 );
			int numeroGiorno = i + 1 - giorniPrimaLunedi;

			boolean giornataCorrente = numeroGiorno == giornoCorrente && cal.get( Calendar.MONTH ) == meseCorrente
					&& cal.get( Calendar.YEAR ) == annoCorrente;

			BottoneCalendario bottoneCalendario = new BottoneCalendario( numeroGiorno, cal.get( Calendar.MONTH ), cal.get( Calendar.YEAR ),
					giornataCorrente );

			meseLayout.add( bottoneCalendario, new GridBagConstraints( c, r + 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets( 1, 1, 1, 1 ), 0, 0 ) );

		}
		if ( popup.isShowing() ) {
			popup.setVisible( false );
			popup.validate();
			popup.show( scegliData, 0, scegliData.getHeight() + 3 );

			meseLayout.repaint();
		}

	}

	private class BottoneCalendario extends Bottone {

		public BottoneCalendario( int g, int m, int a, boolean giornataCorrente ) {
			super( gui, g + "", new ActionListener() {

				@Override
				public void actionPerformed( ActionEvent e ) {
					giorno = g;
					mese = m + 1;
					anno = a;
					dataLabel.setText( giorno + "/" + mese + "/" + anno + " " );
					( ( Bottone ) e.getSource() ).setBorder( gui.bordi.bordoInteragibile() );
					popup.setVisible( false );
				}

			} );

			if ( giornataCorrente ) {
				bottoneGiornoCorrente = this;
				this.setForeground( gui.colori.primario() );
			}
		}

	}

}
