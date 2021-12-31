package preferenze;

import java.awt.Color;

/**
 * Classe che implementa l'interfaccia <code>Colori</code> che ritorna colori
 * per generare una GUI con il tema chiaro
 */
public class ColoriChiari implements Colori {

	private Color colorePrimario;
	private Color coloreSecondario;

	/**
	 * Costruttore che imposta il colore primario come l'arancione
	 * <code>Color( 247, 99, 12 )</code> e il secondario come il rosso
	 * <code>Color( 195, 1, 1 )</code>
	 */
	public ColoriChiari() {
		this.colorePrimario = new Color( 247, 99, 12 );
		this.coloreSecondario = new Color( 195, 1, 1 );
	}

	/**
	 * Costruttore con colore primario e colore secondario personalizzabili
	 *
	 * @param colorePrimario   il colore primario
	 * @param coloreSecondario il colore primario
	 */
	public ColoriChiari( Color colorePrimario, Color coloreSecondario ) {
		this.colorePrimario = colorePrimario;
		this.coloreSecondario = coloreSecondario;
	}

	@Override
	public Color sfondo() {
		return Color.white;
	}

	@Override
	public Color suSfondo() {
		return new Color( 240, 240, 240 );
	}

	@Override
	public Color interagibile() {
		return new Color( 219, 219, 219 );
	}

	@Override
	public Color testo() {
		return Color.black;
	}

	@Override
	public Color primario() {
		return colorePrimario;
	}

	@Override
	public Color secondario() {
		return coloreSecondario;
	}

	@Override
	public Color bordoGenerico() {
		return new Color( 128, 128, 128 );
	}

	@Override
	public Color bordoInteragibile() {
		return new Color( 182, 182, 182 );
	}

	@Override
	public Color bordoSecondario() {
		return new Color( 229, 229, 229 );
	}

	@Override
	public Color subMenu() {
		return bordoSecondario();
	}

}
