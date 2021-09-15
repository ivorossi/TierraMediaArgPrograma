package usuario;

import java.util.ArrayList;

import productos.Producto;

public class Itinerario {
	private ArrayList<Producto> productosDelusuario = new ArrayList<Producto>();

	public Itinerario() {
	}

	public ArrayList<Producto> getProductosDelUsuario() {
		return this.productosDelusuario;
	}

	public void setProducto(Producto productoDelusuario) {
		this.productosDelusuario.add(productoDelusuario);
	}

	public boolean noEstaComprado(Producto producto) {
		for (Producto elemento : productosDelusuario) {
			if (elemento.equals(producto))
				return false;
		}
		return true;
	}

	private String toStrigDeOroductos() {
		String listadoDeProductos = "";
		for (Producto elemento : productosDelusuario) {
			listadoDeProductos += elemento.toString() + "\n\n";
		}
		return listadoDeProductos;
	}

	@Override
	public String toString() {
		return " tu itinerario: \n\n" + toStrigDeOroductos();
	}

}
