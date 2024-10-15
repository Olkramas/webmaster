package chap07.CalcForOverride240930;

public class Computer extends Calculator{
	
	//메소드 재정의
	@Override
	double areaCircle(double r) {		
		return Math.PI * r * r;
	}
	
	
	//super.은 자식 클레스에서만 사용가능.
	//super.(부모클래스 메소드)
	double ac(double r) {
		if(r >= 10) {
			double rs = super.areaCircle(r);
			return rs;
		} else {
			double rs = areaCircle(r);
			return rs;
		}
	}
	
	
}
