package preferenze;

import java.awt.Color;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class DefaultBordi implements Bordi {

	Colori colori;
	int grandezzaDefault;
	Insets spazioDefault;

	public DefaultBordi( Colori colori ) {
		this( colori, 2, new Insets( 5, 5, 5, 5 ) );
	}

	public DefaultBordi( Colori colori, int grandezzaDefault, Insets spazioDefault ) {
		this.colori = colori;
		this.grandezzaDefault = grandezzaDefault;
		this.spazioDefault = spazioDefault;
	}

	public int getGrandezzaDefault() {
		return grandezzaDefault;
	}

	public Insets getSpazioDefault() {
		return spazioDefault;
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
