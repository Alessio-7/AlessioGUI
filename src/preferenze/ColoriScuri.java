package preferenze;

import java.awt.Color;

public class ColoriScuri implements Colori {
	@Override
	public Color sfondo() {
		return new Color( 18, 18, 18 );
	}

	@Override
	public Color suSfondo() {
		return new Color( 18, 18, 18 );
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
		return new Color( 247, 99, 12 );
	}

	@Override
	public Color secondario() {
		return new Color( 195, 1, 1 );
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
}
