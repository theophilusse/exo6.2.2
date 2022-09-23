public class exoVolaille {
    public static void main(String[] args) {
        Elevage e;

        e = new Elevage("Jean");
        e.ajouterCannard(5);
        e.ajouterPoulet(5);
        for (int i = 0; i < 49; i++) {
            //e.afficherElevage();
            Terminal.ecrireStringln("--------------------V " + i + " V--------------------");
            Terminal.ecrireStringln("Poids moyen canards: " + e.poidsMoyenCanards());
            Terminal.ecrireStringln("Poids moyen poulets: " + e.poidsMoyenPoulets());
            e.newDay(1);
        }
        Terminal.ecrireStringln("+$" + e.vendreCanards(3));
        Terminal.ecrireStringln("+$" + e.vendrePoulet(3));
        Terminal.ecrireStringln("" + e);
    }
}
