package co.rsk.rpc;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by ajlopez on 06/10/2017.
 */
public class OriginValidator {
    private URI[] origins;
    private boolean allowAllOrigins;

    public OriginValidator(String uriList) throws URISyntaxException {
        if (uriList == null)
            this.origins = new URI[0];
        else if (uriList.trim().equals("*"))
            this.allowAllOrigins = true;
        else
            this.origins = toUris(uriList);
    }

    public boolean isValid(String origin) {
        if (this.allowAllOrigins)
            return true;

        URI originUri = null;

        try {
            originUri = new URI(origin);
        } catch (URISyntaxException e) {
            return false;
        }

        for (int k = 0; k < origins.length; k++)
            if (originUri.equals(origins[k]))
                return true;

        return false;
    }

    private static URI[] toUris(String list) throws URISyntaxException {
        if (list == null)
            return new URI[0];

        String[] elements = list.split(" ");
        URI[] uris = new URI[elements.length];

        for (int k = 0; k < elements.length; k++)
            uris[k] = new URI(elements[k].trim());

        return uris;
    }
}
