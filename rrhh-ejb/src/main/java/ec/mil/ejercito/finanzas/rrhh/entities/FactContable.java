package ec.mil.ejercito.finanzas.rrhh.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the FACT_CONTABLE database table.
 * 
 */
@Entity
@Table(name="FACT_CONTABLE", schema = "FINANZAS")
@NamedQuery(name="FactContable.findAll", query="SELECT f FROM FactContable f")
public class FactContable implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * Anotación opcional que se coloca cuando se trabaja con claves compuestas y la
	 * clase que representa la clave compuesta se mapea con @Embeddable
	 */
	@EmbeddedId
	private FactContablePK id;

	@Column(name="ACT_COMPROBANTE")
	private BigDecimal actComprobante;

	@Column(name="ACT_CONCILIADO")
	private String actConciliado;

	@Column(name="ACT_DESCRI")
	private String actDescri;

	@Column(name="ACT_ESTADO")
	private String actEstado;

	/*
	 * Anotación opcional que se coloca cuando se esta mapeando tipos de datos fecha,
	 * para especificar la forma de almacenar en la bdd esa fecha
	 */
	//@Temporal(TemporalType.DATE)
	@Column(name="ACT_FECCONCI")
	private LocalDate actFecconci;

	//@Temporal(TemporalType.DATE)
	@Column(name="ACT_FECHA")
	private LocalDate actFecha;

	@Column(name="ACT_FORMA")
	private String actForma;

	@Column(name="ACT_IMPRESO")
	private String actImpreso;

	@Column(name="ACT_NUMDOC")
	private BigDecimal actNumdoc;

	@Column(name="ACT_PAGADO")
	private String actPagado;

	@Column(name="ACT_REFERENCIA")
	private String actReferencia;

	@Column(name="ACT_REVERTIDO")
	private BigDecimal actRevertido;

	@Column(name="CMP_SECUENCIAL")
	private BigDecimal cmpSecuencial;

	@Column(name="DCI_CODIGO")
	private BigDecimal dciCodigo;

	@Column(name="MUN_UNI_CODIGO2")
	private String munUniCodigo2;

	@Column(name="MUN_UNI_CODIGO2_EJE")
	private String munUniCodigo2Eje;

	//bi-directional many-to-one association to FtmoTipmovimiento
	@ManyToOne
	//Nombre columna FK
	@JoinColumn(name="TMO_CODIGO")
	private FtmoTipmovimiento ftmoTipmovimiento;

	//bi-directional many-to-one association to FdacAstCont
	@OneToMany(mappedBy="factContable1")
	private List<FdacAstCont> fdacAstConts1;

	//bi-directional many-to-one association to FdacAstCont
	@OneToMany(mappedBy="factContable2")
	private List<FdacAstCont> fdacAstConts2;

	//bi-directional many-to-one association to FdepDeprecia
	@OneToMany(mappedBy="factContable")
	private List<FdepDeprecia> fdepDeprecias;

	//bi-directional many-to-one association to FmovArticulo
	@OneToMany(mappedBy="factContable")
	private List<FmovArticulo> fmovArticulos;

	public FactContable() {
	}

	public FactContablePK getId() {
		return this.id;
	}

	public void setId(FactContablePK id) {
		this.id = id;
	}

	public BigDecimal getActComprobante() {
		return this.actComprobante;
	}

	public void setActComprobante(BigDecimal actComprobante) {
		this.actComprobante = actComprobante;
	}

	public String getActConciliado() {
		return this.actConciliado;
	}

	public void setActConciliado(String actConciliado) {
		this.actConciliado = actConciliado;
	}

	public String getActDescri() {
		return this.actDescri;
	}

	public void setActDescri(String actDescri) {
		this.actDescri = actDescri;
	}

	public String getActEstado() {
		return this.actEstado;
	}

	public void setActEstado(String actEstado) {
		this.actEstado = actEstado;
	}

	public LocalDate getActFecconci() {
		return this.actFecconci;
	}

	public void setActFecconci(LocalDate actFecconci) {
		this.actFecconci = actFecconci;
	}

	public LocalDate getActFecha() {
		return this.actFecha;
	}

	public void setActFecha(LocalDate actFecha) {
		this.actFecha = actFecha;
	}

	public String getActForma() {
		return this.actForma;
	}

	public void setActForma(String actForma) {
		this.actForma = actForma;
	}

	public String getActImpreso() {
		return this.actImpreso;
	}

	public void setActImpreso(String actImpreso) {
		this.actImpreso = actImpreso;
	}

	public BigDecimal getActNumdoc() {
		return this.actNumdoc;
	}

	public void setActNumdoc(BigDecimal actNumdoc) {
		this.actNumdoc = actNumdoc;
	}

	public String getActPagado() {
		return this.actPagado;
	}

	public void setActPagado(String actPagado) {
		this.actPagado = actPagado;
	}

	public String getActReferencia() {
		return this.actReferencia;
	}

	public void setActReferencia(String actReferencia) {
		this.actReferencia = actReferencia;
	}

	public BigDecimal getActRevertido() {
		return this.actRevertido;
	}

	public void setActRevertido(BigDecimal actRevertido) {
		this.actRevertido = actRevertido;
	}

	public BigDecimal getCmpSecuencial() {
		return this.cmpSecuencial;
	}

	public void setCmpSecuencial(BigDecimal cmpSecuencial) {
		this.cmpSecuencial = cmpSecuencial;
	}

	public BigDecimal getDciCodigo() {
		return this.dciCodigo;
	}

	public void setDciCodigo(BigDecimal dciCodigo) {
		this.dciCodigo = dciCodigo;
	}

	public String getMunUniCodigo2() {
		return this.munUniCodigo2;
	}

	public void setMunUniCodigo2(String munUniCodigo2) {
		this.munUniCodigo2 = munUniCodigo2;
	}

	public String getMunUniCodigo2Eje() {
		return this.munUniCodigo2Eje;
	}

	public void setMunUniCodigo2Eje(String munUniCodigo2Eje) {
		this.munUniCodigo2Eje = munUniCodigo2Eje;
	}

	public FtmoTipmovimiento getFtmoTipmovimiento() {
		return this.ftmoTipmovimiento;
	}

	public void setFtmoTipmovimiento(FtmoTipmovimiento ftmoTipmovimiento) {
		this.ftmoTipmovimiento = ftmoTipmovimiento;
	}

	public List<FdacAstCont> getFdacAstConts1() {
		return this.fdacAstConts1;
	}

	public void setFdacAstConts1(List<FdacAstCont> fdacAstConts1) {
		this.fdacAstConts1 = fdacAstConts1;
	}

	public FdacAstCont addFdacAstConts1(FdacAstCont fdacAstConts1) {
		getFdacAstConts1().add(fdacAstConts1);
		fdacAstConts1.setFactContable1(this);

		return fdacAstConts1;
	}

	public FdacAstCont removeFdacAstConts1(FdacAstCont fdacAstConts1) {
		getFdacAstConts1().remove(fdacAstConts1);
		fdacAstConts1.setFactContable1(null);

		return fdacAstConts1;
	}

	public List<FdacAstCont> getFdacAstConts2() {
		return this.fdacAstConts2;
	}

	public void setFdacAstConts2(List<FdacAstCont> fdacAstConts2) {
		this.fdacAstConts2 = fdacAstConts2;
	}

	public FdacAstCont addFdacAstConts2(FdacAstCont fdacAstConts2) {
		getFdacAstConts2().add(fdacAstConts2);
		fdacAstConts2.setFactContable2(this);

		return fdacAstConts2;
	}

	public FdacAstCont removeFdacAstConts2(FdacAstCont fdacAstConts2) {
		getFdacAstConts2().remove(fdacAstConts2);
		fdacAstConts2.setFactContable2(null);

		return fdacAstConts2;
	}

	public List<FdepDeprecia> getFdepDeprecias() {
		return this.fdepDeprecias;
	}

	public void setFdepDeprecias(List<FdepDeprecia> fdepDeprecias) {
		this.fdepDeprecias = fdepDeprecias;
	}

	public FdepDeprecia addFdepDeprecia(FdepDeprecia fdepDeprecia) {
		getFdepDeprecias().add(fdepDeprecia);
		fdepDeprecia.setFactContable(this);

		return fdepDeprecia;
	}

	public FdepDeprecia removeFdepDeprecia(FdepDeprecia fdepDeprecia) {
		getFdepDeprecias().remove(fdepDeprecia);
		fdepDeprecia.setFactContable(null);

		return fdepDeprecia;
	}

	public List<FmovArticulo> getFmovArticulos() {
		return this.fmovArticulos;
	}

	public void setFmovArticulos(List<FmovArticulo> fmovArticulos) {
		this.fmovArticulos = fmovArticulos;
	}

	public FmovArticulo addFmovArticulo(FmovArticulo fmovArticulo) {
		getFmovArticulos().add(fmovArticulo);
		fmovArticulo.setFactContable(this);

		return fmovArticulo;
	}

	public FmovArticulo removeFmovArticulo(FmovArticulo fmovArticulo) {
		getFmovArticulos().remove(fmovArticulo);
		fmovArticulo.setFactContable(null);

		return fmovArticulo;
	}

}