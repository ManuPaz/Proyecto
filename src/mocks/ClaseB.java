package mocks;

public class ClaseB {
	ClaseA ca;

	public ClaseB() {
		super();
	}
	public void setCa(ClaseA ca) {
		this.ca = ca;
	}
	public int met1() {
		ca.func1();
		ca.func1();
		return ca.func3(5, 6);
	}
	public void met2() {
	ca.func2();
	}
}
