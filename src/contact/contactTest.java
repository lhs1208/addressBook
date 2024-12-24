package contact;

public class contactTest {

	public static void main(String[] args) {
		contact contatct = new contact();
		oneData();
		manyData();
		noName();
	}
	
	//이름이 한개일때
	public static void oneData(){
		contact.load("test1.csv");
		//이름이 홍길동인 사람이 몇명인지 보내준다.
		System.out.println("oneData >> " + contact.findMyName("Hong gildong"));
	}
	
	//이름이 여러명일떄
	public static void manyData(){
		
		//분명 어디서는 총 주소록이 몇개인지 재는게 있었는데 기억이 안나네
		//여기서 중복된 이름은 1개로 치는 그런 문제였는데
		
		contact.load("test2.csv");
		//중복된 홍길동은 1개로 친다.
		//이름이 홍길동인 사람의 번호가 몇개인지 보내준다.
		System.out.println("manyData >> " + contact.findMyName("hong gildong"));
		
		int count = contact.findMyName("hong gildong");
		
		String[][] nameNum = new String[count][2];
		//이름데이터를 보내주면 이름과 번호를 보내준다.
		nameNum = contact.findUniqueNum("hong gildong");
		
		for(int i=0; i<count; i++){
			String temp = nameNum[i][0] + "," + nameNum[i][1]; 
			System.out.println(temp);
		}
		
	}
	
	//이름이 없을때
	public static void noName(){
		contact.load("test2.csv");
		System.out.println("noName >> " + contact.findMyName("없는이름"));
	}

}
