package jarroba;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

public final class TestNewInstance {

	public static void main(String[] args) {

		MiClase objDeMiClase = new MiClase();
		Class<? extends MiClase> objetoDeClassConInfoDeMiClase = objDeMiClase.getClass();
		System.out.println(objDeMiClase);
		System.out.println(objetoDeClassConInfoDeMiClase);
		
		System.out.println("            ====Constructores=====");
		System.out.println("\n---> Obtener constructores de declarados en la clase");
		// Si queremos obtener un array con todos los constructores publicos de
		// nuestra clase
		Constructor[] todosLosConstructores = objetoDeClassConInfoDeMiClase.getConstructors();
		for (Constructor c : todosLosConstructores)
			System.out.println(c);	
		
		// Recorrer todos los métodos de la clase
		final Method[] metodos = objetoDeClassConInfoDeMiClase.getDeclaredMethods();
		for (final Method metodo : metodos) {
			System.out.println("\nNombre del MÉTODO: " + metodo.getName());
			System.out.println("  Cantidad de parámetros: " + metodo.getParameterCount());

			System.out.println("  Es public: " + Modifier.isPublic(metodo.getModifiers()));
			System.out.println("  Es private: " + Modifier.isPrivate(metodo.getModifiers()));

			System.out.println("  Tipo del return: " + metodo.getGenericReturnType().getTypeName());
			Type[] tipos = metodo.getGenericParameterTypes();

			System.out.println("  Tipos de los parámetros:");
			for (Type tipo : tipos) {
				System.out.println("    " + tipo.getTypeName());
			}
		}
		
		try {			
			System.out.println("\nGeneramos la instancia luego de tener la info");
			System.out.println("Constructores Creados");
			Constructor constructorSinParametros = objetoDeClassConInfoDeMiClase.getConstructor();
			Constructor constructorConParametros = objetoDeClassConInfoDeMiClase.getDeclaredConstructor(String.class, long.class, int.class);
			
			System.out.println(constructorSinParametros);
			System.out.println(constructorConParametros);
			
			
			MiClase objDeMiClase1 = (MiClase) constructorSinParametros.newInstance();
			MiClase objDeMiClase2 = (MiClase) constructorConParametros.newInstance("Texto", 4444L,58);
			
			System.out.println("\nObjetos instanciados de las dos unicas maneras posibles");
			System.out.println(objDeMiClase1);
			System.out.println(objDeMiClase2);
			
			//visualizamos lo set del constructor
			System.out.println("\n Valores del constructor");
			System.out.println(objDeMiClase2.getUnaVariableString());
				//dos formas
				System.out.println(objDeMiClase2.l);
				System.out.println(objDeMiClase2.getL());

			//como es publica podemos acceder de esta manera
			Field variableString1 = objDeMiClase1.getClass().getField("unaVariableString");
			variableString1.set(objDeMiClase1, "Texto para el primer obj");
			System.out.println("\n  Valor de la variable asignada: " + objDeMiClase1.unaVariableString);

			//Como es privada accedemso de esta manera
			Field variableString2 = objDeMiClase2.getClass().getDeclaredField("otraVariableString");
			
				//dos formas de actualizar en un campo que es privado
				
				variableString2.setAccessible(true);
				variableString2.set(objDeMiClase2, "primera forma de set");
				System.out.println(objDeMiClase2.getOtraVariableString());
			
				Method setOtraVariableString = objetoDeClassConInfoDeMiClase.getMethod("setOtraVariableString", String.class);
				System.out.println("\n Info del metodo: " + setOtraVariableString);
				System.out.println(" Nombre del metodo: " + setOtraVariableString.getName());
				
				setOtraVariableString.invoke(objDeMiClase2, "segudna forma de set");
				System.out.println(objDeMiClase2.getOtraVariableString());
				
			
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchFieldException | SecurityException | NoSuchMethodException e) {	e.printStackTrace();	}
	}

}
