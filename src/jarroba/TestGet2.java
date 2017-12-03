package jarroba;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

public class TestGet2 {
	public static void main(String[] args) {

		MiClase objetoDeMiClase = new MiClase();

		Class<? extends MiClase> objetoDeClassConInfoDeMiClase = objetoDeMiClase.getClass();

		// Recorrer todas las variables de la clase
		Field[] todasLasVariablesDeclaradas = objetoDeClassConInfoDeMiClase.getDeclaredFields();
		for (Field variable : todasLasVariablesDeclaradas) {
			String nombreVariable = variable.getName();
			System.out.println("\nNombre de la VARIABLE GLOBAL: " + nombreVariable);

			Type tipo = variable.getGenericType();
			String nombreTipoVariable = tipo.getTypeName();
			System.out.println("  Tipo: " + nombreTipoVariable);

			int modificador = variable.getModifiers();

			Boolean esPublic = Modifier.isPublic(modificador);
			System.out.println("  Es public: " + esPublic);

			Boolean esPrivate = Modifier.isPrivate(modificador);
			System.out.println("  Es private: " + esPrivate);
		}

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
	}
}