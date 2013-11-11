package edu.tallerweb.cuentas;

public class CajaAhorros extends AbstractCuenta {

	private int cantidadExtrac;

	public CajaAhorros () {
		this.cantidadExtrac = 0;
	}

	public void depositar(final Double monto) {
		if (monto < 0)
			throw new CuentaBancariaException("Imposible realiza operacion");

		this.fondos += monto; 
	}

	public void extraer(final Double monto) {
		double mas = monto;

		if ((this.cantidadExtrac +1) > 5)
			mas += 6;

		if (this.fondos < mas)
			throw new CuentaBancariaException("No posee sufucientes fondos");

		this.fondos -= mas;
		this.cantidadExtrac += 1;
	}

	public Double getSaldo() {
		return this.fondos;
	}

}