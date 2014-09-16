package utility;

import javax.xml.namespace.NamespaceContext;
import javax.xml.stream.events.Namespace;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Marion on 9/16/2014.
 */
public class NameSpaceURImpl implements NamespaceContext
{
    private HashMap<String, String> prefixToUri;

    public NameSpaceURImpl( String prefix, String uri )
    {
        prefixToUri = new HashMap<String, String>();
        prefixToUri.put( prefix, uri );
    }
    public NameSpaceURImpl( String prefix[] , String uri )
    {
        prefixToUri = new HashMap<String, String>();
        for( int i=0; i<prefix.length; i++ )
            prefixToUri.put( prefix[i], uri );
    }

    @Override
    public String getNamespaceURI(String prefix) {
        return prefixToUri.get( prefix );
    }

    @Override
    public String getPrefix(String namespaceURI) {
        String rtnval = null;
        Set<String> keys = prefixToUri.keySet();
        Iterator<String> itr = keys.iterator();
        while( itr.hasNext() )
        {
            String prefix = (String)itr.next();
            if( (prefixToUri.get(prefix)).equals( namespaceURI) )
            {
                rtnval = prefix;
                break;
            }
        }

        return rtnval;
    }

    @Override
    public Iterator getPrefixes(String namespaceURI) {
        ArrayList<String> prefixes = new ArrayList<String>();

        Set<String> keys = prefixToUri.keySet();
        Iterator<String> itr = keys.iterator();
        while( itr.hasNext() )
        {
            String prefix = (String)itr.next();
            if( (prefixToUri.get(prefix)).equals( namespaceURI) )
            {
                prefixes.add( prefix );
            }
        }

        return prefixes.iterator();
    }
}
