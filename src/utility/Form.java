package utility;

import java.awt.Component;
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

	public Form(PreferenzeGUI gui) {
		this.gui = gui;
		parametri = new HashMap<String, Component>();
	}

	public Form(PreferenzeGUI gui, HashMap<String, Component> parametri) {
		this.gui = gui;
		this.parametri = parametri;
	}

	public Form(PreferenzeGUI gui, String[] parametri, Component[] campiParametri) {
		this.gui = gui;
		this.parametri = new HashMap<String, Component>();
		for (int i = 0; i < parametri.length; i++) {
			this.parametri.put(parametri[i], campiParametri[i]);
		}
	}

	public void aggiungiParametro(String parametro, Component campoParametro) {
		parametri.put(parametro, campoParametro);
	}

	public String getParametroTesto(String parametro) {
		Component campoParametro = parametri.get(parametro);

		if (campoParametro instanceof TextField) {
			return ((TextField) campoParametro).getText();
		} else if (campoParametro instanceof TextArea) {
			return ((TextArea) campoParametro).getText();
		} else if (campoParametro instanceof PasswordField) {
			return ((PasswordField) campoParametro).getPassword().toString();
		} else if (campoParametro instanceof DateChooser) {
			return ((DateChooser) campoParametro).getGiorno() + "\\" + ((DateChooser) campoParametro).getMese() + "\\"
					+ ((DateChooser) campoParametro).getAnno();
		}

		return "";
	}

	public boolean getParametroBooleano(String parametro) {
		Component campoParametro = parametri.get(parametro);

		if (campoParametro instanceof CheckBox) {
			return ((CheckBox) campoParametro).isSelected();
		} else if (campoParametro instanceof RadioButton) {
			return ((RadioButton) campoParametro).isSelected();
		}

		return false;
	}

	public Component getCampoParametro(String parametro) {
		return parametri.get(parametro);
	}

	public Layout getFormOrizzontale() {
		return gui.creaGruppoLabelComponenteOrizzontale(
				parametri.keySet().toArray(new String[parametri.keySet().size()]),
				parametri.values().toArray(new Component[parametri.values().size()]));
	}

	public Layout getFormVerticale() {
		return gui.creaGruppoLabelComponenteVerticale(parametri.keySet().toArray(new String[parametri.keySet().size()]),
				parametri.values().toArray(new Component[parametri.values().size()]));
	}

}
