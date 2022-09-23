/**
 *
 * Classe Marche, propose des prix de rachat pour differents produits.
 *
*/
public class Marche {
    /**
     *
     * Attributs
     * prixKg[0] - poulet
     * prixKg[1] - canard
     *
    */
    float[]         prixKg;
    boolean         prixConstant;

    /**
     *
     * Constructeur initialisant le cours du poulet et du canard.
     *
    */
    public                  Marche()
    {
        prixKg = new float[2];
        prixKg[0] = 3.75f;
        prixKg[1] = 5f;
    	prixConstant = false;
    }

    /**
     *
     * Bloque les prix de vente sur une valeur fixe.
     *
     * @param float prixPoulet
     * @param float prixCanard
     *
    */
    public void		        setPrixKg(float poulet, float canard)
    {
	    prixKg[0] = poulet > 0 ? poulet : 3.75;
	    prixKg[1] = canard > 0 ? canard : 5f;
	    prixConstant = true;
    }

    /**
     *
     * Active les fluctuations journalieres des prix.
     *
    */
    public void 	        unlockPrix()
    {
    	prixConstant = false;
    }

    /**
     *
     * Methode calculant le prix d'un poulet donne, en fonction de son poids et du prix au kilo ce jour.
     *
     * @param Poulet p
     * @return float
     *
    */
    public float            prix(Poulet p)
    {
        Terminal.ecrireStringln(p.poids + "kg, taille: " + p.taille);
        if (!p.isReady())
            return (0f);
        return (p.poids * prixKg[0]);
    }

    /**
     *
     * Methode calculant le prix d'un canard donne, en fonction de son poids et du prix au kilo ce jour.
     *
     * @param Canard c
     * @return float
     *
    */
    public float            prix(Canard c)
    {
        Terminal.ecrireStringln(c.poids + "kg, taille: " + c.taille);
        if (!c.isReady())
            return (0f);
        return (c.poids * prixKg[1]);
    }

    /**
     *
     * Met a jours les prix au kilo.
     *
    */
    public void             newDay()
    {
	    if (prixConstant)
            return ;
        prixKg[0] = 7.5f + ((float)Math.random() * 5 - 2.5f);
        prixKg[1] = 10f + ((float)Math.random() * 7 - 3.5f);
        for (int i = 0; i < prixKg.length; i++) // Clamp
	        if (prixKg[i] < 0f)
	            prixKg[i] = 0f;
    }

    /**
     *
     * Affiche les prix au format humain.
     *
     * @return String out
     *
    */
    public String           toString()
    {
        return ("Tarif/kg Poulet: " + prixKg[0] + "\nTarif/kg Canard: " + prixKg[1] + "\n");
    }
}
