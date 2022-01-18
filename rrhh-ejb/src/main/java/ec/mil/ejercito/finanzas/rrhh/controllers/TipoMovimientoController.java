/**
 * 
 */
package ec.mil.ejercito.finanzas.rrhh.controllers;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import ec.mil.ejercito.finanzas.rrhh.entities.FtmoTipmovimiento;

/**
 * Clase para administrar las operaciones de tipo de movimiento
 * 
 * @author martosfre
 *
 */
//Modelo de EJB - NoViewInterface
@Stateless
public class TipoMovimientoController {
	// El nombre del unitName se obtiene del archivo persistence.xml
	@PersistenceContext(unitName = "finanzasPU")
	private EntityManager em;

	/**
	 * Método para guardar un tipo de movimiento
	 * 
	 * @param tipoMovimiento
	 * @return
	 * @throws Exception
	 */
	public String guardar(FtmoTipmovimiento tipoMovimiento) throws Exception {
		String mensaje = null;
		em.persist(tipoMovimiento);
		mensaje = "Registro guardado correctamente";
//		em.getTransaction().begin();
//		em.persist(movimiento);
//		em.getTransaction().commit();

		return mensaje;
	}

	/**
	 * Método para actualizar un tipo de movimiento
	 * 
	 * @param tipoMovimiento
	 * @return
	 * @throws Exception
	 */
	public String actualizar(FtmoTipmovimiento tipoMovimiento) throws Exception {
		String mensaje = null;
		em.merge(tipoMovimiento);
		mensaje = "Registro actualizado correctamente";
		return mensaje;
	}

	/**
	 * Método para actualizar un objeto
	 * 
	 * @param idTipMov
	 * @return
	 * @throws Exception
	 */
	public String actualizar(long idTipMov) throws Exception {
		String mensaje = null;
		FtmoTipmovimiento tipMov = em.find(FtmoTipmovimiento.class, idTipMov);
		tipMov.setTmoAbrevia("Prueba");
		mensaje = "Registro actualizado correctamente";
		return mensaje;
	}

	/**
	 * Método para eliminar un tipo de movimiento
	 * 
	 * @param movimiento
	 * @return
	 * @throws Exception
	 */
	public String eliminar(long idTipMov) throws Exception {
		String mensaje = null;
		FtmoTipmovimiento tipMov = em.find(FtmoTipmovimiento.class, idTipMov);
		em.remove(tipMov);
		mensaje = "Registro eliminado correctamente";
		return mensaje;
	}

	/**
	 * Método para eliminar el tipo de movimiento
	 * 
	 * @param tipoMovimiento
	 * @return
	 * @throws Exception
	 */
	public String eliminar(FtmoTipmovimiento tipoMovimiento) throws Exception {
		String mensaje = null;
		em.remove(em.merge(tipoMovimiento));
		mensaje = "Registro eliminado correctamente";
		return mensaje;
	}

	/**
	 * Método para consultar todos por JPQL
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<FtmoTipmovimiento> consultarTodos() throws Exception {
		TypedQuery<FtmoTipmovimiento> conTipMov = em.createQuery("Select tm from FtmoTipmovimiento tm",
				FtmoTipmovimiento.class);
		return conTipMov.getResultList();
	}

	/**
	 * Método para consultar todos por NamedQuery
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<FtmoTipmovimiento> consultarTodosNamedQuery() throws Exception {
		TypedQuery<FtmoTipmovimiento> conTipMov = em.createNamedQuery("FtmoTipmovimiento.findAll",
				FtmoTipmovimiento.class);
		return conTipMov.getResultList();
	}
}
