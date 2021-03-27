package InputOutput;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

/**
 * Writer Class
 */
public class Writer {
    /**
     * writes in XML format and saves it to given path
     * @param path
     * @throws IOException
     * @throws ParserConfigurationException
     * @throws TransformerException
     */
    public void writerToFile(String path ) throws IOException,
            ParserConfigurationException, TransformerException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();

        Element elements = document.createElement("SpaceMarines");
        Element element = document.createElement("SpaceMarine");
        Element element2 = document.createElement("SpaceMarine");
        Element element3 = document.createElement("SpaceMarine");

        Attr attr = document.createAttribute("id");
        Attr attr2 = document.createAttribute("id");
        Attr attr3 = document.createAttribute("id");

        attr.setValue("1");
        attr2.setValue("2");
        attr3.setValue("3");

        element.setAttributeNode(attr);
        element2.setAttributeNode(attr2);
        element3.setAttributeNode(attr3);

        Element name = document.createElement("name");
        Element name2 = document.createElement("name");
        Element name3 = document.createElement("name");
        name.appendChild(document.createTextNode("Abraam"));
        name2.appendChild(document.createTextNode("Mary"));
        name3.appendChild(document.createTextNode("Alex"));
        element.appendChild(name);
        element2.appendChild(name2);
        element3.appendChild(name3);
        elements.appendChild(element);
        elements.appendChild(element2);
        elements.appendChild(element3);
        document.appendChild(elements);

        Element coordinatesX = document.createElement("coordinatesX");
        Element coordinatesX2 = document.createElement("coordinatesX");
        Element coordinatesX3 = document.createElement("coordinatesX");
        coordinatesX.appendChild(document.createTextNode("2"));
        coordinatesX2.appendChild(document.createTextNode("8"));
        coordinatesX3.appendChild(document.createTextNode("5"));
        element.appendChild(coordinatesX);
        element2.appendChild(coordinatesX2);
        element3.appendChild(coordinatesX3);

        Element coordinatesY = document.createElement("coordinatesY");
        Element coordinatesY2 = document.createElement("coordinatesY");
        Element coordinatesY3 = document.createElement("coordinatesY");
        coordinatesY.appendChild(document.createTextNode("22"));
        coordinatesY2.appendChild(document.createTextNode("25"));
        coordinatesY3.appendChild(document.createTextNode("43"));
        element.appendChild(coordinatesY);
        element2.appendChild(coordinatesY2);
        element3.appendChild(coordinatesY3);

        Element category = document.createElement("category");
        Element category2 = document.createElement("category");
        Element category3 = document.createElement("category");
        category.appendChild(document.createTextNode("CHAPLAIN"));
        category2.appendChild(document.createTextNode("TACTICAL"));
        category3.appendChild(document.createTextNode("CHAPLAIN"));
        element.appendChild(category);
        element2.appendChild(category2);
        element3.appendChild(category3);

        Element weapon = document.createElement("weapon");
        Element weapon2 = document.createElement("weapon");
        Element weapon3 = document.createElement("weapon");
        weapon.appendChild(document.createTextNode("GRENADE_LAUNCHER"));
        weapon2.appendChild(document.createTextNode("GRAV_GUN"));
        weapon3.appendChild(document.createTextNode("BOLTGUN"));
        element.appendChild(weapon);
        element2.appendChild(weapon2);
        element3.appendChild(weapon3);

        Element meleeWeapon = document.createElement("meleeWeapon");
        Element meleeWeapon2 = document.createElement("meleeWeapon");
        Element meleeWeapon3 = document.createElement("meleeWeapon");
        meleeWeapon.appendChild(document.createTextNode("POWER_SWORD"));
        meleeWeapon2.appendChild(document.createTextNode("MANREAPER"));
        meleeWeapon3.appendChild(document.createTextNode("POWER_SWORD"));
        element.appendChild(meleeWeapon);
        element2.appendChild(meleeWeapon2);
        element3.appendChild(meleeWeapon3);

        Element hp = document.createElement("hp");
        Element hp2 = document.createElement("hp");
        Element hp3 = document.createElement("hp");
        hp.appendChild(document.createTextNode("33"));
        hp2.appendChild(document.createTextNode("2"));
        hp3.appendChild(document.createTextNode("45"));
        element.appendChild(hp);
        element2.appendChild(hp2);
        element3.appendChild(hp3);

        Element chapter = document.createElement("chapter");
        Element chapter2 = document.createElement("chapter");
        Element chapter3 = document.createElement("chapter");
        Element marineCount = document.createElement("marineCount");
        Element marineCount2 = document.createElement("marineCount");
        Element marineCount3 = document.createElement("marineCount");
        chapter.appendChild(document.createTextNode("First"));
        chapter2.appendChild(document.createTextNode("Second"));
        chapter3.appendChild(document.createTextNode("Third"));
        marineCount.appendChild(document.createTextNode("23"));
        marineCount2.appendChild(document.createTextNode("87"));
        marineCount3.appendChild(document.createTextNode("234"));
        element.appendChild(chapter);
        element2.appendChild(chapter2);
        element3.appendChild(chapter3);
        element.appendChild(marineCount);
        element2.appendChild(marineCount2);
        element3.appendChild(marineCount3);

        Element creationDate = document.createElement("creationDate");
        Element creationDate2 = document.createElement("creationDate");
        Element creationDate3 = document.createElement("creationDate");
        creationDate.appendChild(document.createTextNode("2021-03-12T21:37:57.101454449+03:00[Europe/Moscow]"));
        creationDate2.appendChild(document.createTextNode("2020-03-12T21:37:57.101454449+03:00[Europe/Moscow]"));
        creationDate3.appendChild(document.createTextNode("2001-03-12T21:37:57.101454449+03:00[Europe/Moscow]"));
        element.appendChild(creationDate);
        element2.appendChild(creationDate2);
        element3.appendChild(creationDate3);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        String env  = System.getenv("IN_PATH");

        if (env==null){

            File fff = new File("ScriptFile/"+path);
            StreamResult streamResult = new StreamResult(fff);
            transformer.transform(source,streamResult);
            System.out.println("No env.var. so I will use from default");

        }else {

            File fff = new File(env+path);
            StreamResult streamResult = new StreamResult(fff);
            transformer.transform(source,streamResult);
        }




    }


}
