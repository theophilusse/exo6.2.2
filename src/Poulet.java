public class Poulet extends Volaille {

    float           calibreMin;
    public          Poulet()
    {
        super();
        calibreMin = 5f;
    }

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

    public boolean  isReady()
    {
        if (taille > calibreMin)
            return (true);
        return (false);
    }

    @Override
    public String       toString()
    {
        return ("Poulet " + super.toString());
    }
}
