package chapter9;

/**
 * ʵ����ֻ��һ��������������ѡ��ֻ��A������һ��Ĭ�Ϸ����������� ���ӿ���D�ĸ��ӿ�
 * 
 * @author YJP
 *
 */
public class LingxingExtends implements B3, C3 {

	public static void main(String[] args) {
		new LingxingExtends().hello();
	}

	@Override
	public void hello() {
		// TODO Auto-generated method stub
		
	}

}

interface A3 {
	default void hello() {
		System.out.println("Hello from A3");
	}
}

interface B3 extends A3 {
	default void hello() {
		System.out.println("Hello from B3");
	}
}

interface C3 extends A3 {
	public abstract void hello();
}