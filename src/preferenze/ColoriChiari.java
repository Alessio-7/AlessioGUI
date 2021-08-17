package preferenze;

import java.awt.Color;

public class ColoriChiari implements Colori {

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
		return new Color( 247, 99, 12 );
	}

	@Override
	public Color secondario() {
		return new Color( 195, 1, 1 );
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

}
