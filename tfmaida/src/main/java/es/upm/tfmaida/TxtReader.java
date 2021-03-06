/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.upm.tfmaida;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author aida
 */
public class TxtReader {

    /**
     * Método que lee un archivo con formato TXT y lo convierte en un String 
     * 
     * @param ruta ruta de la carpeta y el archivo de texto dentro de data (licencias)
     * @return texto
     * @throws FileNotFoundException
     */
    public static String TXT2String(String ruta) throws FileNotFoundException {
        String cadena;
        String cadenaRetorno = "";
        
        File archivo = new File(ruta);
        
        if (archivo.exists()) {

            try {
                FileReader fr = new FileReader(archivo);
                BufferedReader br = new BufferedReader(fr);
                while ((cadena = br.readLine()) != null) {
                    cadenaRetorno = cadenaRetorno.concat(cadena) + "\n";
                }
                br.close();
                fr.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("El sistema no pudo hallar la ruta especifica.");
        }
        return cadenaRetorno;
    }

    
    public static String getLabel(String text) throws FileNotFoundException {
        String cadena = "";
        int pos = text.indexOf("\n");
        
        cadena = text.substring(0, pos);
        
        return cadena;
    }
    
    public static ArrayList<String> getRegex(String ruta) {
        
        String cadena;
        ArrayList<String> setOfRegex = new ArrayList<String>();
        
        File archivo = new File(ruta);
        
        if (archivo.exists()) {

            try {
                FileReader fr = new FileReader(archivo);
                BufferedReader br = new BufferedReader(fr);
                while ((cadena = br.readLine()) != null) {
                    setOfRegex.add(cadena);
                }
                br.close();
                fr.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("El sistema no pudo hallar la ruta especifica.");
        }
        
        return setOfRegex;
        
    }
    
    /**
     * Método que retorna una lista con los verbos clave (lematizados) dado un archivo 
     * con formato TXT. 
     * 
     * @param ruta  ruta de la carpeta y archivo de texto que contiene la lista 
     *              de verbos clave dentro de res
     * @return lista con los verbos 
     * @throws FileNotFoundException
     */
    public static ArrayList<String> TXT2List(String ruta) throws FileNotFoundException {
        String cadena;
        ArrayList<String> lista = new ArrayList();

        String home = System.getProperty("user.home");
        File archivo = new File("../res/" + ruta);

        if (archivo.exists()) {

            try {
                FileReader fr = new FileReader(archivo);
                BufferedReader br = new BufferedReader(fr);
                while ((cadena = br.readLine()) != null) {
                    lista.add(cadena);
                }
                br.close();
                fr.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("El sistema no pudo hallar la ruta especifica.");
        }
        return lista;
    }
    
    

}
