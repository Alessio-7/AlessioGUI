package preferenze;

import java.awt.Color;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 * Classe che implementa l'interfaccia <code>Bordi</code>
 */
public class DefaultBordi implements Bordi {

	private Colori colori;
	private int grandezzaDefault;
	private Insets spazioDefault;

	/**
	 * Costruttore con la classe personalizzata per i colori dei bordi
	 *
	 * @param colori la classe personalizzata che implementa l'interfaccia
	 *               <code>Colori</code>
	 */
	public DefaultBordi( Colori colori ) {
		this( colori, 2, new Insets( 5, 5, 5, 5 ) );
	}

	/**
	 * Costruttore con valori personalizzati
	 *
	 * @param colori           la classe personalizzata che implementa l'interfaccia
	 *                         <code>Colori</code>
	 * @param grandezzaDefault la grandezza default dei bordi
	 * @param spazioDefault    lo spazio default dei bordi
	 */
	public DefaultBordi( Colori colori, int grandezzaDefault, Insets spazioDefault ) {
		this.colori = colori;
		this.grandezzaDefault = grandezzaDefault;
		this.spazioDefault = spazioDefault;
	}

	/**
	 * Ritorna la grandezza default
	 *
	 * @return la grandezza default
	 */
	public int getGrandezzaDefault() {
		return grandezzaDefault;
	}

	/**
	 * Ritorna lo spazio default
	 *
	 * @return lo spazio default
	 */
	public Insets getSpazioDefault() {
		return spazioDefault;
	}

	@Override
	public Border bordoVuotoGenerico() {
		return BorderFactory.createEmptyBorder( spazioDefault.top, spazioDefault.left, spazioDefault.bottom, spazioDefault.right );
	}

	@Override
	public Border bordoGenerico() {
		return bordoGenerico( grandezzaDefault, spazioDefault );
	}

	@Override
	public Border bordoGenericoFocus() {
		return bordoGenericoFocus( grandezzaDefault, spazioDefault, colori.primario() );
	}

	@Override
	public Border bordoInteragibile() {
		return bordoInteragibile( grandezzaDefault, spazioDefault );
	}

	@Override
	public Border bordoInteragibileFocus() {
		return bordoInteragibileFocus( grandezzaDefault, spazioDefault, colori.primario() );
	}

	@Override
	public Border bordoSecondario() {
		return bordoSecondario( grandezzaDefault, spazioDefault );
	}

	@Override
	public Border bordoSecondarioFocus() {
		return bordoSecondarioFocus( grandezzaDefault, spazioDefault, colori.primario() );
	}

	@Override
	public Border bordoMenuBar() {
		return BorderFactory.createCompoundBorder( BorderFactory.createMatteBorder( 0, 0, 1, 0, colori.bordoSecondario() ),
				BorderFactory.createEmptyBorder( 2, 0, 0, 0 ) );
	}

	@Override
	public Border bordoGenerico( int grandezza, Insets spazio ) {
		return bordoGenericoFocus( grandezza, spazio, colori.bordoGenerico() );
	}

	@Override
	public Border bordoGenericoFocus( int grandezza, Insets spazio, Color colore ) {
		return BorderFactory.createCompoundBorder( BorderFactory.createLineBorder( colore, grandezza ),
				BorderFactory.createEmptyBorder( spazio.top, spazio.left, spazio.bottom, spazio.right ) );
	}

	@Override
	public Border bordoInteragibile( int grandezza, Insets spazio ) {
		return bordoGenericoFocus( grandezza, spazio, colori.bordoInteragibile() );
	}

	@Override
	public Border bordoInteragibileFocus( int grandezza, Insets spazio, Color colore ) {
		return bordoGenericoFocus( grandezza, spazio, colore );
	}

	@Override
	public Border bordoSecondario( int grandezza, Insets spazio ) {
		return bordoGenericoFocus( grandezza, spazio, colori.bordoSecondario() );
	}

	@Override
	public Border bordoSecondarioFocus( int grandezza, Insets spazio, Color colore ) {
		return bordoGenericoFocus( grandezza, spazio, colore );
	}
}
