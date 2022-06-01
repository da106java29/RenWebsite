package idv.ren.serializable.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import idv.ren.serializable.bean.Animal_Bean;

public class Serializable extends Serializable_Impl {

	public void doSerializable(Object obj, String fileName) {

		if (isSerializable(obj)) {
			try (FileOutputStream fos = new FileOutputStream(fileName);
					ObjectOutputStream oos = new ObjectOutputStream(fos);) {

//				Animal_Bean anm = new Animal_Bean("Cat", "Dragon");

				System.out.println("The First Object is : " + obj);

				oos.writeObject(obj);
				fos.flush();

			} catch (FileNotFoundException fe) {
				fe.printStackTrace();
				System.out.println("Write the Object throw FileNotFoundException!");
			} catch (IOException ioe) {
				ioe.printStackTrace();
				System.out.println("Write the Object throw This is IOException");
			}
		}else {
			System.out.println("Could not Serializable the class");
		}

	}

}
