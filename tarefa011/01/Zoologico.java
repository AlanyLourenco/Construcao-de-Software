public class Zoologico {
    private Animal[] jaulas;

    public Zoologico() {
        jaulas = new Animal[10];
        jaulas[0] = new Cachorro("Rex");
        jaulas[1] = new Cavalo("Pé de Pano");
        jaulas[2] = new Preguica("Sid");
        jaulas[3] = new Gato("Garfield");
        jaulas[4] = new Elefante("Dumbo");
        jaulas[5] = new Leao("Simba");
        jaulas[6] = new Macaco("Curioso");
        jaulas[7] = new Tigre("Rajah");
        jaulas[8] = new Baleia("Willy");
        jaulas[9] = new Golfinho("Flipper");
    }

    public void percorrerJaulas() {
        for (Animal animal : jaulas) {
            animal.emitirSom();

            if (animal instanceof Corredor) {
                ((Corredor) animal).correr();
            }
        }
    }
}
