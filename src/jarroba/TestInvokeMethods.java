package jarroba;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

public class TestInvokeMethods {

	public static void main(String[] args) {

		MiClase objetoDeMiClase = new MiClase();		
		Class<? extends MiClase> objetoDeClassConInfoDeMiClase = objetoDeMiClase.getClass();
		
		// Recorrer todos los m�todos de la clase
		final Method[] metodos = objetoDeClassConInfoDeMiClase.getDeclaredMethods();
		for (final Method metodo : metodos) {
			System.out.println("\nNombre del M�TODO: " + metodo.getName());
			System.out.println("  Cantidad de par�metros: " + metodo.getParameterCount());

			System.out.println("  Es public: " + Modifier.isPublic(metodo.getModifiers()));
			System.out.println("  Es private: " + Modifier.isPrivate(metodo.getModifiers()));

			System.out.println("  Tipo del return: " + metodo.getGenericReturnType().getTypeName());
			Type[] tipos = metodo.getGenericParameterTypes();

			System.out.println("  Tipos de los par�metros:");
			for (Type tipo : tipos) {
				System.out.println("    " + tipo.getTypeName());
			}
		}
		
		System.out.println("\n==== Invocasion de dos metodos =====");

		Object valorPasar = null;
		Object valorRetornoMetodoInvocado = null;
			
			// Si queremos obtener un m�todo p�blico. Si tiene par�metros
			// podremos pasar cada uno de sus tipos.class en orden despu�s del
			// nombre
		
			try {
				Method metodoGetString = objetoDeClassConInfoDeMiClase.getMethod("getUnaVariableString", String.class);
				
				System.out.println("\nNombre del M�TODO: " + metodoGetString.getName());

				valorPasar = "/ A�adir otra cosa";
				
				valorRetornoMetodoInvocado = metodoGetString.invoke(objetoDeMiClase, valorPasar);
		
				System.out.println("  Valor del m�todo invocado: " + valorRetornoMetodoInvocado);

			} catch (NoSuchMethodException | SecurityException |IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {	e.printStackTrace();	}

			
			try{
				Method metodoGetInt = objetoDeClassConInfoDeMiClase.getDeclaredMethod("getUnaVariableInt", int.class);
				
				//Segun la ficha ya sabemos que es privado pero no esta de mas preguntar
				if(Modifier.isPrivate(metodoGetInt.getModifiers()))
					metodoGetInt.setAccessible(true);
				
				System.out.println("\nNombre del M�TODO: " + metodoGetInt.getName());
	
				valorPasar = 100;
				
				valorRetornoMetodoInvocado = metodoGetInt.invoke(objetoDeMiClase, valorPasar);
						
				System.out.println("  Valor del m�todo invocado: " + valorRetornoMetodoInvocado);

			} catch (NoSuchMethodException | SecurityException |IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {	e.printStackTrace();	}
		
			
			try{
				Method metodoSetString = objetoDeClassConInfoDeMiClase.getDeclaredMethod("setUnaVariableString", String.class);
				
 				System.out.println("\nNombre del Metodo: " + metodoSetString.getName());
 				
 				valorPasar = null;
 				
 				valorRetornoMetodoInvocado = metodoSetString.invoke(objetoDeMiClase, valorPasar);
 				
				System.out.println("  Valor del m�todo invocado: " + valorRetornoMetodoInvocado);
				
			} catch (NoSuchMethodException | SecurityException |IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {	e.printStackTrace();	}

	
	
	}
}

