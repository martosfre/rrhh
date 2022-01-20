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

import org.primefaces.event.SelectEvent;

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
	@Getter
	@Setter
	private boolean esConciliable;

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

	/**
	 * Método para guardar el tipo de movimiento
	 */
	public void guardar() {
		try {
			String mensaje = null;
			tipoMovimiento.setTmoConciliable(esConciliable == true ? "S" : "N");
			if (tipoMovimiento.getTmoCodigo() > 0) {
				mensaje = adminTipoMovimiento.actualizar(tipoMovimiento);
			} else {
				mensaje = adminTipoMovimiento.guardar(tipoMovimiento);
			}
			anadirInfo(mensaje);
			cargarTiposMovimiento();
			this.tipoMovimiento = new FtmoTipmovimiento();
		} catch (Exception e) {
			anadirError("Problema al guardar tipo de movimiento:" + e.getMessage());
		}
	}

	/**
	 * Método para seleccionar tipo de movimiento
	 * 
	 * @param ev
	 */
	public void seleccionarRegistro(SelectEvent<FtmoTipmovimiento> ev) {
		this.tipoMovimientoSel = ev.getObject();
	}

	/**
	 * Método para editar un registro
	 */
	public void editar() {
		if (tipoMovimientoSel != null) {
			tipoMovimiento = tipoMovimientoSel;
		} else {
			anadirError("Se debe seleccionar un registro");
		}
	}

	/**
	 * Método para eliminar un tipo de movimiento
	 */
	public void eliminar() {
		try {
			if (tipoMovimientoSel != null) {
				String mensaje = adminTipoMovimiento.eliminar(tipoMovimientoSel);
				anadirInfo(mensaje);
				cargarTiposMovimiento();
			} else {
				anadirError("Se debe seleccionar un registro");
			}
		} catch (Exception e) {
			anadirError("Problema al eliminar un tipo de movimiento:" + e.getMessage());

		}
	}

	@PostConstruct
	public void inicializar() {
		cargarTiposMovimiento();
	}

}
