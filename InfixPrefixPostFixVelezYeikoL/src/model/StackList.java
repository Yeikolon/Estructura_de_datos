package model;


public class StackList {
private StackNode cime;
	
	public StackList() {
		cime = null;
	}
	
	//Verificar si la pila esta vacia
	public boolean emptyPile() {
		return cime == null;
	}
	
	//Insertar un elemento en la cima (PUSH)
	public void pushPila(Object element) {
		StackNode newPile;
		newPile = new StackNode(element);
		newPile.setNext(cime);
		cime = newPile;
	}
	
	//Eliminar el elemento de la cima (POP)
	public Object popPila() throws Exception{
		if(emptyPile()) {
			throw new Exception("Empty pile, cannot be extracted");
		}
		Object aux = cime.getElement();
		cime = cime.getNext();
		return aux;
	}
	
	//Obtener elemento de la cima con Exception
	public Object cimePile2() throws Exception{
		if(emptyPile()) {
			throw new Exception("Pila vacia, no se puede leer la cima");
		}
		return cime.getElement();
	}
	
	//Obtener elemento de la cima con Funcion de tipo nodo para no hacer el control
	public StackNode cimePile() {
		StackNode aux = null;
		if(!emptyPile()) {
			aux = cime;
		}
		return null;
	}
	
	//Vaciar pila
	public void cleanPile() {
		StackNode t;
		while(!emptyPile()) {
			t = cime;
			cime = cime.getNext();
			t.setNext(null);
		}
	}
}
