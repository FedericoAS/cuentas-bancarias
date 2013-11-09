package edu.tallerweb.cuentas;

public class CuentaSueldo extends AbstractCuenta {

	public void depositar(final Double monto) {
		if (monto < 0)
			throw new CuentaBancariaException("Imposible realiza operacion");

		this.fondos = this.fondos + monto;
	}

	public void extraer(final Double monto) {
		if (monto > this.fondos)
			throw new CuentaBancariaException("No posee suficientes fondos");

		this.fondos = this.fondos - monto;
	}

	public Double getSaldo() {
		return this.fondos;
	}

}
