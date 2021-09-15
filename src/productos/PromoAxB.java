package productos;

import java.util.ArrayList;

import excepcion.ExcepcionDeProducto;

public class PromoAxB extends Promo {

	private String atraccionGratis;

	public PromoAxB(String nombreDeProducto, String tipoDeProducto, String atraccionGratis, int costoTotal,
			double tiempoDeProducto, ArrayList<Atraccion> atraccionesDePromo) throws ExcepcionDeProducto {

		super(nombreDeProducto, tipoDeProducto, costoTotal, tiempoDeProducto, atraccionesDePromo);

		this.atraccionGratis = atraccionGratis;
		this.aplicarDescuento();
	}

	private void aplicarDescuento() {
		for (Atraccion elemento : super.atracciones) {
			if (this.atraccionGratis.equals(elemento.getNombreDeProducto()))
				super.costoTotal -= elemento.getCostoTotal();
		}
	}

	@Override
	public String toString() {
		return "Promo de tipo AxB la atraccion: " + atraccionGratis + " es gratis.\n" + super.toString();
	}

}
