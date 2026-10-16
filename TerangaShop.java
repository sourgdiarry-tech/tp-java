public class TerangaShop {
    public static void main(String[] args) {
        String s = " TerangaShop, Dakar - Sénégal ";

        // 1. Longueur avant et après nettoyage
        System.out.println("Longueur avant trim : " + s.length());

        String clean = s.trim();
        System.out.println("Chaîne sans espaces extérieurs : [" + clean + "]");
        System.out.println("Longueur après trim : " + clean.length());

        // 2. Position de la virgule
        int posVirgule = clean.indexOf(',');
        System.out.println("Position de la virgule : " + posVirgule);

        // 3. Nom de la ville (Dakar) extrait avec substring et indexOf
        // clean = "TerangaShop, Dakar - Sénégal"
        // On cherche après la virgule et espace
        int debutVille = clean.indexOf(',') + 2; // +2 pour sauter ", "
        int finVille = clean.indexOf(" -"); // espace + tiret
        String ville = clean.substring(debutVille, finVille);
        System.out.println("Ville extraite : " + ville);

        // 4. Chaîne en majuscules
        System.out.println("En majuscules : " + clean.toUpperCase());

        // 5. Nombre de mots
        // split sur un ou plusieurs espaces ou tiret
        String[] mots = clean.split("[\\s,-]+");
        // [\\s,-]+ = espaces, virgule, tiret
        System.out.println("Nombre de mots : " + mots.length);
        System.out.print("Mots : ");
        for (String mot : mots) {
            System.out.print("[" + mot + "] ");
        }
        System.out.println();
    }
}
