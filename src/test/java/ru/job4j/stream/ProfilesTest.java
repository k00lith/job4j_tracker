package ru.job4j.stream;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;

import static org.junit.Assert.assertThat;

public class ProfilesTest extends TestCase {

    @Test
    public void testCollect() {
        Address address1 = new Address("Msk", "Street1", 1, 1);
        Address address2 = new Address("Spb", "Street2", 2, 2);

        Profile profile1 = new Profile(address1);
        Profile profile2 = new Profile(address2);
        List<Profile> profileList = Arrays.asList(profile1, profile2);
        List<Address> addressList = Arrays.asList(address1, address2);
        assertThat(Profiles.collect(profileList), is(addressList));
    }
}
