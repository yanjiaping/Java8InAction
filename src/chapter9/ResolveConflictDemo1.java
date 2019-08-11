package chapter9;

/**
 * (1) ���еķ������ȼ���ߡ�������������ķ��������ȼ������κ�����ΪĬ�Ϸ������� �ȼ���
 * (2) ����޷����ݵ�һ�������жϣ���ô�ӽӿڵ����ȼ����ߣ�����ǩ����ͬʱ������ѡ�� ӵ�������ʵ�ֵ�Ĭ�Ϸ����Ľӿڣ������B�̳���A����ôB�ͱ�A���Ӿ��塣
 * (3) �����������޷��жϣ��̳��˶���ӿڵ������ͨ����ʽ���Ǻ͵��������ķ�������ʽ��ѡ��ʹ����һ��Ĭ�Ϸ�����ʵ�֡�
 *
 */
public class ResolveConflictDemo1 extends D implements B, A {

	public static void main(String[] args) {
		new ResolveConflictDemo1().hello();
	}

}

interface A {
	default void hello() {
		System.out.println("Hello from A");
	}
}

interface B extends A {
	default void hello() {
		System.out.println("Hello from B");
	}
}

abstract class D implements A {
	public void hello() {
		System.out.println("Hello from D");
	}
}

/*
 * ResolveConflictDemo1����ʵ��D���еĳ��󷽷�
 * abstract class D implements A { public abstract void hello(); }
 */
