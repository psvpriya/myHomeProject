package leetcode;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*String s1 = new String("String 1");
		String s2 = "String 1";
		if (s1 == s2) {
		    System.out.println("Equal");
		} else {
		    System.out.println("Not equal");
		}
		
		String text = new String("My ");
		text.concat("String");
		System.out.println(text);
		
		Test t = new Test();
		t.mystery("Hello How are you");*/
		
		StringBuffer sb = new StringBuffer("start");
		System.out.println(sb.insert(5, "le").toString());
		System.out.println(sb.insert(0, 'x').toString());

		StringBuffer sb2 = new StringBuffer("Tword");
		System.out.println(sb2.deleteCharAt(0));
		System.out.println(sb2.deleteCharAt(3));
	}
	
	
	public int mystery(String s)
	{
	    char[] letters = s.toCharArray();
	    int x = 0;
	    for (int i = 0; i < letters.length; i++) {
	        if (letters[i] == ' ') {
	           letters[i] = '_';
	           x++;
	        }
	    }
	    
	    for (int i = 0; i < letters.length; i++) {
	    	System.out.println(letters[i]);
	    }
	    return x;
	}

}
