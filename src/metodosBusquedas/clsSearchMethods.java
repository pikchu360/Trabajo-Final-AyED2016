package metodosBusquedas;

import java.util.ArrayList;
import java.util.List;

public class ClsSearchMethods {
	
	private String patron;
	private String texto;
	private int ocurrencia;
	private int tiempoDemora;
	
	public ClsSearchMethods(String ptr, String tex){
		patron = ptr;
		texto = tex;
		this.ocurrencia=0;
	}
	public ClsSearchMethods(){
		this.ocurrencia=0;
	}
	
	//Get's and Set's methods
	public void setPatron(String ptr){
		patron = ptr;
	}
	public String getPatron(){
		return patron;
	}
	
	public void setTexto(String tex){
		texto = tex;
	}
	public String getTexto(){
		return texto;
	}
	public int getOcurrencia(){
		return this.ocurrencia;
	}
	public int getTiempoDemora(){
		return this.tiempoDemora;
	}
	
	public List <Integer> buscarFuerzaBruta(){
		boolean flag=false;
		List <Integer> posicionesPatron = new ArrayList<Integer>();
		for(int i=0; i<texto.length(); i++){
			int it=i,ip=0,pos=it;
			while( ip<patron.length()){
				if(texto.toLowerCase().charAt(it)==patron.toLowerCase().charAt(ip)){
					flag=true;
					it++;
				}else{
					pos=0;
					flag=false;
					ip=patron.length();
				}
				ip++;
			}
			if(flag){ 
				this.ocurrencia++;
				posicionesPatron.add(pos);
			}
			
		}
		this.tiempoDemora=texto.length()*patron.length();
		return posicionesPatron;
	}
	
	//Boyer More methods's
/*	public int[] preBmBc(char[] x) { //Crea lista con el tamañao del patron
		
		int[] bmBC;
		int m = x.length;
		bmBC = new int[ALPHABET_SIZE];

		Arrays.fill(bmBC, m);

		for (int i = 0; i < m - 1; i++) {
			bmBC[x[i]] = m - i - 1;
		}
		return bmBC;
	}

	public int[] suffixes(char[] x) {
		
		int m = x.length;
		int suff[] = new int[m];
		int g = m - 1;
		int f = m - 1;

		suff[m - 1] = m;

		for (int i = m - 2; i >= 0; --i) {
			if (i > g && (i + m - 1 - f) < m && suff[i + m - 1 - f] < i - g) {
				suff[i] = suff[i + m - 1 - f];
			} else {
				//if (i < g) {
				g = i;
				//}
				f = g;
				while (g >= 0 && x[g] == x[g + m - 1 - f]) {
					--g;
				}
				suff[i] = f - g;
			}
		}
		return suff;
	}

	public int[] preBmGs(char[] x) {
		
		int[] bmGs;
		int m = x.length;
		bmGs = new int[m];

		int suff[] = suffixes(x);
		Arrays.fill(bmGs, m);

		int j = 0;
		for (int i = m - 1; i >= -1; --i) {
			if (i == -1 || suff[i] == i + 1) {
				for (; j < m - 1 - i; ++j) {
					if (bmGs[j] == m) {
						bmGs[j] = m - 1 - i;
					}
				}
			}
		}
		for (int i = 0; i < m - 1; i++) {
			bmGs[m - 1 - suff[i]] = m - 1 - i;
		}
		return bmGs;
	}
	
	public List<Integer> search() {
		
		int[] bmGs;
		int[] bmBC;
		char[] y = texto.toCharArray();
		char[] x = patron.toCharArray();
		int n = y.length; // string length
		int m = x.length; // pattern length
		List<Integer> resultado = new ArrayList<Integer>();

		int j = 0;
		int i = 0;
		comparisons = 0;

		// Precompute 
		bmBC=preBmBc(x);
		bmGs=preBmGs(x);	

		/* Searching 
		while (j <= n - m) {
			for (i = m - 1; i >= 0 && x[i] == y[i + j]; i--) {
				comparisons++;
			}

			if (i < 0) {
				resultado.add(j);
				j += bmGs[0];
			} else {
				j += Math.max(bmGs[i], bmBC[y[i + j]] - m + 1 + i);
			}

		}

		return resultado;
	}
	
*/
	//Method Test
	public static void main(String []args){
		
		ClsSearchMethods buscar = new ClsSearchMethods();
		
		String texto="Algoritmo de analisis algoritmicos";
		String patron="algo";
		
		buscar.buscarFuerzaBruta();
		
		System.out.println("Texto: "+texto+"\nPatron: "+patron);
		System.out.println("Ocurrencia: "+buscar.getOcurrencia()+"\nTiempo de Espera: "+buscar.getTiempoDemora());
	}
}
