package edu.tallerweb.cuentas;

public abstract class AbstractCuenta {

	protected double fondos;

	public abstract void depositar(final Double monto);

	public abstract void extraer(final Double monto);

}
