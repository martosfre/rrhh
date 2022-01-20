/**
 * 
 */
package ec.mil.ejercito.finanzas.rrhh.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.mil.ejercito.finanzas.rrhh.controllers.TipoMovimientoController;
import ec.mil.ejercito.finanzas.rrhh.entities.FtmoTipmovimiento;
import ec.mil.ejercito.finanzas.rrhh.util.FacesUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * Clase para administrar el formulario de tipo movimiento
 * 
 * @author martosfre 20 ene. 2022 - 09:52:33 <br>
 *         <a href="https://www.matoosfe.com">Soporte Matoosfe</a>
 */
@Named
@ViewScoped
public class TipoMovimientoBean extends FacesUtil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private FtmoTipmovimiento tipoMovimiento;
	@Getter
	@Setter
	private FtmoTipmovimiento tipoMovimientoSel;
	@Getter
	@Setter
	private List<FtmoTipmovimiento> listaTipoMovimiento;

	@Inject
	private TipoMovimientoController adminTipoMovimiento;

	public TipoMovimientoBean() {
		this.tipoMovimiento = new FtmoTipmovimiento();
		this.listaTipoMovimiento = new ArrayList<>();
	}

	/**
	 * Método para cargar los tipos de movimiento
	 */
	private void cargarTiposMovimiento() {
		try {
			this.listaTipoMovimiento = adminTipoMovimiento.consultarTodos();
		} catch (Exception e) {
			anadirError("Problema al cargar tipos de movimiento:" + e.getMessage());
		}
	}

	@PostConstruct
	public void inicializar() {
		cargarTiposMovimiento();
	}

}
