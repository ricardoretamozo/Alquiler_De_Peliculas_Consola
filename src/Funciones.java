import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

	public class Funciones {

	static Scanner teclado =new Scanner(System.in);
	
	//creamos LinkedList<String> necesarios para almacenar nuestra informacion.
	public static LinkedList<String> Codigo_Usuario=new LinkedList <String>();
	public static LinkedList<String> Nombres_y_Apellidos=new LinkedList<String>();
	public static LinkedList<String> Usuario=new LinkedList<String>();
	public static LinkedList<String> Contraseña=new LinkedList<String>();
	public static LinkedList<String> Cargo=new LinkedList<String>();
	public static LinkedList<String> Codigo=new LinkedList<String>();
	public static LinkedList<String> Nombre=new LinkedList<String>();
	public static LinkedList<String> Genero=new LinkedList<String>();
	public static LinkedList<String> Duracion=new LinkedList<String>();
	public static LinkedList<String> Estado=new LinkedList<String>();
	public static LinkedList<String> Entrega=new LinkedList<String>();
	public static LinkedList<String> Devolucion=new LinkedList<String>();
	//guardamos en un String nuestro archivo de texto
	public static String txt_c="D://Archivos//Usuarios//Codigo.txt";
	public static String txt_n="D://Archivos//Usuarios//Nombre y Apellidos.txt";
	public static String txt_u="D://Archivos//Usuarios//Usuario.txt";
	public static String txt_con="D://Archivos//Usuarios//Contraseña.txt";
	public static String txt_ca="D://Archivos//Usuarios//Cargo.txt";
	public static String txt_c_p="D://Archivos//Peliculas//Codigo.txt";
	public static String txt_n_p="D://Archivos//Peliculas//Nombre.txt";
	public static String txt_g_p="D://Archivos//Peliculas//Genero.txt";
	public static String txt_d_p="D://Archivos//Peliculas//Duracion.txt";
	public static String txt_e="D://Archivos//Peliculas//Estado.txt";
	public static String txt_Ent="D://Archivos//Peliculas//Entrega.txt";
	public static String txt_Devo="D://Archivos//Peliculas//Devolución.txt";

	
	//Almacena los datos en el LinkedList
	public static void almacenamientodedatos() {
		
		Codigo_Usuario=Guardar_LinkedList(txt_c);
		Nombres_y_Apellidos=Guardar_LinkedList(txt_n);
		Usuario=Guardar_LinkedList(txt_u);
		Contraseña=Guardar_LinkedList(txt_con);
		Cargo=Guardar_LinkedList(txt_ca);
		Codigo=Guardar_LinkedList(txt_c_p);
		Nombre=Guardar_LinkedList(txt_n_p);
		Genero=Guardar_LinkedList(txt_g_p);
		Duracion=Guardar_LinkedList(txt_d_p);
		Estado=Guardar_LinkedList(txt_e);
		Entrega=Guardar_LinkedList(txt_Devo);
		Devolucion=Guardar_LinkedList(txt_Ent);
}
	
	// Imprime la lista de peliculas usando una funcion que devuelve un String
	public static void Listar_Películas_Usuarios(LinkedList <String>codigo,LinkedList <String>nombre,LinkedList <String>generoEusuario,LinkedList <String>duracionOcontraseña,LinkedList <String>estadoOcargo) {
		
		int numero;
		do {
			
			for(int cont=0; cont<codigo.size(); cont++) {
				
				System.out.println("|"+Codigo((String)codigo.get(cont))+Nombre((String)nombre.get(cont))+Genero((String)generoEusuario.get(cont))+Duracion((String)duracionOcontraseña.get(cont))+Estado((String)estadoOcargo.get(cont)));
				}
			
			try {
				System.out.println("Digite 0 para volver al menú: ");
				numero=teclado.nextInt();
			}catch(Exception e){
				System.out.println("Escriba un numero dentro de las opciones");
				numero=0;
				System.out.println("Volviendo al menú");
			}
			
			}while(numero!=0);
	}
	
	//Es una funcion que recibe los LinkedList para que busca el nombre de la pelicula y si le encuentra inprime toda la informacion.
	public static void Buscar_Películas(LinkedList <String>codigo,LinkedList <String> nombres,LinkedList <String>generoEusuario,LinkedList <String>duracionOcontraseña,LinkedList <String>estadoUcargo) {
		String buscar;
		int numero;
		boolean validar;
		int cont;
		do {
			System.out.println("Escriba el nombre de la pelicula a buscar: ");
			buscar=teclado.nextLine();
				validar=verificacion_alquiladas(buscar,nombres);
				if(validar==true){
					cont=pos(buscar,nombres);
					show1();
					show(cont,codigo,nombres,generoEusuario,duracionOcontraseña,estadoUcargo);
				}else {
				System.out.println("No se encuentro, intente de nuevo");
			}
			System.out.println("Digite una opcion: "+
							"\n 1.Volver a buscar"+
							"\n 0.Volver al menú");
			try {
				
				numero=teclado.nextInt();
				teclado.nextLine();
			}catch(Exception e){
				System.out.println("Escriba un numero dentro de las opciones");
				numero=0;
			}
		}while(numero!=0);
	}
	
	//Es una funcion que recibe los LinkedList para que busca el nombre del usuario y si le encuentra inpime toda la informacion.
	public static void Buscar_Usuarios(LinkedList <String>codigo,LinkedList <String> nombres,LinkedList <String>generoEusuario,LinkedList <String>duracionOcontraseña,LinkedList <String>estadoUcargo) {
		String buscar;
		int numero;
		boolean validar;
		int cont;
		do {
			System.out.println("Escriba el nombre del usuario a buscar: ");
			buscar=teclado.nextLine();
				validar=verificacion_alquiladas(buscar,nombres);
				if(validar==true){
					cont=pos(buscar,nombres);
					show(cont,codigo,nombres,generoEusuario,duracionOcontraseña,estadoUcargo);
				}else {
				System.out.println("No se encuentro, intente de nuevo");
			}
			System.out.println("Digite una opcion: "+
							"\n 1.Volver a buscar"+
							"\n 0.Volver al menú");
			try {
				
				numero=teclado.nextInt();
				teclado.nextLine();
			}catch(Exception e){
				System.out.println("Escriba un numero dentro de las opciones");
				numero=0;
			}
		}while(numero!=0);
	}
	
	// Es una funcion que agrega los datos a los LinkedList.
	public static void Agregar_Películas() {
		int numero;
		do {
			System.out.println("Ingrese Nombre de la Pelicula:");
			 Nombre.add(teclado.next());
			 teclado.nextLine();
			 System.out.println("Ingrese Genero de la Pelicula:");
			 Genero.add(teclado.nextLine());
			 
			System.out.print("Ingrese la Duracion de la Peliculas:"+
								"\n Ejemplo 01:23:00");
			 Duracion.add(teclado.next());
			 int renovar=1;
			 do {
			 System.out.println("Ingrese un numero de 3 cifras para el codigo: *Recordar que el codigo automaticamente se le agregara una 'P' mayuscula al inicio*");
			 String codigo=teclado.next();
			 	codigo="P"+codigo;
			 	if(verificacion(codigo,Codigo)==true) {
				 	System.out.println("El codigo que ingreso ya esta siendo usado, Porfavor ingrese otro");
			 	}if(verificacion(codigo,Codigo)==false) {
			 		Codigo.add(codigo);
			 		renovar=0;
			 	}
			 }while(renovar!=0);
			 int est;
			 System.out.println("Ingrese el Estado de la Pelicula: "+
					 			"\n 1.Disponible" +
					 			"\n 2.Alquilado");
			 try {
				 est=teclado.nextInt();
			 }catch(Exception e) {
				 System.out.println("Escriba un numero dentro de las opciones");
				 System.out.println("Poniendo automaticamnete estado: Disponible");
				 est=1;
			 }
			 switch(est) {
			 case 1:
				 Estado.add("Disponible");
				 break;
			 case 2: 
			 	 Estado.add("Alquilado");
			 	Agregar_alquilado();
			 	break;
			 }
			 
			 System.out.println("Se agrego la pelicula satisfactoriamente!!");
			 System.out.println("Ingrese una opcion para progresar:"+
			 			"\n 1.Agregar otra pelicula" +
			 			"\n 0.Volver al menú");
			 
				numero=teclado.nextInt();
		}while(numero!=0);
	}
	
	// Es una funcion que elemina los datos a los LinkedList segun su posicion.
	public static void Eliminar_Películas() {
		String buscar;
		boolean laPeli, elCod;
		int numero;
		do {
			System.out.println("Ingrese el codigo o el nombre de la pelicula: *Recordar que el codigo tiene una 'P' mayuscula al inicio*");
			buscar=teclado.next();
			
			elCod=verificacion(buscar,Codigo);
			laPeli=verificacion(buscar,Nombre);
			if(elCod==true||laPeli==true) {
				int pos=Codigo.indexOf(buscar);
				Codigo.remove(pos);
				Nombre.remove(pos);
				Genero.remove(pos);
				Duracion.remove(pos);
				Estado.remove(pos);
				Entrega.remove(pos);
				Devolucion.remove(pos);
				System.out.println("La Pelicula se elimino satisfactoriamente!!");
			}else {
				System.out.println("La Pelicula no existe o escribío mal el nombre o el codigo");
			}
			System.out.println("Ingrese una opcion para progresar:"+
		 			"\n 1.Eliminar otra pelicula" +
		 			"\n 0.Volver al menú");
			try{
				numero=teclado.nextInt();
			}catch(Exception e) {
				System.out.println("Escriba un numero dentro de las opciones");
				numero=0;
				System.out.println("Volviendo al menu");
			}
		}while(numero!=0);
	
	}

	// Es una funcion que agrega los datos a los LinkedList.
	public static void Registro_Usuario(){
		String Nom, usu,contra;
		int opcion;
		do {
			teclado.nextLine();
			System.out.println("Ingrese Nombre y Apellido:");
			 Nom=teclado.nextLine();
			
			 System.out.println("Ingrese Nombre de Usuario: ");
			 usu=teclado.nextLine();
	
			System.out.println("Ingrese una Contraseña:");
			 contra=teclado.next();
	
			 int renovar=1;
			 do {
			 System.out.println("Ingrese un numero de 3 cifras para el codigo: ");
			 String codigo=teclado.next();
			 codigo="U"+codigo;
			 	if(verificacion(codigo,Codigo_Usuario)==true) {
				 	System.out.println("El codigo que ingreso ya esta siendo usado, Porfavor ingrese otro");
			 	}if(verificacion(codigo,Codigo_Usuario)==false) {
			 		Codigo_Usuario.add(codigo);
			 		Nombres_y_Apellidos.add(Nom);
			 		Usuario.add(usu);
			 		Contraseña.add(contra);
			 		renovar=0;
			 	}
			 }while(renovar!=0);
			 int est;
			System.out.println("Ingrese el cargo del Usuario: Administrador o Consumidor" +
								"\n 1.Administrador" +
								"\n 2.Consumidor");
		
			try {
				est=teclado.nextInt();
			}catch(Exception e) {
				System.out.println("Porfavor Escriba un numero 1 o 2");
				est=1;
				System.out.println("Se pondra automaticamente el cargo de Consumidor");
			}switch(est) {
			 
			case 1:
				 Cargo.add("Administrador");
				 break;
			 case 2:
			 	 Cargo.add("Consumidor");
			 	break;
			 }
			 System.out.println("Se agrego al Usuario satisfactoriamente!!");
			
			 System.out.println("Ingrese una opcion para progresar:"+
			 			"\n 1.Agregar otro usuario" +
			 			"\n 0.Volver al menú");
				opcion=teclado.nextInt();
				 teclado.nextLine();
		}while(opcion!=0);



		}
 
	// Imprime la lista de peliculas alquiladas usando una funcion que devuelve un String
	public static void Listar_Películas_Alquiladas(){
		int numero;
		
		do {
			show2();
			for(int cont=1;cont<Estado.size();cont++) {
				String s=(String)Estado.get(cont);
				if(s.equals("Alquilado")==true) {
					
					System.out.println("|"+Codigo((String)Codigo.get(cont))+Nombre((String)Nombre.get(cont))+Duracion((String)Entrega.get(cont))+Duracion((String)Devolucion.get(cont)));
	
				}
			}
			try {
				System.out.println("Digite 0 para volver al menú: ");
				numero=teclado.nextInt();
			}catch(Exception e) {
				System.out.println("Escriba un numero dentro de las opciones");
				numero=0;
				System.out.println("Volviendo al menu");
			}
		}while(numero!=0);
		
	}

	
	// Es una funcion que recibe los LinkedList para que busca el nombre de la pelicula alquilada y si le encuentra inprime toda la informacion.
	public static void Buscar_Películas_Alquiladas() {
		String buscar, estado;
		int numero;
		boolean validar;
		int pos;
		do {
			System.out.println("Escriba el nombre de la Pelicula alquilada: ");
			
			buscar=teclado.next();
			teclado.nextLine();
			
			validar=verificacion_alquiladas(buscar, Nombre);
			pos=pos(buscar,Nombre);
			
			estado=(String)Estado.get(pos);
		
			if(validar==true && estado.equals("Alquilado")==true) {
				show2();
				System.out.println("|"+Codigo((String)Codigo.get(pos))+Nombre((String)Nombre.get(pos))+Duracion((String)Entrega.get(pos))+Duracion((String)Devolucion.get(pos)));
			}else {
				System.out.println("No se encuentro, intente de nuevo ");
			}
			System.out.println("Digite una opcion: "+
					"\n 1.Volver a buscar"+
					"\n 0.Volver al menú");
			try {
				numero=teclado.nextInt();
				
			}catch(Exception e) {
				System.out.println("Escriba un numero dentro de las opciones");
				numero=0;
				System.out.println("Regreso al menú");
			}
			teclado.nextLine();
		}while(numero!=0);
		}
		
	// Es una funcion que agrega los datos a los LinkedList para alquilar la pelicula y cambia el estado de la pelicula usando otra funcion llamado reeamplazo.
	public static void Alquilar_Películas() {
		String cod,prest,devo;
		int numero;
		boolean vereficar;
		do {
			System.out.println("Ingrese el codigo de la Pelicula que quiera alquilar:");
			 cod=teclado.next();
			System.out.println("Ingrese la fecha de prestamo: Ejemplo-04/07/2019-");
			 prest=teclado.next();
			System.out.println("Ingrese la fecha de devolucion: Ejemplo-06/07/2019-");
			 devo=teclado.next();
			 vereficar=verificacion(cod, Codigo);
			 int x=(pos(cod,Codigo));
			 String r=(Estado.get(x));
			if(r.equalsIgnoreCase("Alquilado")==true) {
				System.out.println("La pelicula que escogio ya esta alquilada");
			}else {

				Entrega.add(prest);
				Devolucion.add(devo);
				Reemplazo(cod);
				System.out.println("Se alquilo la pelicula satisfactoriamente!!");
			}
			System.out.println("Ingrese una opcion para proseguir:"+
			"\n Ingrese 1. Volver a Alquilar"+
					"\n Ingrese 0. Volver al menú");
			try {
				numero=teclado.nextInt();
			}catch(Exception e) {
				System.out.println("Porfavor, Escriba un numero");
				numero=0;
				System.out.println("Volviendo al menú");
			}
		
		}while(numero!=0);
	}
	
	public static void Agregar_alquilado() {
		String prest,devo;
		int numero;
		
		do {
			System.out.println("Ingrese la fecha de prestamo: Ejemplo-04/07/2019-");
			 prest=teclado.next();
			System.out.println("Ingrese la fecha de devolucion: Ejemplo-06/07/2019-");
			 devo=teclado.next();
			
	
				Entrega.add(prest);
				Devolucion.add(devo);
				
				System.out.println("Se alquilo la pelicula satisfactoriamente!!");
			
			System.out.println("Ingrese una opcion para proseguir:"+
			"\n Ingrese 1. Volver a Alquilar"+
					"\n Ingrese 0. Volver al menú");
			try {
				numero=teclado.nextInt();
			}catch(Exception e) {
				System.out.println("Porfavor, Escriba un numero");
				numero=0;
				System.out.println("Volviendo al menú");
			}
		
		}while(numero!=0);
	}
	
	// Modifica el LinkedList de estado.
	public static void Reemplazo(String cod) {
		boolean reconocer;
		int cont;
		reconocer=verificacion(cod,Codigo);
		if(reconocer==true) {
			cont=pos(cod,Codigo);
			Estado.remove(cont);
			Estado.add(cont,"Alquilado");
			
		}
	
		
	}
	
	//compara un string con un linkedlist
	public static boolean verificacion(String revisar, LinkedList<String> txt) {
		
		for(int cont=0; cont<txt.size();cont++) {
			String pos=txt.get(cont);
			if(revisar.equals(pos)==true) {
				return true;
			}
		}
		return false;
		
	}
	
	//compara un string con un linkedlist ignorando las mayusculas.
	public static boolean verificacion_alquiladas(String revisar, LinkedList<String> txt) {
		
		for(int cont=0; cont<txt.size();cont++) {
			String pos=txt.get(cont);
			if(revisar.equalsIgnoreCase(pos)==true) {
				return true;
			}
		}
		return false;
		
	}
	
	// retorna la posicon del string en la linkkedlist.
	public static int pos(String revisar, LinkedList<String> txt) {
		
		for(int cont=0; cont<txt.size();cont++) {
			String sitio=txt.get(cont);
			if(revisar.equalsIgnoreCase(sitio)==true) {
				return cont;
			}
			
		}
		return -1;

	}
	
	// Visualiza los datos de los LinkedList.
	static void show(int cont,LinkedList <String>a,LinkedList <String>b,LinkedList <String>c,LinkedList <String>d,LinkedList <String>e) {
		System.out.println("|"+Codigo((String)a.get(cont))+Nombre((String)b.get(cont))+Genero((String)c.get(cont))+Genero((String)d.get(cont))+Genero((String)e.get(cont)));
	}
	
	public static void show1() {
		int cont=0;
		System.out.println("|"+Codigo((String)Codigo.get(cont))+Nombre((String)Nombre.get(cont))+Genero((String)Genero.get(cont))+Genero((String)Duracion.get(cont))+Genero((String)Estado.get(cont)));
	}
	
	public static void show2() {
		int cont=0;
		System.out.println("|"+Codigo((String)Codigo.get(cont))+Nombre((String)Nombre.get(cont))+Duracion((String)Entrega.get(cont))+Duracion((String)Devolucion.get(cont)));
	}
	
	// busca el id y si le encuentra saca la posicion y con eso saca la contraseña y lo compara con la contraseña ingresada y si es correpto acedes alas opciones.
	public static String Iniciar(String x) {
		boolean validar_Usu, validar_Cont;
		String ID,contraseña;
		int numero;
		do {
			System.out.println("      Inicio de Sesion"+
					"\n");
			System.out.println("Escriba su ID:");
			ID=teclado.next();
			
			validar_Usu=verificacion(ID, Usuario);
			numero=Usuario.indexOf(ID);
			
			if(numero==-1) {
				validar_Cont=false;
			}else {
			 String con=Contraseña.get(numero);
			 System.out.println("Escriba su contraseña:");
				contraseña=teclado.next();
			 validar_Cont= con.equals(contraseña);
			}	
			if(validar_Usu==false || validar_Cont==false) {
				System.out.println("Usted no esta registrado o se confundio al ingresar sus datos"+
									"\n Intente de nuevo");
				
			}
			
			
		}while(validar_Usu==false || validar_Cont==false);
		
		
		numero=Usuario.indexOf(ID);
		String usuario_ =Cargo.get(numero);
		return usuario_;
	}
	
	// Guarda los linkkedlist en los archivos
	public static void Guardar(String archivo,LinkedList<String> sitio) {
		FileWriter fichero=null;
		PrintWriter pw=null;
		try {
			fichero=new FileWriter(archivo);
			pw = new PrintWriter(fichero);
			for(int cont=0;cont<sitio.size();cont++) {
				pw.println((String)sitio.get(cont));
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(null != fichero) {
					fichero.close();
				}
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	// guarda un string en un linkdlist.
	public static LinkedList<String> Guardar_LinkedList(String texto) {
		LinkedList<String> guardar=new LinkedList<String>();

		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
	
			try {	
			archivo=new File(texto);
			fr =new FileReader(archivo);
			br = new BufferedReader(fr);
			
				for(String linea=br.readLine();linea!=null;linea=br.readLine()) {
					guardar.add(linea);
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			return guardar;
		}
	
	// usa la funcion guardar para actulizar todos los datos.
	public static void ActualizarDatos() {
		
		Guardar(txt_c, Codigo_Usuario);			
		Guardar(txt_n, Nombres_y_Apellidos);
		Guardar(txt_u, Usuario);
		Guardar(txt_con, Contraseña);
		Guardar(txt_ca, Cargo);
		Guardar(txt_c_p, Codigo);
		Guardar(txt_n_p, Nombre);
		Guardar(txt_g_p, Genero);
		Guardar(txt_d_p, Duracion);
		Guardar(txt_e, Estado);
		Guardar(txt_Ent, Entrega);
		Guardar(txt_Devo, Devolucion);
		
		
	}

	public static void linea() {
		
		for(int cont=0;cont<50;cont++) {
			System.out.print("-");
		}
	}
	

	// son funcion que agreaga un tamaño especifico al string para que la vizualizacion sea mejor.
	public static String Codigo(String s) {
		int esp=0;
		for(int cont=0;cont<s.length();cont++) {
			if(s.charAt(cont)==s.charAt(cont)) {
				esp++;
			}
		}
		String retorno="";
		retorno=retorno+s;
		for(int con=esp;con<7;con++) {
			retorno=retorno+" ";
		}
		retorno=retorno+"|";
		return retorno;
	}
	
	public static String Nombre(String s) {
		int esp=0;
		for(int cont=0;cont<s.length();cont++) {
			if(s.charAt(cont)==s.charAt(cont)) {
				esp++;
			}
		}
		String retorno="";
		retorno=retorno+s;
		for(int con=esp;con<20;con++) {
			retorno=retorno+" ";
		}
		retorno=retorno+"|";
		return retorno;
	}
	
	public static String Genero(String s) {
		int esp=0;
		for(int cont=0;cont<s.length();cont++) {
			if(s.charAt(cont)==s.charAt(cont)) {
				esp++;
			}
		}
		String retorno="";
		retorno=retorno+s;
		for(int con=esp;con<15;con++) {
			retorno=retorno+" ";
		}
		retorno=retorno+"|";
		return retorno;
	}
	
	public static String Duracion(String s) {
		int esp=0;
		for(int cont=0;cont<s.length();cont++) {
			if(s.charAt(cont)==s.charAt(cont)) {
				esp++;
			}
		}
		String retorno="";
		retorno=retorno+s;
		for(int con=esp;con<10;con++) {
			retorno=retorno+" ";
		}
		retorno=retorno+"|";
		return retorno;
	}
	
	public static String Estado(String s) {
		int esp=0;
		for(int cont=0;cont<s.length();cont++) {
			if(s.charAt(cont)==s.charAt(cont)) {
				esp++;
			}
		}
		String retorno="";
		retorno=retorno+s;
		for(int con=esp;con<11;con++) {
			retorno=retorno+" ";
		}
		retorno=retorno+"|";
		return retorno;
	}
	
	}
