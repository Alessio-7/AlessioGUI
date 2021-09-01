package preferenze;

import java.awt.Color;

public class ColoriScuri implements Colori {

	Color colorePrimario;
	Color coloreSecondario;

	public ColoriScuri() {
		this.colorePrimario = new Color( 247, 99, 12 );
		this.coloreSecondario = new Color( 195, 1, 1 );
	}

	public ColoriScuri( Color colorePrimario, Color coloreSecondario ) {
		this.colorePrimario = colorePrimario;
		this.coloreSecondario = coloreSecondario;
	}

	@Override
	public Color sfondo() {
		return new Color( 18, 18, 18 );
	}

	@Override
	public Color suSfondo() {
		return new Color( 15, 15, 15 );
	}

	@Override
	public Color interagibile() {
		return new Color( 12, 12, 12 );
	}

	@Override
	public Color testo() {
		return Color.white;
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
		return Color.DARK_GRAY;
	}

	@Override
	public Color bordoInteragibile() {
		return Color.DARK_GRAY;
	}

	@Override
	public Color bordoSecondario() {
		return Color.DARK_GRAY;
	}

	@Override
	public Color subMenu() {
		return bordoSecondario();
	}
}
