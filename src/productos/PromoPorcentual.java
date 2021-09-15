package productos;

import java.util.ArrayList;

import excepcion.ExcepcionDeProducto;

public class PromoPorcentual extends Promo {
	private double descuento;

	public PromoPorcentual(String nombreDeProducto, String tipoDeProducto, double descuento, int costoTotal,
			double tiempoDeProducto, ArrayList<Atraccion> atracciones) throws ExcepcionDeProducto {

		super(nombreDeProducto, tipoDeProducto, costoTotal, tiempoDeProducto, atracciones);
		if (descuento < 1 && descuento > 100)
			throw new ExcepcionDeProducto(descuento + ": se esperan un descuento entre 1 y 100");
		this.descuento = descuento;
		this.aplicarDescuento();
	}

	private void aplicarDescuento() {
		super.costoTotal -= (int) Math.round(super.getCostoTotal() * (this.descuento / 100));
	}

	@Override
	public String toString() {
		return "Promo de tipo porcentual tenes un: " + descuento + "% de descuento.\n" + super.toString();
	}

}
