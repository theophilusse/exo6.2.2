public class Marche {
    float[]                     prixKg;

    public Marche()
    {
        prixKg = new float[2];
        prixKg[0] = 3.75f;
        prixKg[1] = 5f;
    }

    public float            prix(Poulet p)
    {
        Terminal.ecrireStringln(p.poids + "kg, taille: " + p.taille);
        if (!p.isReady())
            return (0f);
        return (p.poids * prixKg[0]);
    }

    public float            prix(Canard c)
    {
        Terminal.ecrireStringln(c.poids + "kg, taille: " + c.taille);
        if (!c.isReady())
            return (0f);
        return (c.poids * prixKg[1]);
    }

    public void             newDay()
    {
        prixKg[0] = 7.5f + ((float)Math.random() * 5 - 2.5f);
        prixKg[1] = 10f + ((float)Math.random() * 7 - 3.5f);
    }

    public String           toString()
    {
        return ("Tarif/kg Poulet: " + prixKg[0] + "\nTarif/kg Canard: " + prixKg[1] + "\n");
    }
}
