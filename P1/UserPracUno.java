import java.util.*;
import java.io.*;
public class UserPracUno{
	public static void main(String[] args) {

		/*
		//Ingresar por consola el nombre del archivo
		Scanner entrada = new Scanner(System.in); 
		String input=entrada.nextLine();*/

		try{
			File archi = new File("prueba.txt");	//abrir archivo
			Scanner lectorl = new Scanner(archi);	//lectorl= lector de línea, para ir leyendo linea por linea

			//Crear objetos del datatype Linea
			Linea states, finalstates, initialstate, alphabet; 
			states=new Linea(lectorl.nextLine());			//estados
			finalstates=new Linea(lectorl.nextLine());		//estados finales
			initialstate=new Linea(lectorl.nextLine());		//estado inicial (debería ser solo uno)
			alphabet=new Linea(lectorl.nextLine());			//alfabeto

			//empezar la parte de la función de transición
			Transition set=new Transition();	//set va a ser todo el conjunto de funciones de transición
			while(lectorl.hasNextLine()){
				Linea templine = new Linea(lectorl.nextLine());		//templine = auxiliar para generar un objeto tipo línea
				set.addLine(templine);								//y después añadir esa línea al set de transiciones
			}

			set.completar(states, alphabet);	//función para completar el set de transiciones

			System.out.print("Q : ");
			System.out.println(states);
			System.out.print("F : ");
			System.out.println(finalstates);
			System.out.print("S : ");
			System.out.println(initialstate);
			System.out.print("E : ");
			System.out.println(alphabet);
			System.out.println("Transiciones :");
			set.imprimirT();						//prueba

			System.out.println("Ingresar cadena a validar:");
			Scanner entrada = new Scanner(System.in); 
			String input=entrada.nextLine();
			Cadena diswe = new Cadena(input);		//diswe: objeto tipo cadena
			
			ArrayList<String> mgee=new ArrayList<String>();		//array vacío para caminos
			ArrayList<String> bolt2=new ArrayList<String>();	//array vacío para manejo de errores
			//diswe.Validar(states, finalstates, initialstate, alphabet, set, initialstate.singleelement(0), okok, 0);
			mgee.add(initialstate.singleelement(0));		//inicializa el array de camino con el estado inicial
			diswe.Validar(states, finalstates, initialstate, alphabet, set, initialstate.singleelement(0),0,mgee,bolt2);	//con esto se valida todo así bien sabroso


		} catch (FileNotFoundException a){
			System.out.println("Error al abrir el archivo");
			a.printStackTrace();
		}

	}
}