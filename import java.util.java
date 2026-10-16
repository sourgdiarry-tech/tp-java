import java.util.Scanner;

public class ConjugueurComplet {

    static String[] PRONOMS = {"je", "tu", "il/elle", "nous", "vous", "ils/elles"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez un verbe a l'infinitif (ex: parler, finir, vendre, etre, avoir, aller): ");
        String verbe = sc.nextLine().toLowerCase().trim().replace("é", "e").replace("è", "e");

        if (verbe.equals("")) verbe = "parler";

        System.out.println("\n========== CONJUGAISON DU VERBE : " + verbe.toUpperCase() + " ==========\n");

        // Verbes irreguliers les plus courants
        if (verbe.equals("etre")) {
            conjuguerEtre();
        } else if (verbe.equals("avoir")) {
            conjuguerAvoir();
        } else if (verbe.equals("aller")) {
            conjuguerAller();
        } else if (verbe.equals("faire")) {
            conjuguerFaire();
        } else if (verbe.endsWith("er")) {
            conjuguerER(verbe);
        } else if (verbe.endsWith("ir")) {
            conjuguerIR(verbe);
        } else if (verbe.endsWith("re")) {
            conjuguerRE(verbe);
        } else {
            System.out.println("Verbe non reconnu. Utilisez un verbe en -er, -ir, -re, etre, avoir, aller, faire");
        }
        sc.close();
    }

    // ===== GROUPE 1 : -er comme parler =====
    static void conjuguerER(String verbe) {
        String rad = verbe.substring(0, verbe.length() - 2);
        String radI = rad; // radical pour imparfait/subjonctif

        afficher("INDICATIF PRESENT", new String[]{rad+"e", rad+"es", rad+"e", rad+"ons", rad+"ez", rad+"ent"});
        afficher("IMPARFAIT", new String[]{radI+"ais", radI+"ais", radI+"ait", radI+"ions", radI+"iez", radI+"aient"});
        afficher("PASSE SIMPLE", new String[]{rad+"ai", rad+"as", rad+"a", rad+"ames", rad+"ates", rad+"erent"});
        afficher("FUTUR SIMPLE", new String[]{verbe+"ai", verbe+"as", verbe+"a", verbe+"ons", verbe+"ez", verbe+"ont"});
        afficher("CONDITIONNEL PRESENT", new String[]{verbe+"ais", verbe+"ais", verbe+"ait", verbe+"ions", verbe+"iez", verbe+"aient"});
        afficherCompose("PASSE COMPOSE (avec avoir)", new String[]{"ai", "as", "a", "avons", "avez", "ont"}, rad+"e");
        afficherCompose("PLUS-QUE-PARFAIT", new String[]{"avais", "avais", "avait", "avions", "aviez", "avaient"}, rad+"e");
        afficherSubjonctif("SUBJONCTIF PRESENT", new String[]{rad+"e", rad+"es", rad+"e", rad+"ions", rad+"iez", rad+"ent"});
        afficherImperatif(rad+"e", rad+"ons", rad+"ez");
    }

    // ===== GROUPE 2 : -ir comme finir =====
    static void conjuguerIR(String verbe) {
        String rad = verbe.substring(0, verbe.length() - 2);
        afficher("INDICATIF PRESENT", new String[]{rad+"is", rad+"is", rad+"it", rad+"issons", rad+"issez", rad+"issent"});
        afficher("IMPARFAIT", new String[]{rad+"issais", rad+"issais", rad+"issait", rad+"issions", rad+"issiez", rad+"issaient"});
        afficher("FUTUR SIMPLE", new String[]{verbe+"ai", verbe+"as", verbe+"a", verbe+"ons", verbe+"ez", verbe+"ont"});
        afficher("CONDITIONNEL PRESENT", new String[]{verbe+"ais", verbe+"ais", verbe+"ait", verbe+"ions", verbe+"iez", verbe+"aient"});
        afficherCompose("PASSE COMPOSE", new String[]{"ai", "as", "a", "avons", "avez", "ont"}, rad+"i");
        afficherSubjonctif("SUBJONCTIF PRESENT", new String[]{rad+"isse", rad+"isses", rad+"isse", rad+"issions", rad+"issiez", rad+"issent"});
        afficherImperatif(rad+"is", rad+"issons", rad+"issez");
    }

