package contact;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import javax.swing.plaf.synth.SynthSplitPaneUI;

public class contact {

	
	// 반환용 리스트 변수
    static List<String> ret = new ArrayList<>();
	
	public static void load(String string) {
		// 입력 스트림 오브젝트 생성
        BufferedReader br = null;
        try {
			br = Files.newBufferedReader(Paths.get("D:\\workspace\\addressBook\\test\\src\\test\\" + string),Charset.forName("UTF-8"));
	        String line = "";
            while((line = br.readLine()) != null) {
            	ret.add(line);
            }
        } catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String[][] findUniqueNum(String string) {

		String[][] nameNum = new String[ret.size()][2];
		
		List<String> arr1 = new ArrayList<String>();
		List<String> arr2 = new ArrayList<String>();
		
		for(int i=0; i<ret.size(); i++){
			int temp = ret.get(i).indexOf(",");
			String name = ret.get(i).substring(0, temp).replace("\uFEFF", "").trim();
			String num = ret.get(i).substring(temp+1, ret.get(i).length());
			arr1.add(name);
			arr2.add(num);
		}
		
		int temp = 0;
		for(int x=0; x<arr1.size(); x++){
			if(arr1.get(x).contains(string)){
				nameNum[temp][0] = arr1.get(x);
				nameNum[temp][1] = arr2.get(x);
				temp++;
			}
		}
		
		return nameNum;
	}
	
	public static int findMyName(String string) {
		
		int answer = 0;
		
		HashMap<String, Integer> hm = new HashMap<>();
		for(int i=0; i<ret.size(); i++){
			int temp = ret.get(i).indexOf(",");
			String name = ret.get(i).substring(0, temp).replace("\uFEFF", "").trim();
			hm.put(name, hm.getOrDefault(name, 0) +1);  
		}
		
		if(hm.keySet().contains(string)){
			answer = hm.get(string);
		}else{
			answer = 0;
		}
		
		return answer;
	}

}
