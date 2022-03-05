package com.co.robinfood.utils;

public class Constantes {

	public static final String CLIENTE_ENDPOINT ="cliente";
	public static final String CREAR_CLIENTE = "crear-cliente";
	public static final String ACTUALIZAR_CLIENTE = "actualizar-cliente/{id}";
	public static final String ELIMINAR_CLIENTE = "eliminar-cliente/{id}";
	
	public static final String ENCUESTA_ENDPOINT ="encuesta";
	public static final String CONSULTAR_ENCUESTA = "/{id}";
	public static final String GUARDAR_ENCUESTA = "guardar/{id}";
	public static final String GUARDAR_PREGUNTAS_ENCUESTA = "guardar-encuesta/{id}";
	
	public static final String STATUS_200 = "200";
	public static final String STATUS_500 = "500";
	public static final String STATUS_400 = "400";
	
	public static final String MENSAJE_SATISFACTORIO = "OK";
	public static final String INTERNAL_SERVER = "Internal Server Error";
	public static final String BAD_REQUEST = "Bad Request";
	
	public static final String ERROR_REGISTRO_CLIENTE = "No se registro cliente";
	public static final String ERROR_CLIENTE_NO_EXISTE = "No existe el cliente";
	
	public static final String ERROR_NO_EXISTE_ENCUESTA = "No existe la encuesta";
	
	public static final String FORMATO_ERROR ="Error consumiendo %s, en el metodo %s";
	
	public static final String CONSULTAR_CLIENTES_SERVICE = "consultar cliente service";
	public static final String METODO_LISTAR_CLIENTES = "listaClientes";
	
	public static final String CREAR_CLIENTES_SERVICE =	"crear cliente service";
	public static final String METODO_CREAR_CLIENTES = "crearClientes";
	
	public static final String MODIFICAR_CLIENTES_SERVICE =	"modificar cliente service";
	public static final String METODO_MODIFICAR_CLIENTES = "modificarClientes";
	
	public static final String ELIMINAR_CLIENTES_SERVICE =	"eliminar cliente service";
	public static final String METODO_ELIMINAR_CLIENTES = "eliminarClientes";
	
	public static final String OBTENER_ENCUESTA_SERVICE =	"obtener encuesta service";
	public static final String METODO_OBTENER_ENCUESTA = "obtenerEncuesta";
	
	public static final String GUARDAR_ENCUESTA_SERVICE =	"guardar encuesta service";
	public static final String METODO_GUARDAR_ENCUESTA = "guardarEncuesta";
	
	public static final String GENERAR_ENCUESTA_SERVICE =	"generar encuesta service";
	public static final String METODO_GENERAR_ENCUESTA = "generarEncuesta";
	
	public static final String ELIMINAR_CLIENTE_SATISFACTORIA = "Se elimino el cliente";
	
    public static final long  TIPO_PREGUNTA_S_N = 1;
    public static final long  TIPO_PREGUNTA_TEXTO = 2;
}
