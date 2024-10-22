package Encapsulationdatahidingjava;  
                       
public class Student { 
	// So , Variables and set and getmethods in 1 class 
	//Abstraction is more about “What” a class can do.
	//Encapsulation is more about “How” to achieve a functionality
	//Functionality :- methods, data - variable .                 Pass by value , pass by reference 
    // directly dont initialize, private enables the data hiding,
	// can accessible with the methods defined in the class. no other class/object can access them. 
    // 1st encapsulation(data hiding)-> no direct initializaion , 2. inheritance  
    //3. polymorphism(Compile time polymorphism ,Run time poly) 
	// 4. abstraction(abstract(Old ) java 8 implementation,interface)->common methods/code repeat
	
	private String Sid;
	private String Sname;
	
	
	//other codes also u can implement here !
	//accessor and mutator -> getter and setter , create , view, retriew , modify delete 
	public void setSname(String sname) { //similar to constructor 
		this.Sname = sname;
	}
	
	public void setSid(String id) {
		Sid = id;
	}
	

	
	public String getSid() {
		return Sid;
	}
	
	public String getSname() {
		return Sname;
	}

}
