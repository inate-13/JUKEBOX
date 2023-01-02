import Dao.SongDao;
import Exceptions.SongNotFoundException;
import ModelClasses.Song;
import org.junit.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class SongTest
{
    SongDao songDao;
    List<Song> songList;

    @Before
    public void setUp()
    {
        songList = new ArrayList<>();
    }

    @After
    public void tearDown()
    {
        songDao = null;
    }

    @Test
    public void getAllSong() throws SQLException {
        List<Song> total = SongDao.showAllSongs();
        assertEquals(4, total.size());
    }

    @Test
    public void getSongByName() throws SQLException, SongNotFoundException {
        List<Song> total = SongDao.searchSongByName("abc");
        assertEquals(1, total.size());

        List<Song> total1 = SongDao.searchSongByName("");
        assertEquals(0, total1.size());
    }

    @Test
    public void getSongByArtistName() throws SQLException, SongNotFoundException {
        List<Song> total = SongDao.searchSongByArtistName("Jubin");
        assertEquals(1, total.size());

        List<Song> total1 = SongDao.searchSongByArtistName("");
        assertEquals(0, total1.size());
    }

    @Test
    public void getSongByAlbumName() throws SQLException, SongNotFoundException {
        List<Song> total = SongDao.searchSongByAlbumName(" ");
        assertEquals(0, total.size());
        List<Song> total1 = SongDao.searchSongByAlbumName("DEF");
        assertEquals(0, total1.size());
    }
}

