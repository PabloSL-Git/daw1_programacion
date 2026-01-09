package teoria;

public class BooleanPractica {

    public static void main(String[] args) {
        
    int a = 10;
    int b = 15;

    // Operadores relacionales 
    boolean esAigualB = a == b;
    System.out.println("¿Son iguales? " + esAigualB);

    boolean esAMayorIgualB = a >= b;
    System.out.println("¿Es a mayor o igual que b? " + esAMayorIgualB);

    boolean sonDistintas = a != b;
    System.out.println("¿Son distintas? " + sonDistintas);

    int estatura = 178;

    boolean esDistintade200 = estatura != 200;
    boolean esMayorQueCero = estatura > 0;

    // Y lógico es true cuando las dos partes son true 
    boolean esDistintade200yMayorCero = 
    esDistintade200 && esMayorQueCero;

    // 0 lógico es true cuando una de las partes 
    // es true 
    // Si la estatura es menor que 0 o mayor que
    // 200, para la ejecucion
    estatura = 210;
    boolean x = estatura<0 || estatura > 200;
    System.out.println(x);

    // Negación 
    boolean verdad = true;
    System.out.println(!verdad);

    // autoasignación +=; -=; *=; /= 
    // autoincremento a++; ++a; autodecremento a--; --a 

System.out.println(esDistintade200yMayorCero);

    }


}
