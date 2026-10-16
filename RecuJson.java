public class RecuJson {
    static String recuJson(String client, String[] articles, long[] prix, int[] quantites) {
        StringBuilder sb = new StringBuilder();
        long total = 0;

        for (int i = 0; i < articles.length; i++) {
            long sous = prix[i] * quantites[i];
            total += sous;

            sb.append("""
                {
                  "libelle": "%s",
                  "quantite": %d,
                  "prixUnitaire": %d,
                  "sousTotal": %d
                }""".formatted(articles[i], quantites[i], prix[i], sous));

            if (i < articles.length - 1) sb.append(",");
            sb.append("\n");
        }

        return """
            {
              "client": "%s",
              "lignes": [
            %s],
              "totalGeneral": %d
            }""".formatted(client, sb.toString(), total);
    }

    public static void main(String[] args) {
        System.out.println(recuJson("Awa Diop",
            new String[]{"Bazin", "Boubou"},
            new long[]{18500, 25000},
            new int[]{1, 2}));
    }
}