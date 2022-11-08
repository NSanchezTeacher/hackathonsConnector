package hackathon.api;

import hackathon.Parameters;

import java.util.HashMap;
import java.util.Map;

public class Hack <T>{

    private static Connector connector;
    private static Hack hack;
    public static Hack getHack(){
        if(hack == null){
            hack = new Hack();
            connector = Connector.getConector();
        }
        return hack;
    }

    /***
     *
     * @param exercicie: Nombre del ejercicio
     * @param solution: Array de la solución
     */

    public void resolve(String exercicie, T[] solution){
        Map<String, Object> dictionary = new HashMap<>();
        dictionary.put("exercice", exercicie);
        dictionary.put("solution", solution);
        connector.post(String.class, dictionary, Parameters.PATH);

    }

    /***
     *
     * @param exercice: Nombre del ejercicio
     * @param solution: String separado por comas con la solución en forma clave valor. Ejemplo: "nombre:Pepe,edad:25"
     */

    public void resolve(String exercice, String solution){
        Map<String, Object> dictionary = new HashMap<>();
        Map<String, Object> json = new HashMap<>();
        String[] elements = solution.split(",");
        for(String elem: elements){
            String[] keyValue = elem.split(":");
            if(isParseableInt(keyValue[1])){
                json.put(keyValue[0], Integer.parseInt(keyValue[1]));
            }
            else if(isParseableDouble(keyValue[1])){
                json.put(keyValue[0], Double.parseDouble(keyValue[1]));
            }
            else if(isParseableBoolean(keyValue[1])){
                json.put(keyValue[0], Boolean.parseBoolean(keyValue[1]));
            }
            else if(isParseableChar(keyValue[1])){
                json.put(keyValue[0], keyValue[1].charAt(0));
            }
            else{
                json.put(keyValue[0], keyValue[1]);
            }

        }

        dictionary.put("exercice", exercice);
        dictionary.put("solution", json);

        connector.post(String.class, dictionary, Parameters.PATH);
    }

    private boolean isParseableInt(String data){
        try{
            Integer.parseInt(data);
            return true;
        }
        catch (NumberFormatException numberFormatException) {
            return false;
        }
    }

    private boolean isParseableDouble(String data){
        try{
            Double.parseDouble(data);
            return true;
        }
        catch (NumberFormatException numberFormatException) {
            return false;
        }
    }

    private boolean isParseableBoolean(String data){
        if (data.equals("true") || data.equals("false")){
            return true;
        }
        return false;
    }

    private boolean isParseableChar(String data){
        if(data.length() == 0)
            return true;
        return false;
    }

}
