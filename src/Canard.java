/**
 *
 * Classe Cannard heritee de Volaille, avec croissance specifique.
 *
*/
public class Canard extends Volaille {
    float           calibreMin;

    /**
     *
     * Constructeur de cannard.
     * Applique le calibre minimum.
     *
     */
    public          Canard()
    {
        super();
        calibreMin = 6.5f;
    }

    /**
     *
     * Methode faisant grandire un canard d'une journee (poids et taille), plus vite en debut de croissance.
     * La duree de la croissance est de 60 jours
     *
     * @return float v
     *
     */
    public float    grow()
    {
        float       v;

        jours++;
        v = 0f;
        if (jours < 60)
        {
            poids += (float)Math.random() * (float)(Math.pow(60 - jours, 2) / 6000);
            v = (float)Math.random() * 1.2f;
            taille += v;
        }
        return (v);
    }

    /**
     *
     * Methode s'assurant de la taille minimum d'un canard pour la vente.
     *
     * @return boolean
     *
    */
    public boolean  isReady()
    {
        if (taille > calibreMin)
            return (true);
        return (false);
    }

    /**
     *
     * Methode renvoyant les information du canard au format humain.
     *
     * @return String
     *
    */
    public String   toString()
    {
        return ("Canard: " + super.toString());
    }
}
