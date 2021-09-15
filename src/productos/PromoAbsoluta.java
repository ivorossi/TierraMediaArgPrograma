package productos;

import java.util.ArrayList;

import excepcion.ExcepcionDeProducto;

public class PromoAbsoluta extends Promo {
	private int costoDePromo;

	public PromoAbsoluta(String nombreDeProducto, String tipoDeProducto, int costoDePromo, int costoTotal,
			double tiempoDeProducto, ArrayList<Atraccion> atracciones) throws ExcepcionDeProducto {

		super(nombreDeProducto, tipoDeProducto, costoTotal, tiempoDeProducto, atracciones);
		if (costoDePromo <= 0)
			throw new ExcepcionDeProducto(costoDePromo + ": se esperan un costo de promo mayor a 0");

		this.costoDePromo = costoDePromo;
		this.aplicarDescuento();
	}

	private void aplicarDescuento() {
		super.costoTotal = this.costoDePromo;
	}

	@Override
	public String toString() {
		return "Promo de tipo absoluta, el pack te queda en : " + costoDePromo + " monedas.\n" + super.toString();
	}

}
