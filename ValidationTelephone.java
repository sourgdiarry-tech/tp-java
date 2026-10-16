public class ValidationTelephone { 
    static final String REGEX_MOBILE_SN = "(\\+221)?7[05678]\\d{7}"; 
 
    static boolean estMobileValide(String numero) { 
        String nettoye = numero.replaceAll("[\\s.-]", "");   // retire espaces, points, tirets 
        return nettoye.matches(REGEX_MOBILE_SN); 
    } 
 
    public static void main(String[] args) { 
        String[] essais = {"77 123 45 67", "+221 78-000-11-22", "33 820 00 00", 
                "76123456", "70.555.44.33"}; 
        for (String n : essais) { 
            System.out.printf("%-20s -> %s%n", n, estMobileValide(n) ? "valide" : "invalide"); 
        } 
    } 
} 
 
Sortie console