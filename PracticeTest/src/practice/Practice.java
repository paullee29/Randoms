package practice;

public class Practice {

	public static void main(String[] args) {
		System.out.println(firstDuplicate ( ));


	}
	
	public static int firstDuplicate() {
		int [] a = {2, 1,15, 15, 3, 5, 3, 2,15, 15};
	    for(int i=0;i<a.length;i++) {
	//    	System.out.println(a[Math.abs(a[i])-1]);
	        if(a[Math.abs(a[i])-1]<0)
	            return Math.abs(a[i]);
	        else{
	            a[Math.abs(a[i])-1]=-a[Math.abs(a[i])-1];
	        }
	    }
	    
	    for (int i = 0; i<a.length; i++) {
//	    System.out.print(a[i]+", ");
	    
	    }
	    return -1;
	}
	
	public static void minimalDup () {
		int [] a = {2, 1, 3, 5, 3, 2};
		
	    int bestindex = a.length;
	    int currentindex = -1;
	    int dup = -1;
	    int zz = 1;
	    int z = 1;

	    for (int i =0; i<bestindex; i++) {
	    	z = zz;
	        while (z<a.length) {
	            if (a[i]==a[z]) {
	                currentindex = z;

	                if (currentindex <bestindex) {
	                    dup = a[z];
	                    bestindex = z;
	                    break;
	                }
	            }
		        z++;
	        }
	        zz ++;

	    }
	    System.out.println(dup);
	}
	
	
	public static char firstNotRepeatingChar ( ) {
	    String s = "abacabad";
		char a = '_';
	    for (int i = 0; i<s.length(); i++) {
	        for (int b=1; b<s.length();b++) {
	        	if (s.charAt(i)!=s.charAt(b)) {
	        		return s.charAt(i);

	        	}
	        }
	    }
	    return a;
	}

}
