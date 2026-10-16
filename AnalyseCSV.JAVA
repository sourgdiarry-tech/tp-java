public class AnalyseCSV {
    public static void main(String[] args) {

        String ligne = "2026-09-14;TS-2026-000087;Awa Diop;Médina;WAVE;18500";

        String[] champs = ligne.split(";");
        if (champs.length!= 6) {
            System.out.println("Ligne invalide");
            return;
        }

        String date = champs[0].trim();
        String ref = champs[1].trim();
        String client = champs[2].trim();
        String quartier = champs[3].trim().toUpperCase(); // en majuscules demandé
        String paiement = champs[4].trim();
        String montant = champs[5].trim();

        // Résumé lisible sur plusieurs lignes avec text block
        String resume = """
                --- Vente ---
                Date: %s
                Référence: %s
                Client: %s
                Quartier: %s
                Paiement: %s
                Montant: %s FCFA
                """.formatted(date, ref, client, quartier, paiement, montant);

        System.out.println(resume);
    }
}