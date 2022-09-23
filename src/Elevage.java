import java.util.ArrayList;

public class Elevage {
    String nom;
    Marche                     m;
    ArrayList<Poulet>          p;
    ArrayList<Canard>          c;
    int                        date;
    float                      cash;

    public Elevage(String nom)
    {
        this.nom = nom;
        date = 0;
        cash = 0f;
        p = new ArrayList<Poulet>();
        c = new ArrayList<Canard>();
        m = new Marche();
    }

    public void          ajouterPoulet(int n)
    {
        for (int i = 0; i < n; i++)
            p.add(new Poulet());
    }

    public void          ajouterCannard(int n)
    {
        for (int i = 0; i < n; i++)
            c.add(new Canard());
    }

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
                if (--n <= 0)
                    break;
            }
        cash += gain;
        return (gain);
    }

    public float         vendrePoulet(int n)
    {
        float           gain;

        if (n <= 0)
            return (0f);
        gain = 0f;
        for (int i = 0; i < p.size(); i++)
            if (p.get(i).isReady()) {
                gain += m.prix(p.get(i));
                p.remove(i);
                if (--n <= 0)
                    break;
            }
        cash += gain;
        return (gain);
    }

    public void     newDay(int n)
    {
        for (int j = 0; j < n; j++)
        {
            m.newDay();
            for (int i = 0; i < p.size(); i++)
                p.get(i).grow();
            for (int i = 0; i < c.size(); i++)
                c.get(i).grow();
        }
    }

    public int      pouletsPret()
    {
        int     count;

        count = 0;
        for (int i = 0; i < p.size(); i++)                      // Compte les poulets disponibles a la vente
            if (p.get(i).isReady())
                count++;
        return (count);
    }

    public int      canardsPret()
    {
        int     count;

        count = 0;
        for (int i = 0; i < c.size(); i++)                      // Compte les poulets disponibles a la vente
            if (c.get(i).isReady())
                count++;
        return (count);
    }

    public void     afficherElevage()
    {
        for (int i = 0; i < p.size(); i++)
            Terminal.ecrireStringln(p.get(i) + "");
        for (int i = 0; i < c.size(); i++)
            Terminal.ecrireStringln(c.get(i) + "");
    }

    public float    poidsMoyenPoulets()
    {
        float           sum;

        sum = 0f;
        for (int i = 0; i < p.size(); i++)
            sum += p.get(i).poids;
        return (sum / p.size());
    }

    public float    poidsMoyenCanards()
    {
        float           sum;

        sum = 0f;
        for (int i = 0; i < c.size(); i++)
            sum += c.get(i).poids;
        return (sum / c.size());
    }

    public String   toString()
    {
        String          out;
        int             count;

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
