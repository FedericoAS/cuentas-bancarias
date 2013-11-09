package edu.tallerweb.cuentas;

public class CuentaCorriente extends AbstractCuenta {

	double descubierto;
	double descubiertoTotal;

	public CuentaCorriente(final Double descubiertoTotal) {
		if (descubiertoTotal < 0)
			throw new CuentaBancariaException("Imposible realiza operacion");

		this.descubierto = descubiertoTotal;
		this.descubiertoTotal = descubiertoTotal;
	}

	public void depositar(final Double monto) {
		if (monto < 0)
			throw new CuentaBancariaException("Imposible realiza operacion");

		if (this.descubierto != this.descubiertoTotal) {
			this.fondos += (monto - (this.descubiertoTotal-this.descubierto));
			this.descubierto = this.descubiertoTotal;
		} else
			this.fondos += monto;
	}

	public void extraer(final Double monto) {

		if( (monto - this.fondos) > (this.descubierto + ((monto - this.fondos)*0.05)))
			throw new CuentaBancariaException("No posee suficientes fondos");

		if ((monto - this.fondos)>0) {
			this.descubierto -= ((monto - this.fondos)*1.05);
			this.fondos = 0;
		} else {
			this.fondos -= monto;
		}
	}

	public Double getSaldo() {
		return this.fondos;
	}

	public Double getDescubierto() {
		return this.descubierto;
	}

}
