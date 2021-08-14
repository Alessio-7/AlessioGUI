package preferenze;

import java.awt.Font;

public class DefaultFonts implements Fonts {

	@Override
	public Font fontGenerico( int stile ) {
		return new Font( "Microsoft New Tai Lue", stile, 11 );
	}

	@Override
	public Font fontInteragibile( int stile ) {
		return new Font( "Microsoft New Tai Lue", stile, 13 );
	}

	@Override
	public Font fontTitolo( int stile ) {
		return new Font( "Microsoft New Tai Lue", stile, 23 );
	}

	@Override
	public Font fontTitoloSecondario( int stile ) {
		return new Font( "Microsoft New Tai Lue", stile, 18 );
	}

	@Override
	public Font fontTitoloTerziario( int stile ) {
		return new Font( "Microsoft New Tai Lue", stile, 13 );
	}
}
