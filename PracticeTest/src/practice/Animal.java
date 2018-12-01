package practice;

abstract class Animal {
	
	public static void main (String args[]) {
		Animal animal = new Animal ();
		animal.sayHello();
	}
	
	abstract void sayHello();

}
