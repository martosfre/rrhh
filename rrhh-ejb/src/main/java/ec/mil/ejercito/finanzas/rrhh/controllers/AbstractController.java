/**
 * 
 */
package ec.mil.ejercito.finanzas.rrhh.controllers;

import javax.persistence.EntityManager;

/**
 * @author martosfre
 *
 */
public abstract class AbstractController<T> {
	private Class<T> entidad;

	/**
	 * @param 
	 */
	public AbstractController(Class<T> entidad) {
		this.entidad = entidad;
	}
	
	/**
	 * Método para guardar un tipo de movimiento
	 * 
	 * @param tipoMovimiento
	 * @return
	 * @throws Exception
	 */
	public String guardar(T entidad) throws Exception {
		String mensaje = null;
		getEntityManager().persist(entidad);
		mensaje = "Registro guardado correctamente";
		return mensaje;
	}
	
	/**
	 * Método para actualizar un tipo de movimiento
	 * 
	 * @param tipoMovimiento
	 * @return
	 * @throws Exception
	 */
	public String actualizar(T entidad) throws Exception {
		String mensaje = null;
		getEntityManager().merge(entidad);
		mensaje = "Registro actualizado correctamente";
		return mensaje;
	}
	
	/**
	 * Método para eliminar el tipo de movimiento
	 * @param tipoMovimiento
	 * @return
	 * @throws Exception
	 */
	public String eliminar(T entidad) throws Exception {
		String mensaje = null;
		getEntityManager().remove(getEntityManager().merge(entidad));
		mensaje = "Registro eliminado correctamente";
		return mensaje;
	}

	protected abstract EntityManager getEntityManager();

	
}
