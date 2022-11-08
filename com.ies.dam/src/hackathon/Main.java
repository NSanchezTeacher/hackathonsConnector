package hackathon;


import hackathon.api.Hack;

public class Main {


    /***
     *
     * Puede que llegado a este punto aún no sepas como utilizar las clases Integer, Double, etc..
     * En caso de tener que declarar un array de tipo int debes crearlo de tipo Integer. Ejemplo
     *
     * Integer[] numeros = new Integer[4];
     *
     * Esto pasa exactamente igual para los de tipo:
     *
     *   - double = Double
     *   - float = Float
     *   - boolean = Boolean
     *   - char = Character
     */
    public static void main(String[] args) {
        Integer[] array = new Integer[]{1, 2, 3};
        Hack hack = Hack.getHack();
        String solution = "num:1,bb:true,pal:hola";
        hack.resolve("EJ1", solution);

    }
}
