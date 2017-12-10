package jarroba;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class TestSet {

	public static void main(String[] args) {

		MiClase objetoDeMiClase = new MiClase();
		Class<? extends MiClase> objetoDeClassConInfoDeMiClase = objetoDeMiClase.getClass();

		Field[] todasLasVariablesDeclaradas = objetoDeClassConInfoDeMiClase.getDeclaredFields();

		for (Field variable : todasLasVariablesDeclaradas) {
			String nombreVariable = variable.getName();

			try {
				if (String.class == variable.getType()) {

					Field stringObtenido;
					String variableString = null;

					try {
						stringObtenido = objetoDeClassConInfoDeMiClase.getDeclaredField(nombreVariable);

						// como son privadas la hacermos publica para evitar el
						// IllegalAccessException
						variable.setAccessible(true);
						stringObtenido.setAccessible(true);

						variable.set(objetoDeMiClase, "Texto cambiado en la variable");

						variableString = (String) stringObtenido.get(objetoDeMiClase);
						System.out
								.println("Valor cambiado de la variable " + nombreVariable + " es: " + variableString);

					} catch (NoSuchFieldException | SecurityException e) {
						e.printStackTrace();
					}

				} else if (int.class == variable.getType()) {

					Field variableInt;
					try {
						variableInt = objetoDeClassConInfoDeMiClase.getDeclaredField(nombreVariable);

						int intObtenido = 5;

						// como son privadas la hacermos publica para evitar el IllegalAccessException

						variable.setAccessible(true);

						variableInt.setAccessible(true);

						variable.setInt(objetoDeMiClase, 123456789);

						intObtenido = variableInt.getInt(objetoDeMiClase);
						System.out.println("Valor cambiado de la variable " + nombreVariable + " es: " + intObtenido);

					} catch (NoSuchFieldException | SecurityException e) {
						e.printStackTrace();
					}
				}

			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
}
