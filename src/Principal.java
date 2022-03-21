import java.util.Scanner;

public class Principal {
static Scanner teclado;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		teclado = new Scanner (System.in);
		Funciones.almacenamientodedatos();
		int reinicio=1;
		String x="";
		do {
			Funciones.linea();
			System.out.println("\n Bienvenidos a"+"\n"+
					"\n Suvlime Alquiler de Peliculas"+"\n");
			
			x=Funciones.Iniciar(x);
			
			if(x.equalsIgnoreCase("Consumidor")==true) {
				int opcionUsuarios;
				do{
				
					System.out.println("Digite una opcion: "+
							"\n"+
							"\n 1. Listar Peliculas"+
							"\n 2. Buscar Peliculas"+
							"\n 3. Alquilar"+
							"\n 0. salir");
					
				try {
	
					opcionUsuarios=teclado.nextInt();
				}catch(Exception e) {
					System.out.println("Porfavor Escriba un numero entre el 0 y el 1");
					opcionUsuarios=0;
					System.out.println("Cerrando sesion");
					teclado.nextLine();

				}
	
					switch (opcionUsuarios){
					
					case 1:
		
						Funciones.Listar_Películas_Usuarios(Funciones.Codigo,Funciones.Nombre,Funciones.Genero,Funciones.Duracion,Funciones.Estado);
					
						break;
					case 2:
						
						teclado.nextLine();
						Funciones.Buscar_Películas(Funciones.Codigo,Funciones.Nombre,Funciones.Genero,Funciones.Duracion,Funciones.Estado);
						
						break;
					case 3:
						
						Funciones.Alquilar_Películas();
						Funciones.ActualizarDatos();
						break;
					default:
					break;
					}
					
				}while (opcionUsuarios!=0);
				
				System.out.println("¡Gracias por su Visita a suvlime!"+
							"\n Que tenga un Buen Dia...!!!! ");
				
			}
		
			if(x.equalsIgnoreCase("Administrador")==true) {
				int opcionPeliculas;
				do {
					System.out.println("Digite una opcion: " +
							"\n"+
							"\n 1. Listar Peliculas" +
							"\n 2. Buscar Peliculas" +
							"\n 3. Agregar Peliculas" +
							"\n 4. Eliminar Peliculas" +
							"\n 5. Listar Usuarios" +
							"\n 6. Buscar Usuarios" +
							"\n 7. Agregar Usuarios" +
							"\n 8. Listar Peliculas Alquiladas" +
							"\n 9. Buscar Peliculas Alquiladas" +
							"\n 0. Cerrar sesion");
					
				try {
					
					opcionPeliculas=teclado.nextInt();
					
				}catch(Exception e){
					System.out.println("Porfavor Escriba un numero entre el 0 y el 9");
					opcionPeliculas=0;
					System.out.println("Cerrando sesion");
				
				}
					
				
					switch(opcionPeliculas) {
						case 1:
							
							Funciones.Listar_Películas_Usuarios(Funciones.Codigo,Funciones.Nombre,Funciones.Genero,Funciones.Duracion,Funciones.Estado);
							
							break;
						case 2:
							teclado.nextLine();
							Funciones.Buscar_Películas(Funciones.Codigo,Funciones.Nombre,Funciones.Genero,Funciones.Duracion,Funciones.Estado);
					
							break;
						case 3:
							
							Funciones.Agregar_Películas();
							Funciones.ActualizarDatos();
							break;
						case 4:
							
							Funciones.Eliminar_Películas();
							Funciones.ActualizarDatos();
							break;
						case 5:
							
							Funciones.Listar_Películas_Usuarios(Funciones.Codigo_Usuario, Funciones.Nombres_y_Apellidos, Funciones.Usuario, Funciones.Contraseña, Funciones.Cargo);
							
							break;
						case 6:
							teclado.nextLine();
							Funciones.Buscar_Usuarios(Funciones.Codigo_Usuario, Funciones.Nombres_y_Apellidos, Funciones.Usuario, Funciones.Contraseña, Funciones.Cargo);
							
							break;
						case 7:
							
							Funciones.Registro_Usuario();
							Funciones.ActualizarDatos();
							break;
						case 8:
							
							Funciones.Listar_Películas_Alquiladas();
							
							break;
						case 9:
				
							Funciones.Buscar_Películas_Alquiladas();
						
							break;
						default:
							break;
					}
					
				}while(opcionPeliculas!=0);
		
				System.out.println("¡Gracias por su Visita a suvlime!"+
						"\n Que tenga un Buen Dia...!!!! ");
				
			}
	  	}while(reinicio!=0);
	}

}
