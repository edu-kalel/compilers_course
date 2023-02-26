import java.util.*;
public class Cadena{
	private String cadena;
	private boolean valida;

	//constructores
	public Cadena(String cadena){
		this.cadena=cadena;
		valida=false;
	}


	//métodos

	public void Validar(Linea states, Linea finalstates, Linea initialstates, Linea alphabet, Transition set, String actual, ArrayList<String> oldlist, int ind){
		ArrayList<String> newlist = new ArrayList<String>(oldlist);
		char[] chtkn=this.cadena.toCharArray();
		for (int i=0; i<set.CuantasRows; i++) {
			String tempchartkn=Character.toString(chtkn[ind]);
			if ((!(actual.equals("EE")))&&(actual.equals(set.singleelement_of_a_row(i,0)))&&(tempchartkn.equals(set.singleelement_of_a_row(i,1)))) {
				newlist.add(set.singleelement_of_a_row(i,2));
			}
		}
		ind++;
		if (newlist.size()!=0) {
			for (int j=0; j<newlist.size(); j++) {
				if (newlist.size()>1) {
					System.out.println(actual);
				}
				System.out.println(newlist.get(j));
				if ((ind!=this.cadena.length())&&(newlist.get(j).equals("EE"))) {
					Validar(states, finalstates, initialstates, alphabet, set, newlist.get(j), newlist, ind);
				}
				else{
					if (newlist.get(j).equals(finalstates.singleelement(0))) {
						System.out.println("validawe");
					}
					else{
						System.out.println("nowe");
					}
					System.out.println("xd");
				}
			}
		}
		//this.camino1=camino1;
	}
	/*
	public void Validar(Linea states, Linea finalstates, Linea initialstate, Linea alphabet, Transition set){
		int i =0, posibles_caminos=0;
		String actual_state=initialstate.singleelement(0);
		char[] chtkn=this.cadena.toCharArray();
		Caminos posibilidades=new Caminos();
		for (char s : chtkn) {
			i++;
			int caminopadre=0;
			for (int k=0; k<set.CuantasRows; k++) {
				if ((actual_state.equals(set.singleelement_of_a_row(k,0)))&&(s.equals(set.singleelement_of_a_row(k,1)))&&(!(set.singleelement_of_a_row(k,2).equals"EE"))) {
					caminopadre++;
					posibilidades.AddCamino(actual_state, set.singleelement_of_a_row(k,2),caminopadre);
					posibles_caminos++;
				}
			}
		}
		
	}
	*/

}