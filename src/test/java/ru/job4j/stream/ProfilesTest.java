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
        Address address1 = new Address("Aab", "Street1", 1, 1);
        Address address2 = new Address("Zas", "Street2", 2, 2);
        Address address3 = new Address("Baa", "Street3", 2, 2);
        Address address4 = new Address("Kav", "Street2", 2, 2);
        Address address5 = new Address("Baa", "Street3", 2, 2);

        Profile profile1 = new Profile(address1);
        Profile profile2 = new Profile(address2);
        Profile profile3 = new Profile(address3);
        Profile profile4 = new Profile(address4);
        Profile profile5 = new Profile(address5);
        List<Profile> profileList = Arrays.asList(profile1, profile2, profile3, profile4, profile5);
        List<Address> addressList = Arrays.asList(address1, address3, address4, address2);
        assertThat(Profiles.collect(profileList), is(addressList));
    }
}
