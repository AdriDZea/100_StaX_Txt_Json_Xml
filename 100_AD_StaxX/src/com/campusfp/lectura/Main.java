package com.campusfp.lectura;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.campusfp.modelo.Item;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

public class Main {

	static ArrayList<String> almacenjson = new ArrayList<String>();
	static ArrayList<String> almacentxt = new ArrayList<String>();
	static StaXParser read = new StaXParser();
	static List<Item> readConfig = read.readConfig("config.xml");
	
	public static void main(String[] args) throws IOException {
       System.out.println("---XML---");
        for (Item item : readConfig) {
            System.out.println(item);
            almacenjson.add("{"+item.toString()+"}");
        }
        guardarjson();      
        System.out.println("");
        System.out.println("---Json---");
        JsonParser parser = new JsonParser();
        FileReader fr = new FileReader("prueba.json");
        JsonElement datos = parser.parse(fr);
        dumpJSONElement(datos);
        leertxt();
        System.out.println("");System.out.println("");
        System.out.println("---TxT---");
        muestraContenido();
	}
	public static void muestraContenido() throws FileNotFoundException, IOException {
		String archivo="prueba.txt";
        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            System.out.println(cadena);
        }
        b.close();
    }
	 public static void leertxt() throws IOException {
	        String ruta = "prueba.txt";
	        File archivo = new File(ruta);
	        BufferedWriter bw;
	            bw = new BufferedWriter(new FileWriter(archivo));
	           bw.write(almacentxt.toString());    
	        bw.close();
	    }
	
	public static void dumpJSONElement(JsonElement elemento) {
		if (elemento.isJsonObject()) {  
	        JsonObject obj = elemento.getAsJsonObject();
	        java.util.Set<java.util.Map.Entry<String,JsonElement>> entradas = obj.entrySet();
	        java.util.Iterator<java.util.Map.Entry<String,JsonElement>> iter = entradas.iterator();
	        while (iter.hasNext()) {
	            java.util.Map.Entry<String,JsonElement> entrada = iter.next();    
	            dumpJSONElement(entrada.getValue());
	        }
	    } else if (elemento.isJsonArray()) {
	        JsonArray array = elemento.getAsJsonArray();
	        java.util.Iterator<JsonElement> iter = array.iterator();
	        while (iter.hasNext()) {
	            JsonElement entrada = iter.next();
	            dumpJSONElement(entrada);
	        }
	    } else if (elemento.isJsonPrimitive()) {
	        JsonPrimitive valor = elemento.getAsJsonPrimitive();
	        if (valor.isNumber()) {
	        	almacentxt.add(valor.getAsNumber().toString());
	        	System.out.println(valor.getAsNumber());
	        } else if (valor.isString()) {
	        	almacentxt.add( valor.getAsString().toString());
	        	System.out.print(valor.getAsString()+" ");
	        }
	    }	
	}
        public static void guardarjson() throws IOException {
        String ruta = "prueba.json";
        File archivo = new File(ruta);
        BufferedWriter bw;
        	String guardar=almacenjson.toString();
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(guardar); 
        bw.close(); 
        }
}
