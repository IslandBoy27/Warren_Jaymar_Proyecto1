package proyecto;

public class main {

    public static void main(String[] args) {
        MusicPlayer.playMusic("./014_What You Came For.wav");

        MenuInicial ObjetoMenuInicial = new MenuInicial(null, null);
        ObjetoMenuInicial.setVisible(true);

    }

}
