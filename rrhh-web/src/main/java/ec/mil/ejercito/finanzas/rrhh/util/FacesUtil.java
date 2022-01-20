/**
 * 
 */
package ec.mil.ejercito.finanzas.rrhh.util;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

/**
 * Clase utilitaria para JSF
 * 
 * @author martosfre 20 ene. 2022 - 10:06:40 <br>
 *         <a href="https://www.matoosfe.com">Soporte Matoosfe</a>
 */
public class FacesUtil {

	/**
	 * Método para añadir mensaje JSF
	 * 
	 * @param mensajeVista
	 * @param severity
	 */
	private void anadirMensaje(String mensajeVista, Severity severity) {
		FacesMessage mensaje = new FacesMessage();
		mensaje.setSummary(mensajeVista);
		mensaje.setSeverity(severity);
		FacesContext.getCurrentInstance().addMessage(null, mensaje);
	}

	/**
	 * Método para añadir mensaje de información
	 * 
	 * @param mensaje
	 */
	protected void anadirInfo(String mensaje) {
		anadirMensaje(mensaje, FacesMessage.SEVERITY_INFO);
	}

	/**
	 * Método para añadir mensaje de error
	 * 
	 * @param mensaje
	 */
	protected void anadirError(String mensaje) {
		anadirMensaje(mensaje, FacesMessage.SEVERITY_ERROR);
	}
}
