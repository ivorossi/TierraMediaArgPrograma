package sistema;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Scanner;

import productos.Atraccion;
import productos.Producto;
import usuario.Usuario;

public class TierraMedia {

	private ArrayDeque<Usuario> colaDeVisitantes = new ArrayDeque<Usuario>();
	private LinkedList<Producto> productosOfertables = new LinkedList<Producto>();
	private LinkedList<Atraccion> atracciones = new LinkedList<Atraccion>();
	private LinkedList<Producto> listaDePromos = new LinkedList<Producto>();

	public void sistema() {
		AdministradorDeArchivos archivero = new AdministradorDeArchivos();
		Scanner teclado = new Scanner(System.in);
		String asd;
		Usuario visitante;
		int id = 0;

		colaDeVisitantes = archivero.leerArchivoDeUsuario("usuarios.csv");
		System.out.println("-----------------------------------------");
		atracciones = archivero.leerArchivoDeAtracciones("atracciones.csv");
		System.out.println("-----------------------------------------");
		listaDePromos = archivero.leerArchivoDePromos("promos.csv", atracciones);
		System.out.println("-----------------------------------------");

		productosOfertables.addAll(atracciones);
		productosOfertables.addAll(listaDePromos);
		
		while (!colaDeVisitantes.isEmpty()) {
			visitante = colaDeVisitantes.poll();
			visitante.setId(id);
			id++;
			OrdenarLista ordenarOfertables = new OrdenarLista(visitante);
			productosOfertables.sort(ordenarOfertables);

			System.out.println("\n-----------------------------------------------------------------------------\n"
					+ "Bienvenido/a a la tierra media: " + visitante.getNombre() + "\nVamos a Comprar");

			for (Producto elemento : productosOfertables) {

				if (visitante.getTiempoDisponible() >= elemento.getTimepoDeProducto()
						&& visitante.getPresupuesto() >= elemento.getCostoTotal() && elemento.hayCupo()
						&& visitante.yaLoTengo(elemento)) {

					System.out.println("\n" + elemento + "\n");
					do {
						System.out.println("Desea comprar el: " + elemento.getNombreDeProducto()
								+ ",  presione (y), si no, presione (n)");
						asd = teclado.nextLine();
					} while (!(asd.equalsIgnoreCase("y") || asd.equalsIgnoreCase("n")));

					if (asd.equalsIgnoreCase("y"))
						visitante.Comprar(elemento);
				}
			}
			archivero.imprimirItinerario(visitante);
			System.out.println(visitante);
		}
		teclado.close();
	}
}
