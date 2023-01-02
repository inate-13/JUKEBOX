
 import Dao.PodcastDao;
 import Exceptions.PodcastNotFoundException;
 import ModelClasses.Podcast;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

    public class PodcastTest
    {
        PodcastDao podcastDao;
        List<Podcast> podcastList;

        @Before
        public void setUp()
        {
            podcastList = new ArrayList<>();
        }

        @After
        public void tearDown()
        {
            podcastDao = null;
        }

        @Test
        public void getAllPodcast() throws SQLException {
            List<Podcast> total = PodcastDao.showAllPodcast();
            assertEquals(1, total.size());
        }

        @Test
        public void getPodcastByName() throws SQLException, PodcastNotFoundException {
            List<Podcast> total = PodcastDao.searhByName("Podcast1");
            assertEquals(1, total.size());

            List<Podcast> total1 = PodcastDao.searhByName("");
            assertEquals(0, total1.size());
        }

    }


