package InputOutput;

import Utils.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.time.ZonedDateTime;
import java.util.*;

/**
 * Reader Class for XML format
 */
public class ReaderM {

    public ReaderM() {
    }

    /**
     * reads xml format and saves to current collection
     * @param spaceMarines
     * @param path
     * @throws IOException
     * @throws ParserConfigurationException
     * @throws SAXException
     */
    public void xmlRead (Vector<SpaceMarine> spaceMarines, String path) throws IOException, ParserConfigurationException, SAXException {

        String env  = System.getenv("IN_PATH");
        if (env==null){
            File fff = new File("ScriptFile/"+path);
            File xmlF = new File(String.valueOf(fff));
            System.out.println("No env.var. so I will use from default");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlF);
            NodeList list  = document.getElementsByTagName("SpaceMarine");

            for(int i = 0 ; i<list.getLength(); i++){
                Node node = list.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    Coordinates coordinates = new Coordinates(Integer.parseInt(element.getElementsByTagName("coordinatesX").item(0).getTextContent()),Integer.valueOf(element.getElementsByTagName("coordinatesY").item(0).getTextContent()));
                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    Long hp = Long.parseLong(element.getElementsByTagName("hp").item(0).getTextContent());
                    AstartesCategory astartesCategory =  AstartesCategory.valueOf(element.getElementsByTagName("category").item(0).getTextContent());
                    Weapon weapon =  Weapon.valueOf(element.getElementsByTagName("weapon").item(0).getTextContent());
                    MeleeWeapon meleeWeapon =  MeleeWeapon.valueOf(element.getElementsByTagName("meleeWeapon").item(0).getTextContent());
                    Chapter chapter = new Chapter(element.getElementsByTagName("chapter").item(0).getTextContent(),Long.parseLong(element.getElementsByTagName("marineCount").item(0).getTextContent()));
                    SpaceMarine spaceMarine = new SpaceMarine(name,coordinates,hp,astartesCategory,weapon,meleeWeapon,chapter);
                    spaceMarine.setCreationDate(ZonedDateTime.parse(element.getElementsByTagName("creationDate").item(0).getTextContent()));
                    spaceMarines.add(spaceMarine);
                }
            }
        }else {
            File fff = new File(env+path);
            File xmlF = new File(String.valueOf(fff));
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlF);
            NodeList list  = document.getElementsByTagName("SpaceMarine");

            for(int i = 0 ; i<list.getLength(); i++){
                Node node = list.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    Coordinates coordinates = new Coordinates(Integer.parseInt(element.getElementsByTagName("coordinatesX").item(0).getTextContent()),Integer.valueOf(element.getElementsByTagName("coordinatesY").item(0).getTextContent()));
                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    Long hp = Long.parseLong(element.getElementsByTagName("hp").item(0).getTextContent());
                    AstartesCategory astartesCategory =  AstartesCategory.valueOf(element.getElementsByTagName("category").item(0).getTextContent());
                    Weapon weapon =  Weapon.valueOf(element.getElementsByTagName("weapon").item(0).getTextContent());
                    MeleeWeapon meleeWeapon =  MeleeWeapon.valueOf(element.getElementsByTagName("meleeWeapon").item(0).getTextContent());
                    Chapter chapter = new Chapter(element.getElementsByTagName("chapter").item(0).getTextContent(),Long.parseLong(element.getElementsByTagName("marineCount").item(0).getTextContent()));
                    SpaceMarine spaceMarine = new SpaceMarine(name,coordinates,hp,astartesCategory,weapon,meleeWeapon,chapter);
                    spaceMarine.setCreationDate(ZonedDateTime.parse(element.getElementsByTagName("creationDate").item(0).getTextContent()));
                    spaceMarines.add(spaceMarine);
                }
            }
        }


    }
}
