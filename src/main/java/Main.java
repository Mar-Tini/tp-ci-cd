import iut.bad.Femme;
import iut.bad.Homme;

public class Main {

    public static void main(String[] args) {

        Homme h = new Homme("Dupont", "Jean", 25);
        Femme f = new Femme("Martin", "Marie", 23);

        f.ami(h); 
        h.ami(f, 365); 

    }

}