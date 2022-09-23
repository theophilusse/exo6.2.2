import java.util.UUID;

public class Volaille {
    UUID id;
    float taille;
    float poids;
    int jours;

    public Volaille() {
        id = UUID.randomUUID();
        taille = 1.0f + (float) Math.random() * 3.0f;
        poids = 0.4f + (float) Math.random() * 0.3f;
        jours = 21;
    }

    public String toString()
    {
        return ("taille: [" + taille + "cm], poids: [" + poids + "kg] jours: " + jours);
    }
}
