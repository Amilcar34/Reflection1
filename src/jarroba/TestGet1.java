package jarroba;

import java.lang.reflect.*;

import javax.annotation.processing.SupportedSourceVersion;

public final class TestGet1 {

	public static void main(String[] args) {

		// Obtener el Class directamente de un objeto (Recordatorio: un objeto
		// de tipo String válido es un texto entre comillas)
		Class classDelTexto = "Un texto".getClass();
		System.out.println(classDelTexto);

		Integer numero = 5;
		Class classDelNumero = numero.getClass();
		System.out.println(classDelNumero);

		// Para tipos primitivos tenemos que usar “.class”
		Class classDeBooleanA = boolean.class;
		System.out.println(classDeBooleanA);

		// También podemos obtener una clase desde un nombre completamente
		// cualificado (fully-quailified name); esto es, el nombre del paquete
		// donde está nuestra clase, seguido del nombre de la clase
		System.out.println("---->Rutra entre paquetes y tipo de template: ");
		
		try {

			Class c = Class.forName("jarroba.MiClase");
			System.out.println(c);

		} catch (ClassNotFoundException e) {	e.printStackTrace();	}

		// me devuelve la ruta entre paquetes
		MiClase objetoDeMiClase = new MiClase();
		Class<? extends MiClase> objetoDeClassConInfoDeMiClase = objetoDeMiClase.getClass();
		System.out.println(objetoDeClassConInfoDeMiClase);

		// Obtener el nombre de la clase
		System.out.print("---->Nombre de la clase: ");
		String nombreDeLaClase = objetoDeClassConInfoDeMiClase.getSimpleName();
		System.out.println(nombreDeLaClase);
		System.out.println();

		try {
			System.out.println("            ====VARIABLES=====");
			System.out.println("\n--->Obtener info de variables especificas");

			// Si queremos obtener una variable pública
			Field variableString = objetoDeClassConInfoDeMiClase.getField("unaVariableString");
			System.out.println(variableString);

			// Si queremos obtener una variable, sea privada o no
			Field variableInt = objetoDeClassConInfoDeMiClase.getDeclaredField("unaVariableInt");
			System.out.println(variableInt);

		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}

		// Si queremos obtener un array con todas las variables públicas de
		// nuestra clase
		System.out.println("\n---> Obtener toda la info de varibles PUBLICAS que alla");
		Field[] todasLasVariables = objetoDeClassConInfoDeMiClase.getFields();

		for (Field field : todasLasVariables)
			System.out.println(field);

		System.out.println("\n---> Obtener toda la info de TODAS varible1s que alla");
		// Si queremos obtener todas las variables, independientemente de si son
		// privadas o no
		Field[] todasLasVariablesDeclaradas = objetoDeClassConInfoDeMiClase.getDeclaredFields();
		for (Field f : todasLasVariablesDeclaradas) {
			System.out.println(f);
			// System.out.println(todasLasVariablesDeclaradas);
		}

		System.out.println("\n----> Obtener solo el nombre de las variales que alla");
		for (Field fi : todasLasVariablesDeclaradas)
			System.out.println(fi.getName());

		System.out.println();
		System.out.println("            ====METODOS=====");
		System.out.println("\n--->Obtener info de metodos especificos");
		try {

			// Si queremos obtener un método público. Si tiene parámetros
			// podremos pasar cada uno de sus tipos.class en orden después del
			// nombre
			Method metodoGetString = objetoDeClassConInfoDeMiClase.getMethod("getUnaVariableString", String.class);
			System.out.println(metodoGetString);

			// Si queremos obtener un método, sea privado o no. Si tiene
			// parámetros podremos pasar cada uno de sus tipos.class en orden
			// después del nombre
			Method metodoGetInt = objetoDeClassConInfoDeMiClase.getDeclaredMethod("getUnaVariableInt", int.class);
			System.out.println(metodoGetInt);

		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}

		System.out.println("\n---> Obtener toda la info de metodos PUBLICOS que alla");
		// Si queremos obtener un array con todas las metodos públicas de
		// nuestra clase
		Method[] todosLosMetodos = objetoDeClassConInfoDeMiClase.getMethods();
		for (Method method : todosLosMetodos)
			System.out.println(method);
		System.out.println();

		System.out.println();
		System.out.println("\n---> Metodos, tipo de parametros y privacidad delcarados en la clase");
		// Si queremos obtener todos los métodos, independientemente de si son
		// privados o no
		Method[] todosLosMetodosDeclarados = objetoDeClassConInfoDeMiClase.getDeclaredMethods();
		for (Method m : todosLosMetodosDeclarados)
			System.out.println(m);

		final Method[] metodos = objetoDeClassConInfoDeMiClase.getDeclaredMethods();
		for (final Method metodo : metodos) {
			System.out.println("Nombre del MÉTODO: " + metodo.getName());
			System.out.println("  Cantidad de parámetros: " + metodo.getParameterCount());
		}

		System.out.println("\n---> Obtener todas las variables PUBLICAS en la clase");
		Field[] todasVariablesDeclaradas = objetoDeClassConInfoDeMiClase.getDeclaredFields();
		for (Field todasVariables : todasLasVariables)
			System.out.println(todasVariables);

		System.out.println();
		System.out.println("            ====Constructores=====");
		System.out.println("\n---> Obtener constructores de declarados en la clase");

		// Si queremos obtener un array con todos los constructores publicos de
		// nuestra clase
		Constructor[] todosLosConstructores = objetoDeClassConInfoDeMiClase.getConstructors();
		for (Constructor c : todosLosConstructores)
			System.out.println(c);
		
		System.out.println("\n---> Obtener constructores disponibles");
		// Si queremos obtener todos los métodos, independientemente de si son
		// privados o no
		Constructor[] constructoresDeClase = objetoDeClassConInfoDeMiClase.getDeclaredConstructors();
		for (Constructor c : constructoresDeClase)
			System.out.println(c);

	}

}
