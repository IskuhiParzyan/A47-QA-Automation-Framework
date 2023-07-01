
import org.testng.annotations.Test;

import static java.lang.Thread.*;


public class Homework19 extends BaseTest {
    @Test

    public void deletePlaylist() throws InterruptedException {
        // openUrl();
        enterEmail("Iparzyan@gmail.com");
        enterPassword("MkoIkaMarkMia-789");
        clickSubmit();
        clickPLaylist();
        deletePlaylistBtn();
        notification();


    }
}
