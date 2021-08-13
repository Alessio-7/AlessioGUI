package preferenze;

import java.awt.Font;

public class DefaultFonts implements Fonts {

	@Override
	public Font fontGenerico( int stile ) {
		return new Font( "Microsoft New Tai Lue", stile, 13 );
	}

	@Override
	public Font fontInteragibile( int stile ) {
		return new Font( "Microsoft New Tai Lue", stile, 15 );
	}

	@Override
	public Font fontTitolo( int stile ) {
		return new Font( "Microsoft New Tai Lue", stile, 25 );
	}

	@Override
	public Font fontTitoloSecondario( int stile ) {
		return new Font( "Microsoft New Tai Lue", stile, 20 );
	}

	@Override
	public Font fontTitoloTerziario( int stile ) {
		return new Font( "Microsoft New Tai Lue", stile, 15 );
	}
}
