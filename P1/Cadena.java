import java.util.*;
public class Cadena{
	private String cadena;
	private boolean valida;
	//constructores
	public Cadena(String cadenamgee){
		cadena=cadenamgee;
		valida=false;
	}

	//métodos

	//orasisi esta es la perra función mamalona que valida y hace todo lo de los caminos
	public void Validar(Linea states, Linea finalstates, Linea initialstate, Linea alphabet, Transition set, String actual, int ind, ArrayList<String> oldlist_camino, ArrayList<String> oldlist_errores){
		ArrayList<String> newlist_camino = new ArrayList<String>(oldlist_camino);		//se crea un nuevo arraylist<string> para ir guardando el camino que contiene lo que se recibió en oldlist_camino
		ArrayList<String> newlist_errores = new ArrayList<String>(oldlist_errores);		//se crea un nuevo arraylist<string> para ir guardando manejo de errores que contiene lo que se recibió en oldlist_errores
		//System.out.println("Entró a validar");//prueba
		char[] chtkn=this.cadena.toCharArray();	//convertir la cadena a un array de chars
		if(ind==chtkn.length){					//si ya se terminó la cadena
		//	System.out.println("ind==chtknlength");//testing
			if(finalstates.dameelarraywe().contains(actual)) {	//Si el estado actual es parte de los estados finales
				this.valida=true;								//establece la cadena como válida
				//Lo que sale a consola
				System.out.println("Válida");					
				System.out.print("\tCamino: \n\t");
				System.out.println(newlist_camino);				//imprime el camino tomado con el que se logró validar la palabra
				System.out.print("\tM.E.: \n\t");
				System.out.println(newlist_errores);			//imprime el manejo de errores
			}

		}
		else{									//si no se ha terminado la cadena
		//	System.out.println("Entró al else perro");//prueba	mgee
			String tempchartkn=Character.toString(chtkn[ind]);	//Guardar en un string el caracter en el que vamos de la cadena
		//	System.out.println(tempchartkn);//prueba

			//manejo de errores
			if (!(alphabet.dameelarraywe().contains(tempchartkn))) {	//si el caracter ni siquiera forma parte del alfabeto definido
		//		System.out.println("Entró a manejo de errores con el caracter desconocido: "+tempchartkn);	//prueba
				newlist_errores.add(""+actual+" ("+tempchartkn+")");	//añades el estado en el que estás actualmente y el caracter desconocido a la lista de manejo de errores
				this.Validar(states, finalstates, initialstate, alphabet, set, actual, ind+1, newlist_camino, newlist_errores);	//RECURSIÓN a Validar, se queda en el mismo estado y avanza al siguiente caracter
			}
			else{														//si el caracter si forma parte del alfabeto definido
				for (int j=0; j<set.CuantasRows(); j++) {	//este for recorre las rows del set de transición
					//el siguiente if checa que en la row actual (j) exista la combinación del estado actual con el caracter actual
					if ((actual.equals(set.singleelement_of_a_row(j,0)))&&(tempchartkn.equals(set.singleelement_of_a_row(j,1)))/*&&(!(set.singleelement_of_a_row(j,2).equals("EE")))*/) {
//						System.out.println("Se encontró la combinación deseada, siendo estado actual: "+actual+" , simbolo: "+tempchartkn+" , siguiente estado será: "+set.singleelement_of_a_row(j,2));//testing
						actual=set.singleelement_of_a_row(j,2);		//ahora nuestro estado actual será el estado siguiente, que nos lo da la row de la función de transición
						newlist_camino.add(actual);					//añadir dicho estado al arraylist que va guardando el camino
						this.Validar(states, finalstates, initialstate, alphabet, set, actual, ind+1, newlist_camino, newlist_errores);	//RECURSION a Validar, con el nuevo estado actual y avanzando al siguiente caracter
						newlist_camino.remove((newlist_camino.size())-1);	//ya que se haya terminado el camino anterior, regresará aquí, y quitas el estado que lo mando al otro camino, del array que guarda el camino
					}
				}
			}
		}
	}
}