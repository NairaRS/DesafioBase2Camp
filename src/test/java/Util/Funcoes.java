package Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Funcoes {
    public static String remove_texto(String texto){
        Pattern p = Pattern.compile("([0]{0,6}\\d+)");
        Matcher m = p.matcher(texto);
        m.find();
        return m.group().toString();
    }
}



