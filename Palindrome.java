public class Palindrome {

    // Version 1 : Boucle avec deux indices (demandée dans le sujet)
    // Sans tenir compte des espaces ni de la casse
    public static boolean estPalindrome(String s) {
        if (s == null) return false;
        
        // Nettoyage : minuscule + enlève espaces
        String clean = s.toLowerCase().replaceAll("\\s+", "");
        
        int debut = 0;
        int fin = clean.length() - 1;
        
        while (debut < fin) {
            if (clean.charAt(debut) != clean.charAt(fin)) {
                return false;
            }
            debut++;
            fin--;
        }
        return true;
    }

    // Version 2 : Avec StringBuilder.reverse() (demandée dans le sujet)
    public static boolean estPalindromeV2(String s) {
        if (s == null) return false;
        
        String clean = s.toLowerCase().replaceAll("\\s+", "");
        String inverse = new StringBuilder(clean).reverse().toString();
        
        return clean.equals(inverse);
    }

    public static void main(String[] args) {
        String[] tests = {
            "kayak",
            "Engage le jeu que je le gagne",
            "Dakar",
            "Esope reste ici et se repose"
        };

        for (String test : tests) {
            System.out.println("--- Test : \"" + test + "\" ---");
            System.out.println("V1 boucle : " + estPalindrome(test));
            System.out.println("V2 StringBuilder : " + estPalindromeV2(test));
            System.out.println();
        }
    }
}