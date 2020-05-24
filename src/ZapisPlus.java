import java.io.PrintStream;
import java.io.Serializable;
import java.util.*;

public class ZapisPlus extends Zapis implements Serializable {
    /**
     korzystam z ZapisPlus z wykładu
     @author Mariusz Trzaska
     */
    private Map<String, Map<Object, ZapisPlus>> links = new Hashtable<>();

    /**
     * Stores information about all parts connected with any objects.
     */
    private static Set<ZapisPlus> allParts = new HashSet<>();

    /**
     * The constructor.
     *
     */
    public ZapisPlus() {
        super();
    }

    /**
     * Creates a new link (private, utility method).
     * @param roleName
     * @param reverseRoleName
     * @param targetObject
     * @param qualifier
     * @param counter
     */
    private void addLink(String roleName, String reverseRoleName, ZapisPlus targetObject, Object qualifier, int counter) {
        Map<Object, ZapisPlus> objectLinks;

        // Protection for the reverse connection
        if(counter < 1) {
            return;
        }

        // Find a collection of links for the role
        if(links.containsKey(roleName)) {
            // Get the links
            objectLinks = links.get(roleName);
        }
        else {
            // No links ==> create them
            objectLinks = new HashMap<>();
            links.put(roleName, objectLinks);
        }

        // Check if there is already the connection
        // If yes, then ignore the creation
        if(!objectLinks.containsKey(qualifier)) {
            // Add a link for the target object
            objectLinks.put(qualifier, targetObject);

            // Add the reverse connection
            targetObject.addLink(reverseRoleName, roleName, this, this, counter - 1);
        }
    }

    /**
     * Creates a new link to the given target object (optionally as quilified connection).
     * @param roleName
     * @param reverseRoleName
     * @param targetObject
     * @param qualifier Jezeli rozny od null to tworzona jest asocjacja kwalifikowana.
     */
    public void addLink(String roleName, String reverseRoleName, ZapisPlus targetObject, Object qualifier) {
        addLink(roleName, reverseRoleName, targetObject, qualifier, 2);
    }

    /**
     * Creates a new link to the given target object (as an ordinary association, not the quilified one).
     * @param roleName
     * @param reverseRoleName
     * @param targetObject
     */
    public void addLink(String roleName, String reverseRoleName, ZapisPlus targetObject) {
        addLink(roleName, reverseRoleName, targetObject, targetObject);
    }
//myAddLink
    public void addLink(String roleName, String reverseRoleName, Object object) {
        addLink(roleName, reverseRoleName, object);
    }


    /**
     * Adds an information about a connection (using a "semi" composition).
     * @param roleName
     * @param reverseRoleName
     * @throws Exception
     */
    public void addPart(String roleName, String reverseRoleName, ZapisPlus partObject) throws Exception {
        // Check if the part exist somewhere
        if(allParts.contains(partObject)) {
            throw new Exception("The part is already connected to a whole!");
        }

        addLink(roleName, reverseRoleName, partObject);

        // Store adding the object as a part
        allParts.add(partObject);
    }

    public void addPart(String roleName, String reverseRoleName, Object o, ZapisPlus partObject) throws Exception {
        // Check if the part exist somewhere
        if(allParts.contains(partObject)) {
            throw new Exception("The part is already connected to a whole!");
        }

        addLink(roleName, reverseRoleName, partObject);

        // Store adding the object as a part
        allParts.add(partObject);
    }

    /**
     * Gets an array of connected objects for the given role name.
     * @param roleName
     * @return
     * @throws Exception
     */
    public ZapisPlus[] getLinks(String roleName) throws Exception {
        Map<Object, ZapisPlus> objectLinks;

        if(!links.containsKey(roleName)) {
            // No links for the role
            throw new Exception("No links for the role: " + roleName);
        }

        objectLinks = links.get(roleName);

        return (ZapisPlus[]) objectLinks.values().toArray(new ZapisPlus[0]);
    }

    /**
     * Shows links to the given stream.
     * @param roleName
     * @param stream
     * @throws Exception
     */
    public void showLinks(String roleName, PrintStream stream) throws Exception {
        Map<Object, ZapisPlus> objectLinks;

        if(!links.containsKey(roleName)) {
            // No links
            throw new Exception("No links for the role: " + roleName);
        }

        objectLinks = links.get(roleName);

        Collection col = objectLinks.values();

        stream.println(this.getClass().getSimpleName() + " links, role '" + roleName + "':");

        for(Object obj : col) {
            stream.println("   " + obj);
        }
    }

    /**
     * Gets an object for the given qualifier (a qualified association).
     * @param roleName
     * @param qualifier
     * @return
     * @throws Exception
     */
    public ZapisPlus getLinkedObject(String roleName, Object qualifier) throws Exception {
        Map<Object, ZapisPlus> objectLinks;

        if(!links.containsKey(roleName)) {
            // No links
            throw new Exception("No links for the role: " + roleName);
        }

        objectLinks = links.get(roleName);
        if(!objectLinks.containsKey(qualifier)) {
            // No link for the qualifer
            throw new Exception("No link for the qualifer: " + qualifier);
        }

        return objectLinks.get(qualifier);
    }

    /**
     * Checks if there are any links for the given role name.
     * @param nazwaRoli
     * @return
     */
    public boolean anyLink(String nazwaRoli) {
        if(!links.containsKey(nazwaRoli)) {
            return false;
        }

        Map<Object, ZapisPlus> links = this.links.get(nazwaRoli);
        return links.size() > 0;
    }

    /**
     * Checks if there is a link to a given object as a given role.
     * @param roleName
     * @param targetObject
     * @return
     */
    public boolean isLink(String roleName, ZapisPlus targetObject) {
        Map<Object, ZapisPlus> objectLink;

        if(!links.containsKey(roleName)) {
            // No links for the role
            return false;
        }

        objectLink = links.get(roleName);

        return objectLink.containsValue(targetObject);
    }

}
