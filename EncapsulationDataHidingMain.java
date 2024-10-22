package Encapsulationdatahidingjava;

public class EncapsulationDataHidingMain {    

	public static void main(String[] args) {
		Student value = new Student();
		
		
		
	value.setSid("ID01");
		value.setSname("John");
		
		value.setSid("ID02");
		value.setSname("Smith");
		

		value.setSid("ID03"); //Latest value is displayed 
		value.setSname("Sandy");
		

		System.out.println(value.getSid()); //ID03
		System.out.println(value.getSname());//Sandy
		
	}

}
