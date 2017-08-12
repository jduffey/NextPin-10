import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jedduffey on 8/12/17.
 */
public class PinUserTests {

    private PinUser pinUser;

    @Before
    public void setup() {
        pinUser = new PinUser();
    }

    @Test
    public void thePinUserClassShouldExist() {
        assertNotNull(pinUser);
    }


}
