package productos;

import java.util.Objects;

import excepcion.ExcepcionDeProducto;

public class Atraccion extends Producto {

	private int cupo;

	public Atraccion(String nombre, String tipoDeProducto, int costo, double tiempo, int cupo)
			throws ExcepcionDeProducto {
		super(nombre, tipoDeProducto, costo, tiempo);
		if (cupo <= 0)
			throw new ExcepcionDeProducto(cupo + ": se esperan cupos mayores a 0");

		this.cupo = cupo;
	}

	@Override
	public boolean hayCupo() {
		return cupo > 0;
	}

	@Override
	public void restarCupo() {
		this.cupo -= 1;
	}

	@Override
	public String toString() {

		return "Atraccion: " + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cupo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		return false;
	}

}
