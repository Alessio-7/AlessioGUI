package preferenze;

import java.awt.Font;

public interface Fonts {

	public static int PLAIN = Font.PLAIN;
	public static int ITALIC = Font.ITALIC;
	public static int BOLD = Font.BOLD;

	public Font fontGenerico( int stile );

	public Font fontInteragibile( int stile );

	public Font fontTitolo( int stile );

	public Font fontTitoloSecondario( int stile );

	public Font fontTitoloTerziario( int stile );

}
