package iut.bad;


public class Femme extends Humain {
    private String nom;
    private String prenom;
    private int age;

    public Femme(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    // Getters
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public int getAge() { return age; }
}
