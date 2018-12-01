import java.io.File;

public class MultipleUnrar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File[] files = new File("C:/").listFiles();
	    showFiles(files);

	}



public static void showFiles(File[] files) {
    for (File file : files) {
        if (file.isDirectory()) {
            System.out.println("Directory: " + file.getName());
            showFiles(file.listFiles()); // Calls same method again.
        } else {
            System.out.println("File: " + file.getName());
        	}
    	}
	}




}