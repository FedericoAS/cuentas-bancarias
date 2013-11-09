package edu.tallerweb.cuentas;

import org.junit.Assert;
import org.junit.Test;

public class CuentaTests {

//Test en cuenta sueldo
	@Test
	public void queVerifiqueLaConsignaDepExtCuentaSueldo() {
		CuentaSueldo cuenta = new CuentaSueldo();

		cuenta.depositar(4000.0);

		Assert.assertEquals(
				"al depositar $ 4000.0 en una cuenta vacia, tiene $ 4000.0",
				4000.0, cuenta.getSaldo(), 0.0);

		cuenta.extraer(500.0);

		Assert.assertEquals(
				"al extraer $ 500.0 de una cuenta con $ 4000.0 se obtienen $ 3500.0",
				3500.0, cuenta.getSaldo(), 0.0);
	}

	@Test(expected=CuentaBancariaException.class)
	public void exceptionFondosInsuficientesCuentaSueldo() {
		CuentaSueldo cuenta = new CuentaSueldo();
		cuenta.depositar(3500.0);

		cuenta.extraer(4000.0);
	}

	@Test(expected=CuentaBancariaException.class)
	public void ExceptionDepositoNegativoCuentaSueldo() {
		CuentaSueldo cuenta = new CuentaSueldo();

		cuenta.depositar(-4000.0);
	}

//Test en Caja de Ahorros
	@Test
	public void queVerifiqueLaConsignaDepExtCajaAhorros() {
		CajaAhorros cuenta = new CajaAhorros();

		cuenta.depositar(4000.0);

		Assert.assertEquals(
				"al depositar $ 4000.0 en una cuenta vacia, tiene $ 4000.0",
				4000.0, cuenta.getSaldo(), 0.0);

		cuenta.extraer(500.0);

		Assert.assertEquals(
				"al extraer $ 500.0 de una cuenta con $ 4000.0 se obtienen $ 3500.0",
				3500.0, cuenta.getSaldo(), 0.0);
	}

	@Test(expected=CuentaBancariaException.class)
	public void exceptionFondosInsuficientesCajaAhorros() {
		CajaAhorros cuenta = new CajaAhorros();
		cuenta.depositar(3500.0);

		cuenta.extraer(4000.0);
	}

	@Test
	public void queCobreSeisPorSextaExtraccion() {
		CajaAhorros cuenta = new CajaAhorros();
		cuenta.depositar(706.0);
		cuenta.extraer(100.0);
		cuenta.extraer(100.0);
		cuenta.extraer(100.0);
		cuenta.extraer(100.0);
		cuenta.extraer(100.0);
		cuenta.extraer(100.0);

		Assert.assertEquals(
				"cobre $6 por 6 extraccion",
				100.0, cuenta.getSaldo(), 0.0);
	}

	@Test(expected=CuentaBancariaException.class)
	public void ExceptionSinFondos6Extraccion() {
		CajaAhorros cuenta = new CajaAhorros();

		cuenta.depositar(600.0);
		cuenta.extraer(100.0);
		cuenta.extraer(100.0);
		cuenta.extraer(100.0);
		cuenta.extraer(100.0);
		cuenta.extraer(100.0);
		cuenta.extraer(100.0);
	}

	@Test(expected=CuentaBancariaException.class)
	public void ExceptionDepositoNegativoCajaAhorros() {
		CajaAhorros cuenta = new CajaAhorros();

		cuenta.depositar(-4000.0);
	}

//Test CuentaCorrientes

	@Test
	public void queVerifiqueLaConsignaDECuentaCorriente() {
		CuentaCorriente cuenta = new CuentaCorriente(100.0);

		cuenta.depositar(4000.0);

		Assert.assertEquals(
				"al depositar $ 4000.0 en una cuenta vacia, tiene $ 4000.0",
				4000.0, cuenta.getSaldo(), 0.0);

		cuenta.extraer(500.0);

		Assert.assertEquals(
				"al extraer $ 500.0 de una cuenta con $ 4000.0 se obtienen $ 3500.0",
				3500.0, cuenta.getSaldo(), 0.0);
	}

	@Test(expected=CuentaBancariaException.class)
	public void exceptionFondosInsuficientesCuentaCorriente() {
		CuentaCorriente cuenta = new CuentaCorriente(100.0);
		cuenta.depositar(3500.0);

		cuenta.extraer(4000.0);
	}

	@Test(expected=CuentaBancariaException.class)
	public void ExceptionDepositoNegativoCuentaCorriente() {
		CuentaCorriente cuenta = new CuentaCorriente(100.0);

		cuenta.depositar(-4000.0);
	}
	
	@Test(expected=CuentaBancariaException.class)
	public void ExceptionDescubiertoNegativoCuentaCorriente() {
		CuentaCorriente cuenta = new CuentaCorriente(-100.0);
		cuenta.depositar(100.0);
	}

	@Test
	public void queCobre5PorcientoPorDescubierto(){
		CuentaCorriente cuenta = new CuentaCorriente(100.0);
		cuenta.depositar(100.0);
		cuenta.extraer(150.0);
		
		Assert.assertEquals(
				"fondo en cero por extraccion mayor",
				0.0, cuenta.getSaldo(), 0.0);

		Assert.assertEquals(
				"cobro 5 porciento en descubierto",
				47.5, cuenta.getDescubierto(), 0.0);

	}
}