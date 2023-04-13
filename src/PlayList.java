import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

public class PlayList {

    private String title;
    private List<Song> songs;
    private ListIterator<Song> itr;

    private Boolean isNext=false;

    public PlayList(String title) {
        this.title = title;
        songs=new ArrayList<>();
        itr= songs.listIterator();
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

    public String addSongFromAlbum(Album album,int trackNum){

        Optional<Song> op1=album.findSong(trackNum);

        if(!op1.isEmpty()){
            Optional<Song> op2=findSong(op1.get().getTitle());
            if(op2.isEmpty()){
                songs.add(op1.get());
                itr=songs.listIterator();
                return "Song added to Playlist";
            }else{
                return "Song already present in Playlist";
            }
        }else{
            return "Song not found in the Album";
        }
    }
    public String addSongFromAlbum(Album album,String songTitle){

        Optional<Song> op1=album.findSong(songTitle);
        Optional<Song> op2=findSong(songTitle);
        if(!op1.isEmpty()){
            if(op2.isEmpty()){
                songs.add(op1.get());
                itr=songs.listIterator();
                return "Song added to Playlist";
            }else{
                return "Song already present in Playlist";
            }
        }else{
            return "Song not found in the Album";
        }
    }

    public String playCurrent(){

        if(isNext){
            isNext=false;
            return "Playing : " + itr.previous();
        }else{
            isNext=true;
          return "Playing : " +  itr.next();
        }


    }

    public String playNextSong(){

        if(isNext){

        }
        if(!isNext){
            itr.next();
            isNext=true;

        }
        if(itr.hasNext()){
            isNext=true;
            return "next song to play is : " + itr.next();
        }

        return "You have reached end of playlist";
    }

    public String playPrevSong(){

        if(!isNext){

        }
        if(isNext){
            itr.previous();
            isNext=false;
        }
        if(itr.hasPrevious()){
            isNext=false;
            return "previous song was : " + itr.previous();
        }

        return "You are at the beginning of the playlist";
    }



}
