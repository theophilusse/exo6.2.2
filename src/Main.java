/**
 *
 * Point d'entree du programme.
 *
*/
public class Main {
    /**
     *
     * Main test.
     *
     * @param args Liste d'argurments.
     *
    */
    public static void main(String[] args)
    {
        loop(new Elevage(Menu.askString("Nom de l'elevage")));
    }

    /**
     *
     * Boucle principale.
     *
     * @param e Elevage.
     *
    */
    public static void loop(Elevage e)
    {
        int         index;
        Menu        menu;
        String[]    option = { "afficher", "afficher tout", "poulets prets", "canards prets",
                                "ajouter poulet", "ajouter canard", "vendre poulet", "vendre canard",
                                "fixer prix", "debloquer prix", "dormir", "quitter" };

        index = -1;
        menu = new Menu(option, "Options: ");
        while (index != 11)
        {
            index = menu.ask();
            switch (index)
            {
                case 0:
                {
                    Terminal.ecrireStringln(e.toString());
                    break;
                }
                case 1:
                {
                    e.afficherElevage();
                    break;
                }
                case 2:
                {
                    Terminal.ecrireStringln("Poulets prets: " + e.pouletsPret());
                    break;
                }
                case 3:
                {
                    Terminal.ecrireStringln("Canards prets: " + e.canardsPret());
                    break;
                }
                case 4:
                {
                    e.ajouterPoulet(Menu.askNumber("Combien?: "));
                    break;
                }
                case 5:
                {
                    e.ajouterCanard(Menu.askNumber("Combien?: "));
                    break;
                }
                case 6:
                {
                    Terminal.ecrireStringln("+$" + e.vendrePoulets(Menu.askNumber("Combien?: ")));
                    break;
                }
                case 7:
                {
                    Terminal.ecrireStringln("+$" + e.vendreCanards(Menu.askNumber("Combien?: ")));
                    break;
                }
                case 8:
                {
                    e.m.setPrixKg(Menu.askRealNumber("Prix du poulet au kg: "),
                                    Menu.askRealNumber("Prix du canard au kg: "));
                    break;
                }
                case 9:
                {
                    e.m.unlockPrix();
                    Terminal.ecrireStringln("Prix fluctuants.");
                    break;
                }
                case 10:
                {
                    Terminal.ecrireStringln("Vous dormez " + e.newDay(Menu.askNumber("Combien?: ")) + " jours");
                    break;
                }
            }
            Terminal.ecrireStringln("---------------V J" + e.date + " V---------------");
        }
        Terminal.ecrireStringln("Bye!");
    }
}
