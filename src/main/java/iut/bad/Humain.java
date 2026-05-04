package iut.bad;

public class Humain implements Consommation {

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

    @Override
    public void manger() {
        System.out.println(prenom + " est en train de manger.");
    }

    @Override
    public void boire() {
        System.out.println(prenom + " est en train de boire.");
    }

    public void ami(Humain autre) {
        System.out.println(prenom + " et " + autre.prenom + " sont amis.");
    }
}
