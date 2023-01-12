package com.singleton.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SingletonSerializedTest implements Serializable {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {

		try {

			// Step 4 : Call Singleton Class Method
			Singleton instance1 = Singleton.getSingletonObject();

			// Step 5 : Serialized
			ObjectOutput output = new ObjectOutputStream(
					new FileOutputStream("C:\\Users\\Stars\\Desktop\\JavaWorkSpace\\exp.txt"));

			output.writeObject(instance1);
			output.close();

			// Step 6 : DeSerialized
			ObjectInput input = new ObjectInputStream(
					new FileInputStream("C:\\Users\\Stars\\Desktop\\JavaWorkSpace\\exp.txt"));

			Singleton instance2 = (Singleton) input.readObject();
			input.close();

			// Step 7 : Print
			System.out.println("Instance 1 > " + instance1.hashCode());
			System.out.println("Instance 2 > " + instance2.hashCode());

			/*
			 * Output : Instance 1 > 644117698 Instance 2 > 644117698
			 */

		} catch (Exception e) {

			System.out.println(e);

		}

	}

}
