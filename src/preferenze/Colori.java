package preferenze;

import java.awt.Color;

/**
 * Interfaccia per generare i colori dei componenti della GUI
 */
public interface Colori {
	/**
	 * Ritorna il colore dello sfondo
	 *
	 * @return colore dello sfondo
	 */
	public Color sfondo();

	/**
	 * Ritorna il colore per i componenti presenti sullo sfondo
	 *
	 * @return il colore per i componenti presenti sullo sfondo
	 */
	public Color suSfondo();

	/**
	 * Ritorna il colore dei componenti interagibili
	 *
	 * @return il colore dei componenti interagibili
	 */
	public Color interagibile();

	/**
	 * Ritorna il colore del testo
	 *
	 * @return il colore del testo
	 */
	public Color testo();

	/**
	 * Ritorna il colore primario
	 *
	 * @return il colore primario
	 */
	public Color primario();

	/**
	 * Ritorna il colore secondario
	 *
	 * @return il colore secondario
	 */
	public Color secondario();

	/**
	 * Ritorna il colore per il bordo generico
	 *
	 * @return il colore per il bordo generico
	 */
	public Color bordoGenerico();

	/**
	 * Ritorna il colore per il bordo per i componenti interagibili
	 *
	 * @return il colore per il bordo per i componenti interagibili
	 */
	public Color bordoInteragibile();

	/**
	 * Ritorna il colore per il bordo secondario
	 *
	 * @return il colore per il bordo secondario
	 */
	public Color bordoSecondario();

	/**
	 * Ritorna il colore per i componenti presenti in un <i>sub menu</i>
	 *
	 * @return colore per i componenti presenti in un <i>sub menu</i>
	 */
	public Color subMenu();
}
