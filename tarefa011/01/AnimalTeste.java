public class AnimalTeste {
    public static void main(String[] args) {
        Animal cachorro = new Cachorro("Rex");
        Animal cavalo = new Cavalo("Pé de Pano");
        Animal preguica = new Preguica("Sid");

        cachorro.emitirSom();
        cavalo.emitirSom();
        preguica.emitirSom();
    }
}