    // ===== GROUPE 3 : -re comme vendre =====
    static void conjuguerRE(String verbe) {
        String rad = verbe.substring(0, verbe.length() - 2);
        afficher("INDICATIF PRESENT", new String[]{rad+"s", rad+"s", rad+"", rad+"ons", rad+"ez", rad+"ent"});
        afficher("IMPARFAIT", new String[]{rad+"ais", rad+"ais", rad+"ait", rad+"ions", rad+"iez", rad+"aient"});
        afficher("FUTUR SIMPLE", new String[]{rad+"rai", rad+"ras", rad+"ra", rad+"rons", rad+"rez", rad+"ront"});
        afficher("CONDITIONNEL PRESENT", new String[]{rad+"rais", rad+"rais", rad+"rait", rad+"rions", rad+"riez", rad+"raient"});
        afficherCompose("PASSE COMPOSE", new String[]{"ai", "as", "a", "avons", "avez", "ont"}, rad+"u");
        afficherImperatif(rad+"s", rad+"ons", rad+"ez");
    }

    static void conjuguerEtre() {
        afficher("INDICATIF PRESENT", new String[]{"suis", "es", "est", "sommes", "etes", "sont"});
        afficher("IMPARFAIT", new String[]{"etais", "etais", "etait", "etions", "etiez", "etaient"});
        afficher("PASSE SIMPLE", new String[]{"fus", "fus", "fut", "fumes", "futes", "furent"});
        afficher("FUTUR SIMPLE", new String[]{"serai", "seras", "sera", "serons", "serez", "seront"});
        afficher("CONDITIONNEL PRESENT", new String[]{"serais", "serais", "serait", "serions", "seriez", "seraient"});
        afficherCompose("PASSE COMPOSE", new String[]{"ai", "as", "a", "avons", "avez", "ont"}, "ete");
    }
    static void conjuguerAvoir() {
        afficher("INDICATIF PRESENT", new String[]{"ai", "as", "a", "avons", "avez", "ont"});
        afficher("IMPARFAIT", new String[]{"avais", "avais", "avait", "avions", "aviez", "avaient"});
        afficher("FUTUR SIMPLE", new String[]{"aurai", "auras", "aura", "aurons", "aurez", "auront"});
        afficher("CONDITIONNEL PRESENT", new String[]{"aurais", "aurais", "aurait", "aurions", "auriez", "auraient"});
        afficherCompose("PASSE COMPOSE", new String[]{"ai", "as", "a", "avons", "avez", "ont"}, "eu");
    }
    static void conjuguerAller() {
        afficher("INDICATIF PRESENT", new String[]{"vais", "vas", "va", "allons", "allez", "vont"});
        afficher("IMPARFAIT", new String[]{"allais", "allais", "allait", "allions", "alliez", "allaient"});
        afficher("FUTUR SIMPLE", new String[]{"irai", "iras", "ira", "irons", "irez", "iront"});
        afficher("CONDITIONNEL PRESENT", new String[]{"irais", "irais", "irait", "irions", "iriez", "iraient"});
        afficherCompose("PASSE COMPOSE", new String[]{"suis", "es", "est", "sommes", "etes", "sont"}, "alle");
    }
    static void conjuguerFaire() {
        afficher("INDICATIF PRESENT", new String[]{"fais", "fais", "fait", "faisons", "faites", "font"});
        afficher("IMPARFAIT", new String[]{"faisais", "faisais", "faisait", "faisions", "faisiez", "faisaient"});
        afficher("FUTUR SIMPLE", new String[]{"ferai", "feras", "fera", "ferons", "ferez", "feront"});
        afficher("CONDITIONNEL PRESENT", new String[]{"ferais", "ferais", "ferait", "ferions", "feriez", "feraient"});
        afficherCompose("PASSE COMPOSE", new String[]{"ai", "as", "a", "avons", "avez", "ont"}, "fait");
    }

    // ===== AFFICHAGE =====
    static void afficher(String temps, String[] f) {
        System.out.println("--- " + temps + " ---");
        for (int i = 0; i < 6; i++) {
            System.out.println(" " + PRONOMS[i] + " " + f[i]);
        }
        System.out.println();
    }
    static void afficherCompose(String temps, String[] aux, String part) {
        System.out.println("--- " + temps + " ---");
        for (int i = 0; i < 6; i++) {
            System.out.println(" " + PRONOMS[i] + " " + aux[i] + " " + part);
        }
        System.out.println();
    }
    static void afficherSubjonctif(String temps, String[] f) {
        System.out.println("--- " + temps + " ---");
        for (int i = 0; i < 6; i++) {
            System.out.println(" que " + PRONOMS[i] + " " + f[i]);
        }
        System.out.println();
    }
    static void afficherImperatif(String tu, String nous, String vous) {
        System.out.println("--- IMPERATIF PRESENT ---");
        System.out.println(" " + tu + "!");
        System.out.println(" " + nous + "!");
        System.out.println(" " + vous + "!");
        System.out.println();
    }
}