package usuario;

import excepcion.ExcepcionDelUsuario;
import productos.Producto;

public class Usuario {
	private String nombre;
	private String gusto;
	private int presupuesto;
	private double tiempoDisponible;
	private Itinerario itinerarioDelUsuario = new Itinerario();

	public Usuario(String nombre, String gusto, double tiempoDisponible, int presupuesto) throws ExcepcionDelUsuario {
		if (tiempoDisponible <= 0)
			throw new ExcepcionDelUsuario(tiempoDisponible + ": se esperan valores positivos de tiempo disponible ");
		this.nombre = nombre;
		if (presupuesto <= 0)
			throw new ExcepcionDelUsuario(presupuesto + ": se esperan valores positivos de presupuesto");
		this.gusto = gusto;
		this.tiempoDisponible = tiempoDisponible;
		this.presupuesto = presupuesto;
	}

	public void Comprar(Producto compra) {
		this.presupuesto -= compra.getCostoTotal();
		this.tiempoDisponible -= compra.getTimepoDeProducto();
		compra.restarCupo();
		itinerarioDelUsuario.setProducto(compra);
	}

	public boolean yaLoTengo(Producto compra) {
		return this.itinerarioDelUsuario.noEstaComprado(compra);
	}

	public String getNombre() {
		return nombre;
	}

	public String getGusto() {
		return gusto;
	}

	public int getPresupuesto() {
		return presupuesto;
	}

	public double getTiempoDisponible() {
		return tiempoDisponible;
	}

	@Override
	public String toString() {
		return nombre + itinerarioDelUsuario + "\nGracias Por tu compra!!\n" + "tu vuelto es: " + presupuesto
				+ " monedas y tu tiempo libre es de: " + tiempoDisponible + "hs;";
	}

}
