import java.util.UUID;

/**
 *
 * Classe mere Volaille, regroupe les attributs des base.
 *
*/
public class Volaille {
    UUID    id;
    float   taille;
    float   poids;
    int     jours;

    /**
     *
     * Constructeur de la classe mere, les nouvelle volailles arrivent avec trois semaines de croissance.
     *
    */
    public          Volaille()
    {
        id = UUID.randomUUID();
        taille = 1.0f + (float) Math.random() * 3.0f;
        poids = 0.4f + (float) Math.random() * 0.3f;
        jours = 21;
    }

    /**
     *
     * Retourne les informations de la volaille au format humain.
     *
     * @return String
     *
    */
    public String   toString()
    {
        return ("taille: [" + taille + "cm], poids: [" + poids + "kg] jours: " + jours);
    }
}
