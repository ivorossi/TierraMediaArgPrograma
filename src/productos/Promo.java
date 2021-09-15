package productos;

import java.util.ArrayList;
import java.util.Objects;

import excepcion.ExcepcionDeProducto;

public class Promo extends Producto {

	protected ArrayList<Atraccion> atracciones;

	public Promo(String nombreDeProducto, String tipoDeProducto, int costoTotal, double tiempoDeProducto,
			ArrayList<Atraccion> atracciones) throws ExcepcionDeProducto {
		super(nombreDeProducto, tipoDeProducto, costoTotal, tiempoDeProducto);
		this.atracciones = atracciones;
	}

	public boolean hayCupo() {
		for (Atraccion elemento : atracciones) {
			if (!elemento.hayCupo())
				return false;
		}
		return true;
	}

	@Override
	public boolean esPromo() {
		return true;
	}

	@Override
	public void restarCupo() {
		for (Atraccion elemento : atracciones)
			elemento.restarCupo();
	}

	private String toStrigDeAtracciones() {
		String listadoDeAtracciones = "";
		int i = 0;
		for (Atraccion elemento : atracciones) {
			listadoDeAtracciones += elemento.getNombreDeProducto();
			i++;
			if (i < atracciones.size()) {
				listadoDeAtracciones += ", ";
			} else {
				listadoDeAtracciones += ";";
			}
		}
		return listadoDeAtracciones;
	}

	@Override
	public String toString() {
		return super.toString() + "]" + "\natracciones inculidas:\n" + this.toStrigDeAtracciones();
	}

	@Override
	public int hashCode() {
		return Objects.hash(atracciones);
	}

	@Override
	public boolean equals(Object obj) {
		for (Atraccion elemento : atracciones) {
			if (elemento.equals(obj))
				return true;
		}
		return false;
	}

}
