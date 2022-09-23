public class Canard extends Volaille {
    float           calibreMin;
    public          Canard()
    {
        super();
        calibreMin = 6.5f;
    }

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

    public boolean  isReady()
    {
        if (taille > calibreMin)
            return (true);
        return (false);
    }

    public String       toString()
    {
        return ("Canard: " + super.toString());
    }
}
