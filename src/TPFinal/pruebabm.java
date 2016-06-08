package TPFinal;

public class pruebabm {
static String patron;
static String cad;
static int pos;
private static int abecedarios[];

static int BusquedaCadena(String patron,String cad){
//probando git
	abecedarios = new int [256];
	int i,j,k; 
	char c;       
	pos=-1;
	//boolean r;
	//r=false;

	for (i= 0; i<=255; i++) {
		abecedarios[i]=patron.length();
	}
	for (i=0; i< patron.length()-1; i++) {
		abecedarios[(int)(patron.charAt(i))]=patron.length()-i; 
	}

	//return false;   
	i=patron.length()-1;    
	j=i;
	k=i;
	c=cad.charAt(k);
	// System.out.println("pat " + patron + " // cad "  + cad);
	while ((j>=0) && (k<cad.length())) {
		System.out.println(" i " + i + "j"  + j);
		System.out.println("pat " + patron.charAt(j) + " cad " + cad.charAt(i));
		if (patron.charAt(j)!= cad.charAt(i)){
			//si hay discrepancia saltar segun abecedario 
			k=k+abecedarios[(int)(c)];        
			i=k;   
			c=cad.charAt(k);
			j=patron.length()-1;
		}    
		else {  
			//caso contrario comparar hacia atras.  
			i=i-1;
			j=j-1;
		} 
		if (j==0) {
			pos=i+1;
		}
	}
	return pos;
}
  

public static void main(String args[]) {
	
	cad=("Hola en ingles se escribe asi: hello"); 
	patron=("hello");

	int pos = (BusquedaCadena(patron,cad));
	if (pos >=0) {
		System.out.printf("Se encontro en : " + pos);
	}
	else {
		System.out.printf("no se encontro");       
	}
}

}