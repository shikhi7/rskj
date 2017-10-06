package co.rsk.rpc;

import org.junit.Assert;
import org.junit.Test;

import java.net.URISyntaxException;

/**
 * Created by ajlopez on 06/10/2017.
 */
public class OriginValidatorTest {
    @Test
    public void noOrigin() throws URISyntaxException {
        OriginValidator validator = new OriginValidator("");

        Assert.assertFalse(validator.isValid("http://localhost"));
        Assert.assertFalse(validator.isValid("https://rks.co"));
    }

    @Test
    public void noOriginWithSpaces() throws URISyntaxException {
        OriginValidator validator = new OriginValidator("  ");

        Assert.assertFalse(validator.isValid("http://localhost"));
        Assert.assertFalse(validator.isValid("https://rks.co"));
    }

    @Test
    public void nullOrigin() throws URISyntaxException {
        OriginValidator validator = new OriginValidator(null);

        Assert.assertFalse(validator.isValid("http://localhost"));
        Assert.assertFalse(validator.isValid("https://rks.co"));
    }

    @Test
    public void allOriginsUsingWildcard() throws URISyntaxException {
        OriginValidator validator = new OriginValidator("*");

        Assert.assertTrue(validator.isValid("http://localhost"));
        Assert.assertTrue(validator.isValid("https://rks.co"));
    }

    @Test
    public void allowLocalhost() throws URISyntaxException {
        OriginValidator validator = new OriginValidator("http://localhost");

        Assert.assertTrue(validator.isValid("http://localhost"));
        Assert.assertFalse(validator.isValid("https://rks.co"));
    }

    @Test
    public void allowDomain() throws URISyntaxException {
        OriginValidator validator = new OriginValidator("https://rsk.co");

        Assert.assertFalse(validator.isValid("http://localhost"));
        Assert.assertTrue(validator.isValid("https://rsk.co"));
    }
}
