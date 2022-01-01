package preferenze;

import java.awt.Font;

/**
 * Interfaccia per generare i font dei componenti della GUI
 */
public interface Fonts {

	/**
	 * font normale
	 */
	public static int PLAIN = Font.PLAIN;
	/**
	 * font corsivo
	 */
	public static int ITALIC = Font.ITALIC;
	/**
	 * font in grassetto
	 */
	public static int BOLD = Font.BOLD;

	/**
	 * Ritorna il font per uso generico
	 *
	 * @param stile stile del font
	 * @return il font per uso generico
	 */
	public Font fontGenerico( int stile );

	/**
	 * Ritorna il font per i componenti interagibili
	 *
	 * @param stile stile del font
	 * @return il font per i componenti interagibili
	 */
	public Font fontInteragibile( int stile );

	/**
	 * Ritorna il font per un titolo
	 *
	 * @param stile stile del font
	 * @return il font per un titolo
	 */
	public Font fontTitolo( int stile );

	/**
	 * Ritorna il font per un titolo secondario
	 *
	 * @param stile stile del font
	 * @return il font per un titolo secondario
	 */
	public Font fontTitoloSecondario( int stile );

	/**
	 * Ritorna il font per un titolo terziario
	 *
	 * @param stile stile del font
	 * @return il font per un titolo terziario
	 */
	public Font fontTitoloTerziario( int stile );

}
