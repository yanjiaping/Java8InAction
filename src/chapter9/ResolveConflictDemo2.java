package chapter9;

public class ResolveConflictDemo2 implements A2, B2 {

	public static void main(String[] args) {
		new ResolveConflictDemo2().hello();

	}

	@Override
	public void hello() {
		A2.super.hello();
		B2.super.hello();
	}

}

interface A2 {
	default void hello() {
		System.out.println("Hello from A2");
	}
}

interface B2 {
	default void hello() {
		System.out.println("Hello from B2");
	}
}