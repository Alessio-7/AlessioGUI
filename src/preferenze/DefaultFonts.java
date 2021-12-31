package preferenze;

import java.awt.Font;

/**
 * Classe che implementa l'interfaccia <code>Fonts</code> che utilizza il font
 * <b>Segoe UI</b>
 */
public class DefaultFonts implements Fonts {

	@Override
	public Font fontGenerico( int stile ) {
		return new Font( "Segoe UI", stile, 11 );
	}

	@Override
	public Font fontInteragibile( int stile ) {
		return new Font( "Segoe UI", stile, 13 );
	}

	@Override
	public Font fontTitolo( int stile ) {
		return new Font( "Segoe UI", stile, 23 );
	}

	@Override
	public Font fontTitoloSecondario( int stile ) {
		return new Font( "Segoe UI", stile, 18 );
	}

	@Override
	public Font fontTitoloTerziario( int stile ) {
		return new Font( "Segoe UI", stile, 13 );
	}
}
