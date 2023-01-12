/* Singleton design pattern :
It means define the class which has single instance that provide the global point of access to it called as singleton design pattern. */

package com.singleton.demo;

import java.io.Serializable;

public class Singleton implements Cloneable, Serializable {

	// Step-1 : Create class singleton and static member of class.
	private static Singleton singletonObject;

	// Step-2 : Make constructor as private
	private Singleton() {

	}

	/*
	 * Step-3 : Create the method for checking the references and use synchronized
	 * block instead of method.
	 */

	public static Singleton getSingletonObject() {

		synchronized (Singleton.class) {

			if (singletonObject == null) {

				singletonObject = new Singleton();

			} else {

				return singletonObject;

			}

			return singletonObject;

		}
	}

	// Step 8 : To Achieve Singleton Write this readResolve() Method

	protected Object readResolve() {

		return singletonObject;
	}

}
