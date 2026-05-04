package iut.bad;

public class Humain {

    protected String nom;
    protected String prenom;
    protected int age;

    public Humain(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public int getAge() { return age; }

    @Override
    public String toString() {
        return nom + " " + prenom + ", " + age + " ans";
    }

    public void details() {
        System.out.println(toString());
    }
}
