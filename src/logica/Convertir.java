package logica;

public class Convertir {

    public static String toSoles(Double valorOriginal, Double factor){
        return " S/" + Calculo(valorOriginal,factor) + " Soles";
    }
    public static  String toDolares(Double valorOriginal, Double factor){
        return " $" + Calculo(valorOriginal,factor) + " Dolares";
    }
    public static  String toEuros(Double valorOriginal, Double factor){
        return " \u20AC" + Calculo(valorOriginal,factor) + " Euros";
    }
    public static String toLibrasEsterlinas(Double valorOriginal, Double factor){
        return " \u00A3" + Calculo(valorOriginal,factor) + " Libras Esterlinas";
    }
    public static String toYen(Double valorOriginal, Double factor){
        return " \u00A5" + Calculo(valorOriginal,factor) + " Yenes";
    }
    public static String toWon(Double valorOriginal, Double factor){
        return "  \u20A9" + Calculo(valorOriginal,factor) + " Wones";
    }


    private static Double Calculo(Double valorOriginal, Double factor){
        return valorOriginal*factor;
    }
}
