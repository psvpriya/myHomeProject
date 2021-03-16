package leetcode.q811;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution811 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution811 obj = new Solution811();
		String[] cpdomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
		List<String> output = obj.subdomainVisits(cpdomains);
		System.out.println(output);
	}


	public List<String> subdomainVisits(String[] cpdomains) {

		HashMap<String, Integer> domainVisit = new HashMap<String, Integer>();
		
		for(String cpdomain: cpdomains) {
			String[] str = cpdomain.split(" ");
			Integer count = Integer.parseInt(str[0]);
			String domain = str[1];
			int startIndex = -1;
			do {
				domain = domain.substring(startIndex+1, domain.length());
				Integer value = null;
				
				if(domainVisit.containsKey(domain)) {
					value = domainVisit.get(domain)+count;
				} else {
					value = count;
				}
				domainVisit.put(domain, value);
				startIndex = domain.indexOf(".");
			}while(startIndex > -1) ;
		}
		
		ArrayList<String> strings = new ArrayList<String>();
		for(String key : domainVisit.keySet()) {
			strings.add(domainVisit.get(key).toString()+" "+key);
		}



		return strings;
	}

}
