package ec.mil.ejercito.finanzas.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the FR_CEDULAS database table.
 * 
 */
@Entity
@Table(name="FR_CEDULAS")
@NamedQuery(name="FrCedula.findAll", query="SELECT f FROM FrCedula f")
public class FrCedula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="RCP_COD")
	private String rcpCod;

	@Column(name="RCP_CODIGO")
	private String rcpCodigo;

	@Column(name="RCP_COMPRO")
	private double rcpCompro;

	@Column(name="RCP_DESCRI")
	private String rcpDescri;

	@Column(name="RCP_DEVENGA")
	private double rcpDevenga;

	@Column(name="RCP_INICIAL")
	private double rcpInicial;

	@Column(name="RCP_MES")
	private BigDecimal rcpMes;

	@Column(name="RCP_PAGADO")
	private double rcpPagado;

	@Column(name="RCP_REFOR")
	private double rcpRefor;

	public FrCedula() {
	}

	public String getRcpCod() {
		return this.rcpCod;
	}

	public void setRcpCod(String rcpCod) {
		this.rcpCod = rcpCod;
	}

	public String getRcpCodigo() {
		return this.rcpCodigo;
	}

	public void setRcpCodigo(String rcpCodigo) {
		this.rcpCodigo = rcpCodigo;
	}

	public double getRcpCompro() {
		return this.rcpCompro;
	}

	public void setRcpCompro(double rcpCompro) {
		this.rcpCompro = rcpCompro;
	}

	public String getRcpDescri() {
		return this.rcpDescri;
	}

	public void setRcpDescri(String rcpDescri) {
		this.rcpDescri = rcpDescri;
	}

	public double getRcpDevenga() {
		return this.rcpDevenga;
	}

	public void setRcpDevenga(double rcpDevenga) {
		this.rcpDevenga = rcpDevenga;
	}

	public double getRcpInicial() {
		return this.rcpInicial;
	}

	public void setRcpInicial(double rcpInicial) {
		this.rcpInicial = rcpInicial;
	}

	public BigDecimal getRcpMes() {
		return this.rcpMes;
	}

	public void setRcpMes(BigDecimal rcpMes) {
		this.rcpMes = rcpMes;
	}

	public double getRcpPagado() {
		return this.rcpPagado;
	}

	public void setRcpPagado(double rcpPagado) {
		this.rcpPagado = rcpPagado;
	}

	public double getRcpRefor() {
		return this.rcpRefor;
	}

	public void setRcpRefor(double rcpRefor) {
		this.rcpRefor = rcpRefor;
	}

}