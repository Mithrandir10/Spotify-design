public class Main {
    public static void main(String[] args) {

        Album a1=new Album("moosetape","samsmith");
        a1.addSong(new Song("unholy","samsmith",2));
        a1.addSong(new Song("holy","samsmith",3));
        a1.addSong(new Song("wholly","samsmith",4));


        Album a2=new Album("pbx1","drake");
        a2.addSong(new Song("kiki","drake",2));
        a2.addSong(new Song("views","drake",3));
        a2.addSong(new Song("take care","drake",4));

        PlayList pl1=new PlayList("gymlist");
        pl1.addSongFromAlbum(a1,"unholy");
        pl1.addSongFromAlbum(a1,"holy");
        pl1.addSongFromAlbum(a2,"take care");

        System.out.println(pl1.playPrevSong());
        System.out.println(pl1.playNextSong());
        System.out.println(pl1.playNextSong());
        System.out.println(pl1.playNextSong());


    }
}