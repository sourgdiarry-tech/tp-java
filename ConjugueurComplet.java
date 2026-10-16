import java.util.Scanner;

public class ConjugueurComplet {
    static String[] PRONOMS = {"je", "tu", "il/elle", "nous", "vous", "ils/elles"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "UTF-8");
        System.out.print("Verbe a conjuguer (ex: parler, finir, vendre, etre, avoir, aller): ");
        String verbe = sc.nextLine().toLowerCase().trim();
        if (verbe.isEmpty()) verbe = "parler";

        System.out.println("\n========== CONJUGAISON DE : " + verbe.toUpperCase() + " ==========\n");

        conjuguer(verbe);
        sc.close();
    }

    static void conjuguer(String verbe) {
        // Gestion irreguliers
        if (verbe.equals("etre") || verbe.equals("être")) {
            conjuguerEtre(); return;
        }
        if (verbe.equals("avoir")) {
            conjuguerAvoir(); return;
        }
        if (verbe.equals("aller")) {
            conjuguerAller(); return;
        }

        String radical = verbe.substring(0, verbe.length() - 2);
        String terminaison = verbe.substring(verbe.length() - 2);

        if (terminaison.equals("er")) {
            conjER(radical, verbe);
        } else if (terminaison.equals("ir")) {
            conjIR(radical, verbe);
        } else if (terminaison.equals("re")) {
            conjRE(radical, verbe);
        } else {
            System.out.println("Verbe non reconnu. Essayez un verbe en -er, -ir, -re");
        }
    }

    static void conjER(String rad, String inf) {
        String[] present = {rad+"e", rad+"es", rad+"e", rad+"ons", rad+"ez", rad+"ent"};
        String[] imparfait = {rad+"ais", rad+"ais", rad+"ait", rad+"ions", rad+"iez", rad+"aient"};
        String[] passeSimple = {rad+"ai", rad+"as", rad+"a", rad+"ames", rad+"ates", rad+"erent"};
        String[] futur = {inf+"ai", inf+"as", inf+"a", inf+"ons", inf+"ez", inf+"ont"};
        String[] cond = {rad+"erais", rad+"erais", rad+"erait", rad+"erions", rad+"eriez", rad+"eraient"};
        String participe = rad + "e";

        afficher("Present", present);
        afficher("Imparfait", imparfait);
        afficher("Passe simple", passeSimple);
        afficher("Futur simple", futur);
        afficher("Conditionnel present", cond);
        afficherCompose("Passe compose", participe, false);
        afficherCompose("Plus-que-parfait", participe, true);
        afficherSubjonctif(rad+"e", rad+"es", rad+"e", rad+"ions", rad+"iez", rad+"ent");
        afficherImperatif(present[1], present[3], present[4]);
    }

    static void conjIR(String rad, String inf) {
        String[] present = {rad+"is", rad+"is", rad+"it", rad+"issons", rad+"issez", rad+"issent"};
        String[] imparfait = {rad+"issais", rad+"issais", rad+"issait", rad+"issions", rad+"issiez", rad+"issaient"};
        String[] futur = {inf+"ai", inf+"as", inf+"a", inf+"ons", inf+"ez", inf+"ont"};
        String[] cond = {rad+"irais", rad+"irais", rad+"irait", rad+"irions", rad+"iriez", rad+"iraient"};
        String participe = rad + "i";

        afficher("Present", present);
        afficher("Imparfait", imparfait);
        afficher("Futur simple", futur);
        afficher("Conditionnel present", cond);
        afficherCompose("Passe compose", participe, false);
        afficherSubjonctif(rad+"isse", rad+"isses", rad+"isse", rad+"issions", rad+"issiez", rad+"issent");
        afficherImperatif(present[1], present[3], present[4]);
    }

    static void conjRE(String rad, String inf) {
        String[] present = {rad+"s", rad+"s", "", rad+"ons", rad+"ez", rad+"ent"};
        String[] imparfait = {rad+"ais", rad+"ais", rad+"ait", rad+"ions", rad+"iez", rad+"aient"};
        String[] futur = {rad+"rai", rad+"ras", rad+"ra", rad+"rons", rad+"rez", rad+"ront"};
        String[] cond = {rad+"rais", rad+"rais", rad+"rait", rad+"rions", rad+"riez", rad+"raient"};
        String participe = rad + "u";

        afficher("Present", present);
        afficher("Imparfait", imparfait);
        afficher("Futur simple", futur);
        afficher("Conditionnel present", cond);
        afficherCompose("Passe compose", participe, false);
        afficherImperatif(present[1], present[3], present[4]);
    }

    static void conjuguerEtre() {
        afficher("Present", new String[]{"suis", "es", "est", "sommes", "etes", "sont"});
        afficher("Imparfait", new String[]{"etais", "etais", "etait", "etions", "etiez", "etaient"});
        afficher("Futur simple", new String[]{"serai", "seras", "sera", "serons", "serez", "seront"});
        afficher("Passe simple", new String[]{"fus", "fus", "fut", "fumes", "futes", "furent"});
        afficherCompose("Passe compose", "ete", false);
        afficher("Conditionnel", new String[]{"serais", "serais", "serait", "serions", "seriez", "seraient"});
    }
    static void conjuguerAvoir() {
        afficher("Present", new String[]{"ai", "as", "a", "avons", "avez", "ont"});
        afficher("Imparfait", new String[]{"avais", "avais", "avait", "avions", "aviez", "avaient"});
        afficher("Futur simple", new String[]{"aurai", "auras", "aura", "aurons", "aurez", "auront"});
        afficherCompose("Passe compose", "eu", false);
    }
    static void conjuguerAller() {
        afficher("Present", new String[]{"vais", "vas", "va", "allons", "allez", "vont"});
        afficher("Imparfait", new String[]{"allais", "allais", "allait", "allions", "alliez", "allaient"});
        afficher("Futur simple", new String[]{"irai", "iras", "ira", "irons", "irez", "iront"});
        afficherCompose("Passe compose", "alle", true);
    }

    static void afficher(String temps, String[] formes) {
        System.out.println("--- " + temps + " ---");
        for (int i = 0; i < 6; i++) {
            System.out.println(" " + PRONOMS[i] + " " + formes[i]);
        }
        System.out.println();
    }
    static void afficherCompose(String temps, String participe, boolean etreAux) {
        String[] aux = etreAux? new String[]{"suis", "es", "est", "sommes", "etes", "sont"} :
                                 new String[]{"ai", "as", "a", "avons", "avez", "ont"};
        System.out.println("--- " + temps + " ---");
        for (int i = 0; i < 6; i++) {
            System.out.println(" " + PRONOMS[i] + " " + aux[i] + " " + participe);
        }
        System.out.println();
    }
    static void afficherSubjonctif(String... formes) {
        System.out.println("--- Subjonctif present ---");
        for (int i = 0; i < 6; i++) {
            System.out.println(" que " + PRONOMS[i] + " " + formes[i]);
        }
        System.out.println();
    }
    static void afficherImperatif(String tu, String nous, String vous) {
        System.out.println("--- Imperatif present ---");
        System.out.println(" " + tu + "!");
        System.out.println(" " + nous + "!");
        System.out.println(" " + vous + "!\n");
    }
}