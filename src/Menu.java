/**
 *
 * Classe permettant de creer facilement un menu de type CLI
 *
 */
public class Menu {
    String[]        option;
    String          prefix;

    /**
     *
     * Constructeur principal, sans prefix.
     *
     * @param option Liste des options proposees.
     *
     */
    public                          Menu(String[] option)
    {
        this.option = option;
        this.prefix = "";
    }

    /**
     *
     * Contructeur avec prefix.
     *
     * @param option Liste des options proposees.
     * @param prefix Nom du menu.
     *
     */
    public                          Menu(String[] option, String prefix)
    {
        this.option = option;
        this.prefix = prefix;
    }

    /**
     *
     * Getter de l'attribut option.
     *
     * @return Les options du menu.
     *
     */
    public String[]                 getOption() {
        return option;
    }

    /**
     *
     * Setter de l'attribut option.
     *
     * @param option Remplace les options.
     *
     */
    public void                     setOption(String[] option) {
        this.option = option;
    }

    /**
     *
     * Ajoute une option au menu.
     *
     * @param s Nouvelle option.
     *
     */
    public void                     addOption(String s)
    {
        String[]    opt;
        int         len;

        len = option.length;
        opt = new String[len + 1];
        opt[len] = s;
        option = opt;
    }

    /**
     *
     * Methode pour demander un nombre reel (float) a l'utilisateur.
     *
     * @param prompt Prefix du shell.
     * @return La valeur castee en float.
     *
     */
    public static float              askRealNumber(String prompt)
    {
        float       ret;

        while (true)
        {
            try
            {
                ret = Terminal.lireFloat(prompt);
                return (ret);
            } catch (TerminalException e) {
                Terminal.ecrireStringln("Entrez un nombre valide!");
            }
        }
    }

    /**
     *
     * Methode pour demander un nombre entier (int) a l'utilisateur.
     *
     * @param prompt Prefix du shell.
     * @return La valeur castee en int
     *
     */
    public static int              askNumber(String prompt)
    {
        int         ret;

        while (true)
        {
            try
            {
                ret = Terminal.lireInt(prompt);
                return (ret);
            } catch (TerminalException e) {
                Terminal.ecrireStringln("Entrez un nombre valide!");
            }
        }
    }

    /**
     *
     * Methode pour demander une chaine de caractere a l'utilisateur.
     *
     * @param prompt Prefix du shell.
     * @return Chaine entree par l'utilisateur de taille non nulle.
     *
     */
    public static String           askString(String prompt)
    {
        String      s;

        s = "";
        while (s.length() == 0)
            s = Terminal.lireString(prompt + ": ").trim();
        return (s);
    }

    /**
     *
     * Affiche le menu, compose des differentes options.
     *
     * @return Le menu dans une String.
     *
     */
    public String                   toString()
    {
        String      out;

        if (option == null)
            return ("");
        out = "";
        if (!prefix.equals(""))
            out += prefix + "\n";
        for (int i = 0; i < option.length; i++)
            out += "(" + i + ") -> " + option[i].substring(0, 1).toUpperCase() + option[i].substring(1) + "\n";
        return (out);
    }

    /**
     *
     * Affiche le menu et demande a l'utilisateur une option a choisir.
     *
     * @return Index de l'option choisie.
     *
     */
    public int                      ask()
    {
        String      input;

        input = askString(toString()).toLowerCase();
        for (char i = 0; i < option.length; i++)
            if (input.equals(option[i]))
                return (i);
        return (ask());
    }
}
