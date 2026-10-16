public class Validation {
    public static boolean estEmailValide(String email) {
        if (email == null) return false;
        String regex = "^[A-Za-z0-9._-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}(\\.[A-Za-z]{2,6})?$";
        return email.matches(regex);
    }

    // 2. Référence produit TerangaShop : PRD- suivi de exactement 3 chiffres
    public static boolean estReferenceValide(String ref) {
        if (ref == null) return false;
        return ref.matches("^PRD-\\d{3}$");
    }

    public static void main(String[] args) {
        // Tests demandés dans l'énoncé
        System.out.println("awa.diop@isep.edu.sn -> " + estEmailValide("awa.diop@isep.edu.sn")); // true
        System.out.println("moussa@gmail -> " + estEmailValide("moussa@gmail")); // false - pas d'extension
        System.out.println("@wave.com -> " + estEmailValide("@wave.com")); // false - pas de partie locale

        System.out.println("---");
        System.out.println("PRD-001 -> " + estReferenceValide("PRD-001")); // true
        System.out.println("PRD-12 -> " + estReferenceValide("PRD-12")); // false
        System.out.println("PRD-1234 -> " + estReferenceValide("PRD-1234")); // false
    }
}