package tk.alexanderjoe.build.utils;

public class ColorTranslator {
    public static String translate(String txt){
        String newText = "";
        for (int i = 0; i < txt.length(); i++) {
            char c = txt.charAt(i);
            if (c == '&')
                c = '§';
            newText += c;
        }
        return newText;
    }
}
