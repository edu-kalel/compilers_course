//Para todo lo de la función de transición
import java.util.*;
public class Transition{
	private ArrayList<Linea> rows =new ArrayList<Linea>();	//El set de transiciones contiene n número de filas, cada fila contiene una linea con 3 elementos
	private int numrows;				//numero de filas

	//constructores
	public Transition(){		//crear e inicializar el set de transiciones con 0 filas
		numrows=0;
	}

	//métodos
	public void addLine(Linea nuevalinea){		//añade una línea con n numero de elementos (se supone que deberían ser 3) a una nueva fila
		rows.add(nuevalinea);
		numrows++;								//incrementa en uno el número de filas en el set
	}

	public void imprimir(){						//imprime todas las funciones de transición y cuántas hay
		System.out.println(numrows);
		System.out.println(rows);
	}

	public void imprimirT(){					//imprime las funciones de transición más ordenadito, por rows
		for (Linea mgee : rows) {
			System.out.println(mgee);
		}
	}

	public void completar(Linea states, Linea alphabet){					//completa las transiciones
		boolean eecreado=false;												//ee=Estado de error, flag para ver si fue necesario crearlo
		for (int i=0; i<(states.howmany()); i++) {							//este for es para recorrer los estados
			String temp_estado = states.singleelement(i);					//temp para guardar el estado
			for (int j=0; j<(alphabet.howmany()); j++) {					//este for recorre los símbolos del alfabeto\mgee
				String temp_symbol = alphabet.singleelement(j);				//temp para guardar simbolo
				boolean existe=false;										//existe: flag para indicar si la combinación de estado con simbolo existe
				for (int k=0; k<numrows; k++) {								//este for recorre las filas (Rows) que se proporcionaron para la función de transición
					String temp_estado_tran = (rows.get(k).singleelement(0));	//obtiene el primer elemento (estado) de la fila k del set de transiciones
					String temp_symbol_tran = (rows.get(k).singleelement(1));	//obtiene el segundo elemento (símbolo) de la fila k del set de transiciones
					if ((temp_estado.equals(temp_estado_tran))&&(temp_symbol.equals(temp_symbol_tran))) {	//si la combinación del estado "i" con el símbolo "j" existe en el set de transiciones
						existe=true;																		//flag de existe cambia a true
						break;												//sale del ciclo for que recorre las filas, si ya se encontró al menos una vez la combinación buscada, no es necesario seguir buscándola
					}
				}
				if (!existe) {												//si resulta que no existe la combinación buscada
					Linea templine1=new Linea(temp_estado, temp_symbol, "EE");	//se crea una nueva linea, con la combinaciónd de estado "i" y símbolo "j", el estado siguiente será el estado de error
					this.addLine(templine1);								//se agrega la nueva línea creada al set de transiciones
					eecreado=true;										//la flag de "estado de error creado?" cambia a true
				}
			}
		}
		if (eecreado) {									//si se creó el estado de error
			for (int j=0; j<alphabet.howmany(); j++) {	//este for recorre los símbolos del alfabeto
				String temp_symbol = alphabet.singleelement(j);	//temp almacena el símbolo
				Linea templine1=new Linea("EE", temp_symbol, "EE");	//Nueva línea, estado inicial: EE, símbolo j y estado final EE
				this.addLine(templine1);				//añade la nueva línea al set de transiciones
			}
		}
	}

	public int CuantasRows(){	//regresa cuántas rows hay
		return numrows;
	}

	public String singleelement_of_a_row(int ind, int ind_1){	//regresa un solo elemento de la row deseada. ind es la row seleccionada e ind_1 el número de elemento en esa row
		return (rows.get(ind).singleelement(ind_1));
	}
}