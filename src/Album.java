import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Album {

    private String title;
    private String artist;
    private List<Song> songs;

    public Album(String title, String artist, List<Song> songs) {
        this.title = title;
        this.artist = artist;
        this.songs = songs;
    }

    public Album(String title, String artist) {
        this.title = title;
        this.artist = artist;
        this.songs=new ArrayList<>();
    }

    public Boolean findSong(Song songToSearch){
        for(Song song : songs){
            if(songToSearch.getTitle().equals(song.getTitle()) && songToSearch.getArtist().equals(song.getArtist())){
                return true;
            }
        }
        return false;
    }

    public Optional<Song> findSong(String title,String artist){
        for(Song song : songs){
            if(title.equals(song.getTitle()) && artist.equals(song.getArtist())){
                return Optional.of(song);
            }
        }
        return Optional.empty();
    }

    public Optional<Song> findSong(String title){
        for(Song song : songs){
            if(title.equals(song.getTitle())){
                return Optional.of(song);
            }
        }
        return Optional.empty();
    }

    public Optional<Song> findSong(int trackNum){

        if(trackNum>=0 && trackNum<=songs.size())
            return Optional.of(songs.get(trackNum-1));
        return Optional.empty();
    }
    public String addSong(Song song){

        Optional<Song> optionalSong = findSong(song.getTitle());
        if(!optionalSong.isEmpty()){
            return "Song already exists";
        }
        songs.add(song);
        return "Song added";
    }
}
