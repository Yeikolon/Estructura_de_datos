package model;

public class StackNode {
	private Object element;
	private StackNode next;
	
	StackNode(Object x){
		element = x;
		next = null;
	}
	
	public void setElement(Object element) {
		this.element = element;
	}
	
	public void setNext(StackNode next) {
		this.next = next;
	}
	
	public Object getElement() {
		return element;
	}
	
	public StackNode getNext() {
		return next;
	}
}
