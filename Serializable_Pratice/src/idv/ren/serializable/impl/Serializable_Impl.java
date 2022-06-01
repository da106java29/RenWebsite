package idv.ren.serializable.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import idv.ren.serializable.bean.Animal_Bean;

public class Serializable_Impl {
	
	private static final String fileName = "D:/Animal_Bean.txt";
	
	public static void main(String[] args) {
		
		
		try (
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
		){
			
			Animal_Bean anm = new Animal_Bean("Cat", "Dragon");
			
			System.out.println("The First Object is :" + anm);
			
			oos.writeObject(anm);
			fos.flush();
		
		}catch(FileNotFoundException fe) {
			fe.printStackTrace();
			System.out.println("Write the Object throw FileNotFoundException!");
		}catch(IOException ioe) {
			ioe.printStackTrace();
			System.out.println("Write the Object throw This is IOException");
		}
		
		try(FileInputStream  fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis);
		){
		
			Animal_Bean anm2 = null;
			
			anm2 = (Animal_Bean) ois.readObject();
			
			System.out.println("The read Object is : " + anm2.toString());
			
		}catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}catch(ClassNotFoundException cfe) {
			cfe.printStackTrace();
		}
		
	}

}
