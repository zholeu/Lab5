package InputOutput;
import Utils.Chapter;
import Utils.SpaceMarine;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.*;
import java.util.Vector;

/**
 * A Parser XML Class
 */
public class ParserToXML {
    /**
     * method that parsers to xml format
     * @param spaceMarines
     * @param file
     * @throws IOException
     */
    public static void writeInXml(Vector<SpaceMarine> spaceMarines, String file) throws IOException {
        try{
            org.jdom2.Document doc = new org.jdom2.Document();
            org.jdom2.Element root = new org.jdom2.Element("spaceMarines");
            doc.setRootElement(root);
            for(SpaceMarine spaceMarine : spaceMarines){
                org.jdom2.Element currentSpaceMarine = new org.jdom2.Element("SpaceMarine");
                currentSpaceMarine.setAttribute("id", String.valueOf(spaceMarine.getId()));
                currentSpaceMarine.addContent(new org.jdom2.Element("name").addContent(spaceMarine.getName()));
                org.jdom2.Element coords = new org.jdom2.Element("coordinates")
                        .addContent(new org.jdom2.Element("x").addContent(String.valueOf(spaceMarine.getCoordinates().getX())))
                        .addContent(new org.jdom2.Element("y").addContent(String.valueOf(spaceMarine.getCoordinates().getY())));
                currentSpaceMarine.addContent(coords);
                currentSpaceMarine.addContent(new org.jdom2.Element("creationDate").addContent(spaceMarine.getCreationDate().toString()));
                currentSpaceMarine.addContent(new org.jdom2.Element("hp").addContent(String.valueOf(spaceMarine.getHealth())));
                currentSpaceMarine.addContent(new org.jdom2.Element("category").addContent(String.valueOf(spaceMarine.getCategory())));
                currentSpaceMarine.addContent(new org.jdom2.Element("weaponType").addContent(String.valueOf(spaceMarine.getWeaponType())));
                currentSpaceMarine.addContent(new org.jdom2.Element("MeleeWeapon").addContent(String.valueOf(spaceMarine.getMeleeWeapon())));
                Chapter chapter = spaceMarine.getChapter();
                org.jdom2.Element chapterAdd = new org.jdom2.Element("chapter")
                        .addContent(new org.jdom2.Element("name").addContent(chapter.getName()))
                        .addContent(new org.jdom2.Element("marinesCount").addContent(String.valueOf(chapter.getMarinesCount())));
                currentSpaceMarine.addContent(chapterAdd);
                root.addContent(currentSpaceMarine);
            }
            Format fmt = Format.getPrettyFormat();
            XMLOutputter outputter = new XMLOutputter(fmt);
            outputter.output(doc, new FileWriter(new File(file)));
        }catch (IOException e) {
            System.out.println("Exception in Parser");
        }


    }

}
