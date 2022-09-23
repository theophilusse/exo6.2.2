/**
 *
 * Classe Poulet heritee de Volaille, avec croissance specifique.
 *
*/
public class Poulet extends Volaille {

    float           calibreMin;

    /**
     *
     * Constructeur de poulet, assigne le calibre minimum a la vente.
     *
    */
    public          Poulet()
    {
        super();
        calibreMin = 5f;
    }

    /**
     *
     * Methode faisant grandir un poulet (poids et taille), plus vite en debut de croissance.
     * La croissance est de 60 jours.
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
            poids += (float)Math.random() * (float)(Math.pow(60 - jours, 2) / 5500);
            v = (float)Math.random() * 1.2f;
            taille += v;
        }
        return (v);
    }

    /**
     *
     * Methode s'assurant de la taille minimum d'un poulet pour la vente.
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
     * Methode renvoyant les informations du poulet au format humain.
     *
     * @return String
     *
    */
    public String   toString()
    {
        return ("Poulet " + super.toString());
    }
}
