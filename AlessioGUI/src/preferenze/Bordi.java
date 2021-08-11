package preferenze;

import java.awt.Color;
import java.awt.Insets;

import javax.swing.border.Border;

public interface Bordi {

	public Border bordoGenerico();

	public Border bordoGenericoFocus();

	public Border bordoInteragibile();

	public Border bordoInteragibileFocus();

	public Border bordoSecondario();

	public Border bordoSecondarioFocus();

	public Border bordoGenerico( int grandezza, Insets spazio );

	public Border bordoGenericoFocus( int grandezza, Insets spazio, Color colore );

	public Border bordoInteragibile( int grandezza, Insets spazio );

	public Border bordoInteragibileFocus( int grandezza, Insets spazio, Color colore );

	public Border bordoSecondario( int grandezza, Insets spazio );

	public Border bordoSecondarioFocus( int grandezza, Insets spazio, Color colore );

}
