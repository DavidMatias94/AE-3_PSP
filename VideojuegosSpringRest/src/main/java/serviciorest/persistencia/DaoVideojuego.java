package serviciorest.persistencia;

import java.util.ArrayList;


import java.util.List;

import org.springframework.stereotype.Component;

import serviciorest.entidad.Videojuego;

/**
 * Patron DAO (Data Access Object), objeto que se encarga de hacer las consultas
 * a algun motor de persistencia (BBDD, Ficheros, etc). En este caso vamos a 
 * simular que los datos estan guardados en una BBDD trabajando con una lista
 * de objetos cargada en memoria para simplificar el ejemplo.
 * 
 * Hay que tener en cuenta que para simplificar el ejemplo tambien se ha hecho
 * que el ID con el que se dan de alta las personas en la lista coincide exactamente
 * con la posicion del array que ocupan.
 * 
 * Mediante la anotacion @Component, damos de alta un unico objeto de esta clase
 * dentro del contexto de Spring, su ID sera el nombre de la case en notacion
 * lowerCamelCase
 * 
 */
@Component
public class DaoVideojuego {

	public List<Videojuego> listaVideojuegos;
	public int contador;
	
	/**
	 * Cuando se cree el objeto dentro del contexto de Spring, se ejecutara
	 * su constructor, que creara las personas y las metera en una lista
	 * para que puedan ser consumidas por nuestros clientes
	 */
	public DaoVideojuego() {
		System.out.println("DaoPersona -> Creando la lista de personas!");
		listaVideojuegos = new ArrayList<Videojuego>();
		Videojuego p1 = new Videojuego(contador++,"FORTNITE", "EPIC GAMES", 7);//ID: 0
		Videojuego p2 = new Videojuego(contador++,"FIFA 21", "EA", 8);//ID: 1
		Videojuego p3 = new Videojuego(contador++,"CALL OF DUTTY", "ACTIVISION", 9);//ID: 2
		Videojuego p4 = new Videojuego(contador++,"AMONG US", "INNERSLOTH", 6);//ID:3
		Videojuego p5 = new Videojuego(contador++,"NBA 2K21", "2K SPORTS", 7);//ID:4
		
		listaVideojuegos.add(p1);
		listaVideojuegos.add(p2);
		listaVideojuegos.add(p3);
		listaVideojuegos.add(p4);
		listaVideojuegos.add(p5);
		
	}
	
	/**
	 * Devuelve una persona a partir de su posicion del array
	 * @param posicion la posicion del arrya que buscamos
	 * @return la persona que ocupe en la posicion del array, null en caso de
	 * que no exista o se haya ido fuera de rango del array
	 */
	public Videojuego get(int posicion) {
		try {
			return listaVideojuegos.get(posicion);
		} catch (IndexOutOfBoundsException iobe) {
			System.out.println("Persona fuera de rango");
			return null;
		}
	}
	
	/**
	 * Metodo que devuelve toda las personas del array
	 * @return una lista con todas las personas del array
	 */
	public List<Videojuego> list() {
		return listaVideojuegos;
	}
	
	/**
	 * Metodo que introduce una persona al final de la lista
	 * @param p la persona que queremos introducir
	 */
	public void add(Videojuego p) {
		p.setId(contador++);
		listaVideojuegos.add(p);
	}
	
	/**
	 * Borramos una persona de una posicion del array
	 * @param posicion la posicion a borrar
	 * @return devolvemos la persona que hemos quitado del array, 
	 * o null en caso de que no exista.
	 */
	public Videojuego delete(int posicion) {
		try {
			return listaVideojuegos.remove(posicion);
		} catch (Exception e) {
			System.out.println("delete -> Persona fuera de rango");
			return null;
		}
	}
	
	/**
	 * Metodo que modifica una persona de una posicion del array
	 * @param p contiene todos los datos que queremos modificar, pero 
	 * p.getId() contiene la posicion del array que queremos eliminar
	 * @return la persona modificada en caso de que exista, null en caso
	 * contrario
	 */
	public Videojuego update(Videojuego p) {
		try {
				Videojuego pAux = listaVideojuegos.get(p.getId());	
				pAux.setNombre(p.getNombre());
				pAux.setCompañia(p.getCompañia());
				pAux.setNota(p.getNota());
			
			return pAux;
		} catch (IndexOutOfBoundsException iobe) {
			System.out.println("update -> Persona fuera de rango");
			return null;
		}
	}
	
	/**
	 * Metodo que devuelve todas las personas por nombre. Como puede
	 * haber varias personas con el mismo nombre (HARRY) tengo que
	 * devolver una lista con todas las encontradas
	 * @param nombre representa el nombre por el que vamos a hacer la
	 * busqueda
	 * @return una lista con las personas que coincidan en el nombre.
	 * La lista estará vacia en caso de que no hay coincidencias
	 */
	public List<Videojuego> listByName(String nombre){
		List<Videojuego> listaPersonasAux = new ArrayList<Videojuego>();
		for(Videojuego p : listaVideojuegos) {
			if(p.getNombre().equalsIgnoreCase(nombre)) {
				listaPersonasAux.add(p);
			}
		}
		return listaPersonasAux;
	}
}
