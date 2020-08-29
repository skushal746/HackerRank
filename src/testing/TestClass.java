package testing;

public class TestClass {
	
    public static void main(String []args) {
        B b = new B();
        b.foo1();
        
        
    }
    
}

class B extends A{
	void foo2() {System.out.println("Inside class B foo2");}
	
	void printFoo1() {
		foo1();
	}
}

class A {
	public static String  yolo = "skjghkdjsbg";
    private void foo() {System.out.println("Inside class A");}
    void foo1() {System.out.println("Inside class A foo1");}
    void foo2() {System.out.println("Inside class A foo2");}
}

