package idv.ren.serializable.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import idv.ren.serializable.bean.Animal_Bean;

public class DeSerializable extends Serializable_Impl{

	public void doDeSerializable(Object obj, String fileName) {
		
		if(isSerializable(obj)) {
			
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
			
		}else {
			System.out.println("Could not DeSerializable class!!");
		}
		
	}
	
}
