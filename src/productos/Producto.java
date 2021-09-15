package productos;

import excepcion.ExcepcionDeProducto;
import sistema.TiposDeAtraccion;

public class Producto {

	private String nombreDeProducto;
	private String tipoDeProducto;
	protected int costoTotal;
	private double timepoDeProducto;

	public Producto(String nombreDeProducto, String tipoDeProducto, int costoTotal, double tiempoDeProducto)
			throws ExcepcionDeProducto {

		if (!(TiposDeAtraccion.AVENTURA.esUnTipo(tipoDeProducto) || TiposDeAtraccion.PAISAJE.esUnTipo(tipoDeProducto)
				|| TiposDeAtraccion.DEGUSTACION.esUnTipo(tipoDeProducto)))
			throw new ExcepcionDeProducto(tipoDeProducto + ": no es un valor valido(paisaje,aventura,degustacion");
		if (costoTotal <= 0)
			throw new ExcepcionDeProducto(costoTotal + ": se esperan costos mayores a 0");
		if (tiempoDeProducto <= 0)
			throw new ExcepcionDeProducto(tiempoDeProducto + ": se esperan tiempos mayores a 0");

		this.nombreDeProducto = nombreDeProducto;
		this.tipoDeProducto = tipoDeProducto;
		this.costoTotal = costoTotal;
		this.timepoDeProducto = tiempoDeProducto;
	}

	public boolean esPromo() {
		return false;
	}

	public boolean hayCupo() {
		return true;
	}

	public String getTipoDeProducto() {
		return tipoDeProducto;
	}

	public double getCostoTotal() {
		return costoTotal;
	}

	public void restarCupo() {

	}

	public double getTimepoDeProducto() {
		return timepoDeProducto;
	}

	public String getNombreDeProducto() {
		return nombreDeProducto;
	}

	@Override
	public String toString() {
		return nombreDeProducto + "  [ Tipo: " + tipoDeProducto + ",  costo del producto: " + costoTotal + " monedas";
	}

}
