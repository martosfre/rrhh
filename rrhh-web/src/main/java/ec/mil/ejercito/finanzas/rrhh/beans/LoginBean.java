/**
 * 
 */
package ec.mil.ejercito.finanzas.rrhh.beans;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import ec.mil.ejercito.finanzas.rrhh.util.Usuario;

/**
 * Clase para administrar la página d Login
 * 
 * @author martosfre 18 ene. 2022 - 11:32:32 <br>
 *         <a href="https://www.matoosfe.com">Soporte Matoosfe</a>
 */
@Named
@ViewScoped
public class LoginBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Usuario usuario;

	public LoginBean() {
		this.usuario = new Usuario();
	}

	/**
	 * Método para validar usuario
	 */
	public void validadUsuario() {
		try {
			if (usuario.getNombreUsu().equals("mtoscano") && usuario.getClaveUsu().equals("1234")) {
				FacesContext.getCurrentInstance().getExternalContext().redirect("./pages/principal.ft");
			} else {
				FacesMessage mensaje = new FacesMessage();
				mensaje.setSummary("Credenciales Incorrectas");
				mensaje.setSeverity(FacesMessage.SEVERITY_ERROR);
				FacesContext.getCurrentInstance().addMessage(null, mensaje);
			}
		} catch (IOException e) {
			FacesMessage mensaje = new FacesMessage();
			mensaje.setSummary(e.getMessage());
			mensaje.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, mensaje);
		}
	}

}
