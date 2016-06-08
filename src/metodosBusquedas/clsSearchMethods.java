package metodosBusquedas;

public class clsSearchMethods {
	
	private String patron;
	private String texto;
	
	public clsSearchMethods(String ptr, String tex){
		patron = ptr;
		texto = tex;
	}
	
	public void setPatron(String ptr){
		patron = ptr;
	}
	public String getPatron(){
		return patron;
	}
	
	public void setTexto(String tex){
		texto = tex;
	}
	public String setTexto(){
		return texto;
	}
	
	
	
}
