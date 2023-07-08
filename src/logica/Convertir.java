package logica;

public class Convertir {


    ////////////MONEY
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

    /////////////TEMPERATURE
    public static double Celcius_to_Fahrenheit(double Celcius){
        double Fahrenheit = (Celcius * 9/5) + 32;
        return Fahrenheit;
    }
    // Celcius to Kelvin
    public static double Celcius_to_Kelvin(double Celcius){
        double Kelvin = Celcius + 273.15;
        return Kelvin;
    }

    // Fahrenheit to Celcius
    public static double Fahrenheit_to_Celcius(double Fahrenheit){
        double Celcius = (Fahrenheit - 32) * 5/9;
        return Celcius;
    }
    // Fahrenheit to Kelvin
    public static double Fahrenheit_to_Kelvin(double Fahrenheit){
        double Kelvin = (Fahrenheit - 32) * 5/9 + 273.15;
        return Kelvin;
    }

    // Kelvin to Celcius
    public static double Kelvin_to_Celcius(double Kelvin){
        double Celcius = Kelvin - 273.15;
        return Celcius;
    }
    // Kelvin to Fahrenheit
    public static double Kelvin_to_Fahrenheit(double Kelvin){
        double Fahrenheit = (Kelvin - 273.15) * 9/5 + 32;
        return Fahrenheit;
    }
}
