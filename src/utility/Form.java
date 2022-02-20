package utility;

import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;

import gui.CheckBox;
import gui.DateChooser;
import gui.Layout;
import gui.PasswordField;
import gui.RadioButton;
import gui.TextArea;
import gui.TextField;
import preferenze.PreferenzeGUI;

public class Form {

	private PreferenzeGUI gui;
	private HashMap<String, Component> parametri;
	private ArrayList<String> ordineParametri;

	public Form( PreferenzeGUI gui ) {
		this.gui = gui;
		parametri = new HashMap<String, Component>();
		ordineParametri = new ArrayList<String>();
	}

	public Form( PreferenzeGUI gui, HashMap<String, Component> parametri ) {
		this.gui = gui;
		this.parametri = parametri;
		ordineParametri = new ArrayList<String>();
	}

	public Form( PreferenzeGUI gui, String[] parametri, Component[] campiParametri ) {
		this.gui = gui;
		this.parametri = new HashMap<String, Component>();
		ordineParametri = new ArrayList<String>();
		for ( int i = 0; i < parametri.length; i++ ) {
			this.parametri.put( parametri[i], campiParametri[i] );
		}
	}

	public void aggiungiParametro( String parametro, Component campoParametro ) {
		ordineParametri.add( parametro );
		parametri.put( parametro, campoParametro );
	}

	public String getParametroTesto( String parametro ) {
		Component campoParametro = parametri.get( parametro );

		if ( campoParametro instanceof TextField ) {
			return ( ( TextField ) campoParametro ).getText();
		} else if ( campoParametro instanceof TextArea ) {
			return ( ( TextArea ) campoParametro ).getText();
		} else if ( campoParametro instanceof PasswordField ) {
			return ( ( PasswordField ) campoParametro ).getPassword().toString();
		} else if ( campoParametro instanceof DateChooser ) {
			return ( ( DateChooser ) campoParametro ).getGiorno() + "/" + ( ( DateChooser ) campoParametro ).getMese() + "/"
					+ ( ( DateChooser ) campoParametro ).getAnno();
		}

		return "";
	}

	public boolean getParametroBooleano( String parametro ) {
		Component campoParametro = parametri.get( parametro );

		if ( campoParametro instanceof CheckBox ) {
			return ( ( CheckBox ) campoParametro ).isSelected();
		} else if ( campoParametro instanceof RadioButton ) {
			return ( ( RadioButton ) campoParametro ).isSelected();
		}

		return false;
	}

	public Component getCampoParametro( String parametro ) {
		return parametri.get( parametro );
	}

	public Layout getFormOrizzontale() {

		String[] labels = ordineParametri.toArray( new String[ordineParametri.size()] );
		Component[] campiParametri = new Component[ordineParametri.size()];

		for ( int i = 0; i < labels.length; i++ ) {
			if ( parametri.get( labels[i] ) instanceof PasswordField ) {
				campiParametri[i] = gui.creaPasswordFieldSH( ( PasswordField ) parametri.get( labels[i] ) );
			} else {
				campiParametri[i] = parametri.get( labels[i] );
			}
		}

		return gui.creaGruppoLabelComponenteOrizzontale( labels, campiParametri );
	}

	public Layout getFormVerticale() {
		String[] labels = ordineParametri.toArray( new String[ordineParametri.size()] );
		Component[] campiParametri = new Component[ordineParametri.size()];

		for ( int i = 0; i < labels.length; i++ ) {
			if ( parametri.get( labels[i] ) instanceof PasswordField ) {
				campiParametri[i] = gui.creaPasswordFieldSH( ( PasswordField ) parametri.get( labels[i] ) );
			} else {
				campiParametri[i] = parametri.get( labels[i] );
			}
		}

		return gui.creaGruppoLabelComponenteVerticale( labels, campiParametri );
	}

}
