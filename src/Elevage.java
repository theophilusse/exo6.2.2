import java.util.ArrayList;

/**
 *
 * Classe Elevage, fais pousser des volailles en echange d'argent.
 *
*/
public class Elevage {
    String nom;
    Marche                     m;
    ArrayList<Poulet>          p;
    ArrayList<Canard>          c;
    int                        date;
    float                      cash;

    /**
     *
     * Constructeur d'elevage.
     * Cree une liste de poulets et de canards, initialisation de l'orloge et du portefeuille.
     * 
     * @param nom Nom de l'elevage
     *
    */
    public Elevage(String nom)
    {
        this.nom = nom;
        date = 0;
        cash = 0f;
        p = new ArrayList<Poulet>();
        c = new ArrayList<Canard>();
        m = new Marche();
    }

    /**
     *
     * Methode pour ajouter un certain nombre de poulets.
     *
     * @param n Nombre de poulets
     *
    */
    public void          ajouterPoulet(int n)
    {
        for (int i = 0; i < n; i++)
            p.add(new Poulet());
    }

    /**
     *
     * Methode pour ajouter un certain nombre de canards.
     *
     * @param n Nombre de canards
     *
    */
    public void          ajouterCanard(int n)
    {
        for (int i = 0; i < n; i++)
            c.add(new Canard());
    }

    /**
     *
     * Methode vendant jusqu'a n nombre de canards prets, au prix de vente du jour.
     *
     * @param n Nombre maximum de canard a vendre.
     * @return float gain
     *
    */
    public float         vendreCanards(int n)
    {
        float           gain;

        if (n <= 0)
            return (0f);
        gain = 0f;
        for (int i = 0; i < c.size(); i++)
            if (c.get(i).isReady()) {
                gain += m.prix(c.get(i));
                c.remove(i);
        		i--;
                if (--n <= 0)
                    break;
            }
        cash += gain;
        return (gain);
    }

    /**
     *
     * Methode vendant jusqu'a n nombre de poulets prets, au prix de vente du jour.
     *
     * @param n Nombre maximum de poulet a vendre.
     * @return float gain
     *
    */
    public float         vendrePoulets(int n)
    {
        float           gain;

        if (n <= 0)
            return (0f);
        gain = 0f;
        for (int i = 0; i < p.size(); i++)
            if (p.get(i).isReady()) {
                gain += m.prix(p.get(i));
                p.remove(i);
		        i--;
                if (--n <= 0)
                    break;
            }
        cash += gain;
        return (gain);
    }

    /**
     *
     * Methode incrementant la date de n jours, fais grandir les volailles en consequence.
     *
     * @param n Nombre de jours a attendre.
     * @return n Nombre de jours attendu
     *
    */
    public int      newDay(int n)
    {
        if (n == 0)
            return (0);
        for (int j = 0; j < n; j++)
        {
            m.newDay();
            for (int i = 0; i < p.size(); i++)
                p.get(i).grow();
            for (int i = 0; i < c.size(); i++)
                c.get(i).grow();
            date++;
        }
        return (n);
    }

    /**
     *
     * Methode comptant le nombre de poulets prets a la vente.
     *
     * @return int count
     *
    */
    public int      pouletsPret()
    {
        int     count;

        count = 0;
        for (int i = 0; i < p.size(); i++)
            if (p.get(i).isReady())
                count++;
        return (count);
    }

    /**
     *
     * Methode comptant le nombre de canards prets a la vente.
     *
     * @return int count
     *
    */
    public int      canardsPret()
    {
        int     count;

        count = 0;
        for (int i = 0; i < c.size(); i++)
            if (c.get(i).isReady())
                count++;
        return (count);
    }

    /**
     *
     * Methode affichant les details toutes les volailles.
     *
    */
    public void     afficherElevage()
    {
        for (int i = 0; i < p.size(); i++)
            Terminal.ecrireStringln(p.get(i) + "");
        for (int i = 0; i < c.size(); i++)
            Terminal.ecrireStringln(c.get(i) + "");
    }

    /**
     *
     * Methode calculant le poids moyen de tout les poulets.
     *
     * @return Float
     *
    */
    public float    poidsMoyenPoulets()
    {
        float           sum;

        sum = 0f;
        for (int i = 0; i < p.size(); i++)
            sum += p.get(i).poids;
        return (sum / p.size());
    }

    /**
     *
     * Methode calculant le poids moyen de tout les canards.
     *
     * @return float
     *
    */
    public float    poidsMoyenCanards()
    {
        float           sum;

        sum = 0f;
        for (int i = 0; i < c.size(); i++)
            sum += c.get(i).poids;
        return (sum / c.size());
    }

    /**
     *
     * Methode retournant les informations de l'elevage au format humain.
     *
     * @return String out
     *
    */
    public String   toString()
    {
        String          out;

        // Affiche le nom de l'elevage et le nombre de poulets prets
        out = "Elevage " + nom + "\nPoulets: " + p.size() + " (" + pouletsPret() + " prets)\n";
        // Affiche le nombre de canards prets
        out += "Canards: " + c.size() + " (" + canardsPret() + " prets)\n";
        // Prix de vente a ce jour
        out += m;
        // Affiche la tresorerie
        out += "Tresorerie: " + cash + "\n";
        return (out);

    }
}
